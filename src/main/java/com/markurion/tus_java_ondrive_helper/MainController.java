package com.markurion.tus_java_ondrive_helper;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.awt.Desktop;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.PrintWriter;

import java.nio.file.Files;
import java.nio.file.Path;

public class MainController {
    public Stage stage;
    public Button btnClose;
    public Button btnFinish;
    public Button btnInfo;
    public Label labelDate;
    public TextField tfieldSourcePath;
    public TextField tfieldName;
    public TextField tfieldInfo;
    private MainService ser;
    public File folder;
    public File createdFolderPath;
    public String folderName;

    private static FileWriter file;

    public MainController(){
        ConsoleColors.main();
        ser = new MainService();
        ser.setMainController(this);
    }

    @FXML public void initialize(){
        tfieldName.setDisable(true);
        tfieldInfo.setEditable(false);
//        btnFinish.setDisable(true);
        labelDate.setText(ser.getNowDate() + "__");
    }

    public void btnClose(){
        System.out.println("Btn close Clicked");
        Platform.exit();
    }

    public void btnInfoClick(){
        System.out.println("Btn info Clicked");
    }

    public void btnFinishClick() throws IOException {
        System.out.println("Btn Finish Clicked");
        createInfoJson();
        ser.createFileList();
    }

    public void btnInFolderClick() throws IOException {
        System.out.println("Btn inFolder Clicked");
//            this.folder = ser.pickFolderDBB(tfieldSourcePath, stage);

            //Laptop
            this.folder = new File("C:\\Users\\M\\Downloads\\NewThing");
            tfieldSourcePath.setText("C:\\Users\\M\\Downloads\\NewThing");
            tfieldName.setText("testFolder");
            //PC
//        this.folder = new File("C:\\Users\\Marcepan\\Downloads\\New folder\\2022-09-12");
//        tfieldSourcePath.setText("C:\\Users\\Marcepan\\Downloads\\New folder\\2022-09-12");

            tfieldName.setDisable(false);
            tfieldInfo.setText("Please enter title of the folder then press Start.");

    }

    public void btnStartClick() throws IOException {
        System.out.println("Btn start Clicked");
        tfieldName.setDisable(true);
        this.folderName = labelDate.getText() + tfieldName.getText();
        tfieldInfo.setText("Folder \"" + folderName + "\" is created on your desktop.");
        ConsoleColors.consolePrintln(ConsoleColors.BLACK_BACKGROUND, "Folder: " + folderName);

        String stringPath = System.getProperty("user.home") + "\\Desktop\\"+ folderName;
        new File(stringPath).mkdir();
        createdFolderPath = new File(stringPath);
        System.out.println(createdFolderPath.getPath());
    }

    public void btnOpenWorkDir() throws IOException {
        System.out.println("Btn btnOpenWorkDir Clicked");
        if(folder != null){
            Desktop.getDesktop().open(folder);
        }
    }

    public void btnOpenSourceDir() throws IOException {
        System.out.println("Btn btnOpenSourceDir Clicked");
        if(folder != null){
            Desktop.getDesktop().open(createdFolderPath);
        }
    }

    public void createInfoJson() throws IOException {
        JSONObject data = new JSONObject();
        try {
            data.put("Init_Date", ser.getDate());
            data.put("Source_Folder", createdFolderPath.getPath());
            data.put("Created_Folder+Path", createdFolderPath.getPath());
        }catch (JSONException e){
            e.printStackTrace();
        }

        try(PrintWriter out = new PrintWriter(new FileWriter(createdFolderPath.getPath() + "\\data.json"))){
            out.write(data.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}



