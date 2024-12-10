import { Component } from '@angular/core';
import { TaskService } from '../../task.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
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
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      this.listId = params['listId'];
    });
  }
  createTask(taskName: string) {
    this.taskService.createTask(this.listId, taskName).subscribe((data) => {
      const newTask = data as Task;
      //navigate back to list page after creating list
      this.router.navigate(['../'], {relativeTo: this.route});
    });
  }
}
