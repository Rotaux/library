package library.bookflow;

import java.util.Map;
import java.util.Vector;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.Pane;
import library.database.DBOperate;

public class BookTable extends Pane {

	public BookTable(String sql) {
		init(sql);
	}
	
	public void init(String sql) {
		
		ObservableList<Map> allData = DBOperate.getTableView(sql);
		Vector<String> columnNames = DBOperate.getFieldNames(sql);
		
		TableColumn<Map, String> c1 = new TableColumn<>("图书编号");
		TableColumn<Map, String> c2 = new TableColumn<>("图书书名");
		TableColumn<Map, String> c3 = new TableColumn<>("图书作者");
		TableColumn<Map, String> c4 = new TableColumn<>("出版社");
		TableColumn<Map, String> c5 = new TableColumn<>("类型");
		TableColumn<Map, String> c6 = new TableColumn<>("定价");
		TableColumn<Map, String> c7 = new TableColumn<>("图书类别");

		
		c1.setCellValueFactory(new MapValueFactory(columnNames.get(0)));
		c2.setCellValueFactory(new MapValueFactory(columnNames.get(1)));
		c3.setCellValueFactory(new MapValueFactory(columnNames.get(2)));
		c4.setCellValueFactory(new MapValueFactory(columnNames.get(3)));
		c5.setCellValueFactory(new MapValueFactory(columnNames.get(4)));
		c6.setCellValueFactory(new MapValueFactory(columnNames.get(5)));
		c7.setCellValueFactory(new MapValueFactory(columnNames.get(6)));
		
		c1.setMinWidth(120);
		c2.setMinWidth(120);
		c3.setMinWidth(120);
		c4.setMinWidth(120);
		c5.setMinWidth(120);
		c6.setMinWidth(120);
		c7.setMinWidth(120);
		
		TableView table_view = new TableView<>(allData);
     	table_view.setEditable(true);
		table_view.getSelectionModel().setCellSelectionEnabled(true);
		table_view.getColumns().setAll(c1, c2,c3,c4,c5,c6,c7);
		table_view.setPrefWidth(720);
		table_view.setPrefHeight(555);
		
		
		this.setLayoutX(0);
		this.setLayoutY(50);
		this.setPrefWidth(720);
		this.setPrefHeight(500);
		this.getChildren().add(table_view);
		
	}

}
