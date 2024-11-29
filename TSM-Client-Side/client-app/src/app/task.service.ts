import { Injectable } from '@angular/core';
import { WebRequestService } from './web-request.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private webReqService:WebRequestService) { }

  createList(title:string) {
    //we want to send a web request to create a list
    return this.webReqService.post({title});
  }

  getLists(){
    return this.webReqService.get();
  }

  getTasks(listId:number) {
    return this.webReqService.get(`/${listId}/tasks`);
  }
}
