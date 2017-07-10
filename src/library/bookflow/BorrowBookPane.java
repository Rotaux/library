package library.bookflow;

import java.util.Vector;

import javax.swing.JOptionPane;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import library.database.DBOperate;
import library.main.CommonClass;

public class BorrowBookPane extends SubBookFlowPane{
	BorrowBookTable borrowBookTable;

	public BorrowBookPane() {
		init();
	}

	public void init() {
		
		Text txtTableName = new Text("借阅信息表:");
		txtTableName.setLayoutX(10);
		txtTableName.setLayoutY(35);
		this.getChildren().add(txtTableName);
		
		Text txtSearchReaderId = new Text("请输入要借书的读者编号：");
		txtSearchReaderId.setLayoutX(730);
		txtSearchReaderId.setLayoutY(65);
		this.getChildren().add(txtSearchReaderId);
		TextField tfSearchReaderId = new TextField();
		tfSearchReaderId.setPrefWidth(100);
		tfSearchReaderId.setLayoutX(880);
		tfSearchReaderId.setLayoutY(50);
		this.getChildren().add(tfSearchReaderId);
//		Button btnSearch = new Button("查询");
//		btnSearch.setLayoutX(780);
//		btnSearch.setLayoutY(95);
//		this.getChildren().add(btnSearch);
		Button btnSearch = new Button("查找");
		btnSearch.setLayoutX(750);
		btnSearch.setLayoutY(95);
		this.getChildren().add(btnSearch);

		Label lblReaderName = new Label("读者姓名:");
		Label lblSex = new Label("性别:");
		Label lblAddress = new Label("家庭住址:");
		Label lblPhone = new Label("联系电话:");
		Label lblState = new Label("状态:");

		TextField tfReaderName = new TextField();
		TextField tfSex = new TextField();
		TextField tfAddress = new TextField();
		TextField tfPhone = new TextField();
		TextField tfState = new TextField();
		tfReaderName.setEditable(false);
		tfSex.setEditable(false);
		tfAddress.setEditable(false);
		tfPhone.setEditable(false);
		tfState.setEditable(false);

		GridPane pane1 = new GridPane();
		pane1.setHgap(5);
		pane1.setVgap(20);

		pane1.add(lblReaderName, 0, 1);
		pane1.add(tfReaderName, 1, 1);
		pane1.add(lblSex, 0, 2);
		pane1.add(tfSex, 1, 2);
		pane1.add(lblAddress, 0, 3);
		pane1.add(tfAddress, 1, 3);
		pane1.add(lblPhone, 0, 4);
		pane1.add(tfPhone, 1, 4);
		pane1.add(lblState, 0, 5);
		pane1.add(tfState, 1, 5);

		pane1.setLayoutX(750);
		pane1.setLayoutY(138);

		this.getChildren().add(pane1);
		
		Label lblBookId = new Label("请输入要借阅的图书书号:");
		lblBookId.setLayoutX(730);
		lblBookId.setLayoutY(400);
		this.getChildren().add(lblBookId);
		
		TextField tfBookId = new TextField();
		tfBookId.setPrefWidth(100);
		tfBookId.setLayoutX(875);
		tfBookId.setLayoutY(400);
		tfBookId.setEditable(false);
		this.getChildren().add(tfBookId);
		

		Button btnBorrowBook = new Button("借书");
		btnBorrowBook.setLayoutX(800);
		btnBorrowBook.setLayoutY(430);
		
		this.getChildren().add(btnBorrowBook);
		borrowBookTable = new BorrowBookTable("select * from ReaderBorrowView where 读者编号 = '7';");
//		borrowBookTable = new BorrowBookTable("select * from readerInfo where ReaderID = '01'");
		this.getChildren().add(borrowBookTable);
		
		btnSearch.setOnAction( e -> {
			String readerId = tfSearchReaderId.getText();
			String sql = "select * from readerInfo where ReaderId = '" + readerId + "'";
			String sql1 = "select * from ReaderBorrowView where  读者编号 = '"+readerId+"';";
			getChildren().remove(borrowBookTable);
			borrowBookTable = new BorrowBookTable(sql1);
			getChildren().add(borrowBookTable);
			Vector<Vector<String>> data = DBOperate.getTable(sql);
			if (data.size()>0) {
				tfReaderName.setText(data.get(0).get(1));
				tfSex.setText(data.get(0).get(2));
				tfAddress.setText(data.get(0).get(7));
				tfPhone.setText(data.get(0).get(6));
				tfState.setText(data.get(0).get(9));
				if (data.get(0).get(9).trim().equals("激活"))
					tfBookId.setEditable(true);
			}
		});
		
		btnBorrowBook.setOnAction( e -> {
			if (borrowBookTable.getRowCount() >= 3) {
			//	JOptionPane.showMessageDialog(null, "超出借书数量，不可再借图书");
				CommonClass.messageDialog("提示信息","","超出借书数量，不可再借图书");
				return;
			}
			String bookId = tfBookId.getText();
			String readerId = tfSearchReaderId.getText();
			String operateName = CommonClass.userName;
			String sql0 = "select * from ReaderBorrowView where 读者编号='"+readerId+"'and 应还时间<now()";
			if(DBOperate.getTable(sql0).size()>0){
			//	JOptionPane.showMessageDialog(null,"已借图书已过期，请还书后再借图书");
				CommonClass.messageDialog("提示信息","","已借图书已过期，请还书后再借图书");
				return;
			}
			String sql = "select State from storageInfo where BookID = '"+bookId+"'";
			Vector<Vector<String>> table = DBOperate.getTable(sql);
			if (table.get(0).get(0).trim().equals("可借")){
			//	JOptionPane.showMessageDialog(null, "借书成功!");
				CommonClass.messageDialog("提示信息","恭喜","借书成功");
				String sql1 = "update storageInfo set State = '借出' where BookID = '"+bookId+"'";
				String sql2 = "insert into borrowBookInfo(ReaderID,BorrowBookID,BorrowDate,StafferName)values('"+readerId+"','"+bookId+"',now(),'"+operateName+"')";
				if (DBOperate.tableUpdate(sql1) > 0 && DBOperate.tableUpdate(sql2)>0) {
					String sql3 = "select * from ReaderBorrowView where 读者编号 = '"+readerId+"'";
					getChildren().remove(borrowBookTable);
					borrowBookTable = new BorrowBookTable(sql3);
					getChildren().add(borrowBookTable);
				}
			}
			else
				CommonClass.messageDialog("提示信息","","该书不可借或已借出");
				//JOptionPane.showMessageDialog(null,"该书不可借或已借出");
		});
	}
}
		