package library.database;


import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JOptionPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class DBOperate {
	/*private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=LibraryStockDB;";*/
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/libraryStock?characterEncoding=utf8&useSSL=false";
	/**
	 * 获取字段名
	 * @param sql 要执行的SQL语句
	 * @return 把查询到的字段名放在向量中，并返回向量值（存放字段名的向量）
	 */
	public static Vector<String> getFieldNames(String sql){
		Vector<String> fieldNames=new Vector<String>();
		try{
			Class.forName(driver); 
			Connection conn=DriverManager.getConnection(url,"rotamx","1314");//建立连接
	        Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++)  //rsmd.getColumnCount()获取表中的列数
				fieldNames.add(rsmd.getColumnName(i));//rsmd.getColumnName(i)获取第i列的列名			
			rs.close();
			stmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return fieldNames;
	}
	
	public static Vector<Vector<String>> getTable(String sql){
		Vector<Vector<String>> data=new Vector<Vector<String>>();
		try{
			Class.forName(driver);
		 	Connection conn=DriverManager.getConnection(url,"rotamx","1314");
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();			
			while(rs.next()){
				Vector<String> row=new Vector<String>();
				for(int i=1;i<=rsmd.getColumnCount();i++)
					row.add(rs.getString(i));
				data.add(row);
			}
			rs.close();
			stat.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return data;
	}
	
	public static ObservableList<Map> getTableView(String sql) {
		ObservableList<Map> allData = FXCollections.observableArrayList();
		try {
			Class.forName(driver);
		 	Connection conn=DriverManager.getConnection(url,"rotamx","1314");
			Statement stat=conn.createStatement();
			ResultSet rs=stat.executeQuery(sql);
			ResultSetMetaData rsmd=rs.getMetaData();
			Vector<String> column = getFieldNames(sql);
			while(rs.next()) {
				Map<String,String> dataRow = new HashMap<>();
				for(int i = 1;i <=rsmd.getColumnCount();i++) {
					dataRow.put(column.get(i-1), rs.getString(i));	
				}
				allData.add(dataRow);
			}
			rs.close();
			stat.close();
			conn.close();
		}catch(Exception e){
			
		}
		return allData;
		
	}
	public static int tableUpdate(String sql){
		int flag=0;
		try{
			Class.forName(driver); 
			Connection conn=DriverManager.getConnection(url,"rotamx","1314");//建立连接
			PreparedStatement stat=conn.prepareStatement(sql);				
			flag=stat.executeUpdate();				
			stat.close();
			conn.close();	
		}catch(Exception e){			
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return flag;
	}
}
