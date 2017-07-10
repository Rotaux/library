package library.bookpurchase;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.bookstock.StorageTable;
import library.bookstock.SubBookStockPane;
import library.database.DBOperate;
import library.main.CommonClass;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by rotamx on 2017/7/10.
 */
public class UpdatePurchasePane extends SubBookPurchasePane {
    public static PurchaseCarTable purchaseCarTable;
    Button btnSearchAll;
    TextField tfSearch = new TextField();
    TextField tfBookId = new TextField();
    TextField tfStafferId = new TextField();
    TextField tfProviderId = new TextField();
    TextField tfPurchaseDate = new TextField();
    TextField tfAllAmount = new TextField();
    TextField tfUnitPrice = new TextField();

    public UpdatePurchasePane() {
        init();
    }

    public void init() {
        Text txtSearch = new Text("请输入要修改的采购图书编号：");
        txtSearch.setLayoutX(730);
        txtSearch.setLayoutY(65);
        this.getChildren().add(txtSearch);
        TextField tfSearch = new TextField();
        tfSearch.setPrefWidth(100);
        tfSearch.setLayoutX(880);
        tfSearch.setLayoutY(50);
        this.getChildren().add(tfSearch);
        Button btnSearch = new Button("查询");
        btnSearch.setLayoutX(780);
        btnSearch.setLayoutY(90);
        this.getChildren().add(btnSearch);
        Button btnSearchAll = new Button("查询全部");
        btnSearchAll.setLayoutX(850);
        btnSearchAll.setLayoutY(90);
        this.getChildren().add(btnSearchAll);

        Label lblProviderId = new Label("供应商编号:");
        Label lblStafferId = new Label("员工编号");
        Label lblBookId = new Label("图书编号:");
        Label lblPurchaseDate = new Label("采购日期:");
        Label lblAllAmount = new Label("数量:");
        Label lblUnitPrice = new Label("单价:");
        Label lblAllPrice = new Label("总金额");


        GridPane pane1 = new GridPane();
        pane1.setHgap(5);
        pane1.setVgap(20);
        pane1.add(lblBookId, 0, 1);
        pane1.add(tfBookId, 1, 1);
        pane1.add(lblStafferId, 0, 2);
        pane1.add(tfStafferId, 1, 2);
        pane1.add(lblProviderId, 0, 3);
        pane1.add(tfProviderId, 1, 3);
        pane1.add(lblPurchaseDate, 0, 4);
        pane1.add(tfPurchaseDate, 1, 4);
        pane1.add(lblAllAmount, 0, 5);
        pane1.add(tfAllAmount, 1, 5);
        pane1.add(lblUnitPrice, 0, 6);
        pane1.add(tfUnitPrice, 1, 6);

        pane1.setLayoutX(750);
        pane1.setLayoutY(138);

        this.getChildren().add(pane1);

        Button btnUpdate = new Button("修改");
        Button btnCancel = new Button("取消");
        btnUpdate.setLayoutX(760);
        btnUpdate.setLayoutY(555);

        btnCancel.setLayoutX(850);
        btnCancel.setLayoutY(555);

        this.getChildren().add(btnUpdate);
        this.getChildren().add(btnCancel);

        purchaseCarTable = new PurchaseCarTable("select * from purchaseCarTable");
        this.getChildren().add(purchaseCarTable);

        btnSearch.setOnAction(e -> {
            getChildren().remove(purchaseCarTable);
            String sql = "select * from purchaseCarTable where BookID = '" + tfSearch.getText().trim() + "'";
            purchaseCarTable = new PurchaseCarTable(sql);
            getChildren().add(purchaseCarTable);
            Vector<Vector<String>> data = DBOperate.getTable(sql);
            if (data.size() > 0) {
                tfBookId.setText(data.get(0).get(3));
                tfStafferId.setText(data.get(0).get(2));
                tfProviderId.setText(data.get(0).get(1));
                tfPurchaseDate.setText(data.get(0).get(4));
                tfAllAmount.setText(data.get(0).get(5));
                tfUnitPrice.setText(data.get(0).get(6));
            }
        });

        btnSearchAll.setOnAction(e -> {
            SearchAll();
        });

        btnUpdate.setOnAction(e -> {
            String bookId = tfBookId.getText();
            String stafferId = tfStafferId.getText();
            String providerId = tfProviderId.getText();
            String purchaseDate = tfPurchaseDate.getText();
            String allAmount = tfAllAmount.getText();
            String unitPrice = tfUnitPrice.getText();
            String sql = "update purchaseCarTable set BookID='"+bookId+"',StafferID='"+stafferId+"',ProviderId='"+providerId+"',ProcurementDate='"+purchaseDate+"',Amount='"+allAmount+"',UnitPrice='"+unitPrice+"\n" +
                    "',AllPrice = Amount*UnitPrice where BookID = '"+tfSearch.getText().trim()+"'";
            if (DBOperate.tableUpdate(sql) > 0) {
                CommonClass.messageDialog("信息提示框","恭喜","修改成功");
                getChildren().remove(purchaseCarTable);
                String sql1 = "select * from purchaseCarTable where BookID = '" + tfSearch.getText().trim() + "'";
                purchaseCarTable = new PurchaseCarTable(sql1);
                getChildren().add(purchaseCarTable);
                tfBookId.setText("");
                tfStafferId.setText("");
                tfProviderId.setText("");
                tfPurchaseDate.setText("");
                tfAllAmount.setText("");
                tfUnitPrice.setText("");
            }

        });

        btnCancel.setOnAction(e -> {
            tfBookId.setText("");
            tfStafferId.setText("");
            tfProviderId.setText("");
            tfPurchaseDate.setText("");
            tfAllAmount.setText("");
            tfUnitPrice.setText("");

        });
    }

    public void SearchAll() {
        tfSearch.setText("");
        getChildren().remove(purchaseCarTable);
        String sql = "select * from purchaseCarTable";
        purchaseCarTable = new PurchaseCarTable(sql);
        getChildren().add(purchaseCarTable);
        tfBookId.setText("");
        tfStafferId.setText("");
        tfProviderId.setText("");
        tfPurchaseDate.setText("");
        tfAllAmount.setText("");
        tfUnitPrice.setText("");
    }
}