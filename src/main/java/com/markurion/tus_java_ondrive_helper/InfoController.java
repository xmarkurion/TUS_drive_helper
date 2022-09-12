package com.markurion.tus_java_ondrive_helper;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class InfoController {
    public Button btnClose;
    @FXML private TextArea txtArea;
    private Stage stage;

    public InfoController() {
        System.out.println("Info controller.");
    }

    @FXML public void initialize(){
        txtArea.setEditable(false);
       txtArea.setText(infoTxt());
    }

    public void setStage(Stage stage){ this.stage = stage;}

    public void btnCloseController(ActionEvent e){
        System.out.print("click");
        stage.close();
    }

    private String infoTxt(){
       return "This app is for helping with data handling.\n" +
               "Select your folder where you want to save the files. \n" +
               "Enter the title of the folder you want to create. \n" +
               "Press start and a new folder will be created on desktop. \n"+
               "Do and change what you want inside the folder. \n" +
               "-... Then when you will finish just pres Finish. \n" +
               "All data will be packed into zip file and zip will be moved.\n" +
               "To the source folder.\n" +
               "Done by Markurion Github: xmarkurion";
    }
}
