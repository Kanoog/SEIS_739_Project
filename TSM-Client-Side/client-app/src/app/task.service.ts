import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';
import { List } from './models/list.model';
import { Task } from './models/task.model';

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

  //completed a task
  completeTask(listId: number, task: Task) {
    return this.webReqService.patch(listId, task, {'completed' : !task.completed});
  }
}
