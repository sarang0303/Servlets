<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

String id= request.getParameter("id");
String name= request.getParameter("name");
String mobilenumber= request.getParameter("mobilenumber");
String yop= request.getParameter("yop");

String password= request.getParameter("password");
String email= request.getParameter("email");





int id1=Integer.parseInt(id);
long mobilenumber1=Long.parseLong(mobilenumber);
int yop1=Integer.parseInt(yop);


Class.forName("com.mysql.cj.jdbc.Driver");
Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/colloge","root","root");
PreparedStatement ps=con.prepareStatement("insert into student(id,name,mobilenumber,yop,password,email)  values(?,?,?,?,?,?)");
ps.setInt(1, id1);
ps.setString(2, name);
ps.setLong(3, mobilenumber1);
ps.setInt(4, yop1);
ps.setString(5, password);
ps.setString(6, email);




System.out.println("Data Saved Succesfully");
ps.execute();



%>

</body>
</html>