import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class VividseatsService {

  private baseUrl:string = 'http://localhost:8080';

  constructor(private http:HttpClient) {}

  getAllEvents() {
    const headers = new Headers({'Content-Type': 'application/json', });
    return this.http.get(this.baseUrl + '/events');
  }

  insertEvent(event) {

  }
}
