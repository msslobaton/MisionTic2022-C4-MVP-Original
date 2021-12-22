package com.example.myapplication.presenter;

import com.example.myapplication.model.MainInteractor;
import com.example.myapplication.mvp.MainMVP;
import com.example.myapplication.view.dto.TaskItem;
import com.example.myapplication.view.dto.TaskState;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainPresenter implements MainMVP.Presenter {

    private  final MainMVP.View view;
    private final MainMVP.Model model;

    public MainPresenter(MainMVP.View view){
        this.view = view;
        model = new MainInteractor();
    }

    @Override
    public void loadTask() {
       List <TaskItem> items = model.getTask();
       view.showTaskList(items);

    }

    @Override
    public void addNewTask() {
       String description= view.getTaskDescription();
       String date = SimpleDateFormat.getDateTimeInstance().format(new Date());

       TaskItem task= new TaskItem(description,date);
       model.saveTask(task);
       view.addTaskToList(task);
    }

    @Override
    public void taskItemClicked(TaskItem task) {
        String message = task.getState() == TaskState.PENDING
                ? "Desea Marcar la tarea como terminada?"
                : "Desea marcar como pendiente la tarea?";
        view.showConfirmDialog(message,task);
    }

    @Override
    public void updateTask(TaskItem task) {

        task.setState(task.getState() == TaskState.PENDING ? TaskState.DONE: TaskState.PENDING);

        model.updateTask(task);
        view.updateTask(task);
    }

    @Override
    public void taskItemLongClicked(TaskItem task) {
        if (task.getState() == TaskState.DONE) {
            view.showDeleteDialog("Desea eliminar la tarea?", task);
        }
    }

    @Override
    public void deleteTask(TaskItem task) {
        model.deleteTask(task);
        view.deleteTask(task);
    }
}
