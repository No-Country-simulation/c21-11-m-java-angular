import { Component, signal } from '@angular/core';
import { ListUserComponent } from '../list-user/list-user.component';
import { routes } from '../../app.routes';
import { SaveUserComponent } from '../users/save-user/save-user.component';


@Component({
  selector: 'app-aside',
  standalone: true,
  imports: [ListUserComponent, SaveUserComponent],
  templateUrl: './aside.component.html',
  styleUrl: './aside.component.css'
})
export class AsideComponent {

  currentView = signal<'list' | 'register'>('list');

  setView(view: 'list' | 'register', event: Event) {
    event.preventDefault(); // Previene la recarga de la página
    this.currentView.set(view);
  }

}
