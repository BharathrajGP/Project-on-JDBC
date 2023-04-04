package com.one;
import java.util.*;
public class StudentJDBC {

	public static void main(String[] args) 
	{
		Scanner ip=new Scanner(System.in);
		StudentInterface si=new StudentImpl();
		while(true)
		{
			System.out.println("Enter Choice");
			System.out.println("1:Add\n2:Delete\n3:Update\n4:Get Student By Marks\n5:Get All Students\n6:Exit");
			int choice=ip.nextInt();
			switch(choice)
			{
			case 1:si.saveStudent();
			break;
			case 2:si.deleteStudent();
			break;
			case 3:si.updateStudent();
			break;
			case 4:si.getStudentByMarks();
			break;
			case 5:si.getAllStudents();
			break;
			case 6:System.out.println("Thank You");
			System.exit(0);
			break;
			default:System.out.println("Enter Valid Choice");
			}
		}
	}

}
