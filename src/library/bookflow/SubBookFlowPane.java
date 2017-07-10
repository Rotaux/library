package library.bookflow;

import javafx.scene.layout.Pane;

public class SubBookFlowPane extends Pane{
	
public SubBookFlowPane() {
		
	}
	
	
	public SubBookFlowPane(SubBookFlowPane subPane) {
		init(subPane);
	}
	
	public void init(SubBookFlowPane subPane) {
		
		this.setLayoutX(0);
		this.setLayoutY(43);
		this.setPrefWidth(1000);
		this.setPrefHeight(609);
		this.getChildren().add(subPane);
		
	}
	

}
