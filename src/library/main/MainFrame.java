package library.main;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.bookflow.AddBookPane;
import library.bookflow.BookFlowPane;
import library.bookflow.BorrowBookPane;
import library.bookflow.DeleteBookPane;
import library.bookflow.ReturnBookPane;
import library.bookflow.SearchBookPane;
import library.bookflow.SubBookFlowPane;
import library.bookflow.UpdateBookPane;
import library.bookpurchase.*;
import library.bookstock.AddStockPane;
import library.bookstock.BookStockPane;
import library.bookstock.DeleteStockPane;
import library.bookstock.SearchStockPane;
import library.bookstock.SubBookStockPane;
import library.bookstock.UpdateStockPane;
import library.systemsetting.AddStudentPane;
import library.systemsetting.ChangePasswordPane;
import library.systemsetting.DeleteStudentPane;
import library.systemsetting.ReaderTable;
import library.systemsetting.SubSystemSettingPane;
import library.systemsetting.SystemSettingPane;
import library.systemsetting.UpdateStudentPane;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.image.*;
import javafx.geometry.Pos;
import javafx.scene.text.*;


public class MainFrame extends Stage {
	public Pane rootPane;
	double xOffset;
	double yOffset;
	private static ImageView iv1;
	private static Button ivBookStockButton;
	private static Button ivBookFlowButton;
	private static Button ivBookPurchaseButton;
	private static Button ivSystemSettingButton;
	public SubRootPane subRootPane = new SubRootPane();
//	BookStockPane subBookStockPane = new BookStockPane();
	Media media;
	MediaPlayer mediaPlayer;
	
	SearchStockPane searchStockPane = new SearchStockPane();
	AddStockPane addStockPane = new AddStockPane();
	UpdateStockPane updateStockPane = new UpdateStockPane();
	DeleteStockPane deleteStockPane = new DeleteStockPane();
	SubBookStockPane stockPane = new SubBookStockPane(searchStockPane);
	SubBookStockPane addPane = new SubBookStockPane(addStockPane);
	SubBookStockPane updatePane = new SubBookStockPane(updateStockPane);
	SubBookStockPane deletePane = new SubBookStockPane(deleteStockPane);
	
	SearchBookPane subSearchBookPane = new SearchBookPane();
	AddBookPane subAddBookPane = new AddBookPane();
	UpdateBookPane subUpdateBookPane = new UpdateBookPane();
	DeleteBookPane subDeleteBookPane = new DeleteBookPane();
	BorrowBookPane subBorrowBookPane = new BorrowBookPane();
	ReturnBookPane subReturnBookPane = new ReturnBookPane();
	SubBookFlowPane searchBookPane = new SubBookFlowPane(subSearchBookPane);
	SubBookFlowPane addBookPane = new SubBookFlowPane(subAddBookPane);
	SubBookFlowPane updateBookPane = new SubBookFlowPane(subUpdateBookPane);
	SubBookFlowPane deleteBookPane = new SubBookFlowPane(subDeleteBookPane);
	SubBookFlowPane borrowBookPane = new SubBookFlowPane(subBorrowBookPane);
	SubBookFlowPane returnBookPane = new SubBookFlowPane(subReturnBookPane);

	ChangePasswordPane changePasswordPane = new ChangePasswordPane();
    AddStudentPane addStudentPane = new AddStudentPane();
    UpdateStudentPane updateStudentPane = new UpdateStudentPane();
    DeleteStudentPane deleteStudentPane = new DeleteStudentPane();
	SubSystemSettingPane changePane = new SubSystemSettingPane(changePasswordPane);
	SubSystemSettingPane addPane1 = new SubSystemSettingPane(addStudentPane);
	SubSystemSettingPane updatePane1 = new SubSystemSettingPane(updateStudentPane);
	SubSystemSettingPane deletePane1 = new SubSystemSettingPane(deleteStudentPane);

	PurchaseCarPane purchaseCarPane = new PurchaseCarPane();
	UpdatePurchasePane updatePurchasePane = new UpdatePurchasePane();
	DeletePurchasePane deletePurchasePane = new DeletePurchasePane();
	HadPurchasedPane hadPurchasedPane = new HadPurchasedPane();
	SubBookPurchasePane purchasePane4 = new SubBookPurchasePane(purchaseCarPane);
	SubBookPurchasePane updatePane4 = new SubBookPurchasePane(updatePurchasePane);
	SubBookPurchasePane deletePane4= new SubBookPurchasePane(deletePurchasePane);
	SubBookPurchasePane hadPane = new SubBookPurchasePane(hadPurchasedPane);
	
	

	public MainFrame() {
		init();
	}

	public void init() {
		rootPane = new Pane();
		rootPane.setId("rootPane");
		rootPane.getStylesheets().add("./css/Login.css");
		rootPane.getChildren().add(subRootPane);
		Scene scene = new Scene(rootPane);
		ImageView ivTitle = new ImageView("./images/txtMainTitle.png");
		ivTitle.setLayoutX(32);
		ivTitle.setLayoutY(10);
		Text txtMainTitle = new Text("图书馆管理系统");
		txtMainTitle.setId("txtMainTitle");
		txtMainTitle.setLayoutX(140);
		txtMainTitle.setLayoutY(75);

		ivBookStockButton = new Button("图书库存管理");
		ivBookStockButton.setContentDisplay(ContentDisplay.TOP);
		ivBookStockButton.setId("ivButton");
		ivBookStockButton.setPrefWidth(120);
		ivBookStockButton.setPrefHeight(120);
		ivBookStockButton.setLayoutX(22);
		ivBookStockButton.setLayoutY(160);
		ivBookStockButton.setStyle("-fx-font-size: 16px;");
		ivBookStockButton.setBackground(null);
		ivBookStockButton.setGraphic(new ImageView("./images/bookManage.png"));

		ivBookFlowButton = new Button("图书流通管理");
		ivBookFlowButton.setContentDisplay(ContentDisplay.TOP);
		ivBookFlowButton.setPrefWidth(120);
		ivBookFlowButton.setPrefHeight(120);
		ivBookFlowButton.setLayoutX(22);
		ivBookFlowButton.setLayoutY(320);
		ivBookFlowButton.setStyle("-fx-font-size: 16px;");
		ivBookFlowButton.setBackground(null);
		ivBookFlowButton.setGraphic(new ImageView("./images/bookCirculate.png"));

		ivBookPurchaseButton = new Button("图书采购管理");
		ivBookPurchaseButton.setContentDisplay(ContentDisplay.TOP);
		ivBookPurchaseButton.setPrefWidth(120);
		ivBookPurchaseButton.setPrefHeight(120);
		ivBookPurchaseButton.setLayoutX(22);
		ivBookPurchaseButton.setLayoutY(470);
		ivBookPurchaseButton.setStyle("-fx-font-size: 16px;");
		ivBookPurchaseButton.setBackground(null);
		ivBookPurchaseButton.setGraphic(new ImageView("./images/bookPurchase.png"));

		ivSystemSettingButton = new Button("系统维护");
		ivSystemSettingButton.setContentDisplay(ContentDisplay.TOP);
		ivSystemSettingButton.setPrefWidth(120);
		ivSystemSettingButton.setPrefHeight(120);
		ivSystemSettingButton.setLayoutX(22);
		ivSystemSettingButton.setLayoutY(620);
		ivSystemSettingButton.setStyle("-fx-font-size: 16px;");
		ivSystemSettingButton.setBackground(null);
		ivSystemSettingButton.setGraphic(new ImageView("./images/systemSetting.png"));

//		ImageView ivRightBackground = new ImageView("./images/2.png");
//		ivRightBackground.setLayoutX(0);
//		ivRightBackground.setLayoutY(135);
//		rootPane.getChildren().add(ivRightBackground);
//		ImageView ivBottom = new ImageView("./images/bottom.PNG");
//		ivBottom.setLayoutX(0);
//		ivBottom.setLayoutY(758);
//		rootPane.getChildren().add(ivBottom);
		rootPane.getChildren().add(ivTitle);
		rootPane.getChildren().add(txtMainTitle);
		rootPane.getChildren().add(ivBookStockButton);
		rootPane.getChildren().add(ivBookFlowButton);
		rootPane.getChildren().add(ivBookPurchaseButton);
		rootPane.getChildren().add(ivSystemSettingButton);

		HBox paneForTopButton = new HBox(0);
		paneForTopButton.getStylesheets().add("./css/Login.css");
		paneForTopButton.setAlignment(Pos.TOP_RIGHT);
		Button closeButton = new Button();
		closeButton.setPrefWidth(30);
		closeButton.setPrefHeight(27);
		closeButton.setId("closeButton");
		Button miniButton = new Button();
		miniButton.setPrefWidth(30);
		miniButton.setPrefHeight(27);
		miniButton.setId("miniButton");
		Button aboutButton = new Button();
		aboutButton.setPrefWidth(30);
		aboutButton.setPrefHeight(27);
		aboutButton.setId("aboutButton");
		paneForTopButton.getChildren().addAll(aboutButton, miniButton, closeButton);
		paneForTopButton.setLayoutX(1110);
		paneForTopButton.setLayoutY(0);
		rootPane.getChildren().add(paneForTopButton);

		this.setScene(scene);
		this.setWidth(1200);
		this.setHeight(800);
		this.getIcons().add(new Image(getClass().getResource("./images/ico.png").toExternalForm()));
		this.initStyle(StageStyle.UNDECORATED);
		this.setResizable(false);
		aboutButton.setOnAction(e -> {
			new MyGitHub().show();
		});
		closeButton.setOnAction(e -> {
			System.exit(0);
		});

		miniButton.setOnAction(e -> {
			setIconified(true);
		});
		scene.setOnMousePressed(e -> {
			xOffset = e.getScreenX() - getX();
			yOffset = e.getScreenY() - getY();
		});
		scene.setOnMouseDragged(e -> {
			setX(e.getScreenX() - xOffset);
			setY(e.getScreenY() - yOffset);

		});
		ivBookStockButton.setOnMouseEntered(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivBookStockButton.setTextFill(Color.AQUA);
			ivBookStockButton.setGraphic(new ImageView("./images/bookManage1.png"));
			mediaPlayer.play();
		});
		ivBookStockButton.setOnMouseExited(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivBookStockButton.setTextFill(Color.BLACK);
			ivBookStockButton.setGraphic(new ImageView("./images/bookManage.png"));
			mediaPlayer.pause();
		});
		ivBookStockButton.setOnMouseClicked(e -> {
			subRootPane.getChildren().clear();
			subRootPane.getChildren().add(new BookStockPane(searchStockPane,addStockPane,updateStockPane,deleteStockPane,stockPane,addPane,updatePane,deletePane));
		});
		
		ivBookFlowButton.setOnMouseClicked(e -> {
			subRootPane.getChildren().clear();
//			subRootPane.getChildren().add(new TestPane2());
//			BookFlowPane bookFlowPane = new BookFlowPane();
			subRootPane.getChildren().add(new BookFlowPane(subSearchBookPane,subAddBookPane,subUpdateBookPane,subDeleteBookPane,subBorrowBookPane,subReturnBookPane,searchBookPane,addBookPane,updateBookPane,deleteBookPane,borrowBookPane,returnBookPane));
		});
		ivSystemSettingButton.setOnMouseClicked(e -> {
			subRootPane.getChildren().clear();
			subRootPane.getChildren().add(new SystemSettingPane(changePasswordPane,addStudentPane,updateStudentPane,deleteStudentPane,changePane,addPane1,updatePane1,deletePane1));
		});
		ivBookPurchaseButton.setOnMouseClicked(e -> {
			subRootPane.getChildren().clear();
			subRootPane.getChildren().add(new BookPurchasePane(purchaseCarPane, updatePurchasePane, deletePurchasePane, hadPurchasedPane, purchasePane4, updatePane4, deletePane4, hadPane));
		});
		ivBookFlowButton.setOnMouseEntered(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivBookFlowButton.setTextFill(Color.AQUA);
			ivBookFlowButton.setGraphic(new ImageView("./images/bookCirculate1.png"));
			mediaPlayer.play();
		});
		ivBookFlowButton.setOnMouseExited(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivBookFlowButton.setTextFill(Color.BLACK);
			ivBookFlowButton.setGraphic(new ImageView("./images/bookCirculate.png"));
			mediaPlayer.pause();
		});
		ivBookPurchaseButton.setOnMouseEntered(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivBookPurchaseButton.setTextFill(Color.AQUA);
			ivBookPurchaseButton.setGraphic(new ImageView("./images/bookPurchase1.png"));
			mediaPlayer.play();
		});
		ivBookPurchaseButton.setOnMouseExited(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivBookPurchaseButton.setTextFill(Color.BLACK);
			ivBookPurchaseButton.setGraphic(new ImageView("./images/bookPurchase.png"));
			mediaPlayer.pause();
		});
		ivSystemSettingButton.setOnMouseEntered(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivSystemSettingButton.setTextFill(Color.AQUA);
			ivSystemSettingButton.setGraphic(new ImageView("./images/systemSetting1.png"));
			mediaPlayer.play();
		});
		ivSystemSettingButton.setOnMouseExited(e -> {
			media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
			mediaPlayer = new MediaPlayer(media);
			ivSystemSettingButton.setTextFill(Color.BLACK);
			ivSystemSettingButton.setGraphic(new ImageView("./images/systemSetting.png"));
			mediaPlayer.pause();
		});
	}

}
