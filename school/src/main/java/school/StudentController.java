package school;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String s_name=req.getParameter("s_name");
		String f_name=req.getParameter("f_name");
		String m_name=req.getParameter("m_name");
		int age=Integer.parseInt(req.getParameter("age"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		
		ServletContext context=getServletContext();
		String school=context.getInitParameter("school");
	
		
	
		
		Student student=new Student();
		student.setId(id);
		student.setStudent_name(s_name);
		student.setFather_name(f_name);
		student.setMother_name(m_name);
		student.setAge(age);
		student.setPhone(phone);
		student.setEmail(email);
		student.setPassword(password);
		student.setSchool(school);
		
		String fee=req.getParameter("fees");
				
		
		if (fee.equals("fees")) {
			ServletConfig config=getServletConfig();
			long fees=Long.parseLong(config.getInitParameter("OS"));
			student.setFees(fees);
		}else {
			ServletConfig config=getServletConfig();
			long fees=Long.parseLong(config.getInitParameter("I"));
			student.setFees(fees);
			
		}
		
		StudentCRUD crud=new StudentCRUD();
	
		
		try {
			int result=crud.saveStudent(student);
			if (result!=0) {
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
				dispatcher.forward(req, resp);
				
			} else {
				RequestDispatcher dispatcher=req.getRequestDispatcher("homepage.html");
				dispatcher.forward(req, resp);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
