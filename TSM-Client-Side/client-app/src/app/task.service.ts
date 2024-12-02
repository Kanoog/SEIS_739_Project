import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private webReqService:WebRequestService) { }


  //create a list
  createList(list:string) {
    return this.webReqService.post({list});
  }

  //get all the lists
  getLists(){
    return this.webReqService.get();
  }

  //get task by list ID
  getTasks(listId:number) {
    return this.webReqService.getTaskByListId(listId);
  }
}
