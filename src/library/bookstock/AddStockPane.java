package library.bookstock;
import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.database.DBOperate;
import library.main.CommonClass;

public class AddStockPane extends SubBookStockPane {

	public static StorageTable storageTable;
	Button btnSearchAll;
	TextField tfSearch = new TextField();
//	TextField tfStockId = new TextField();
	TextField tfBookId = new TextField();
	TextField tfStafferId = new TextField();
	TextField tfProviderId = new TextField();
	TextField tfPurchaseDate = new TextField();
	TextField tfAllAmount = new TextField();
	TextField tfUnitPrice = new TextField();
	TextField tfBorrowAmount = new TextField();
	TextField tfStockPosition = new TextField();
	TextField tfState = new TextField();
	TextField tfIsbn = new TextField();
	public AddStockPane() {
		init();
	}

	public void init() {
		Text txtSearch = new Text("请输入库存编号查询：");
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

	//	Label lblStockId = new Label("库存编号:");
		Label lblBookId = new Label("图书编号:");
		Label lblStafferId = new Label("员工编号");
		Label lblProviderId = new Label("供应商编号:");
		Label lblPurchaseDate = new Label("采购日期:");
		Label lblAllAmount = new Label("总数量:");
		Label lblUnitPrice = new Label("单价:");
		Label lblBorrowAmount = new Label("可借数量:");
		Label lblStockPosition = new Label("库存位置:");
		Label lblState = new Label("状态");
		Label lblIsbn = new Label("ISBN号");

		GridPane pane1 = new GridPane();
		pane1.setHgap(5);
		pane1.setVgap(20);
	//	pane1.add(lblStockId, 0, 0);
	//	pane1.add(tfStockId, 1, 0);
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
		pane1.add(lblBorrowAmount, 0, 7);
		pane1.add(tfBorrowAmount, 1, 7);
		pane1.add(lblStockPosition, 0, 8);
		pane1.add(tfStockPosition, 1, 8);
		pane1.add(lblState, 0, 9);
		pane1.add(tfState, 1, 9);
		pane1.add(lblIsbn, 0, 10);
		pane1.add(tfIsbn, 1, 10);


		pane1.setLayoutX(750);
		pane1.setLayoutY(50);

		this.getChildren().add(pane1);

		Button btnAdd = new Button("添加");
		Button btnCancel = new Button("取消");
		btnAdd.setLayoutX(760);
		btnAdd.setLayoutY(535);

		btnCancel.setLayoutX(850);
		btnCancel.setLayoutY(535);

		this.getChildren().add(btnAdd);
		this.getChildren().add(btnCancel);

		storageTable = new StorageTable("select * from storageInfo");
		this.getChildren().add(storageTable);
		
		btnSearch.setOnMouseClicked(e -> {
			getChildren().remove(storageTable);
			String sql = "select * from storageInfo where StorageID = '"+tfSearch.getText().trim()+"'";
			storageTable = new StorageTable(sql);
			getChildren().add(storageTable);
		});
		btnAdd.setOnMouseClicked(e -> {
		//	String stockId = tfStockId.getText();
			String bookId = tfBookId.getText();
			String stafferId = tfStafferId.getText();
			String providerId = tfProviderId.getText();
			String purchaseDate = tfPurchaseDate.getText();
			String allAmount = tfAllAmount.getText();
			String unitPrice = tfUnitPrice.getText();
			String borrowAmount = tfBorrowAmount.getText();
			String stockPosition = tfStockPosition.getText();
			String state = tfState.getText();
			String isbn = tfIsbn.getText();
			String sql = "insert into storageInfo(BookID,StafferID,StorageAddress,StorageDate,AllMount,BorrowAmount,UnitPrice,AllPrice,ProviderID,State,ISBN)\n" +
					"values\n" +
					"('"+bookId+"','"+stafferId+"','"+stockPosition+"','"+purchaseDate+"','"+allAmount+"','"+borrowAmount+"','"+unitPrice+"',AllMount*UnitPrice,'"+providerId+"','"+state+"','"+isbn+"');";
			if (DBOperate.tableUpdate(sql) > 0) {
			//	JOptionPane.showMessageDialog(null, "添加成功");
				CommonClass.messageDialog("提示信息","恭喜","添加成功");
			//	tfStockId.setText("");
				tfBookId.setText("");
				tfStafferId.setText("");
				tfProviderId.setText("");
				tfPurchaseDate.setText("");
				tfAllAmount.setText("");
				tfUnitPrice.setText("");
				tfBorrowAmount.setText("");
				tfStockPosition.setText("");
				getChildren().remove(storageTable);
				String sql1 = "select * from storageInfo";
				storageTable = new StorageTable(sql1);
				this.getChildren().add(storageTable);
			}
		});
		btnCancel.setOnAction( e -> {
		//	tfStockId.setText("");
			tfBookId.setText("");
			tfStafferId.setText("");
			tfProviderId.setText("");
			tfPurchaseDate.setText("");
			tfAllAmount.setText("");
			tfUnitPrice.setText("");
			tfBorrowAmount.setText("");
			tfStockPosition.setText("");
		});
		
		btnSearchAll.setOnAction( e -> {
			SearchAll();	
		});
	}
	
	public void SearchAll() {
		tfSearch.setText("");
		getChildren().remove(storageTable);
		String sql = "select * from storageInfo";
		storageTable = new StorageTable(sql);
		getChildren().add(storageTable);
	//	tfStockId.setText("");
		tfBookId.setText("");
		tfStafferId.setText("");
		tfProviderId.setText("");
		tfPurchaseDate.setText("");
		tfAllAmount.setText("");
		tfUnitPrice.setText("");
		tfBorrowAmount.setText("");
		tfStockPosition.setText("");
	}
}
