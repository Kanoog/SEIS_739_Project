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

  listId: any;

  constructor(
    private taskService: TaskService, 
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      console.log("this is from new-task");
      this.listId = params['listId'];
      console.log(this.listId + "This is from new-task.ts");
    });
  }
  createTask(taskName: string) {
    this.taskService.createTask(this.listId, taskName).subscribe((data) => {
      const newTask = data as Task;
      console.log(newTask);
      //navigate back to list page after creating list
    });
  }
}
