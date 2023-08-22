package product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductCRUD {
	public int saveProduct(Product product) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/serveletdb", "root", "root");
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, product.getId());
		preparedStatement.setString(2, product.getName());
		preparedStatement.setString(3, product.getBrand());
		preparedStatement.setDouble(4, product.getPrice());
		preparedStatement.setString(5, product.getManufacture());
		preparedStatement.setString(6, product.getState());
		
	int result=	preparedStatement.executeUpdate();
	connection.close();
	return result;
		
		
		
	}

}
