import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { List } from './models/list.model';
import { Task } from './models/task.model';

@Injectable({
  providedIn: 'root',
})
export class WebRequestService {
  readonly ROOT_URL;

  constructor(private http: HttpClient) {
    this.ROOT_URL = 'http://localhost:8080/api/lists';
  }

  //get all the list
  get() {
    return this.http.get(`${this.ROOT_URL}`);
  }

  //create a list
  postList(payload: Object) {
    console.log(payload);
    return this.http.post(`${this.ROOT_URL}`, payload);
  }

  //delete a list by list Id
  delete(uri: number) {
    return this.http.delete(`${this.ROOT_URL}/${uri}`);
  }

  //get the task by list Id
  getTaskByListId(listId: number) {
    return this.http.get(`${this.ROOT_URL}/${listId}/tasks`);
  }

  //create a task 
  postTask(listId: number, payload: Object) {
    console.log(payload);
    return this.http.post(`${this.ROOT_URL}/${listId}/tasks`, payload);
  }

  //update a task by its isComplete 
  patch(listId: number, task: Task, payload: Object) {
    return this.http.patch(`${this.ROOT_URL}/${listId}/tasks/${task.taskId}`, payload);
  }
}
