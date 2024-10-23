import { Evaluation } from "./evaluation.interface";
import { User } from "./user.interface";

export interface Subject {
  id?: string,
  name: string;
  topics?: string;
  description?: string;
  schedule: [string];
  days: WeekDays[];
  teacher: User;
  evaluations?: Evaluation[]
}

export enum WeekDays {
    LUNES = "Lunes",
    MARTES = "Martes",
    MIERCOLES = "Miércoles",
    JUEVES = "Jueves",
    VIERNES = "Viernes",
    SABADO = "Sábado",
    DOMINGO = "Domingo",
}