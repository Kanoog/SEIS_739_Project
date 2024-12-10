import { Task } from "./task.model";

export interface List {
    listId: number;
    list: string;
    task:Task[]
}
