package studentproject;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class DBConnect {
		static String driver="com.mysql.cj.jdbc.Driver";
		static String url="jdbc:mysql://localhost:3306/bank";
		static String un="root";
		static String pass="root";
		static Connection con=null;
		
		
		public static Connection getConnection()
		{
			try
			{
				Class.forName(driver);
				con=DriverManager.getConnection(url, un, pass);
				if(con==null)
				{
					System.out.println("Connection object is null");
				}
				
				
			}
			catch(Exception e)
			{
				e.printStackTrace();;
			}
			return con;
		}

}
