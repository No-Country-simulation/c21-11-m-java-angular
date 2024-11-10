import { Component, inject } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { SubjectService } from '../../../services/subject.service';
import { UserService } from '../../../services/user.service';
import { Role } from '../../../interfaces/user.interface';
import { CommonModule } from '@angular/common';
import { Subject, WeekDays } from '../../../interfaces/subject.interface';

@Component({
  selector: 'app-save-subject',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './save-subject.component.html',
  styleUrls: ['./save-subject.component.css'],
})
export class SaveSubjectComponent {
  private fb = inject(FormBuilder);
  private subjectService = inject(SubjectService);
  private userService = inject(UserService);

  registerForm!: FormGroup;
  days = Object.values(WeekDays);
  selectedDays: string[] = [];
  teachers$ = this.userService.getUsersByRole(Role.PROFESOR);

  // Propiedades para el mensaje de éxito o error
  message: string | null = null;
  messageClass: string = '';
  messageType: string | null = null;

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      topics: [''],
      description: [''],
      schedule: ['', Validators.required],
      days: [[], Validators.required],
      teacher: ['', Validators.required],
    });
  }

  onCheckboxChange(event: any) {
    const day = event.target.value;
    if (event.target.checked) {
      this.selectedDays.push(day);
    } else {
      this.selectedDays = this.selectedDays.filter((d) => d !== day);
    }
    this.registerForm.controls['days'].setValue(this.selectedDays);
  }

  onSubmit(): void {
    // Comprobar si el formulario es válido
    if (!this.registerForm.valid) {
      this.message = 'Por favor, complete todos los campos obligatorios.';
      this.messageType = 'error';
      return; // Salir del método si el formulario es inválido
    }

    const subject: Subject = {
      name: this.registerForm.value.name,
      topics: this.registerForm.value.topics,
      description: this.registerForm.value.description,
      schedule: this.registerForm.value.schedule,
      days: this.registerForm.value.days,
      teacher: this.registerForm.value.teacher,
    };

    this.subjectService.saveSubject(subject).subscribe({
      next: (response) => {
        this.message = 'Asignatura registrada con éxito.';
        this.messageType = 'success'; // clase para éxito
        console.log('Subject registered successfully', response);
      },
      error: (error) => {
        this.message =
          'Error al registrar la asignatura. Por favor, intente nuevamente.';
        this.messageType = 'error'; // clase para error
        console.error('Error registering subject', error);
      },
      complete: () => {
       /*  this.resetForm(); */
      },
    });
  }

  resetForm(): void {
    this.registerForm.reset();
    this.selectedDays = [];
    this.message = null; // Limpiar mensaje después de reiniciar el formulario
    this.messageType = null;
  }
}
