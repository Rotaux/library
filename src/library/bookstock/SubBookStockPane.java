package library.bookstock;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class SubBookStockPane extends Pane{
	
	public SubBookStockPane() {
		
	}
	
	
	public SubBookStockPane(SubBookStockPane subPane) {
		init(subPane);
	}
	
	public void init(SubBookStockPane subPane) {
		
		this.setLayoutX(0);
		this.setLayoutY(43);
		this.setPrefWidth(1000);
		this.setPrefHeight(609);
		this.getChildren().add(subPane);
		
	}

}
