package edu.com;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Scanner;

	public class InsertRecord {

		public static void main(String[] args) {
			//Connection 
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/mydb";
			String un="root";
			String pass="root";
			Connection conn=null;
			Statement st=null;
			ResultSet rs=null;
			Scanner sc = new Scanner(System.in);
			System.out.println("enter id to insert record");
			int id = sc.nextInt();
			
			String sql = "select * from mylogin where id="+id;
			
			 
					
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,un,pass);
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				 if(!rs.next()) {
				   System.out.println("Enter name ");
				   String name=sc.next();
				   String ins="insert into mylogin values("+id+",'"+name+"')";
				   
				  int i= st.executeUpdate(ins);
				   if(i>0) {
					   System.out.println("Record is inserted successfully");
				   }
				   
				 }else {
					 System.out.println("Id already exists choose different id ");
				 }
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	}
