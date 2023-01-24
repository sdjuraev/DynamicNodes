package com.example.dynamicnodes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private TextArea studentInfo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        File file=new File("src/main/resources/");
        VBox vBox=new VBox();
        vBox.setAlignment(Pos.BASELINE_CENTER);
        try {
            vBox.getChildren().addAll(
                    createCustomNode("Samidov Hamid", "2110022",file.toURI().toURL().toString()+"Image8.jpg","user1"),
            createCustomNode("Kamilov Davron", "2110018",file.toURI().toURL().toString()+"image1.jpg","user2"),
            createCustomNode("Karimov Dustim", "2110023",file.toURI().toURL().toString()+"image2.jfif","user3"),
            createCustomNode("Talipov Donyor", "2110024",file.toURI().toURL().toString()+"image4.jpg","user4"),
            createCustomNode("Shakirova Maftuna", "2110123",file.toURI().toURL().toString()+"image3.jpg","user5")
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        scrollPane.setContent(vBox);
    }

    public Node createCustomNode(String studentName, String studentID, String imageLink, String imageID){
        ImageView imageView=new ImageView();
        imageView.setImage(new Image(imageLink));
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        imageView.setId(imageID);
        imageView.setOnMouseClicked(mouseEvent -> Method1(studentName+"   "+studentID, studentInfo));
       VBox vBox=new VBox();
       vBox.getChildren().add(new Label(studentName));
       vBox.getChildren().add(new Label(studentID));
       HBox hBox1=new HBox();
       hBox1.setSpacing(20);
       hBox1.getChildren().add(imageView);
       hBox1.getChildren().add(vBox);
       hBox1.setStyle("-fx-padding: 5;" + "-fx-border-style: solid inside;"
               + "-fx-border-width: 2;" + "-fx-border-insets: 5;"
               + "-fx-border-radius: 5;" + "-fx-border-color: #1414e5");
       return hBox1;
    }

    public void Method1(String nameandID, TextArea textArea){
        textArea.setText(nameandID);

    }
}

