package edu.com;

//public class SelectRecord {
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class SelectRecord {

		public static void main(String[] args) {
			//Connection 
					String driver="com.mysql.cj.jdbc.Driver";
					String url="jdbc:mysql://localhost:3306/mydb"; 
					String un="root";
					String pass="root";
					Connection conn=null;
					Statement st=null;
					ResultSet rs=null;
					try {
						Class.forName(driver);
						conn = DriverManager.getConnection(url,un,pass);
						st=conn.createStatement();
						
						String sql="select * from student";
						rs=st.executeQuery(sql);
						System.out.println("ID\tNAME\tPLACE\tFEES");
						while(rs.next()) {
							int id=rs.getInt(1);
							String n=rs.getString(2);
							String n1=rs.getString(3);
							float n2=rs.getInt(4);
							System.out.println(id+"\t"+n+"\t"+n1+"\t"+n2);
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
						
					
		}
}
