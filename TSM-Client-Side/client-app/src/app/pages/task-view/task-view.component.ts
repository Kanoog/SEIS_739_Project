import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../task.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { List } from '../../models/list.model';
import { Task } from '../../models/task.model';


@Component({
  selector: 'app-task-view',
  templateUrl: './task-view.component.html',
  styleUrl: './task-view.component.scss',
})

export class TaskViewComponent implements OnInit {

  lists: List[] = [];
  listId: number = 0;
  tasks: Task[] = [];
  selectedList: List | undefined; 
  selectedListId : number = 0;

  constructor(
    private taskService: TaskService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    this.route.params.subscribe((params: Params) => {
      if(params['listId']){
        this.taskService.getTasks(params['listId']).subscribe((data: any) => {
          const tasks = data as Task[];
          this.tasks = tasks;
        });
      this.listId = params['listId'];
      }
    });

    this.taskService.getLists().subscribe((data) => {
      const lists = data as List[];
      this.lists = lists;
    });
  }

  onTaskClick(task: Task) {
    this.taskService.completeTask(this.listId, task).subscribe(()=>{
      task.completed = !task.completed;
    });
  }

  onDeleteButton(list: List){
    if(this.selectedList != list) {
      this.selectedList = list;
    } else {
      this.selectedList = undefined;
    }
  }

  onDeleteList(listId: number){
    this.taskService.deleteList(listId).subscribe(()=>{
      this.lists = this.lists.filter(list => list.listId !== listId);
      this.tasks = this.tasks.filter(list => list.listId !== listId);
      this.router.navigate(['/lists']);
    });
    console.log("delete sucessfull");
  }
}