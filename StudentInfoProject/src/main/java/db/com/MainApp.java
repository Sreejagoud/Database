package db.com;

import java.util.Scanner;

public class MainApp {

	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			
		System.out.println("Database operation");
		System.out.println("Enter your choice");
		System.out.println("1.To display student information");
		System.out.println("2.Insert student record");
		System.out.println("3.Update student information based on id");
		System.out.println("4.Delete student information based on id");
		System.out.println("5.Select student based on id");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1: StudentDataOperation.displayStudentInfo();
            break;
        case 2: StudentDataOperation.insertStudentInfo();
            break;
        case 3: StudentDataOperation.updateStudentInfo(); 
            break;
        case 4:StudentDataOperation.selectStudentInfo();
            break;
        case 5: StudentDataOperation.deleteStudentInfo();
            break;
         default:System.out.println("Invalid choice");
}

			
		}

	}
		}
