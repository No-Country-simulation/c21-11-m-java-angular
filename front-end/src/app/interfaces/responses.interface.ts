import { Course } from "./course.interface";
import { Evaluation, Observation } from "./evaluation.interface";
import { Qualification } from "./qualification.interface";
import { Subject } from "./subject.interface";
import { User } from "./user.interface";

export interface UserResponse {  // cualquier tipo de usuario individual (get)
    success: boolean,
    message: string,
    data: User
}

export interface UsersResponse {  // traer usuarios en plural
    success: boolean,
    message: string,
    data: User[]
}

export interface SubjectResponse { 
    success: boolean,
    message: string,
    data: Subject
}

export interface SubjectsResponse {
    success: boolean,
    message: string,
    data: Subject[]
}

export interface EnrollResponse {   // respuesta a inscribir alumno
    success: boolean;
    message: string;
    data: User
}
  
export interface CourseResponse {
    success: boolean,
    message: string,
    data: Course
}

export interface EvaluationResponse {
    success: boolean,
    message: string,
    data: Evaluation
}

export interface EvaluationsResponse {
    success: boolean,
    message: string,
    data: Evaluation[]
}

export interface ObservationResponse {
    success: boolean,
    message: string,
    data: Observation
}

export interface QualificationResponse {
    success: boolean,
    message: string,
    data: Qualification
}

export interface QualificationsResponse {
    success: boolean,
    message: string,
    data: Qualification[]
}