package library.bookflow;

import java.util.Vector;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.bookstock.StorageTable;
import library.database.DBOperate;
import library.main.CommonClass;
import library.systemsetting.ReaderTable;

public class DeleteBookPane extends SubBookFlowPane {

	public static BookTable bookTable;

	public DeleteBookPane() {
		init();
	}

	public void init() {
		Text txtSearch = new Text("������Ҫɾ����ͼ���ţ�");
		txtSearch.setLayoutX(730);
		txtSearch.setLayoutY(65);
		this.getChildren().add(txtSearch);
		TextField tfSearch = new TextField();
		tfSearch.setPrefWidth(100);
		tfSearch.setLayoutX(880);
		tfSearch.setLayoutY(50);
		this.getChildren().add(tfSearch);
		Button btnSearch = new Button("��ѯ");
		btnSearch.setLayoutX(780);
		btnSearch.setLayoutY(95);
		this.getChildren().add(btnSearch);
		Button btnSearchAll = new Button("��ѯȫ��");
		btnSearchAll.setLayoutX(850);
		btnSearchAll.setLayoutY(95);
		this.getChildren().add(btnSearchAll);

		Label lblBookId = new Label("ͼ����:");
		Label lblBookName = new Label("ͼ������:");
		Label lblAuthor = new Label("ͼ������:");
		Label lblPublishingHouse = new Label("������:");
		Label lblType = new Label("����:");
		Label lblBookPrice = new Label("����:");

		TextField tfBookId = new TextField();
		TextField tfBookName = new TextField();
		TextField tfAuthor = new TextField();
		TextField tfPublishingHouse = new TextField();
		TextField tfType = new TextField();
		TextField tfBookPrice = new TextField();

		GridPane pane1 = new GridPane();
		pane1.setHgap(5);
		pane1.setVgap(20);

		pane1.add(lblBookId, 0, 1);
		pane1.add(tfBookId, 1, 1);
		pane1.add(lblBookName, 0, 2);
		pane1.add(tfBookName, 1, 2);
		pane1.add(lblAuthor, 0, 3);
		pane1.add(tfAuthor, 1, 3);
		pane1.add(lblPublishingHouse, 0, 4);
		pane1.add(tfPublishingHouse, 1, 4);
		pane1.add(lblType, 0, 5);
		pane1.add(tfType, 1, 5);
		pane1.add(lblBookPrice, 0, 6);
		pane1.add(tfBookPrice, 1, 6);

		pane1.setLayoutX(750);
		pane1.setLayoutY(138);

		this.getChildren().add(pane1);

		Button btnDelete = new Button("ɾ��");
		Button btnCancel = new Button("ȡ��");
		btnDelete.setLayoutX(760);
		btnDelete.setLayoutY(430);

		btnCancel.setLayoutX(850);
		btnCancel.setLayoutY(430);

		this.getChildren().add(btnDelete);
		this.getChildren().add(btnCancel);

		bookTable = new BookTable("select * from bookInfo");
		this.getChildren().add(bookTable);
		
		btnSearch.setOnAction(e -> {
			getChildren().remove(bookTable);
			String sql = "select * from bookInfo where BookID = '" + tfSearch.getText().trim() + "'";
			bookTable = new BookTable(sql);
			getChildren().add(bookTable);
			Vector<Vector<String>> data = DBOperate.getTable(sql);
			if (data.size() > 0) {
				tfBookId.setText(data.get(0).get(0));
				tfBookName.setText(data.get(0).get(1));
				tfAuthor.setText(data.get(0).get(2));
				tfPublishingHouse.setText(data.get(0).get(3));
				tfType.setText(data.get(0).get(4));
				tfBookPrice.setText(data.get(0).get(5));
			}
		});
		
		btnSearchAll.setOnAction( e -> {
			tfSearch.setText("");
			getChildren().remove(bookTable);
			String sql = "select * from bookInfo";
			bookTable = new BookTable(sql);
			getChildren().add(bookTable);
			tfBookId.setText("");
			tfBookName.setText("");
			tfAuthor.setText("");
			tfPublishingHouse.setText("");
			tfType.setText("");
			tfBookPrice.setText("");	
		});
		
		btnDelete.setOnAction( e -> {
//			int n = JOptionPane.showConfirmDialog(null, "��ȷ��Ҫɾ���Ȿͼ����Ϣ��", "����",JOptionPane.OK_CANCEL_OPTION);
//			if(n==0) {
//				String sql = "delete from bookInfo where BookID = '" + tfSearch.getText().trim() + "'";
//				if (DBOperate.tableUpdate(sql)>0) {
//				//	JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
//					getChildren().remove(bookTable);
//					String sql1 = "select * from storageInfo";
//					bookTable = new BookTable(sql1);
//					getChildren().add(bookTable);
//					tfBookId.setText("");
//					tfBookName.setText("");
//					tfAuthor.setText("");
//					tfPublishingHouse.setText("");
//					tfType.setText("");
//					tfBookPrice.setText("");
//				}
//			}else{
//
//			}
			if(CommonClass.confirmDialog("ȷ�϶Ի���","������Ϣ","��ȷ��Ҫɾ���Ȿͼ����Ϣ��") == true) {
				String sql = "delete from bookInfo where BookID = '" + tfSearch.getText().trim() + "'";
				if (DBOperate.tableUpdate(sql)>0) {
					//	JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					CommonClass.messageDialog("��ʾ��Ϣ","��ϲ","ɾ���ɹ�");
					getChildren().remove(bookTable);
					String sql1 = "select * from storageInfo";
					bookTable = new BookTable(sql1);
					getChildren().add(bookTable);
					tfBookId.setText("");
					tfBookName.setText("");
					tfAuthor.setText("");
					tfPublishingHouse.setText("");
					tfType.setText("");
					tfBookPrice.setText("");
				}
			}
		});

	}
}