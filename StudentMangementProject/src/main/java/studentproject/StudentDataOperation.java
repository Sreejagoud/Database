package studentproject;


	import java.sql.Connection;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Scanner;

	public class StudentDataOperation {
		static Connection scon;
		static ResultSet rs;
		static Statement st;
		static Scanner sc=new Scanner(System.in);
		static int sid;
		static String sname;
		static String scourse;
		static String address;
		static long mobnum;
		static String email;
		
		public static void displayStudentInfo() {
			try {
				scon=DBConnect.getConnection();
				st=scon.createStatement();
				String sql="select*from student";
				rs=st.executeQuery(sql);
				System.out.println(" ID \t NAME \t COURSE \t ADDRESS \t MOBNUM \t EMAIL ");
				while(rs.next()) {
			System.out.println(rs.getInt(1) + " \t " +rs.getString(2)+" \t "+rs.getString(3)+rs.getString(4)+" \t "+rs.getLong(5)+" \t "+rs.getString(6));
		
				}

			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}

		public static void insertStudentInfo() {
			try
			{
				scon=DBConnect.getConnection();
				st=scon.createStatement();
				System.out.println("My Connection "+scon);
				sc=new Scanner(System.in);
				//input from user
				System.out.println("Enter id of student");
				sid=sc.nextInt();
				//check id exists or not
				String sql="select * from student where sid="+sid;
				rs=st.executeQuery(sql);
				if(!rs.next())
				{
					System.out.println("Enter student name");
					sname=sc.next();
					System.out.println("Enter student course");
					scourse=sc.next();
					System.out.println("Enter student address");
					address=sc.next();
					System.out.println("Enter student mobile number");
					mobnum=sc.nextLong();
					System.out.println("Enter student email ID");
					email=sc.next();
					
					String ins="insert into student values(" + sid + ",'" +sname+ "','" +scourse+ "','" +address+ "','" +mobnum+ "','" +email+ "')";
					int i=st.executeUpdate(ins);
					if(i>0)
					{
						System.out.println("Student information is inserted successfully");
					}
				}
				else
				{
					System.out.println("ID already exists choose another id");
				}
						
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
		}

		public static void updateStudentInfo() {
			//update name,course,address,mobnum,email
			//taking input id(based on id update record)
			System.out.println("Enter student id to update the record");
			int id=sc.nextInt();
			scon=DBConnect.getConnection();
			try
			{
				st=scon.createStatement();
				String sql="select * from student where sid="+id;
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					System.out.println("****WHICH FIELD YOU WANT TO UPDATE****");
					System.out.println("1.to update name");
					System.out.println("2.to update course");
					System.out.println("3.to update address");
					System.out.println("4.to update mobnum");
					System.out.println("5.to update email id");
					System.out.println("6.to update id");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1: System.out.println("Enter name to change");
					        String n=sc.next();
					        String up="update student set sname= "+n+" where sid="+id;
					         int i=st.executeUpdate(up);
					        if(i>0)
					        {
					        	System.out.println("Name is updated");
				        	}
				        	break;
					case 2: System.out.println("Enter course to change");
					         String c=sc.next();
					         String cup="update student set scourse ="+c+" where sid="+id;
					         int cr=st.executeUpdate(cup);
					         if(cr>0)
					         {
					        	 System.out.println("Course is updated");
					         }
					         break;
					case 3: System.out.println("Enter Address to change");
					          String a=sc.next();
					          String aup="update student set address ="+a+" where sid="+id;
					          int ad=st.executeUpdate(aup);
					          if(ad>0)
					          {
					        	  System.out.println("Address is updated");
					          }
					          break;
					case 4: System.out.println("Enter mobnum to update");
					         long mnum=sc.nextLong();
					         String mup="update student mobnum="+mnum+" where sid="+id;
					         int m=st.executeUpdate(mup);
					         if(m>0)
					         {
					        	 System.out.println("Mobile number is updated");
					         }
					         break;
					case 5: System.out.println("Enter email id to update");
					         String email=sc.next();
					         String eup="update student email="+email+" where sid="+id;
					         int e=st.executeUpdate(eup);
					         if(e>0)
					         {
					        	 System.out.println("Email ID is updated");
					         }
					         break;
					case 6: System.out.println("Enter  id to update");
			         String Id=sc.next();
			         String iup="update student id="+id+" where sid="+id;
			         int I=st.executeUpdate(iup);
			         if(I>0)
			         {
			        	 System.out.println("ID is updated");
			         }
					         
					      
					         
					
					}
				}
				else
				{
					System.out.println(id+" not exists");
				}
			}
			
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			
			
			
			
		}

		public static void deleteStudentInfo() {
			System.out.println("Enter student id to delete the record");
			int id=sc.nextInt();
			//check id exists or not
			//if exists go for delete else display id not exists
			scon=DBConnect.getConnection();
			try
			{
				st=scon.createStatement();
				String sql="select * from student where sid="+id;
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					String del="delete from student where sid="+id;
					int i=st.executeUpdate(del);
					if(i>0)
					{
						System.out.println("Record is deleted successfully");
					}
				}
				else
				{
					System.out.println(id+"not exists");
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
				
			
			
		}

		public static void selectStudentInfo() {
			//based on id
			try
			{
				scon=DBConnect.getConnection();
				st=scon.createStatement();
				System.out.println("Enter student id to display information");
				sid=sc.nextInt();
				String sql="select * from student where sid="+sid;
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getLong(5)+"\t"+rs.getString(6));
					
				}
				else
				{
					System.out.println("ID not exists");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}

			}