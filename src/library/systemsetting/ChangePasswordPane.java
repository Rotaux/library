package library.systemsetting;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import library.database.DBOperate;
import library.main.CommonClass;
public class ChangePasswordPane extends SubSystemSettingPane{
	TextField tfOriginPassword = new TextField();
	PasswordField pfNewPassword = new PasswordField();
	PasswordField pfConfirmPassword = new PasswordField();
	
	public ChangePasswordPane() {
		init();
	}

	public void init() {
		Label lblOriginPassword = new Label("用户原密码:");
		Label lblNewPassword = new Label("用户新密码:");
		Label lblConfirmPassword = new Label("新密码确认:");

		
		Button btnChange = new Button("修改");
		Button btnCancel = new Button("取消");
		
		GridPane pane = new GridPane();
	    pane.setHgap(15);
		pane.setVgap(20);
		
		pane.add(lblOriginPassword, 0, 0);
		pane.add(tfOriginPassword, 1, 0);
		pane.add(lblNewPassword, 0, 1);
		pane.add(pfNewPassword, 1,1);
		pane.add(lblConfirmPassword, 0, 2);
		pane.add(pfConfirmPassword, 1, 2);
		pane.setLayoutX(350);
		pane.setLayoutY(30);
		btnChange.setLayoutX(400);
		btnChange.setLayoutY(170);
		btnCancel.setLayoutX(450);
		btnCancel.setLayoutY(170);

		this.getChildren().add(pane);
		this.getChildren().add(btnChange);
		this.getChildren().add(btnCancel);
		btnChange.setOnAction( e -> {
			String originPassword = tfOriginPassword.getText();
			String newPassword = String.valueOf(pfNewPassword.getText());
			String confirmPassword = String.valueOf(pfConfirmPassword.getText());
			String username = CommonClass.userName;
			if (newPassword.equals(confirmPassword)){
				String sql = "";
				if (CommonClass.role.equals("管理员"))
					sql = "update adminTable set Password='"+newPassword+"'where AdminName = '"+username+"'and Password = '"+originPassword+"'";
				else
					sql = "update ReaderTable set Password='"+newPassword+"'where AdminName = '"+username+"'and Password = '"+originPassword+"'"; 
				
				if (DBOperate.tableUpdate(sql)>0) {
				//	JOptionPane.showMessageDialog(null, "密码修改成功");
					CommonClass.messageDialog("信息提示框","","密码修改成功");
					tfOriginPassword.setText("");
					pfNewPassword.setText("");
					pfConfirmPassword.setText("");	
				}				
			}
			else
				CommonClass.messageDialog("信息提示框","","输入的密码有误");
			//	JOptionPane.showMessageDialog(null, "输入的密码有误");

		});
		btnCancel.setOnAction( e -> {
			tfOriginPassword.setText("");
			pfNewPassword.setText("");
			pfConfirmPassword.setText("");
		});
	}
	
	public void Cancel() {
		tfOriginPassword.setText("");
		pfNewPassword.setText("");
		pfConfirmPassword.setText("");
	}
}
