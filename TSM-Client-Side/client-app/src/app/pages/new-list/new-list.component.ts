import { Component } from '@angular/core';
import { TaskService } from '../../task.service';
import { Router } from '@angular/router';
import { List } from '../../models/list.mode';

@Component({
  selector: 'app-new-list',
  templateUrl: './new-list.component.html',
  styleUrl: './new-list.component.scss'
})
export class NewListComponent {
  constructor(private taskService:TaskService, private router:Router) {

  }

  createList(title:string) {
    this.taskService.createList(title).subscribe((response: any)=> {
      console.log(response);
      //now we navigate to /lists/response._id
      this.router.navigate(['/lists',response._id]);
    });
  }
}
