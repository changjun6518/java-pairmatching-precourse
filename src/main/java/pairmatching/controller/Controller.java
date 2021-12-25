package pairmatching.controller;

import pairmatching.view.InputView;

import javax.swing.plaf.PanelUI;

public class Controller {
    public void getUserChoice() {
        String userChoice = InputView.getUserChoice();
    }

    public void getCourseLevelMission() {
        String courseLevelMission = InputView.getCourseLevelMission();
    }
}
