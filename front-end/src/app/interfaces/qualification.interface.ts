import { Evaluation } from './evaluation.interface';
import { User } from './user.interface';

export interface Qualification {
  student: User;
  grade: Grades; // notas
  comment: string;
  evaluation: string // cada calificacion es de una evaluacion concreta
}

export enum Grades { // notas de alumnos
  ONE = '1',
  TWO = '2',
  THREE = '3',
  FOUR = '4',
  FIVE = '5',
  SIX = '6',
  SEVEN = '7',
  EIGHT = '8',
  NINE = '9',
  TEN = '10',
}
