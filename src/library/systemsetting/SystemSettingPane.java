package library.systemsetting;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import library.bookstock.AddStockPane;
import library.bookstock.DeleteStockPane;
import library.bookstock.SearchStockPane;
import library.bookstock.SubBookStockPane;
import library.bookstock.UpdateStockPane;

public class SystemSettingPane extends Pane{

	ImageView ivSubTitle;
	Label imageContainer;
	Media media;
	MediaPlayer mediaPlayer;
	
	public SystemSettingPane() {
//		init();
	}
	
	public SystemSettingPane(ChangePasswordPane changePasswordPane,AddStudentPane addStudentPane,UpdateStudentPane updateStudentPane,DeleteStudentPane deleteStudentPane,SubSystemSettingPane changePane,SubSystemSettingPane addPane1,SubSystemSettingPane updatePane1,SubSystemSettingPane deletePane1) {
		init(changePasswordPane,addStudentPane,updateStudentPane,deleteStudentPane,changePane,addPane1,updatePane1,deletePane1);
	}

	public void init(ChangePasswordPane changePasswordPane,AddStudentPane addStudentPane,UpdateStudentPane updateStudentPane,DeleteStudentPane deleteStudentPane,SubSystemSettingPane changePane,SubSystemSettingPane addPane1,SubSystemSettingPane updatePane1,SubSystemSettingPane deletePane1) {
		
		this.getStylesheets().add("./css/Login.css");
		ivSubTitle = new ImageView("./images/bookStock1.png");
		imageContainer = new Label();
		imageContainer.setGraphic(ivSubTitle);
		imageContainer.setLayoutX(0);
		imageContainer.setLayoutY(0);
		Text changePassword = new Text("密码修改");
		changePassword.setId("stockSearch");
		changePassword.setLayoutX(35);
		changePassword.setLayoutY(25);
		Text addBook = new Text("添加读者信息");
		addBook.setId("addBook");
		addBook.setLayoutX(150);
		addBook.setLayoutY(25);
		Text updateBook = new Text("修改读者信息");
		updateBook.setId("updateBook");
		updateBook.setLayoutX(280);
		updateBook.setLayoutY(25);
		Text deleteBook = new Text("删除读者信息");
		deleteBook.setId("deleteBook");
		deleteBook.setLayoutX(410);
		deleteBook.setLayoutY(25);
		
		
		ImageView ivSubBackground = new ImageView("./images/subBackground.png");
		ivSubBackground.setLayoutX(0);
		ivSubBackground.setLayoutY(38);
		
		this.setLayoutX(0);
		this.setLayoutY(0);
		this.setPrefWidth(1000);
		this.setPrefHeight(652);
		
		this.getChildren().add(imageContainer);
		this.getChildren().add(changePassword);
		this.getChildren().add(addBook);
		this.getChildren().add(updateBook);
		this.getChildren().add(deleteBook);
		this.getChildren().add(ivSubBackground);
		this.getChildren().add(changePane);
		this.getChildren().add(addPane1);
		this.getChildren().add(updatePane1);
		this.getChildren().add(deletePane1);
		changePane.setVisible(true);
		addPane1.setVisible(false);
		updatePane1.setVisible(false);
		deletePane1.setVisible(false);
		
		changePassword.setOnMouseEntered( e -> {
			try {
				media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			    mediaPlayer = new MediaPlayer(media);
			    mediaPlayer.play();
			}catch(Exception ex){
				
			}	
		});
		addBook.setOnMouseEntered( e -> {
			try {
				media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
				mediaPlayer = new MediaPlayer(media);
				mediaPlayer.play();
			}catch(Exception ex){
				
			}
			
		});
		updateBook.setOnMouseEntered( e -> {
			try {
				media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
				mediaPlayer = new MediaPlayer(media);
				mediaPlayer.play();
			}catch(Exception ex){
				
			}
		});
		deleteBook.setOnMouseEntered( e -> {
			try {
				media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
				mediaPlayer = new MediaPlayer(media);
				mediaPlayer.play();
			}catch(Exception ex){
				
			}	
		});
		changePassword.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock1.png"));
			addPane1.setVisible(false);
			updatePane1.setVisible(false);
			deletePane1.setVisible(false);
			changePasswordPane.Cancel();
			changePane.setVisible(true);
		});

		addBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock2.png"));
			changePane.setVisible(false);
			updatePane1.setVisible(false);
			deletePane1.setVisible(false);
			addStudentPane.SearchAll();
			addPane1.setVisible(true);
		});
		updateBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock3.png")); 
			changePane.setVisible(false);
			addPane1.setVisible(false);
			deletePane1.setVisible(false);
			updateStudentPane.SearchAll();
			updatePane1.setVisible(true);
		});
		deleteBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock4.png"));
			changePane.setVisible(false);
			addPane1.setVisible(false);
			updatePane1.setVisible(false);
			deleteStudentPane.SearchAll();
			deletePane1.setVisible(true);
		});
		
	}
	

}
