package library.bookflow;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
public class BookFlowPane extends Pane{
	ImageView ivSubTitle;
	Label imageContainer;
	Media media;
	MediaPlayer mediaPlayer;

	public BookFlowPane() {
		
	}
	public BookFlowPane(SearchBookPane subSearchBookPane,AddBookPane subAddBookPane,UpdateBookPane subUpdateBookPane,DeleteBookPane subDeleteBookPane,BorrowBookPane subBorrowBookPane,ReturnBookPane subReturnBookPane,SubBookFlowPane searchBookPane,SubBookFlowPane addBookPane,SubBookFlowPane updateBookPane,SubBookFlowPane deleteBookPane,SubBookFlowPane borrowBookPane,SubBookFlowPane returnBookPane) {
		init(subSearchBookPane,subAddBookPane,subUpdateBookPane,subDeleteBookPane,subBorrowBookPane,subReturnBookPane,searchBookPane,addBookPane,updateBookPane,deleteBookPane,borrowBookPane,returnBookPane);
	}
	
	public void init(SearchBookPane subSearchBookPane,AddBookPane subAddBookPane,UpdateBookPane subUpdateBookPane,DeleteBookPane subDeleteBookPane,BorrowBookPane subBorrowBookPane,ReturnBookPane subReturnBookPane,SubBookFlowPane searchBookPane,SubBookFlowPane addBookPane,SubBookFlowPane updateBookPane,SubBookFlowPane deleteBookPane,SubBookFlowPane borrowBookPane,SubBookFlowPane returnBookPane) {
		this.getStylesheets().add("./css/Login.css");
		ivSubTitle = new ImageView("./images/bookFlow1.png");
		imageContainer = new Label();
		imageContainer.setGraphic(ivSubTitle);
		imageContainer.setLayoutX(0);
		imageContainer.setLayoutY(0);
		Text searchBook = new Text("图书查询");
		searchBook.setId("stockSearch");
		searchBook.setLayoutX(35);
		searchBook.setLayoutY(25);
		Text addBook = new Text("添加图书信息");
		addBook.setId("addBook");
		addBook.setLayoutX(150);
		addBook.setLayoutY(25);
		Text updateBook = new Text("修改图书信息");
		updateBook.setId("updateBook");
		updateBook.setLayoutX(280);
		updateBook.setLayoutY(25);
		Text deleteBook = new Text("删除图书信息");
		deleteBook.setId("deleteBook");
		deleteBook.setLayoutX(410);
		deleteBook.setLayoutY(25);
		Text borrowBook = new Text("借阅图书");
		borrowBook.setId("borrowBook");
		borrowBook.setLayoutX(560);
		borrowBook.setLayoutY(27);
		Text returnBook = new Text("归还图书");
		returnBook.setId("returnBook");
		returnBook.setLayoutX(690);
		returnBook.setLayoutY(27);
		
		
		
		ImageView ivSubBackground = new ImageView("./images/subBackground.png");
		ivSubBackground.setLayoutX(0);
		ivSubBackground.setLayoutY(38);
		
		this.setLayoutX(0);
		this.setLayoutY(0);
		this.setPrefWidth(1000);
		this.setPrefHeight(652);
		
		this.getChildren().add(imageContainer);
		this.getChildren().add(searchBook);
		this.getChildren().add(addBook);
		this.getChildren().add(updateBook);
		this.getChildren().add(deleteBook);
		this.getChildren().add(borrowBook);
		this.getChildren().add(returnBook);
		this.getChildren().add(ivSubBackground);
		this.getChildren().add(searchBookPane);
		this.getChildren().add(addBookPane);
		this.getChildren().add(updateBookPane);
		this.getChildren().add(deleteBookPane);
		this.getChildren().add(borrowBookPane);
		this.getChildren().add(returnBookPane);
		searchBookPane.setVisible(true);
		addBookPane.setVisible(false);
		updateBookPane.setVisible(false);
		deleteBookPane.setVisible(false);
		borrowBookPane.setVisible(false);
		returnBookPane.setVisible(false);
		
		
		searchBook.setOnMouseEntered( e -> {
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
		borrowBook.setOnMouseEntered( e -> {
			try {
				media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
				mediaPlayer = new MediaPlayer(media);
				mediaPlayer.play();
			}catch(Exception ex){
				
			}	
		});
		returnBook.setOnMouseEntered( e -> {
			try {
				media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
				mediaPlayer = new MediaPlayer(media);
				mediaPlayer.play();
			}catch(Exception ex){
				
			}	
		});
		searchBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookFlow1.png"));
		    searchBookPane.setVisible(true);
			addBookPane.setVisible(false);
			updateBookPane.setVisible(false);
			deleteBookPane.setVisible(false);
			borrowBookPane.setVisible(false);
			returnBookPane.setVisible(false);
		});

		addBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookFlow2.png"));
			searchBookPane.setVisible(false);
			addBookPane.setVisible(true);
			updateBookPane.setVisible(false);
			deleteBookPane.setVisible(false);
			borrowBookPane.setVisible(false);
			returnBookPane.setVisible(false);
			
		});
		updateBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookFlow3.png")); 
			searchBookPane.setVisible(false);
			addBookPane.setVisible(false);
			updateBookPane.setVisible(true);
			deleteBookPane.setVisible(false);
			borrowBookPane.setVisible(false);
			returnBookPane.setVisible(false);
		});
		deleteBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookFlow4.png"));
			searchBookPane.setVisible(false);
			addBookPane.setVisible(false);
			updateBookPane.setVisible(false);
			deleteBookPane.setVisible(true);
			borrowBookPane.setVisible(false);
			returnBookPane.setVisible(false);
		});
		borrowBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookFlow5.png"));
			searchBookPane.setVisible(false);
			addBookPane.setVisible(false);
			updateBookPane.setVisible(false);
			deleteBookPane.setVisible(false);
			borrowBookPane.setVisible(true);
			returnBookPane.setVisible(false);
		});
		returnBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookFlow6.png"));
			searchBookPane.setVisible(false);
			addBookPane.setVisible(false);
			updateBookPane.setVisible(false);
			deleteBookPane.setVisible(false);
			borrowBookPane.setVisible(false);
			returnBookPane.setVisible(true);
		});
		
	}

}
