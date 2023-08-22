package Employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		EmployeeCRUD crud=new EmployeeCRUD();
		String dbpassword=null;
                try {
					dbpassword=crud.loginEmployee(email);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                PrintWriter printWriter=resp.getWriter();
                if (password.equals(dbpassword)) {
//                	resp.sendRedirect("home.html");//One page to another page
                	printWriter.print("succ");
					
				} else {
					
					printWriter.print("failed");
					RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
					dispatcher.forward(req, resp);

				}
	}

}
