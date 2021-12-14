package com.example.myapplication.presenter;

import com.example.myapplication.model.MainInteractor;
import com.example.myapplication.mvp.MainMVP;
import com.example.myapplication.view.dto.TaskItem;

import java.util.List;

public class MainPresenter implements MainMVP.Presenter {

    private MainMVP.View view;
    private MainMVP.Model model;

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

    }
}
