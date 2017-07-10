package library.bookpurchase;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.database.DBOperate;

import java.util.Vector;

/**
 * Created by rotamx on 2017/7/10.
 */
public class HadPurchasedPane extends SubBookPurchasePane {

    public static HadPurchasedTable hadPurchasedTable;
    Button btnSearchAll;
    TextField tfSearch = new TextField();

    public HadPurchasedPane() {
        init();
    }

    public void init() {
        Text txtSearch = new Text("请输入图书编号查询：");
        txtSearch.setLayoutX(150);
        txtSearch.setLayoutY(25);
        this.getChildren().add(txtSearch);
        tfSearch.setPrefWidth(100);
        tfSearch.setLayoutX(270);
        tfSearch.setLayoutY(10);
        this.getChildren().add(tfSearch);
        Button btnSearch = new Button("查询");
        btnSearch.setLayoutX(400);
        btnSearch.setLayoutY(10);
        this.getChildren().add(btnSearch);

        btnSearchAll = new Button("查询全部");
        btnSearchAll.setLayoutX(500);
        btnSearchAll.setLayoutY(10);
        this.getChildren().add(btnSearchAll);

        hadPurchasedTable = new HadPurchasedTable("select * from procurementInfo");
        this.getChildren().add(hadPurchasedTable);


        btnSearch.setOnAction(e -> {
            getChildren().remove(hadPurchasedTable);
            String sql = "select * from procurementInfo where BookID = '" + tfSearch.getText().trim() + "'";
            hadPurchasedTable = new HadPurchasedTable(sql);
            getChildren().add(hadPurchasedTable);

        });

        btnSearchAll.setOnAction(e -> {
            SearchAll();
        });


    }

    public void SearchAll() {
    tfSearch.setText("");
    getChildren().remove(hadPurchasedTable);
    String sql = "select * from procurementInfo";
        hadPurchasedTable = new HadPurchasedTable(sql);
    getChildren().add(hadPurchasedTable);

}
}