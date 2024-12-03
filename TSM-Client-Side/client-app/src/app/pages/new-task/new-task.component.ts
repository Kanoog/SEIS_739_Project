import { Component } from '@angular/core';
import { TaskService } from '../../task.service';
import { ActivatedRoute, Params } from '@angular/router';
import { Task } from '../../models/task.model';

@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrl: './new-task.component.scss',
})
export class NewTaskComponent {

  listId!: number;

  constructor(private taskService: TaskService, private route: ActivatedRoute) {

  }

  ngOnInIt(){
    this.route.params.subscribe(
      (params: Params) => {
        this.listId = params['listId'];
        console.log(this.listId);
      }
    )
  }

  createTask(taskName: string) {
    this.taskService.createTask(this.listId, taskName).subscribe((data) => {
      const task = data as Task;
      console.log(task);
      //navigate back to list page after creating list
      // this.router.navigate(['/lists', this.listId, 'tasks/new-task']);
    });
  }
}
