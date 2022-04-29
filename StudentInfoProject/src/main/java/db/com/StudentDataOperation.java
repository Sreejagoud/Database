package db.com;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDataOperation {
static Connection scon=null;
static ResultSet rs=null;
static Statement st=null;

	static Scanner sc=new Scanner(System.in);
	static int cid;
	static String cname;
	static String sage;
	public static void insertStudentInfo() {
		//get the connection
		try {
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("My connection"+scon);
			
			//Input data from user
			System.out.println("Enter id of student");
			cid=sc.nextInt();
			//Check id exists
			String sql="select * from cloudstd where cid="+cid;
			rs=st.executeQuery(sql);
			
			if(!rs.next()) {
				System.out.println("Enter student name");
				cname=sc.next();
				System.out.println("Enter student age");
				sage=sc.next();
				
		String ins="insert into cloudstd values("+cid+",'"+cname+"','"+sage+"')";
				int  i =st.executeUpdate(ins);
				if(i>0) {
					System.out.println("Student information is registered");
				}
			}else {
				System.out.println("Id already exists Choose another id");
			}
			} catch (Exception e) {
			
			e.printStackTrace();
		}  
		
	}	
	
	
	public static void updateStudentInfo()  {
		//update name, age, name and age
		//taking input id (based on id update records)
		System.out.println("Enter student id to update record");
		int id=sc.nextInt();
		scon=DbConnect.getConnection();
			try {
				st=scon.createStatement();
				String sql="select * from cloudstd where cid="+id;
				rs=st.executeQuery(sql);
				if(rs.next()) {
				
				System.out.println("Which field you want to update");
				System.out.println("1.to update name");
				System.out.println("2.to update age");
				System.out.println("3.to update name and age");
				
				int choice=sc.nextInt();
				switch(choice) {
				case 1:System.out.println("Enter name to change");
				       String n=sc.next();
				       String up="update cloudstd set sname='"+n+"' where cid="+id;
				       int i=st.executeUpdate(up);
				       if(i>0) {
				    	   System.out.println("name is changed");
				       }
				       break;
				case 2:System.out.println("Enter age to change");
			       String c=sc.next();
			       String cup="update cloudstd set sage='"+c+"' where cid="+id;
			       int cr=st.executeUpdate(cup);
			       if(cr>0) {
			    	   System.out.println("age is changed");
			       }
			       break;
				case 3: System.out.println("Enter name to change");
				        String n1=sc.next();
				        System.out.println("Enter age to change");
				        String c1=sc.next();
		 String upnamecourse="update cloudstd set cname='"+n1+"' , sage='"+c1+"' where cid="+id;
				int ncchange=st.executeUpdate(upnamecourse);
				if(ncchange>0) {
					System.out.println("name and age changed successfully");
				}
				}
				}
				else {
					System.out.println(id+" not exists");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public static void deleteStudentInfo() {
		System.out.println("Enter student id to delete record");
		int id=sc.nextInt();
		//check id exists
		//if exists go for delete else display id not exists
		
		scon=DbConnect.getConnection();
		try {
			st=scon.createStatement();
			
			String sql = "select * from cloudstd where cid="+id;
			rs=st.executeQuery(sql);
			
			if(rs.next()) {
				String del = "delete from cloudstd where cid="+id;
				int i=st.executeUpdate(del);
				if(i>0) {
					System.out.println("The student with id "+id+" is deleted");
				}
			}else {
				System.out.println(id+ " not exists in database");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
//based on ID
	public static void selectStudentInfo() {
		try {
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			System.out.println("Enter Student to display Information");
			cid=sc.nextInt();
			String sql="select * from cloudstd where cid="+cid;
			rs=st.executeQuery(sql);
			if(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
			}else {
				System.out.println("ID not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
//display all
	public static void displayStudentInfo() {
		//get the Connection
		try
		{
			scon=DbConnect.getConnection();
			st=scon.createStatement();
			
			String sql="select * from cloudstd";
			rs=st.executeQuery(sql);
			
			System.out.println("ID\tName\tage");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


}
