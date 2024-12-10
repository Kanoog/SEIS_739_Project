import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';
import { List } from './models/list.model';

@Injectable({
  providedIn: 'root',
})
export class TaskService {
  constructor(private webReqService: WebRequestService) {}

  //get all the lists
  getLists() {
    return this.webReqService.get();
  }
  //create a list
  createList(list: string) {
    return this.webReqService.postList({list});
  }

  //get task by list ID
  getTasks(listId: number) {
    return this.webReqService.getTaskByListId(listId);
  }

  //create a list
  createTask(listId: number, task: string) {
    return this.webReqService.postTask(listId, {task});
  }
}
