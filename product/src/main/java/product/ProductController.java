package product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String brand=req.getParameter("brand");
		double price=Double.parseDouble(req.getParameter("price"));
		String manufacture=req.getParameter("manufacture");
		String State=req.getParameter("state");
		
		Product product=new Product();
		ProductCRUD crud=new ProductCRUD();
		product.setId(id);
		product.setName(name);
		product.setBrand(brand);
		
		product.setManufacture(manufacture);
		product.setState(State);
		if (State.equals("MAH")) {
			ServletContext context=getServletContext();
			double CGST =Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config=getServletConfig();
			double SGST=Double.parseDouble(config.getInitParameter("MAH"));
			
			double totalPrice=price+(CGST+SGST)*price;
			product.setPrice(totalPrice);
			
		} else {
			ServletContext context=getServletContext();
			double CGST =Double.parseDouble(context.getInitParameter("CGST"));
			ServletConfig config=getServletConfig();
			double SGST=Double.parseDouble(config.getInitParameter("KAR"));
			
			double totalPrice=price+(CGST+SGST)*price;
			product.setPrice(totalPrice);
			

		}
		PrintWriter printWriter=resp.getWriter();
	
		try {
			int result=crud.saveProduct(product);
			if (result!=0) {
				printWriter.print("Saved");
				
			} else {
				printWriter.print("not saved");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
