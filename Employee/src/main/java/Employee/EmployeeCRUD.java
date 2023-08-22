package Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeCRUD {
	public Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");
		return connection;
	}
	public void saveEmployee(Employee employee) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());
		
		int result=preparedStatement.executeUpdate();
		if(result!=0) {
			System.out.println("Data Inserted");
		}
		else {
			System.out.println("Data not Inserted");
		}
		connection.close();
		
	}
	public String loginEmployee(String email) throws Exception {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMAIL=?");
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

