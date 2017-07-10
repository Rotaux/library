package library.bookflow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.database.DBOperate;
import library.main.CommonClass;


public class ReturnBookPane extends SubBookFlowPane{
	ReturnBookTable returnBookTable;

	public ReturnBookPane() {
		init();
	}

	public void init() {
		
		Text txtTableName = new Text("��������Ϣ��:");
		txtTableName.setLayoutX(10);
		txtTableName.setLayoutY(35);
		this.getChildren().add(txtTableName);

		Button btnSearchAll = new Button("�������д�����Ϣ");
		btnSearchAll.setLayoutX(750);
		btnSearchAll.setLayoutY(15);
		this.getChildren().add(btnSearchAll);


		Text txtReturnBookId = new Text("������Ҫ����ͼ���ţ�");
		txtReturnBookId.setLayoutX(730);
		txtReturnBookId.setLayoutY(65);
		this.getChildren().add(txtReturnBookId);
		TextField tfReturnBookId = new TextField();
		tfReturnBookId.setPrefWidth(100);
		tfReturnBookId.setLayoutX(880);
		tfReturnBookId.setLayoutY(50);
		this.getChildren().add(tfReturnBookId);


		Button btnReturnBook = new Button("����");
		btnReturnBook.setLayoutX(750);
		btnReturnBook.setLayoutY(95);
		this.getChildren().add(btnReturnBook);

		String sql33 = "select * from ReturnBookView";
		getChildren().remove(returnBookTable);
		returnBookTable = new ReturnBookTable(sql33);
		getChildren().add(returnBookTable);
		
		btnReturnBook.setOnAction( e -> {
			String bookId = tfReturnBookId.getText().trim();
			String sql = "select * from ReturnBookView where BookID = '"+bookId+"'";
			Vector<Vector<String>> data = DBOperate.getTable(sql);
			String strBorrowTime = data.get(0).get(4);
		//	System.out.println(strBorrowTime);
			SimpleDateFormat objFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date borrowTime = new Date();
			try{
				borrowTime = objFormat.parse(strBorrowTime);

			}catch(ParseException e1){
				e1.printStackTrace();
			}
			Date currentTime = new Date();
			long day = (currentTime.getTime()-borrowTime.getTime())/(1000*60*60*24);
			if(day>60){
			//	JOptionPane.showMessageDialog(null, "���ѹ���");
				CommonClass.messageDialog("��ʾ��Ϣ","","���ѹ���");
				return;
			}
			String username = CommonClass.userName;
			String sql1 = "update borrowBookInfo set ReturnDate=now(),StafferName='"+
					username+"' where BorrowBookId = '"+bookId+"' and ReturnDate is null";
			String sql2 = "update storageInfo set State = '�ɽ�' where BookId ='"+
					bookId+"'";
			String sql3 = "delete from borrowBookInfo where BorrowBookId = '"+bookId+"'";
			if(DBOperate.tableUpdate(sql1)>0&&DBOperate.tableUpdate(sql2)>0&&DBOperate.tableUpdate(sql3)>0){
			//	JOptionPane.showMessageDialog(null,"����ɹ�");
				CommonClass.messageDialog("��ʾ��Ϣ","��ϲ","����ɹ�");
				String sql4 = "select * from ReturnBookView";
				getChildren().remove(returnBookTable);
				returnBookTable = new ReturnBookTable(sql4);
				getChildren().add(returnBookTable);
			}
		});

		btnSearchAll.setOnAction(e -> {
			String sql = "select * from ReturnBookView";
			getChildren().remove(returnBookTable);
			returnBookTable = new ReturnBookTable(sql);
			getChildren().add(returnBookTable);
		});
	}
}
