package library.systemsetting;

import java.util.Vector;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.database.DBOperate;
import library.main.CommonClass;

public class UpdateStudentPane extends SubSystemSettingPane{
	public static ReaderTable readerTable;
	Button btnSearchAll;
	TextField tfSearch = new TextField();
	TextField tfReaderId = new TextField();
	TextField tfReaderName = new TextField();
	TextField tfSex = new TextField();
	TextField tfIdentityId = new TextField();
	TextField tfCertificateDate = new TextField();
	TextField tfReaderType = new TextField();
	TextField tfPhone = new TextField();
	TextField tfAddress = new TextField();
	TextField tfPassword = new TextField();
	TextField tfState = new TextField();
	public UpdateStudentPane() {
		init();
	}

	public void init() {
//		StorageTable s1 = new StorageTable("exec searchStorageInfo");
//		this.getChildren().add(s1);
//		this.setLayoutX(0);
//		this.setLayoutY(43);
//		this.setPrefWidth(1000);
//		this.setPrefHeight(609);
		Text txtSearch = new Text("请输入要修改的读者编号：");
		txtSearch.setLayoutX(150);
		txtSearch.setLayoutY(25);
		this.getChildren().add(txtSearch);
//		TextField tfSearch = new TextField();
		tfSearch.setPrefWidth(100);
		tfSearch.setLayoutX(290);
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

		Label lblReaderId = new Label("读者编号:");
		Label lblReaderName = new Label("读者姓名:");
		Label lblSex = new Label("性别");
		Label lblIdentityId = new Label("身份证号:");
		Label lblCertificateDate = new Label("办证日期:");
		Label lblReaderType = new Label("读者类型:");
		Label lblPhone = new Label("联系电话:");
		Label lblAddress = new Label("地址:");
		Label lblPassword = new Label("密码:");
		Label lblState = new Label("状态");

//		TextField tfReaderId = new TextField();
//		TextField tfReaderName = new TextField();
//		TextField tfSex = new TextField();
//		TextField tfIdentityId = new TextField();
//		TextField tfCertificateDate = new TextField();
//		TextField tfReaderType = new TextField();
//		TextField tfPhone = new TextField();
//		TextField tfAddress = new TextField();
//		TextField tfPassword = new TextField();
//		TextField tfState = new TextField();

		GridPane pane1 = new GridPane();
		pane1.setHgap(5);
		pane1.setVgap(20);
		pane1.add(lblReaderId, 0, 0);
		pane1.add(tfReaderId, 1, 0);
		pane1.add(lblReaderName, 0, 1);
		pane1.add(tfReaderName, 1, 1);
		pane1.add(lblSex, 0, 2);
		pane1.add(tfSex, 1, 2);
		pane1.add(lblIdentityId, 0, 3);
		pane1.add(tfIdentityId, 1, 3);
		pane1.add(lblCertificateDate, 0, 4);
		pane1.add(tfCertificateDate, 1, 4);
		pane1.add(lblReaderType, 0, 5);
		pane1.add(tfReaderType, 1, 5);
		pane1.add(lblPhone, 0, 6);
		pane1.add(tfPhone, 1, 6);
		pane1.add(lblAddress, 0, 7);
		pane1.add(tfAddress, 1, 7);
		pane1.add(lblPassword, 0, 8);
		pane1.add(tfPassword, 1, 8);
		pane1.add(lblState, 0,9);
		pane1.add(tfState, 1, 9);
		

		pane1.setLayoutX(750);
		pane1.setLayoutY(60);

		this.getChildren().add(pane1);

		Button btnUpdate = new Button("修改");
		Button btnCancel = new Button("取消");
		btnUpdate.setLayoutX(760);
		btnUpdate.setLayoutY(530);

		btnCancel.setLayoutX(850);
		btnCancel.setLayoutY(530);

		this.getChildren().add(btnUpdate);
		this.getChildren().add(btnCancel);

		readerTable = new ReaderTable("select * from readerInfo");
		this.getChildren().remove(readerTable);
		this.getChildren().add(readerTable);
		
		btnSearch.setOnMouseClicked(e -> {
			getChildren().remove(readerTable);
			String sql = "select * from readerInfo where ReaderID = '"+tfSearch.getText().trim()+"'";
			readerTable = new ReaderTable(sql);
			getChildren().add(readerTable);
		});
		
		btnSearch.setOnAction(e -> {
			getChildren().remove(readerTable);
			String sql = "select * from readerInfo where ReaderID = '" + tfSearch.getText().trim() + "'";
			readerTable = new ReaderTable(sql);
			getChildren().add(readerTable);
			Vector<Vector<String>> data = DBOperate.getTable(sql);
			if (data.size()>0) {
				tfReaderId.setText(data.get(0).get(0));
				tfReaderName.setText(data.get(0).get(1));
				tfSex.setText(data.get(0).get(2));
				tfIdentityId.setText(data.get(0).get(3));
				tfCertificateDate.setText(data.get(0).get(4));
				tfReaderType.setText(data.get(0).get(5));
				tfPhone.setText(data.get(0).get(6));
				tfAddress.setText(data.get(0).get(7));
				tfPassword.setText(data.get(0).get(8));
				tfState.setText(data.get(0).get(9));
			}
		});
		
		btnSearchAll.setOnAction( e -> {
			SearchAll();	
		});
		
		btnUpdate.setOnAction(e -> {
			String sql = "update readerInfo set ReaderID='" + tfReaderId.getText().trim() + "',ReaderName='"
					+ tfReaderName.getText().trim() + "',Sex='" + tfSex.getText().trim() + "',IdentityID='"
					+ tfIdentityId.getText().trim() + "',CertificateDate='" + tfCertificateDate.getText().trim()
					+ "',ReaderType='" + tfReaderType.getText().trim() + "',Phone='"
					+ tfPhone.getText().trim() + "',Address='" + tfAddress.getText().trim()
					+ "',Password = '"
					+ tfPassword.getText().trim()
					+ "',State='" + tfState.getText().trim() + "' where ReaderID = '"
					+ tfSearch.getText().trim() + "'";
			if(DBOperate.tableUpdate(sql)>0) {
				//JOptionPane.showMessageDialog(null, "修改成功");
				CommonClass.messageDialog("信息提示框","恭喜","修改成功");
				getChildren().remove(readerTable);
				String sql1 = "select * from readerInfo where ReaderID = '" + tfSearch.getText().trim() + "'";
				readerTable = new ReaderTable(sql1);
				getChildren().add(readerTable);
				tfReaderId.setText("");
				tfReaderName.setText("");
				tfSex.setText("");
				tfIdentityId.setText("");
				tfCertificateDate.setText("");
				tfReaderType.setText("");
				tfPhone.setText("");
				tfAddress.setText("");
				tfPassword.setText("");
				tfState.setText("");	
			}

		});
		
		btnCancel.setOnAction( e -> {
			tfReaderId.setText("");
			tfReaderName.setText("");
			tfSex.setText("");
			tfIdentityId.setText("");
			tfCertificateDate.setText("");
			tfReaderType.setText("");
			tfPhone.setText("");
			tfAddress.setText("");
			tfPassword.setText("");
			tfState.setText("");			
		});
	}
	
	public void SearchAll() {
		tfSearch.setText("");
		getChildren().remove(readerTable);
		String sql = "select * from readerInfo";
		readerTable = new ReaderTable(sql);
		getChildren().add(readerTable);
		tfReaderId.setText("");
		tfReaderName.setText("");
		tfSex.setText("");
		tfIdentityId.setText("");
		tfCertificateDate.setText("");
		tfReaderType.setText("");
		tfPhone.setText("");
		tfAddress.setText("");
		tfPassword.setText("");
		tfState.setText("");
	}
}
