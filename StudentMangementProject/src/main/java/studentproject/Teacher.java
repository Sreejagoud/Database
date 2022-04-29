package studentproject;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;

	class Salary
	{
		String name;
		String add;
		long phn;
		String sub;
		float msal;
		float itax;
		float totalsal;
		void accept() throws IOException
		{
			InputStreamReader is=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(is);
			System.out.println(" Enter a name");
			name=br.readLine();
			System.out.println("Enter a Address");
			add=br.readLine();
			System.out.println("Enter a phone number");
			phn=Integer.parseInt(br.readLine());
			System.out.println("Enter a subject specification");
			sub=br.readLine();
			System.out.println("Enter a monthly salary");
			msal=Float.parseFloat(br.readLine());
			
			
		}
		void calculation()
		{
			totalsal=msal*12;
			if(totalsal>175000)
			{
				itax=totalsal*0.05f;
			}
		}
		void display()
		{
			System.out.println("Name of the teacher is "+name);
			System.out.println("Address is "+add);
			System.out.println("phone number is "+phn);
			System.out.println("Subject specification is "+sub);
			System.out.println("Enter monthly salary "+msal);
			System.out.println("Enter income tax "+itax);
		}
	}

	public class Teacher {

		public static void main(String[] args) throws IOException {
			Salary sal=new Salary();
			sal.accept();
			sal.calculation();
			sal.display();

		}

}
