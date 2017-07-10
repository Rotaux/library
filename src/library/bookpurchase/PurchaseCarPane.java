package library.bookpurchase;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.database.DBOperate;
import library.main.CommonClass;

import javax.swing.*;
import java.util.Vector;

/**
 * Created by rotamx on 2017/7/10.
 */
public class PurchaseCarPane extends SubBookPurchasePane {

    public static PurchaseCarTable purchaseCarTable;
    Button btnSearchAll;
    Button btnConfirm;
    TextField tfSearch = new TextField();
    TextField tfBookId = new TextField();
    TextField tfStafferId = new TextField();
    TextField tfProviderId = new TextField();
    TextField tfPurchaseDate = new TextField();
    TextField tfAllAmount = new TextField();
    TextField tfUnitPrice = new TextField();
    public PurchaseCarPane() {
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

        btnConfirm = new Button("确定购买");
        btnConfirm.setLayoutX(600);
        btnConfirm.setLayoutY(10);
        this.getChildren().add(btnConfirm);



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

        Button btnAdd = new Button("添加到购物车");
        Button btnCancel = new Button("取消");
        btnAdd.setLayoutX(760);
        btnAdd.setLayoutY(555);

        btnCancel.setLayoutX(850);
        btnCancel.setLayoutY(555);

        this.getChildren().add(btnAdd);
        this.getChildren().add(btnCancel);

        purchaseCarTable = new PurchaseCarTable("select * from purchaseCarTable");
        this.getChildren().add(purchaseCarTable);


        btnSearch.setOnMouseClicked( e -> {
            getChildren().remove(purchaseCarTable);
            String sql = "select * from purchaseCarTable where BookID = '"+tfSearch.getText().trim()+"'";
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
        btnSearchAll.setOnMouseClicked( e -> {
            SearchAll();
        });

        btnAdd.setOnAction( e -> {
            String bookId = tfBookId.getText();
            String stafferId = tfStafferId.getText();
            String providerId = tfProviderId.getText();
            String purchaseDate = tfPurchaseDate.getText();
            String allAmount = tfAllAmount.getText();
            String unitPrice = tfUnitPrice.getText();

            String sql = "insert into purchaseCarTable(ProviderID,StafferID,BookID,ProcurementDate,Amount,UnitPrice,AllPrice) "
                    + "values('" + providerId + "','" + stafferId + "','" + bookId + "','"
                    + purchaseDate + "','" + allAmount + "','" + unitPrice + "','"+Double.parseDouble(allAmount.trim()) * Double.parseDouble(unitPrice.trim())+"')";
            if (DBOperate.tableUpdate(sql) > 0) {
                //		JOptionPane.showMessageDialog(null, "添加成功");
                CommonClass.messageDialog("提示信息","恭喜","添加成功");
                tfBookId.setText("");
                tfStafferId.setText("");
                tfProviderId.setText("");
                tfPurchaseDate.setText("");
                tfAllAmount.setText("");
                tfUnitPrice.setText("");
                getChildren().remove(purchaseCarTable);
                String sql1 = "select * from purchaseCarTable";
                purchaseCarTable = new PurchaseCarTable(sql1);
                this.getChildren().add(purchaseCarTable);
            }
        });

        btnCancel.setOnAction( e -> {
            tfBookId.setText("");
            tfStafferId.setText("");
            tfProviderId.setText("");
            tfPurchaseDate.setText("");
            tfAllAmount.setText("");
            tfUnitPrice.setText("");
        });

        btnConfirm.setOnAction(e -> {
            String sql1 = "delete from purchaseCarTable where BookID = '" + tfSearch.getText().trim() + "'";
            DBOperate.tableUpdate(sql1);
            String bookId = tfBookId.getText();
            String stafferId = tfStafferId.getText();
            String providerId = tfProviderId.getText();
            String purchaseDate = tfPurchaseDate.getText();
            String allAmount = tfAllAmount.getText();
            String unitPrice = tfUnitPrice.getText();
            String sql = "insert into procurementInfo(ProviderID,StafferID,BookID,ProcurementDate,Amount,UnitPrice,AllPrice) "
                    + "values('" + providerId.trim() + "','" + stafferId.trim() + "','" + bookId.trim() + "','"
                    + purchaseDate.trim() + "','" + allAmount.trim() + "','" + unitPrice.trim() + "',Amount*UnitPrice)";
            if (DBOperate.tableUpdate(sql) > 0) {
                //		JOptionPane.showMessageDialog(null, "添加成功");
                CommonClass.messageDialog("提示信息","恭喜","所选择商品己购买成功");
                tfBookId.setText("");
                tfStafferId.setText("");
                tfProviderId.setText("");
                tfPurchaseDate.setText("");
                tfAllAmount.setText("");
                tfUnitPrice.setText("");
                getChildren().remove(purchaseCarTable);
                String sql3 = "select * from purchaseCarTable";
                purchaseCarTable = new PurchaseCarTable(sql3);
                this.getChildren().add(purchaseCarTable);
            }

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
