package com.example.myapplication.mvp;

import com.example.myapplication.view.dto.TaskItem;

import java.util.List;

public interface MainMVP {

    interface Model{

        List<TaskItem> getTask();
    }

    interface  Presenter {
        void loadTask();
        void  addNewTask();
    }

    interface  View {

        void showTaskList(List<TaskItem> items);
    }
}
