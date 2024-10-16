import { Routes } from '@angular/router';

export const routes: Routes = [
    {



      
        path: 'dashboard',
        loadComponent: () =>
          import('./views/dashboard/dashboard.component').then(
            (m) => m.DashboardComponent
          ),
        children: [
          {


            path: 'List',
            title: 'Post user interface',
            loadComponent: () =>
              import('./views/list-user/list-user.component').then(
                (m) => m.ListUserComponent
              ),
          },
          {
            path: 'user/:id',
            title: 'Get user interface',
            loadComponent: () =>
              import('./views/users/user/user.component').then(
                (m) => m.UserComponent
              ),
          },
          {
            path: 'delete/:id',
            title: 'Delete user interface',
            loadComponent: () =>
              import('./views/users/delete/delete.component').then(
                (m) => m.DeleteComponent
              ),
          },
          {
            path: 'post',
            title: 'Post user interface',
            loadComponent: () =>
              import('./views/users/save-user/save-user.component').then(
                (m) => m.SaveUserComponent
              ),
          },
          {
            path: '',
            redirectTo: 'dashboard',
            pathMatch: 'full',
          },
        ],
      },
      {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
      },

     


     
];
