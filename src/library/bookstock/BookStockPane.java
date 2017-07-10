package library.bookstock;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

public class BookStockPane extends Pane {
	ImageView ivSubTitle;
	Label imageContainer;
	Media media;
	MediaPlayer mediaPlayer;

	

	public BookStockPane() {
//		init();
	}
	
	public BookStockPane(SearchStockPane searchStockPane,AddStockPane addStockPane,UpdateStockPane updateStockPane,DeleteStockPane deleteStockPane,SubBookStockPane stockPane,SubBookStockPane addPane,SubBookStockPane updatePane,SubBookStockPane deletePane) {
		init(searchStockPane,addStockPane,updateStockPane,deleteStockPane,stockPane,addPane,updatePane,deletePane);
	}
	
	

	public void init(SearchStockPane searchStockPane,AddStockPane addStockPane,UpdateStockPane updateStockPane,DeleteStockPane deleteStockPane,SubBookStockPane stockPane,SubBookStockPane addPane,SubBookStockPane updatePane,SubBookStockPane deletePane) {
		
		this.getStylesheets().add("./css/Login.css");
		ivSubTitle = new ImageView("./images/bookStock1.png");
		imageContainer = new Label();
		imageContainer.setGraphic(ivSubTitle);
		imageContainer.setLayoutX(0);
		imageContainer.setLayoutY(0);
		Text stockSearch = new Text("库存查询");
		stockSearch.setId("stockSearch");
		stockSearch.setLayoutX(35);
		stockSearch.setLayoutY(25);
		Text addBook = new Text("添加库存信息");
		addBook.setId("addBook");
		addBook.setLayoutX(150);
		addBook.setLayoutY(25);
		Text updateBook = new Text("修改库存信息");
		updateBook.setId("updateBook");
		updateBook.setLayoutX(280);
		updateBook.setLayoutY(25);
		Text deleteBook = new Text("删除库存信息");
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
		this.getChildren().add(stockSearch);
		this.getChildren().add(addBook);
		this.getChildren().add(updateBook);
		this.getChildren().add(deleteBook);
		this.getChildren().add(ivSubBackground);
		this.getChildren().add(stockPane);
		this.getChildren().add(addPane);
		this.getChildren().add(updatePane);
		this.getChildren().add(deletePane);
		stockPane.setVisible(true);
		addPane.setVisible(false);
		updatePane.setVisible(false);
		deletePane.setVisible(false);
		
		stockSearch.setOnMouseEntered( e -> {
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
		stockSearch.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock1.png"));
			addPane.setVisible(false);
			updatePane.setVisible(false);
			deletePane.setVisible(false);
			stockPane.setVisible(true);
		});

		addBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock2.png"));
			stockPane.setVisible(false);
			updatePane.setVisible(false);
			deletePane.setVisible(false);
			addStockPane.SearchAll();
			addPane.setVisible(true);
			
		});
		updateBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock3.png")); 
			stockPane.setVisible(false);
			addPane.setVisible(false);
			deletePane.setVisible(false);
			updateStockPane.SearchAll();
			updatePane.setVisible(true);
		});
		deleteBook.setOnMouseClicked( e -> {
			imageContainer.setGraphic(new ImageView("./images/bookStock4.png"));
			stockPane.setVisible(false);
			addPane.setVisible(false);
			updatePane.setVisible(false);
			deleteStockPane.SearchAll();
			deletePane.setVisible(true);
		});
		
	}

}
