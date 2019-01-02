import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class VividseatsService {

  private baseUrl:string = 'http://localhost:8080';

  constructor(private http:HttpClient) {}

  getAllEvents() {
    return this.http.get(this.baseUrl + '/events');
  }

  insertEvent(event) {
    let headers = new HttpHeaders();
    headers.append('Content-Type','application/json');
    headers.append('Accept', 'application/json');
    headers.append('Access-Control-Allow-Methods', 'POST, GET, OPTIONS, DELETE, PUT');
    headers.append('Access-Control-Allow-Origin', '*');
    return this.http.post(this.baseUrl + '/addEvent',
      event,
      {headers: headers});
  }
}
