package library.main;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class CommonClass {
		public static String userName;
		public static String role;
//		public static ReaderTable readerTable;

    public static  boolean confirmDialog(String title,String header,String message){
//        ��ť���ֿ���ʹ��Ԥ���Ҳ�����������Լ� new һ��
//		Alert alert = new Alert(Alert.AlertType.CONFIRMATION,message,new ButtonType("ȡ��", ButtonBar.ButtonData.NO),
//				new ButtonType("ȷ��", ButtonBar.ButtonData.YES));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,message,new ButtonType("ȡ��", ButtonBar.ButtonData.NO),
                new ButtonType("ȷ��", ButtonBar.ButtonData.YES));
//        ���ô��ڵı���
        alert.setTitle(title);
        alert.setHeaderText(header);
//        ���öԻ���� icon ͼ�꣬�����������ڵ� stage
        alert.initOwner(null);
//        showAndWait() ���ڶԻ�����ʧ��ǰ����ִ��֮��Ĵ���
        Optional<ButtonType> _buttonType = alert.showAndWait();
//        ���ݵ���������
        if(_buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)){
            return true;
        }
        else {
            return false;
        }
    }

    //    ����һ����Ϣ�Ի���
    public static  void messageDialog(String title,String header, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.initOwner(null);
        alert.show();
    }
	}

