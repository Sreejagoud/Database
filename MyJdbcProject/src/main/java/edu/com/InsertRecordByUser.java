package edu.com;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	import java.util.Scanner;

	public class InsertRecordByUser {

		public static void main(String[] args) {
			//Connection 
			String driver="com.mysql.cj.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/mydb"; //edudb is the database name of mysql
			String un="root";
			String pass="root";
			Connection conn=null;
			Statement st=null;
			String sname=null;
			int sid=0;
			String scourse=null;
		
			Scanner sc=new Scanner(System.in);
			String ins=null;
			try {
				Class.forName(driver); //load the driver  , here Class is the name of class
			    conn=DriverManager.getConnection(url, un, pass);
			    st=conn.createStatement();
			    
			    //from here
			    while(true) {
			    	System.out.println("Enter name");
			    	sname=sc.next();
			    	System.out.println("Enter id");
			    	sid=sc.nextInt();
			    	System.out.println("Enter course");
			    	scourse=sc.next();
			    	
			    	ins="insert into studentinfo values("+sid+",'"+sname+"','"+scourse+"')";
			    
	             int i=st.executeUpdate(ins);
			    if(i>0) {
			    	System.out.println("Record is inserted successfully");
			    }else {
			    	System.out.println("Not inserted");
			    }
			    
			    System.out.println("Do you want to continue y/n");
			    String ch=sc.next();
			    if(ch.equalsIgnoreCase("no")) {
			    	//break;
			    }
			    }
			}catch(Exception e) {
				e.printStackTrace();
			}
	      System.out.println("End of the program");
		}
		}