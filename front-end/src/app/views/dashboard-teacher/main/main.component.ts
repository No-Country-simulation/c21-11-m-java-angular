import { CommonModule } from '@angular/common';
import { Component, inject, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Evaluation } from '../../../interfaces/evaluation.interface';
import { Subject } from '../../../interfaces/subject.interface';
import { Role } from '../../../interfaces/user.interface';
import { EvaluationService } from '../../../services/evaluation.service';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './main.component.html',
  styleUrl: './main.component.css'
})
export class MainComponent implements OnInit {
  mostrarModal: boolean = false;
  evaluaciones: Evaluation[] = [];
  private evaluationService = inject(EvaluationService);

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.cargarEvaluaciones();
  }

  cargarEvaluaciones(): void {
    this.evaluationService.getEvaluations().subscribe({
      next: (data) => {
        this.evaluaciones = data; 
      },
      error: (error) => {
        console.error('Error al cargar las evaluaciones:', error);
      }
    });
  }

  asignaturas: Subject[] = [
    {
      id: '1', 
      name: '', 
      topics: '', 
      description: '',
      schedule: [''],
      days: [], 
      teacher: {
        firstName: '', 
        lastName: '',
        dni: { dni: 0 },
        email: { email: '' },  
        birthDay: new Date(), 
        role: Role.PROFESOR, 
      },
      evaluations: [], 
    }
  ];

  abrirModal() {
    this.mostrarModal = true;
  }

  cerrarModal() {
    this.mostrarModal = false;
  }

  guardarRegularizacion() {
    this.cerrarModal();
  }

  registrarNuevaEvaluacion() {
    const mockSubjectId = '123'; // ID fijo para probar
    console.log(`Redirigiendo a postEvaluation/${mockSubjectId}`);
    this.router.navigate(['/postEvaluation', mockSubjectId]);
  }

  navigateToEvaluation(evaluationId: number) {
    this.router.navigate(['/evaluation', evaluationId]); 
}
}