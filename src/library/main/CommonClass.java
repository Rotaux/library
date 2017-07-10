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
//        按钮部分可以使用预设的也可以像这样自己 new 一个
//		Alert alert = new Alert(Alert.AlertType.CONFIRMATION,message,new ButtonType("取消", ButtonBar.ButtonData.NO),
//				new ButtonType("确定", ButtonBar.ButtonData.YES));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,message,new ButtonType("取消", ButtonBar.ButtonData.NO),
                new ButtonType("确定", ButtonBar.ButtonData.YES));
//        设置窗口的标题
        alert.setTitle(title);
        alert.setHeaderText(header);
//        设置对话框的 icon 图标，参数是主窗口的 stage
        alert.initOwner(null);
//        showAndWait() 将在对话框消失以前不会执行之后的代码
        Optional<ButtonType> _buttonType = alert.showAndWait();
//        根据点击结果返回
        if(_buttonType.get().getButtonData().equals(ButtonBar.ButtonData.YES)){
            return true;
        }
        else {
            return false;
        }
    }

    //    弹出一个信息对话框
    public static  void messageDialog(String title,String header, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(message);
        alert.initOwner(null);
        alert.show();
    }
	}

