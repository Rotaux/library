package library.bookpurchase;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import library.bookstock.*;

/**
 * Created by rotamx on 2017/7/10.
 */
public class BookPurchasePane extends Pane {
    ImageView ivSubTitle;
    Label imageContainer;
    Media media;
    MediaPlayer mediaPlayer;


    public BookPurchasePane() {
//		init();
    }

    public BookPurchasePane(PurchaseCarPane purchaseCarPane, UpdatePurchasePane updatePurchasePane, DeletePurchasePane deletePurchasePane, HadPurchasedPane hadPurchasedPane,
                            SubBookPurchasePane purchasePane4, SubBookPurchasePane updatePane4, SubBookPurchasePane deletePane4, SubBookPurchasePane hadPane) {
        init(purchaseCarPane, updatePurchasePane, deletePurchasePane, hadPurchasedPane, purchasePane4, updatePane4, deletePane4, hadPane);
    }

    public void init(PurchaseCarPane purchaseCarPane, UpdatePurchasePane updatePurchasePane, DeletePurchasePane deletePurchasePane, HadPurchasedPane hadPurchasedPane,
                     SubBookPurchasePane purchasePane4, SubBookPurchasePane updatePane4, SubBookPurchasePane deletePane4, SubBookPurchasePane hadPane) {

        this.getStylesheets().add("./css/Login.css");
        ivSubTitle = new ImageView("./images/bookStock1.png");
        imageContainer = new Label();
        imageContainer.setGraphic(ivSubTitle);
        imageContainer.setLayoutX(0);
        imageContainer.setLayoutY(0);
        Text purchaseCar = new Text("购物车");
        purchaseCar.setId("stockSearch");
        purchaseCar.setLayoutX(35);
        purchaseCar.setLayoutY(25);
        Text update = new Text("修改采购信息");
        update.setId("addBook");
        update.setLayoutX(150);
        update.setLayoutY(25);
        Text delete = new Text("删除采购信息");
        delete.setId("updateBook");
        delete.setLayoutX(280);
        delete.setLayoutY(25);
        Text hadPurchase = new Text("己采购信息");
        hadPurchase.setId("deleteBook");
        hadPurchase.setLayoutX(410);
        hadPurchase.setLayoutY(25);


        ImageView ivSubBackground = new ImageView("./images/subBackground.png");
        ivSubBackground.setLayoutX(0);
        ivSubBackground.setLayoutY(38);

        this.setLayoutX(0);
        this.setLayoutY(0);
        this.setPrefWidth(1000);
        this.setPrefHeight(652);

        this.getChildren().add(imageContainer);
        this.getChildren().add(purchaseCar);
        this.getChildren().add(update);
        this.getChildren().add(delete);
        this.getChildren().add(ivSubBackground);
        this.getChildren().add(hadPurchase);
        this.getChildren().add(purchasePane4);
        this.getChildren().add(updatePane4);
        this.getChildren().add(deletePane4);
        this.getChildren().add(hadPane);
        purchasePane4.setVisible(true);
        updatePane4.setVisible(false);
        deletePane4.setVisible(false);
        hadPane.setVisible(false);

        purchaseCar.setOnMouseEntered( e -> {
            try {
                media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }catch(Exception ex){

            }
        });
        hadPurchase.setOnMouseEntered( e -> {
            try {
                media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }catch(Exception ex){

            }

        });
        update.setOnMouseEntered( e -> {
            try {
                media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }catch(Exception ex){

            }
        });
        delete.setOnMouseEntered( e -> {
            try {
                media = new Media(this.getClass().getResource("./sounds/buttonSound.wav").toString());
                mediaPlayer = new MediaPlayer(media);
                mediaPlayer.play();
            }catch(Exception ex){

            }
        });
        purchaseCar.setOnMouseClicked( e -> {
            imageContainer.setGraphic(new ImageView("./images/bookStock1.png"));
            purchasePane4.setVisible(true);
            updatePane4.setVisible(false);
            deletePane4.setVisible(false);
            hadPane.setVisible(false);
            purchaseCarPane.SearchAll();

        });

        hadPurchase.setOnMouseClicked( e -> {
            imageContainer.setGraphic(new ImageView("./images/bookStock4.png"));
            purchasePane4.setVisible(false);
            updatePane4.setVisible(false);
            deletePane4.setVisible(false);
            hadPane.setVisible(true);
           hadPurchasedPane.SearchAll();

        });
        update.setOnMouseClicked( e -> {
            imageContainer.setGraphic(new ImageView("./images/bookStock2.png"));
            purchasePane4.setVisible(false);
            updatePane4.setVisible(true);
            deletePane4.setVisible(false);
            hadPane.setVisible(false);
            updatePurchasePane.SearchAll();
        });
        delete.setOnMouseClicked( e -> {
            imageContainer.setGraphic(new ImageView("./images/bookStock3.png"));
            purchasePane4.setVisible(false);
            updatePane4.setVisible(false);
            deletePane4.setVisible(true);
            hadPane.setVisible(false);
            deletePurchasePane.SearchAll();
        });


    }
}