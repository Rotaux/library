package library.bookflow;

import java.util.Vector;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import library.database.DBOperate;

public class SearchBookPane extends SubBookFlowPane{
	BookTable bookTable;
	public SearchBookPane() {
		init();
	}
	
	public void init() {
		Text txtSearch = new Text("������ͼ���ţ�");
		txtSearch.setLayoutX(20);
		txtSearch.setLayoutY(25);
		this.getChildren().add(txtSearch);
		TextField tfSearch = new TextField();
		tfSearch.setPrefWidth(100);
		tfSearch.setLayoutX(120);
		tfSearch.setLayoutY(10);
		this.getChildren().add(tfSearch);
		
		Text txtBookNameSearch = new Text("ͼ��������");
		txtBookNameSearch.setLayoutX(240);
		txtBookNameSearch.setLayoutY(25);
		this.getChildren().add(txtBookNameSearch);
		
		TextField tfBookNameSearch = new TextField();
		tfBookNameSearch.setPrefWidth(100);
		tfBookNameSearch.setLayoutX(300);
		tfBookNameSearch.setLayoutY(10);
		this.getChildren().add(tfBookNameSearch);
		
		Text txtAuthor = new Text("ͼ�����ߣ�");
		txtAuthor.setLayoutX(425);
		txtAuthor.setLayoutY(25);
		this.getChildren().add(txtAuthor);
		
		TextField tfAuthor = new TextField();
		tfAuthor.setPrefWidth(100);
		tfAuthor.setLayoutX(480);
		tfAuthor.setLayoutY(10);
		this.getChildren().add(tfAuthor);

		Button btnSearch = new Button("��ѯ");
		btnSearch.setLayoutX(720);
		btnSearch.setLayoutY(10);
		this.getChildren().add(btnSearch);	
		Button btnSearchAll = new Button("��ѯȫ��ͼ��");
		btnSearchAll.setLayoutX(800);
		btnSearchAll.setLayoutY(10);
		this.getChildren().add(btnSearchAll);
		
		bookTable = new BookTable("select * from bookInfo");
		this.getChildren().add(bookTable);
		
		Text txtCategory = new Text("����:");
		txtCategory.setLayoutX(600);
		txtCategory.setLayoutY(25);
		this.getChildren().add(txtCategory);
		
		ComboBox<String> cmbCategory = new ComboBox<String>();
		String sql1 = "select * from CategoryTable";
		Vector<Vector<String>> table = DBOperate.getTable(sql1);
		for(int i = 0; i < table.size(); i++) {
//			cmbCategory.addItem(table.get(i).get(0));
			cmbCategory.getItems().add(table.get(i).get(0));
		}
		cmbCategory.getSelectionModel().select(0);
		cmbCategory.setLayoutX(630);
		cmbCategory.setLayoutY(10);
		this.getChildren().add(cmbCategory);
		
		
		btnSearch.setOnMouseClicked( e -> {
			getChildren().remove(bookTable);
//			String sql = "select * from bookInfo where BookID = '"+tfSearch.getText().trim()+"'";
			String sql = "select * from bookInfo where 1=1 ";
			if (!tfSearch.getText().trim().isEmpty())
				sql += " and BookID = '"+tfSearch.getText()+"'";
			if (!tfBookNameSearch.getText().trim().isEmpty())
				sql += " and BookName = '"+tfBookNameSearch.getText()+"'";
			if (!tfAuthor.getText().trim().isEmpty())
				sql += " and Author = '"+tfAuthor.getText()+"'";
			if (!cmbCategory.getSelectionModel().getSelectedItem().toString().equals("ȫ��"))
				sql += " and CategoryName = '"+cmbCategory.getSelectionModel().getSelectedItem().toString()+"'";
			bookTable = new BookTable(sql);
			getChildren().add(bookTable);
		});
		btnSearchAll.setOnMouseClicked( e -> {
			tfSearch.setText("");
			getChildren().remove(bookTable);
			String sql = "select * from bookInfo";
			bookTable = new BookTable(sql);
			getChildren().add(bookTable);
		});
		
	}

}
