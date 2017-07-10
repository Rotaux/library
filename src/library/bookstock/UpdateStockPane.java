package library.bookstock;

import java.util.Vector;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import library.database.DBOperate;
import library.main.CommonClass;

public class UpdateStockPane extends SubBookStockPane {
	public static StorageTable storageTable;
	Button btnSearchAll;
	TextField tfSearch = new TextField();
	TextField tfStockId = new TextField();
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
	public UpdateStockPane() {
		init();
	}

	public void init() {
		Text txtSearch = new Text("������Ҫ�޸ĵĿ���ţ�");
		txtSearch.setLayoutX(150);
		txtSearch.setLayoutY(25);
		this.getChildren().add(txtSearch);
		tfSearch.setPrefWidth(100);
		tfSearch.setLayoutX(270);
		tfSearch.setLayoutY(10);
		this.getChildren().add(tfSearch);
		Button btnSearch = new Button("��ѯ");
		btnSearch.setLayoutX(400);
		btnSearch.setLayoutY(10);
		this.getChildren().add(btnSearch);

		btnSearchAll = new Button("��ѯȫ��");
		btnSearchAll.setLayoutX(500);
		btnSearchAll.setLayoutY(10);
		this.getChildren().add(btnSearchAll);

		//	Label lblStockId = new Label("�����:");
		Label lblBookId = new Label("ͼ����:");
		Label lblStafferId = new Label("Ա�����");
		Label lblProviderId = new Label("��Ӧ�̱��:");
		Label lblPurchaseDate = new Label("�ɹ�����:");
		Label lblAllAmount = new Label("������:");
		Label lblUnitPrice = new Label("����:");
		Label lblBorrowAmount = new Label("�ɽ�����:");
		Label lblStockPosition = new Label("���λ��:");
		Label lblState = new Label("״̬");
		Label lblIsbn = new Label("ISBN��");

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

		Button btnUpdate = new Button("�޸�");
		Button btnCancel = new Button("ȡ��");
		btnUpdate.setLayoutX(760);
		btnUpdate.setLayoutY(555);

		btnCancel.setLayoutX(850);
		btnCancel.setLayoutY(555);

		this.getChildren().add(btnUpdate);
		this.getChildren().add(btnCancel);

		storageTable = new StorageTable("select * from storageInfo");
		this.getChildren().add(storageTable);

		btnSearch.setOnAction(e -> {
			getChildren().remove(storageTable);
			String sql = "select * from storageInfo where StorageID = '" + tfSearch.getText().trim() + "'";
			storageTable = new StorageTable(sql);
			getChildren().add(storageTable);
			Vector<Vector<String>> data = DBOperate.getTable(sql);
			if (data.size()>0) {
				tfStockId.setText(data.get(0).get(0));
				tfBookId.setText(data.get(0).get(1));
				tfStafferId.setText(data.get(0).get(2));
				tfProviderId.setText(data.get(0).get(9));
				tfPurchaseDate.setText(data.get(0).get(4));
				tfAllAmount.setText(data.get(0).get(5));
				tfUnitPrice.setText(data.get(0).get(7));
				tfBorrowAmount.setText(data.get(0).get(6));
				tfStockPosition.setText(data.get(0).get(3));
				tfState.setText(data.get(0).get(10));
				tfIsbn.setText(data.get(0).get(11));
			}
		});
		
		btnSearchAll.setOnAction( e -> {
			SearchAll();	
		});

		btnUpdate.setOnAction(e -> {
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
//			String sql = "update storageInfo set BookID = '"+bookId+"',StafferID = '"+stafferId+"',StorageAddress = '"+stockPosition+"'," +
//					"StorageDate = '"+purchaseDate+"',AllMount = '"+allAmount+"',BorrowAmount = '"+borrowAmount+"',UnitPrice = '"+unitPrice+"'," +
//					"AllPrice = 'AllMount*UnitPrice',ProviderID = '"+providerId+"',State = '"+state+"' ,ISBN = '"+isbn+"'  +  where StorageID = '"+tfSearch.getText().trim()+"'";


			String sql = "update storageInfo set BookID='"+bookId+"',StafferID='"+stafferId+"',StorageAddress='"+stockPosition+"',StorageDate='"+purchaseDate+"',AllMount='"+allAmount+"',BorrowAmount='"+borrowAmount+"',UnitPrice='"+unitPrice+"',ProviderID='"+providerId+"',State='"+state+"',ISBN='"+isbn+"',AllPrice = AllMount*UnitPrice where StorageID = '"+tfSearch.getText().trim()+"'";



			if(DBOperate.tableUpdate(sql)>0) {
			//	JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				CommonClass.messageDialog("��ʾ��Ϣ","��ϲ","�޸ĳɹ�");
				getChildren().remove(storageTable);
				String sql1 = "select * from storageInfo where StorageID = '" + tfSearch.getText().trim() + "'";
				storageTable = new StorageTable(sql1);
				getChildren().add(storageTable);
				tfStockId.setText("");
				tfBookId.setText("");
				tfStafferId.setText("");
				tfProviderId.setText("");
				tfPurchaseDate.setText("");
				tfAllAmount.setText("");
				tfUnitPrice.setText("");
				tfBorrowAmount.setText("");
				tfStockPosition.setText("");
				tfState.setText("");
				tfIsbn.setText("");
				
			}

		});
		
		btnCancel.setOnAction( e -> {
			tfStockId.setText("");
			tfBookId.setText("");
			tfStafferId.setText("");
			tfProviderId.setText("");
			tfPurchaseDate.setText("");
			tfAllAmount.setText("");
			tfUnitPrice.setText("");
			tfBorrowAmount.setText("");
			tfStockPosition.setText("");
			tfState.setText("");
			tfIsbn.setText("");
			
		});
	}
	public void SearchAll() {
		tfSearch.setText("");
		getChildren().remove(storageTable);
		String sql = "select * from storageInfo";
		storageTable = new StorageTable(sql);
		getChildren().add(storageTable);
		tfStockId.setText("");
		tfBookId.setText("");
		tfStafferId.setText("");
		tfProviderId.setText("");
		tfPurchaseDate.setText("");
		tfAllAmount.setText("");
		tfUnitPrice.setText("");
		tfBorrowAmount.setText("");
		tfStockPosition.setText("");
		tfState.setText("");
		tfIsbn.setText("");
	}

}
