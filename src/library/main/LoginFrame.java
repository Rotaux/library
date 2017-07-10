package library.main;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import library.database.DBOperate;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.image.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.*;
import java.util.Vector;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

public class LoginFrame extends Application {
	double xOffset;
	double yOffset;

	@Override
	public void start(Stage loginStage) {
		BorderPane rootPane = new BorderPane();
		rootPane.setId("rootPane");
		rootPane.getStylesheets().add("./css/Login.css");
		GridPane paneForCenter = new GridPane();
		paneForCenter.setHgap(10);
		paneForCenter.setVgap(20);
		paneForCenter.setPadding(new Insets(100, 150, 100, 160));
		paneForCenter.getStylesheets().add("./css/Login.css");
		paneForCenter.setPrefWidth(400);
		paneForCenter.setPrefHeight(400);
		Text txtTitle = new Text("图书库存管理系统");
		txtTitle.setId("txtTitle");
		Label lblName = new Label("姓名:");
		TextField tfName = new TextField();
		Label lblPassword = new Label("密码:");
		PasswordField pfPassword = new PasswordField();
		Button loginButton = new Button("登录");
		loginButton.setPrefWidth(220);
		loginButton.setPrefHeight(30);
		loginButton.setId("loginButton");
		// (0列,0行,跨2列,跨2行)
		// paneForCenter.add(txtTitle, 0, 0, 2, 2);
		// add(child:Node,columnIndex:int,rowIndex:int):void
		// paneForCenter.add(lblName, 0, 3);
		// paneForCenter.add(tfName, 1, 3);
		// paneForCenter.add(lblPassword, 0, 4);
		// paneForCenter.add(pfPassword, 1, 4);
		// paneForCenter.add(loginButton, 1, 5);
		RadioButton adminButton = new RadioButton("管理员");
		RadioButton readerButton = new RadioButton("读者");
		ToggleGroup group = new ToggleGroup();
		adminButton.setToggleGroup(group);
		readerButton.setToggleGroup(group);
		adminButton.setSelected(true);

		paneForCenter.add(txtTitle, 0, 0, 2, 1);
		paneForCenter.add(lblName, 0, 1);
		paneForCenter.add(tfName, 1, 1);
		paneForCenter.add(lblPassword, 0, 2);
		paneForCenter.add(pfPassword, 1, 2);
		paneForCenter.add(adminButton, 2, 1);
		paneForCenter.add(readerButton, 2, 2);

		paneForCenter.add(loginButton, 1, 4);
		HBox paneForTopButton = new HBox(0);
		paneForTopButton.getStylesheets().add("./css/Login.css");
		paneForTopButton.setAlignment(Pos.TOP_RIGHT);
		Button closeButton = new Button();
		closeButton.setPrefWidth(30);
		closeButton.setPrefHeight(27);
		closeButton.setId("closeButton");
		Button miniButton = new Button();
		miniButton.setPrefWidth(30);
		miniButton.setPrefHeight(27);
		miniButton.setId("miniButton");
		Button aboutButton = new Button();
		aboutButton.setPrefWidth(30);
		aboutButton.setPrefHeight(27);
		aboutButton.setId("aboutButton");
		paneForTopButton.getChildren().addAll(aboutButton, miniButton, closeButton);
		rootPane.setCenter(paneForCenter);
		rootPane.setTop(paneForTopButton);
		Scene scene = new Scene(rootPane);
		loginStage.setScene(scene);
		loginStage.setTitle("图书库存管理系统");
		loginStage.getIcons().add(new Image(getClass().getResource("./images/ico.png").toExternalForm()));

		loginStage.setWidth(650);


		loginStage.setHeight(450);
		loginStage.initStyle(StageStyle.UNDECORATED);
		loginStage.show();
		loginStage.setResizable(false);
		tfName.setText("admin");
		pfPassword.setText("123");
		aboutButton.setOnAction(e -> {
			new MyGitHub().show();
		});
		closeButton.setOnAction(e -> {
			System.exit(0);
		});

		miniButton.setOnAction(e -> {
			loginStage.setIconified(true);
		});

		scene.setOnMousePressed(e -> {
			// 得出鼠标坐标和窗体左上端坐标之间的距离
			xOffset = e.getScreenX() - loginStage.getX();
			yOffset = e.getScreenY() - loginStage.getY();
		});
		scene.setOnMouseDragged(e -> {
			// 鼠标坐标减去移动的距离可以得到窗体现在的左上端坐标，就可以确定窗体的位置了
			loginStage.setX(e.getScreenX() - xOffset);
			loginStage.setY(e.getScreenY() - yOffset);

		});

		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				JOptionPane.showMessageDialog(new JPanel(),"test");
							String username = tfName.getText();
			String userpassword = String.valueOf(pfPassword.getText());
			if (adminButton.isSelected()) {
				String sql = "select * from stafferInfo where StafferName = '" + username + "' and Password = '"
						+ userpassword + "'";
				Vector<Vector<String>> data = DBOperate.getTable(sql);
				if (data.size() > 0) {
					if (data.get(0).get(8).equals("激活")) {
						CommonClass.userName = tfName.getText();
						loginStage.hide();
						new MainFrame().show();
						CommonClass.role = "管理员";
					} else
						CommonClass.messageDialog("信息提示框","","当前用户未激活");
						//JOptionPane.showMessageDialog(null, "当前用户未激活");BookID

				} else {
					//JOptionPane.showMessageDialog(null, "此用户非管理员或用户名、密码错误,请重新输入");
					CommonClass.messageDialog("信息提示框","","此用户非管理员或用户名、密码错误,请重新输入");
					tfName.setText("");
					pfPassword.setText("");
				}
			} else if (readerButton.isSelected()) {
				String sql1 = "select * from readerInfo where ReaderName = '" + username + "' and Password = '"
						+ userpassword + "'";
				Vector<Vector<String>> data1 = DBOperate.getTable(sql1);
				if (data1.size() > 0) {
					if (data1.get(0).get(9).equals("激活")) {
						CommonClass.userName = tfName.getText();
						loginStage.hide();
						new MainFrame().show();
						CommonClass.role = "读者";
					} else
						CommonClass.messageDialog("信息提示框","","当前用户未激活");
						//JOptionPane.showMessageDialog(null, "当前用户未激活");
				} else {
					//JOptionPane.showMessageDialog(null, "此用户非读者身份或用户名、密码错误,请重新输入");
					CommonClass.messageDialog("信息提示框","","此用户非读者身份或用户名、密码错误,请重新输入");
					tfName.setText("");
					pfPassword.setText("");
				}
			}

			}
		});
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
