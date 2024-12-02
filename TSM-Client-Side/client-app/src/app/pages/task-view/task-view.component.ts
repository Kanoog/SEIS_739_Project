import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../task.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-task-view',
  templateUrl: './task-view.component.html',
  styleUrl: './task-view.component.scss',
})

export class TaskViewComponent implements OnInit {
  lists: any[] | undefined;

  tasks: any[] | undefined;

  constructor(
    private taskService: TaskService,
    private route: ActivatedRoute
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      console.log(params);
      if(params['listId']){
        this.taskService.getTasks(params['listId']).subscribe((data: any) => {
          const tasks = data as any[];
          this.tasks = tasks;
        });
      }
    });
    this.taskService.getLists().subscribe((data: any) => {
      const lists = data as any[];
      this.lists = lists;
    });
  }
}
