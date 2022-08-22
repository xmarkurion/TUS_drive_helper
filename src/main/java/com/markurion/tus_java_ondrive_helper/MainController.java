package com.markurion.tus_java_ondrive_helper;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {
    public Button btnAction;

    public void btnClick(){
        System.out.println("Btn Clicked");
    }

    public void btnInfoClick(){
        System.out.println("Btn info Clicked");
    }

    public void btnStartClick(){
        System.out.println("Btn start Clicked");
    }

    public void btnStopClick(){
        System.out.println("Btn stop Clicked");
    }

    public void btnInFolderClick() {
        System.out.println("Btn inFolder Clicked");
    }

    public void btnOutFolderClick() {
        System.out.println("Btn outFolder Clicked");
    }


}
