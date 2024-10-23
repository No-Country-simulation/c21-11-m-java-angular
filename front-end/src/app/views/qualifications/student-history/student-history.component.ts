import { CommonModule } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { SubjectService } from '../../../services/subject.service';
import { EvaluationService } from '../../../services/evaluation.service';
import { Observable, forkJoin } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { Evaluation } from '../../../interfaces/evaluation.interface';
import { Qualification } from '../../../interfaces/qualification.interface';
import { Subject } from '../../../interfaces/subject.interface';

@Component({
  selector: 'app-student-history',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './student-history.component.html',
  styleUrls: ['./student-history.component.css'],
})
export class StudentHistoryComponent {
  private subjectService = inject(SubjectService);
  private evaluationService = inject(EvaluationService);
  private studentId = "1"; // A reemplazar por el usuario logueado

  public subjects$!: Observable<Subject[]>;

  ngOnInit(): void {
    // Usamos forkJoin para obtener todos los datos y luego combinarlos
    this.subjects$ = this.subjectService.getSubjects().pipe(
      switchMap((subjects) => {
        // Obtenemos las evaluaciones y calificaciones en paralelo
        const evaluations$ = this.evaluationService.getEvaluations();
        const qualifications$ = this.evaluationService.getStudentQualifications(this.studentId);

        return forkJoin([evaluations$, qualifications$]).pipe(
          map(([evaluations, qualifications]) => {
            return subjects!.map((subject) => {
              // Filtrar las evaluaciones relacionadas con esta asignatura
              const subjectEvaluations = evaluations!.filter(
                (evaluation: Evaluation) => evaluation.subject === subject.id
              );

              // Agregar las calificaciones a las evaluaciones correspondientes
              const evaluationsWithGrades = subjectEvaluations.map((evaluation) => ({
                ...evaluation,
                qualifications: qualifications!.filter(
                  (qualification: Qualification) =>
                    qualification.evaluation === evaluation.id && qualification.student.id === this.studentId
                ),
              }));

              // Devolver la asignatura con sus evaluaciones y calificaciones
              return {
                ...subject,
                evaluations: evaluationsWithGrades,
              };
            });
          })
        );
      })
    );

    this.subjects$.subscribe((data) => {
      console.log('Datos combinados:', data);
    });
  }
}
