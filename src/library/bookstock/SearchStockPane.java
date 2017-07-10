package library.bookstock;
import javafx.embed.swing.SwingNode;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class SearchStockPane extends SubBookStockPane{
	StorageTable storageTable;
	public SearchStockPane() {
		init();
	}
	
	public void init() {
//		this.setLayoutX(0);
//		this.setLayoutY(43);
//		this.setPrefWidth(1000);
//		this.setPrefHeight(609);
//		Text test = new Text("测试修改面板");
//		this.getChildren().add(test);
		Text txtSearch = new Text("请输入库存编号查询：");
		txtSearch.setLayoutX(150);
		txtSearch.setLayoutY(25);
		this.getChildren().add(txtSearch);
		TextField tfSearch = new TextField();
		tfSearch.setPrefWidth(100);
		tfSearch.setLayoutX(270);
		tfSearch.setLayoutY(10);
		this.getChildren().add(tfSearch);
		Button btnSearch = new Button("查询");
		btnSearch.setLayoutX(400);
		btnSearch.setLayoutY(10);
		this.getChildren().add(btnSearch);	
		Button btnSearchAll = new Button("查询全部");
		btnSearchAll.setLayoutX(500);
		btnSearchAll.setLayoutY(10);
		this.getChildren().add(btnSearchAll);
		
		
		
	/*	final SwingNode swingNode = new SwingNode();
		createSwingContent(swingNode);
		this.getChildren().add(swingNode);
		*/
		
		
		storageTable = new StorageTable("select * from storageInfo");
		this.getChildren().add(storageTable);
//		storageTable.setVisible(true);
//		this.getChildren().add(new BookTable("select * from bookInfo"));
//		this.getChildren().add(new StorageTable("select * from storageInfo"));
//		this.getChildren().add(new StorageTable("exec searchStorageInfo"));
		btnSearch.setOnMouseClicked( e -> {
			getChildren().remove(storageTable);
			String sql = "select * from storageInfo where StorageID = '"+tfSearch.getText().trim()+"'";
			storageTable = new StorageTable(sql);
			
			getChildren().add(storageTable);

		});
		btnSearchAll.setOnMouseClicked( e -> {
			tfSearch.setText("");
			getChildren().remove(storageTable);
			String sql = "select * from storageInfo";
			storageTable = new StorageTable(sql);
			getChildren().add(storageTable);
		});
	}
	
	/*
	private void createSwingContent(final SwingNode swingNode) {
		SwingUtilities.invokeLater(() -> {
			JTable objTable = new JTable();
			DefaultTableModel objModel = new DefaultTableModel();
			Vector<String> columnIdentifiers = new Vector<String>();
			columnIdentifiers.add("库存编号");
			columnIdentifiers.add("图书编号");
			columnIdentifiers.add("员工编号");
			columnIdentifiers.add("库存位置");
			columnIdentifiers.add("采购日期");
			columnIdentifiers.add("总数量");
			columnIdentifiers.add("可借数量");
			columnIdentifiers.add("单价");
			columnIdentifiers.add("总金额");
			columnIdentifiers.add("供应商编号");
			String sql = "select * from storageInfo";
			Vector<Vector<String>> data = DBOperate.getTable(sql);
			objModel.setDataVector(data, columnIdentifiers);
			objTable.setModel(objModel);
			JScrollPane storageTable = new JScrollPane(objTable);
			swingNode.setContent(storageTable);
		});
	}
	
	*/

}
