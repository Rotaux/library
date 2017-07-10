package library.systemsetting;

//import javax.swing.JOptionPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.database.DBOperate;
import library.main.CommonClass;

public class AddStudentPane extends SubSystemSettingPane{
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
	
	public AddStudentPane() {
		String sql = "select * from readerInfo";
		readerTable = new ReaderTable(sql);
		this.getChildren().add(readerTable);
		init();
	}

	public void init() {
		Text txtSearch = new Text("请输入读者编号查询：");
		txtSearch.setLayoutX(150);
		txtSearch.setLayoutY(25);
		this.getChildren().add(txtSearch);
//		TextField tfSearch = new TextField();
		tfSearch.setPrefWidth(100);
		tfSearch.setLayoutX(270);
		tfSearch.setLayoutY(10);
		this.getChildren().add(tfSearch);
		Button btnSearch = new Button("查询");
		btnSearch.setLayoutX(400);
		btnSearch.setLayoutY(10);
		this.getChildren().add(btnSearch);
		
		btnSearchAll = new Button("查询全部");
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

//		tfReaderId = new TextField();
//		tfReaderName = new TextField();
//		tfSex = new TextField();
//		tfIdentityId = new TextField();
//		tfCertificateDate = new TextField();
//		tfReaderType = new TextField();
//		tfPhone = new TextField();
//		tfAddress = new TextField();
//		tfPassword = new TextField();
//		tfState = new TextField();

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

		Button btnAdd = new Button("添加");
		Button btnCancel = new Button("取消");
		btnAdd.setLayoutX(760);
		btnAdd.setLayoutY(530);

		btnCancel.setLayoutX(850);
		btnCancel.setLayoutY(530);

		this.getChildren().add(btnAdd);
		this.getChildren().add(btnCancel);

		readerTable = new ReaderTable("select * from readerInfo");
		this.getChildren().add(readerTable);
		
		
		btnSearch.setOnMouseClicked(e -> {
			getChildren().remove(readerTable);
			String sql = "select * from readerInfo where ReaderID = '"+tfSearch.getText().trim()+"'";
			readerTable = new ReaderTable(sql);
			getChildren().add(readerTable);
		});
		
		btnSearch.setOnMouseClicked(e -> {
			getChildren().remove(readerTable);
			String sql = "select * from readerInfo where ReaderID = '"+tfSearch.getText().trim()+"'";
			readerTable = new ReaderTable(sql);
			getChildren().add(readerTable);
		});
		
		btnAdd.setOnMouseClicked(e -> {
			String readerId = tfReaderId.getText();
			String readerName = tfReaderName.getText();
			String sex = tfSex.getText();
			String identityId = tfIdentityId.getText();
			String certificateDate = tfCertificateDate.getText();
			String readerType = tfReaderType.getText();
			String phone = tfPhone.getText();
			String address = tfAddress.getText();
			String password = tfPassword.getText();
			String state = tfState.getText();
			String sql = "insert into readerInfo(ReaderID,ReaderName,Sex,IdentityID,CertificateDate,ReaderType,Phone,Address,Password,State) "
					+ "values('" + readerId + "','" + readerName + "','" + sex + "','" + identityId + "','"
					+ certificateDate + "','" + readerType + "','" + phone + "','" + address + "','"
					+ password + "','" + state + "')";
			if (DBOperate.tableUpdate(sql) > 0) {
		//		JOptionPane.showMessageDialog(null, "添加成功");
				CommonClass.messageDialog("信息提示框","","添加成功");
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
				getChildren().remove(readerTable);
				String sql1 = "select * from readerInfo";
				readerTable = new ReaderTable(sql1);
				this.getChildren().add(readerTable);
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
		btnSearchAll.setOnAction( e -> {
//			tfSearch.setText("");
//			getChildren().remove(readerTable);
//			String sql = "select * from readerInfo";
//			readerTable = new ReaderTable(sql);
//			getChildren().add(readerTable);
//			tfReaderId.setText("");
//			tfReaderName.setText("");
//			tfSex.setText("");
//			tfIdentityId.setText("");
//			tfCertificateDate.setText("");
//			tfReaderType.setText("");
//			tfPhone.setText("");
//			tfAddress.setText("");
//			tfPassword.setText("");
//			tfState.setText("");	
			SearchAll();
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