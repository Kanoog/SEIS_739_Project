import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class WebRequestService {
readonly ROOT_URL;
  constructor(private http:HttpClient) { 
    this.ROOT_URL='http://localhost:8080/api/lists'
  }
  get(){
    return this.http.get(`${this.ROOT_URL}`);
  }
  post(payload:Object) {
    return this.http.post(`${this.ROOT_URL}`, payload);
  }
  patch(uri:number, payload:Object) {
    return this.http.patch(`${this.ROOT_URL}/${uri}`, payload);
  }
  delete(uri:number) {
    return this.http.delete(`${this.ROOT_URL}/${uri}`);
  }
}
