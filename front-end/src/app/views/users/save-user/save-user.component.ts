import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Role, User } from '../../../interfaces/user.interface';
import { Router } from '@angular/router';

@Component({
  selector: 'app-save-user',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule],
  templateUrl: './save-user.component.html',
  styleUrls: ['./save-user.component.css']
})
export class SaveUserComponent implements OnInit {
  roles = Object.values(Role);
  title: string = 'Registrar nuevo usuario';
  private fb = inject(FormBuilder);
  private router = inject(Router);
  registerForm!: FormGroup;
  showSuccessMessage: boolean = false;
  showErrorMessage: boolean = false; 

  ngOnInit(): void {
    this.registerForm = this.fb.group({
      email: new FormControl('', [Validators.required, Validators.email]),
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      birthDay: new FormControl('', Validators.required),
      dni: new FormControl('', [Validators.required, Validators.pattern(/^\d+$/)]),
      role: new FormControl('', Validators.required),
      legajo: new FormControl('', Validators.required) 
    });

    this.registerForm.get('role')?.valueChanges.subscribe(role => {
      if (role === 'Profesor') {
        this.registerForm.get('legajo')?.setValidators([Validators.required]);
      } else {
        this.registerForm.get('legajo')?.clearValidators();
      }
      this.registerForm.get('legajo')?.updateValueAndValidity();
    });
  }

  onSubmit(): void {
    if (this.registerForm.valid) {
      const user: User = {
        dni: { dni: Number(this.registerForm.get('dni')?.value) },
        email: this.registerForm.get('email')?.value,
        role: this.registerForm.get('role')?.value,
        legajo: this.registerForm.get('legajo')?.value,
        lastName: this.registerForm.get('lastName')?.value,
        firstName: this.registerForm.get('firstName')?.value,
        birthDay: this.registerForm.get('birthDay')?.value,
      };

      const users = this.getUsersFromLocalStorage();
      const userExists = users.some(existingUser => 
        existingUser.email === user.email || existingUser.dni.dni === user.dni.dni
      );

      if (userExists) {
        this.showErrorMessage = true; 
        return; 
      }

      this.storeUserInLocalStorage(user);
      this.showSuccessMessage = true;
      setTimeout(() => {
        this.router.navigate(['/login']);
      }, 2000);
      this.resetForm();
    } else {
      console.error('El formulario no es valido', this.registerForm.errors);
    }
  }

  storeUserInLocalStorage(user: User): void {
    const users = this.getUsersFromLocalStorage();
    users.push(user);
    localStorage.setItem('users', JSON.stringify(users));
  }

  getUsersFromLocalStorage(): User[] {
    const users = localStorage.getItem('users');
    return users ? JSON.parse(users) : [];
  }

  resetForm(): void {
    this.registerForm.reset();
    this.showErrorMessage = false;
  }
}
