package com.example.myapplication.mvp;

import com.example.myapplication.view.dto.TaskItem;

import java.util.List;

public interface MainMVP {

    interface Model{

        List<TaskItem> getTask();

        void saveTask(TaskItem task);

        void updateTask(TaskItem item);

        void deleteTask(TaskItem task);
    }

    interface  Presenter {
        void loadTask();
        void  addNewTask();

        void taskItemClicked(TaskItem item);

        void updateTask(TaskItem task);

        void taskItemLongClicked(TaskItem task);

        void deleteTask(TaskItem task);
    }

    interface  View {

        void showTaskList(List<TaskItem> items);

        String getTaskDescription();

        void addTaskToList(TaskItem task);

        void updateTask(TaskItem task);

        void showConfirmDialog(String message,TaskItem task);

        void showDeleteDialog(String message, TaskItem task);

        void deleteTask(TaskItem task);
    }
}
