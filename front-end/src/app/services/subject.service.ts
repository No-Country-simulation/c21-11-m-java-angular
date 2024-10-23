import { HttpClient } from '@angular/common/http';
import { inject, Injectable } from '@angular/core';
import { catchError, map, Observable, of } from 'rxjs';
import { Subject } from '../interfaces/subject.interface';
import { SubjectResponse, SubjectsResponse } from '../interfaces/responses.interface';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root',
})
export class SubjectService {
  private http = inject(HttpClient);
  private apiUrl = environment.apiUrl;

  getSubjects(): Observable<Subject[] | null> {
    return this.http.get<SubjectsResponse>(`${this.apiUrl}/subjects`).pipe(
      map((res) => {
        if (res.success) {
          return res.data;
        } else {
          throw new Error(res.message);
        }
      }),
      catchError((err) => {
        return of(err.message);
      })
    );
  }

  getSubjectById(id: string): Observable<Subject | null> {
    return this.http.get<SubjectResponse>(`${this.apiUrl}/subjects/${id}`).pipe(
      map((res) => {
        if (res.success) {
          return res.data;
        } else {
          throw new Error(res.message);
        }
      }),
      catchError((err) => {
        return of(err.message);
      })
    );
  }

  saveSubject(subject: Subject): Observable<Subject | null> {
    return this.http.post<SubjectResponse>(`${this.apiUrl}/subjects`, subject).pipe(
      map((res) => {
        if (res.success) {
          return res.data;
        } else {
          throw new Error(res.message);
        }
      }),
      catchError((err) => {
        return of(err.message);
      })
    );
  }
}
