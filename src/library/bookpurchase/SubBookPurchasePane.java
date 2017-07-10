package library.bookpurchase;

import javafx.scene.layout.Pane;

/**
 * Created by rotamx on 2017/7/10.
 */
public class SubBookPurchasePane extends Pane {

    public SubBookPurchasePane() {

    }


    public SubBookPurchasePane(SubBookPurchasePane subPane) {
        init(subPane);
    }

    public void init(SubBookPurchasePane subPane) {

        this.setLayoutX(0);
        this.setLayoutY(43);
        this.setPrefWidth(1000);
        this.setPrefHeight(609);
        this.getChildren().add(subPane);

    }
}
