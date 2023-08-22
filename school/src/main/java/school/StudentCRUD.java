package school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveletdb", "root", "root");
		return connection;
		
	}
	
	public int saveStudent(Student student) throws Exception {
		Connection connection= getConnection();	
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1, student.getId());
		preparedStatement.setString(2, student.getStudent_name());
		preparedStatement.setString(3, student.getFather_name());

		preparedStatement.setString(4, student.getMother_name());
		preparedStatement.setInt(5, student.getAge());
		preparedStatement.setLong(6, student.getPhone());
		preparedStatement.setString(7, student.getEmail());
		preparedStatement.setString(8, student.getPassword());
		preparedStatement.setString(9, student.getSchool());
		preparedStatement.setLong(10, student.getFees());
		
	int count =	preparedStatement.executeUpdate();
		connection.close();
		return count ;
		
		
		

		
	}

	public String loginStudent(String email) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM STUDENT WHERE EMAIL=?");
		preparedStatement.setString(1, email);
	ResultSet resultSet=	preparedStatement.executeQuery();
	String password=null;
	
	while (resultSet.next()) {
		password=resultSet.getString("password");
		
		
	}
	connection.close();
	return password;
		
		
	}

}
