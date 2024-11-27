import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../task.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-task-view',
  templateUrl: './task-view.component.html',
  styleUrl: './task-view.component.scss'
})

export class TaskViewComponent implements OnInit {

  //lists:any[];

  tasks:any[] | undefined;

  constructor(private taskService:TaskService, private route:ActivatedRoute) { }

  ngOnInit() {
    this.route.params.subscribe(
      (params: Params)=>{
        console.log(params);
        this.taskService.getTasks(params['listId']).subscribe((tasks:any)=>{ 
          //try deleting brackets and '' around listId if it doesn't work
          this.tasks=tasks;
        })
      }
      
    )
    // need to fix below, after incorporating database and API:
    // this.taskService.getLists().subscribe((lists:any[]) => {
    //   this.lists=lists;
    // })
  }

}
