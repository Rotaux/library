package library.systemsetting;

import javafx.scene.layout.Pane;

public class SubSystemSettingPane extends Pane{
	
public SubSystemSettingPane() {
		
	}
	
	
	public SubSystemSettingPane(SubSystemSettingPane subPane) {
		init(subPane);
	}
	
	public void init(SubSystemSettingPane subPane) {
		
		this.setLayoutX(0);
		this.setLayoutY(43);
		this.setPrefWidth(1000);
		this.setPrefHeight(609);
		this.getChildren().add(subPane);
		
	}

}
