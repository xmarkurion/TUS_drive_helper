package com.markurion.tus_java_ondrive_helper;

import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class MainService {
    private final String nowDate;
    private final String date;

    private MainController mainController;


    public MainService(){
        this.nowDate = formatedDate();
        this.date = formatedDate();

        listOfFiles = new ArrayList<>();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public String getDate(){
        return date;
    }

    public String getNowDate(){
        return nowDate;
    }

    private String formatedDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date dateOBJ = new Date();
        return sdf.format(dateOBJ);
    }



    /**
     * Opens file picker in java FX.
     * @param field
     * @param stage
     * @return  return object File class.
     * @throws IOException
     */
    public File pickFolderDBB(TextField field, Stage stage) throws IOException {
        File datt;
        DirectoryChooser directoryChooser = new DirectoryChooser();
        if(field.getText().length() == 0 ){
            datt = directoryChooser.showDialog(stage);
            field.setText(datt.getPath());
        }else {
            System.out.println("Is not nulll");
            directoryChooser.setInitialDirectory(new File(field.getText()));
            datt = directoryChooser.showDialog(stage);

            //In case user cancel the file select
            if(datt!=null) {field.setText(datt.getPath());
            }else{datt = new File(field.getText());}
        }
        field.setStyle("-fx-control-inner-background: green");
        return datt;
    }

    /**
     * Creates a list of files inside a folder.
     */
    public void createFileList(){
        System.out.println(mainController.createdFolderPath.getPath());

    }

    public ArrayList<File> generateFileList(Path folderPatch) throws IOException {
        ArrayList<File> listOfFiles = null;

        try {
            Stream<Path> paths = Files.walk(folderPatch);
            paths.forEach((pathTofile) -> {
                File currentFile = new File("" + pathTofile);
                listOfFiles.add(currentFile);
            });
        }catch (IOException e){
            e.printStackTrace();
        }
        return listOfFiles;
    }
}
