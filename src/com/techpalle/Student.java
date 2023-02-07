package com.techpalle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Student 
{
	public static int sno;
	public static String sname;
	public static String sub;
	public static String email;
	
	public Student(int no, String name, String sub, String mail)
	{
		
		Student.sno = no;
		Student.sname = name;
		Student.sub = sub;
		Student.email = mail;
	}
	static Statement s=null;
	static Connection con=null;
	static PreparedStatement ps=null;
	public static String url="jdbc:mysql://localhost:3306/palle";
	public static String username="root";
	public static String password="Rajesh@123";
	public static ResultSet rs=null;

	public static void creating()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con=DriverManager.getConnection(url,username,password);
			 s=con.createStatement();
			 s.executeUpdate("create table student(sno int primary key auto_increment,"
				 		+ "sname varchar(80) not null,sub varchar(30),email varchar(80))");
		}	
		catch (ClassNotFoundException e) 
		  {
			e.printStackTrace();
		  }
		catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
		
		finally
		{
			try 
			{
				if(s !=null)
				{
				s.close();
				}
				if(con!=null)
				{
				con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
}
	
	public static void inserting(String name,String sub,String mail)
	{
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			 s=con.createStatement();
			 ps=con.prepareStatement("insert into student (sname,sub,email)values (?,?,?)");
			 ps.setString(1, name);
			 ps.setString(2, sub);
			 ps.setString(3,mail );
			 
			 ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		  {
			e.printStackTrace();
		  }
		catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
		
		finally
		{
			try 
			{
				if(ps !=null)
				{
				ps.close();
				}
				if(con!=null)
				{
				con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		
	
    }
	public static void updating(String mail,String sub,int no)
	{
		try
		{

  		Class.forName("com.mysql.cj.jdbc.Driver");
  		 con=DriverManager.getConnection(url,username,password);
  		 ps=con.prepareStatement("update student set email=?,sub=? where sno=?");
  		 ps.setString(1,mail );
  		 ps.setString(2,sub);
  		 ps.setInt(3, no);
  		 
  		 ps.executeUpdate();  
	   }
		catch (ClassNotFoundException e) 
		  {
			e.printStackTrace();
		  }
		catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
		
		finally
		{
			try 
			{
				if(ps !=null)
				{
				ps.close();
				}
				if(con!=null)
				{
				con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	public static void delete(int no)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
	  		 con=DriverManager.getConnection(url,username,password);
	  		 ps=con.prepareStatement("delete from student where sno=?");
	  		 ps.setInt(1, no);
	  		 
	  		 ps.executeUpdate(); 
		}
		catch (ClassNotFoundException e) 
		  {
			e.printStackTrace();
		  }
		catch (SQLException e) 
		  {
			e.printStackTrace();
		  }
		
		finally
		{
			try 
			{
				if(ps !=null)
				{
				ps.close();
				}
				if(con!=null)
				{
				con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
	}
	public static void read()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="select * from student";
			s=con.createStatement();
			
			ResultSet rs=s.executeQuery(qry);
			
			while(rs.next())
			{
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email"));
			}
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}	
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		

	 }
	public static  ArrayList <Student> reading()
	{
		Student d=null;
		ArrayList <Student> alDept=new ArrayList  <Student>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,username,password);
			
			String qry="select * from student";
			s=con.createStatement();
			
			 rs=s.executeQuery(qry);
			 
			 
			 while(rs.next())
			 {
				 	int no=rs.getInt("sno");
					String name=rs.getString("sname");
					String sub=rs.getString("sub");
					String mail=rs.getString("email");
					
					 d=new Student(no,name,sub,mail);
					 alDept.add(d);
					
			 }
			
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(s!=null)
				{
					s.close();
				}
				if(con!=null)
				{
					con.close();
				}	
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}	
		return alDept;
	}
}
	

