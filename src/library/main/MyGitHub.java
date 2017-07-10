package library.main;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.*;
import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
/*
public class MyGitHub extends Stage {
    public MyGitHub() {
        StackPane paneForImage = new StackPane();
        paneForImage.setId("paneForImage");
        paneForImage.getStylesheets().add("./css/Login.css");
        this.setWidth(350);
        this.setHeight(390);
        this.initStyle(StageStyle.UNDECORATED);
        Image image = new Image(getClass().getResource("./images/mygithub2.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        paneForImage.getChildren().add(imageView);
        Scene scene = new Scene(paneForImage);
        this.setScene(scene);
    }
}
*/
/*
public class MyGitHub extends Stage {
    public MyGitHub() {
        init();
    }

    public void init() {
        StackPane paneForImage = new StackPane();
        paneForImage.setId("paneForImage");
        paneForImage.getStylesheets().add("./css/Login.css");
        this.setWidth(350);
        this.setHeight(390);
        this.initStyle(StageStyle.UNDECORATED);
        Image image = new Image(getClass().getResource("./images/mygithub2.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        paneForImage.getChildren().add(imageView);
        Scene scene = new Scene(paneForImage);
        this.setScene(scene);
    }
}
*/

public class MyGitHub extends Stage {
    public MyGitHub() {
        init();
    }

    public void init() {
        BorderPane paneForImage = new BorderPane();
        paneForImage.setId("paneForImage");
        paneForImage.getStylesheets().add("./css/Login.css");
        paneForImage.setStyle("-fx-background:#f0f8ff");
        HBox paneForTop = new HBox();
        Button closeButton = new Button();
        closeButton.setId("closeButton");
        closeButton.setPrefWidth(30);
        closeButton.setPrefHeight(27);
        paneForTop.getChildren().add(closeButton);
        paneForTop.setAlignment(Pos.TOP_RIGHT);
        this.setWidth(350);
        this.setHeight(400);
        this.initStyle(StageStyle.UNDECORATED);
        Image image = new Image(getClass().getResource("./images/mygithub2.png").toExternalForm());
        ImageView imageView = new ImageView(image);
        paneForImage.setCenter(imageView);
        paneForImage.setTop(paneForTop);
        Scene scene = new Scene(paneForImage);
        this.setScene(scene);
        this.setResizable(false);
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {                
                close();
            }
        });
    }
}






















