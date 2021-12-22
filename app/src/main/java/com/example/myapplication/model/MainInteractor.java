package com.example.myapplication.model;

import com.example.myapplication.mvp.MainMVP;
import com.example.myapplication.view.dto.TaskItem;

import java.util.ArrayList;
import java.util.List;

public class MainInteractor implements MainMVP.Model {

    private List <TaskItem> tempItems;

    public MainInteractor(){
        tempItems = new ArrayList<>();
        tempItems.add(new TaskItem("Do the Shooping","November 20,2021"));
    }

    @Override
    public List<TaskItem> getTask() {
        return new ArrayList<>(tempItems);
    }

    @Override
    public void saveTask(TaskItem task) {
        tempItems.add(task);
    }

    @Override
    public void updateTask(TaskItem item) {

    }

    @Override
    public void deleteTask(TaskItem task) {

    }
}
