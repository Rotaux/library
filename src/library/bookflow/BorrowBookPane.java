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
		
		Text txtTableName = new Text("������Ϣ��:");
		txtTableName.setLayoutX(10);
		txtTableName.setLayoutY(35);
		this.getChildren().add(txtTableName);
		
		Text txtSearchReaderId = new Text("������Ҫ����Ķ��߱�ţ�");
		txtSearchReaderId.setLayoutX(730);
		txtSearchReaderId.setLayoutY(65);
		this.getChildren().add(txtSearchReaderId);
		TextField tfSearchReaderId = new TextField();
		tfSearchReaderId.setPrefWidth(100);
		tfSearchReaderId.setLayoutX(880);
		tfSearchReaderId.setLayoutY(50);
		this.getChildren().add(tfSearchReaderId);
//		Button btnSearch = new Button("��ѯ");
//		btnSearch.setLayoutX(780);
//		btnSearch.setLayoutY(95);
//		this.getChildren().add(btnSearch);
		Button btnSearch = new Button("����");
		btnSearch.setLayoutX(750);
		btnSearch.setLayoutY(95);
		this.getChildren().add(btnSearch);

		Label lblReaderName = new Label("��������:");
		Label lblSex = new Label("�Ա�:");
		Label lblAddress = new Label("��ͥסַ:");
		Label lblPhone = new Label("��ϵ�绰:");
		Label lblState = new Label("״̬:");

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
		
		Label lblBookId = new Label("������Ҫ���ĵ�ͼ�����:");
		lblBookId.setLayoutX(730);
		lblBookId.setLayoutY(400);
		this.getChildren().add(lblBookId);
		
		TextField tfBookId = new TextField();
		tfBookId.setPrefWidth(100);
		tfBookId.setLayoutX(875);
		tfBookId.setLayoutY(400);
		tfBookId.setEditable(false);
		this.getChildren().add(tfBookId);
		

		Button btnBorrowBook = new Button("����");
		btnBorrowBook.setLayoutX(800);
		btnBorrowBook.setLayoutY(430);
		
		this.getChildren().add(btnBorrowBook);
		borrowBookTable = new BorrowBookTable("select * from ReaderBorrowView where ���߱�� = '7';");
//		borrowBookTable = new BorrowBookTable("select * from readerInfo where ReaderID = '01'");
		this.getChildren().add(borrowBookTable);
		
		btnSearch.setOnAction( e -> {
			String readerId = tfSearchReaderId.getText();
			String sql = "select * from readerInfo where ReaderId = '" + readerId + "'";
			String sql1 = "select * from ReaderBorrowView where  ���߱�� = '"+readerId+"';";
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
				if (data.get(0).get(9).trim().equals("����"))
					tfBookId.setEditable(true);
			}
		});
		
		btnBorrowBook.setOnAction( e -> {
			if (borrowBookTable.getRowCount() >= 3) {
			//	JOptionPane.showMessageDialog(null, "�������������������ٽ�ͼ��");
				CommonClass.messageDialog("��ʾ��Ϣ","","�������������������ٽ�ͼ��");
				return;
			}
			String bookId = tfBookId.getText();
			String readerId = tfSearchReaderId.getText();
			String operateName = CommonClass.userName;
			String sql0 = "select * from ReaderBorrowView where ���߱��='"+readerId+"'and Ӧ��ʱ��<now()";
			if(DBOperate.getTable(sql0).size()>0){
			//	JOptionPane.showMessageDialog(null,"�ѽ�ͼ���ѹ��ڣ��뻹����ٽ�ͼ��");
				CommonClass.messageDialog("��ʾ��Ϣ","","�ѽ�ͼ���ѹ��ڣ��뻹����ٽ�ͼ��");
				return;
			}
			String sql = "select State from storageInfo where BookID = '"+bookId+"'";
			Vector<Vector<String>> table = DBOperate.getTable(sql);
			if (table.get(0).get(0).trim().equals("�ɽ�")){
			//	JOptionPane.showMessageDialog(null, "����ɹ�!");
				CommonClass.messageDialog("��ʾ��Ϣ","��ϲ","����ɹ�");
				String sql1 = "update storageInfo set State = '���' where BookID = '"+bookId+"'";
				String sql2 = "insert into borrowBookInfo(ReaderID,BorrowBookID,BorrowDate,StafferName)values('"+readerId+"','"+bookId+"',now(),'"+operateName+"')";
				if (DBOperate.tableUpdate(sql1) > 0 && DBOperate.tableUpdate(sql2)>0) {
					String sql3 = "select * from ReaderBorrowView where ���߱�� = '"+readerId+"'";
					getChildren().remove(borrowBookTable);
					borrowBookTable = new BorrowBookTable(sql3);
					getChildren().add(borrowBookTable);
				}
			}
			else
				CommonClass.messageDialog("��ʾ��Ϣ","","���鲻�ɽ���ѽ��");
				//JOptionPane.showMessageDialog(null,"���鲻�ɽ���ѽ��");
		});
	}
}
		