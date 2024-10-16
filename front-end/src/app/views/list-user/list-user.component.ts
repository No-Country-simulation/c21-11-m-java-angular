import { Component } from '@angular/core';
import { User } from '../../models/user/user.model';

import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';





@Component({
  selector: 'app-list-user',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './list-user.component.html',
  styleUrl: './list-user.component.css'
})
export class ListUserComponent {
  users: User[] = [];
  filteredUsers: User[] = [];
  searchTerm: string = '';
  selectedRole: string = '';

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    const storedUsers = localStorage.getItem('users');
    if (storedUsers) {
      this.users = JSON.parse(storedUsers);
      this.filteredUsers = [...this.users];
    }
  }
  earchUsers(): void {
    this.filteredUsers = this.users.filter(user => 
      (user.firstName.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
       user.lastName.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
       user.DNI.toString().includes(this.searchTerm)) &&
      (this.selectedRole === '' || user.Role === this.selectedRole)
    );
  }

  clearFilters(): void {
    this.searchTerm = '';
    this.selectedRole = '';
    this.filteredUsers = [...this.users];
  }

  deleteUser(dni: string): void {
    this.users = this.users.filter(user => user.DNI.toString() !== dni);
    this.filteredUsers = this.filteredUsers.filter(user => user.DNI.toString() !== dni);
    localStorage.setItem('users', JSON.stringify(this.users));
  }
 

  

}
