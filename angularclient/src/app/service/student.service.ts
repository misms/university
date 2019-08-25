import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Student } from '../model/student';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private studentsUrl: string;

  constructor(private http: HttpClient) {
    this.studentsUrl = 'http://localhost:8888/students';
  }

  public findAll(): Observable<Student[]> {
    return this.http.get<Student[]>(this.studentsUrl);
  }

  public save(student: Student){
    return this.http.post<Student>(this.studentsUrl, student);
  } 
}
