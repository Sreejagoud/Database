package edu.com;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;

	public class CreateTable {

		public static void main(String[] args) {
		String mytable="create table studentinfo (sid int(4) primary key,sname varchar(20) not null,scourse varchar(20) not null)";
	   //connection code
		
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/mydb";
		String un="root";
		String pass="root";
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,un,pass);
			Statement st=conn.createStatement();
			st.execute(mytable);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		}
	}
