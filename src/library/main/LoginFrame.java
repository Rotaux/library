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
		Text txtTitle = new Text("ͼ�������ϵͳ");
		txtTitle.setId("txtTitle");
		Label lblName = new Label("����:");
		TextField tfName = new TextField();
		Label lblPassword = new Label("����:");
		PasswordField pfPassword = new PasswordField();
		Button loginButton = new Button("��¼");
		loginButton.setPrefWidth(220);
		loginButton.setPrefHeight(30);
		loginButton.setId("loginButton");
		// (0��,0��,��2��,��2��)
		// paneForCenter.add(txtTitle, 0, 0, 2, 2);
		// add(child:Node,columnIndex:int,rowIndex:int):void
		// paneForCenter.add(lblName, 0, 3);
		// paneForCenter.add(tfName, 1, 3);
		// paneForCenter.add(lblPassword, 0, 4);
		// paneForCenter.add(pfPassword, 1, 4);
		// paneForCenter.add(loginButton, 1, 5);
		RadioButton adminButton = new RadioButton("����Ա");
		RadioButton readerButton = new RadioButton("����");
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
		loginStage.setTitle("ͼ�������ϵͳ");
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
			// �ó��������ʹ������϶�����֮��ľ���
			xOffset = e.getScreenX() - loginStage.getX();
			yOffset = e.getScreenY() - loginStage.getY();
		});
		scene.setOnMouseDragged(e -> {
			// ��������ȥ�ƶ��ľ�����Եõ��������ڵ����϶����꣬�Ϳ���ȷ�������λ����
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
					if (data.get(0).get(8).equals("����")) {
						CommonClass.userName = tfName.getText();
						loginStage.hide();
						new MainFrame().show();
						CommonClass.role = "����Ա";
					} else
						CommonClass.messageDialog("��Ϣ��ʾ��","","��ǰ�û�δ����");
						//JOptionPane.showMessageDialog(null, "��ǰ�û�δ����");BookID

				} else {
					//JOptionPane.showMessageDialog(null, "���û��ǹ���Ա���û������������,����������");
					CommonClass.messageDialog("��Ϣ��ʾ��","","���û��ǹ���Ա���û������������,����������");
					tfName.setText("");
					pfPassword.setText("");
				}
			} else if (readerButton.isSelected()) {
				String sql1 = "select * from readerInfo where ReaderName = '" + username + "' and Password = '"
						+ userpassword + "'";
				Vector<Vector<String>> data1 = DBOperate.getTable(sql1);
				if (data1.size() > 0) {
					if (data1.get(0).get(9).equals("����")) {
						CommonClass.userName = tfName.getText();
						loginStage.hide();
						new MainFrame().show();
						CommonClass.role = "����";
					} else
						CommonClass.messageDialog("��Ϣ��ʾ��","","��ǰ�û�δ����");
						//JOptionPane.showMessageDialog(null, "��ǰ�û�δ����");
				} else {
					//JOptionPane.showMessageDialog(null, "���û��Ƕ�����ݻ��û������������,����������");
					CommonClass.messageDialog("��Ϣ��ʾ��","","���û��Ƕ�����ݻ��û������������,����������");
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
