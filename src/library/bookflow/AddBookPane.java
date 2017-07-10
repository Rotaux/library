package library.bookflow;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.bookstock.StorageTable;
import library.database.DBOperate;
import library.main.CommonClass;

public class AddBookPane extends SubBookFlowPane{
	BookTable bookTable;
	public AddBookPane() {
		init();
	}
	
	public void init() {
		Text txtSearch = new Text("������ͼ���Ų�ѯ��");
		txtSearch.setLayoutX(150);
		txtSearch.setLayoutY(25);
		this.getChildren().add(txtSearch);
		TextField tfSearch = new TextField();
		tfSearch.setPrefWidth(100);
		tfSearch.setLayoutX(270);
		tfSearch.setLayoutY(10);
		this.getChildren().add(tfSearch);
		Button btnSearch = new Button("��ѯ");
		btnSearch.setLayoutX(400);
		btnSearch.setLayoutY(10);
		this.getChildren().add(btnSearch);
		
		Button btnSearchAll = new Button("��ѯȫ��");
		btnSearchAll.setLayoutX(500);
		btnSearchAll.setLayoutY(10);
		this.getChildren().add(btnSearchAll);

		Label lblBookId = new Label("ͼ����:");
		Label lblBookName= new Label("ͼ������:");
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
		pane1.setLayoutY(130);

		this.getChildren().add(pane1);

		Button btnAdd = new Button("���");
		Button btnCancel = new Button("ȡ��");
		btnAdd.setLayoutX(760);
		btnAdd.setLayoutY(500);

		btnCancel.setLayoutX(850);
		btnCancel.setLayoutY(500);

		this.getChildren().add(btnAdd);
		this.getChildren().add(btnCancel);

		bookTable = new BookTable("select * from bookInfo");
		this.getChildren().add(bookTable);
		
		
		btnSearch.setOnAction( e -> {
			getChildren().remove(bookTable);
			String sql = "select * from bookInfo where BookID = '"+tfSearch.getText().trim()+"'";
			bookTable = new BookTable(sql);
			getChildren().add(bookTable);
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
		
		btnAdd.setOnAction( e -> {
			String bookId = tfBookId.getText();
			String bookName = tfBookName.getText();
			String author = tfAuthor.getText();
			String publishingHouse = tfPublishingHouse.getText();
			String type = tfType.getText();
			String bookPrice = tfBookPrice.getText();
			
			String sql = "insert into bookInfo(BookID,BookName,Author,PublishingHouse,Type,BookPrice) "
					+ "values('" + bookId + "','" + bookName + "','" + author + "','"
					+ publishingHouse + "','" + type + "','" + bookPrice + "')";
			if (DBOperate.tableUpdate(sql) > 0) {
		//		JOptionPane.showMessageDialog(null, "��ӳɹ�");
				CommonClass.messageDialog("��ʾ��Ϣ","��ϲ","��ӳɹ�");
				tfBookId.setText("");
				tfBookName.setText("");
				tfAuthor.setText("");
				tfPublishingHouse.setText("");
				tfType.setText("");
				tfBookPrice.setText("");
				getChildren().remove(bookTable);
				String sql1 = "select * from bookInfo";
				bookTable = new BookTable(sql1);
				this.getChildren().add(bookTable);
			}
		});
		
		btnCancel.setOnAction( e -> {
			tfBookId.setText("");
			tfBookName.setText("");
			tfAuthor.setText("");
			tfPublishingHouse.setText("");
			tfType.setText("");
			tfBookPrice.setText("");
		});
		
		
		
		
		
	}

}
