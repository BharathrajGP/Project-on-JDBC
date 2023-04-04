package com.one;
import java.util.*;
import java.sql.*;

public class StudentImpl implements StudentInterface
{
	Scanner ip=new Scanner(System.in);
	String url="jdbc:mysql://localhost:3306/mystudent";
	String uid="root";
	String ps="root";
	@Override
	public void saveStudent()
	{
		System.out.println("Enter the Student id");
		int id=ip.nextInt();
		System.out.println("Enter the Student Name");
		ip.nextLine();
		String name=ip.nextLine();
		System.out.println("Enter Student Age");
		int age=ip.nextInt();
		System.out.println("Enter Student Marks");
		double marks=ip.nextDouble();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, uid, ps);
			PreparedStatement ps1=c.prepareStatement("Insert into student001 values(?,?,?,?)");
			ps1.setInt(1,id);
			ps1.setString(2,name);
			ps1.setInt(3,age);
			ps1.setDouble(4,marks);
			ps1.execute();
			c.close();
			System.out.println("Data Saved");
		}
		catch(Exception e) {}
	}

	@Override
	public void deleteStudent() 
	{
		System.out.println("Delete Student Based on their id");
		System.out.println("Enter Student id");
		int id=ip.nextInt();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, uid, ps);
			PreparedStatement ps1=c.prepareStatement("Delete from student001 where id=?");
			ps1.setInt(1, id);
			ps1.execute();
			c.close();
			System.out.println("Student Data Deleted");
		}
		catch(Exception e) {e.printStackTrace();}
	}

	private void update(int a,int id)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, uid, ps);
			if(a==1)
			{
				PreparedStatement ps1=c.prepareStatement("update student001 set name=? where id=?");
				System.out.println("Enter Name to be updated");
				ip.nextLine();
				ps1.setString(1,ip.nextLine());
				ps1.setInt(2, id);
				ps1.execute();
			}
			else if(a==2)
			{
				PreparedStatement ps1=c.prepareStatement("update student001 set age=? where id=?");
				System.out.println("Enter Age to be updated");
				ps1.setInt(1,ip.nextInt());
				ps1.setInt(2, id);
				ps1.execute();
			}
			else if(a==3)
			{
				PreparedStatement ps1=c.prepareStatement("update student001 set marks=? where id=?");
				System.out.println("Enter Marks to be updated");
				ps1.setDouble(1,ip.nextDouble());
				ps1.setInt(2, id);
				ps1.execute();
			}
			else
			{
				System.out.println("Invalid Choice");
				System.out.println("Enter Valid Choice");
			}
			c.close();
			System.out.println("Student Data Updated");
		}
		catch(Exception e) {e.printStackTrace();}
	}
	
	@Override
	public void updateStudent()
	{
		System.out.println("Enter choice to update");
		System.out.println("1:Name\n2:Age\n3:Marks");
		int choice=ip.nextInt();
		System.out.println("Update Student Details Based on their id");
		System.out.println("Enter Student id");
		int id=ip.nextInt();
		update(choice,id);
	}

	@Override
	public void getStudentByMarks() 
	{
		System.out.println("Enter marks");
		
		double m=ip.nextDouble();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, uid, ps);
			PreparedStatement ps1=c.prepareStatement("Select * from student001 where marks=?");
			ps1.setDouble(1, m);
			ResultSet r=ps1.executeQuery();
			while(r.next())
			{
				System.out.println("Student id : "+r.getInt(1));
				System.out.println("Student Name : "+r.getString(2));
				System.out.println("Student Age : "+r.getInt(3));
			}
			c.close();
			System.out.println("Student Data Fetched");
		}
		catch(Exception e) {e.printStackTrace();}
	}

	@Override
	public void getAllStudents() 
	{
		System.out.println("Enter Student Details");
		System.out.println("*************************************");
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection(url, uid, ps);
			PreparedStatement ps1=c.prepareStatement("Select * from student001");
			ResultSet r=ps1.executeQuery();
			while(r.next())
			{
				System.out.println("Student id : "+r.getInt(1));
				System.out.println("Student Name : "+r.getString(2));
				System.out.println("Student Age : "+r.getInt(3));
				System.out.println("Student Marks : "+r.getDouble(4));
				System.out.println("------------------------------------");
			}
			c.close();
			System.out.println("Student Data Fetched");
		}
		catch(Exception e) {e.printStackTrace();}
	}

}
