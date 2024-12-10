import { Component } from '@angular/core';
import { TaskService } from '../../task.service';
import { Router } from '@angular/router';
import { List } from '../../models/list.model';

@Component({
  selector: 'app-new-list',
  templateUrl: './new-list.component.html',
  styleUrl: './new-list.component.scss'
})
export class NewListComponent {
  constructor(private taskService: TaskService, private router: Router) {

  }

  createList(listName: string) {
    this.taskService.createList(listName).subscribe((data) => {
      const list = data as List;
      //navigate back to list page after creating list
      this.router.navigate(['/lists', list.listId, 'tasks']);
    });
  }
}
