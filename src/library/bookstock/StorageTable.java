package library.bookstock;
import java.util.Map;
import java.util.Vector;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.Pane;
import library.database.DBOperate;

public class StorageTable extends Pane{
	public static TableView table_view;
	public StorageTable(String sql) {
		init(sql);
	}
	
	public void init(String sql) {
		
		ObservableList<Map> allData = DBOperate.getTableView(sql);
		Vector<String> columnNames = DBOperate.getFieldNames(sql);
		
		TableColumn<Map, String> c1 = new TableColumn<>("库存编号");
		TableColumn<Map, String> c2 = new TableColumn<>("图书编号");
		TableColumn<Map, String> c3 = new TableColumn<>("员工编号");
		TableColumn<Map, String> c4 = new TableColumn<>("库存位置");
		TableColumn<Map, String> c5 = new TableColumn<>("采购日期");
		TableColumn<Map, String> c6 = new TableColumn<>("总数量");
		TableColumn<Map, String> c7 = new TableColumn<>("可借数量");
		TableColumn<Map, String> c8 = new TableColumn<>("单价");
		TableColumn<Map, String> c9 = new TableColumn<>("总金额");
		TableColumn<Map, String> c10 = new TableColumn<>("供应商编号");
		TableColumn<Map, String> c11 = new TableColumn<>("状态");
		TableColumn<Map, String> c12 = new TableColumn<>("ISBN");

		
		c1.setCellValueFactory(new MapValueFactory(columnNames.get(0)));
		c2.setCellValueFactory(new MapValueFactory(columnNames.get(1)));
		c3.setCellValueFactory(new MapValueFactory(columnNames.get(2)));
		c4.setCellValueFactory(new MapValueFactory(columnNames.get(3)));
		c5.setCellValueFactory(new MapValueFactory(columnNames.get(4)));
		c6.setCellValueFactory(new MapValueFactory(columnNames.get(5)));
		c7.setCellValueFactory(new MapValueFactory(columnNames.get(6)));
		c8.setCellValueFactory(new MapValueFactory(columnNames.get(7)));
		c9.setCellValueFactory(new MapValueFactory(columnNames.get(8)));
		c10.setCellValueFactory(new MapValueFactory(columnNames.get(9)));
		c11.setCellValueFactory(new MapValueFactory(columnNames.get(10)));
		c12.setCellValueFactory(new MapValueFactory(columnNames.get(11)));
	
		
		c1.setMinWidth(120);
		c2.setMinWidth(120);
		c3.setMinWidth(120);
		c4.setMinWidth(120);
		c5.setMinWidth(120);
		c6.setMinWidth(120);
		c7.setMinWidth(120);
		c8.setMinWidth(120);
		c9.setMinWidth(120);
		c10.setMinWidth(120);
		c11.setMinWidth(120);
		c12.setMinWidth(120);
		
		
		table_view = new TableView<>(allData);
     	table_view.setEditable(true);
		table_view.getSelectionModel().setCellSelectionEnabled(true);
		table_view.getColumns().setAll(c1, c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12);
		table_view.setPrefHeight(555);
		table_view.setPrefWidth(720);
		
		this.setLayoutX(0);
		this.setLayoutY(50);
		this.setPrefWidth(720);
		this.setPrefHeight(500);
		this.getChildren().add(table_view);
		
	}

}
