package changegrade;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Scanner;
public class StudentGrade {

	static Connection con; 
	static PreparedStatement st; 
	
	public static void main(String[] args)throws Exception {
		try {
		
		String sq = "jdbc:mysql://localhost:3306/gradesystem";
		String user = "root";
		String password = "password";
		
		con = DriverManager.getConnection(sq, user, password);
		
		
	
		
		//addStudent();
		updateGrade();
		
		}catch(SQLException e){
        e.printStackTrace();
    }
	}

	static void addStudent() {
		String sql = "insert into student(id, name, grade) values(?,?,?)";
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Name: ");
		String name = s.nextLine();
		
		System.out.println("Enter Id: ");
		int id = s.nextInt();
		
		System.out.println("Enter Grade: ");
		int grade = s.nextInt();
		
		try {
		st = con.prepareStatement(sql);
		st.setString(1, name);
		st.setInt(2, id);
		st.setInt(3, grade);
		}catch(SQLException e){
	        e.printStackTrace();
		}
		try {
		int rowInsert = st.executeUpdate();
		if(rowInsert > 0) {
			System.out.println("Updated Successfully!");
		}
		}catch(SQLException e) {
	        e.printStackTrace();
		}
	}
	static void updateGrade() {
		String sql = "Update student set grade = ? where name = ?";
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Update Grade");
		
		System.out.println("Enter id: ");
		int id = s.nextInt();
		
		System.out.println("Enter Grade: ");
		int grade = s.nextInt();
		try {
			st = con.prepareStatement(sql);
			st.setInt(1, grade);
            st.setInt(2, id);
	
		}catch(SQLException e){
	        e.printStackTrace();
		}
		try {
		 int rowsAffected = st.executeUpdate();
         if (rowsAffected > 0) {
             System.out.println("Grade updated successfully.");
         } else {
             System.out.println("No student found with the given name.");
         }
		}catch (SQLException e){
			e.printStackTrace();
		}
		}
	}
