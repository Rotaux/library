package library.main;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.*;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SubRootPane extends Pane{
	public SubRootPane() {
		init();
	}
	
	public void init() {
		this.setPrefWidth(1000);
		this.setPrefHeight(652);
		this.setLayoutX(150);
		this.setLayoutY(110);
		this.setBackground(null);
		Text txtWelcome = new Text("欢迎使用本软件！");
		txtWelcome.setLayoutX(400);
		txtWelcome.setLayoutY(250);
		txtWelcome.setFont(new Font(null,32));;
		this.getChildren().add(txtWelcome);
	}

}
