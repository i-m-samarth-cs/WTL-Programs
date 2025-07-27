<html> 
<body> 
<%@ page language="java" contentType="text/html" %> 
<%@page import="java.io.*" %> 
<% 
 String msg=""; 
 String age; 
 int age_val; 
 age=request.getParameter("Age"); 
 age_val=Integer.parseInt(age); 
 if(age_val<15) 
  msg+="You are a kid!"; 
 if((age_val>16)&&(age_val<40)) 
  msg+="You are young!"; 
 if(age_val>40) 
  msg+="You are old!"; 
 out.println("<h3>"+msg+"</h3>"); 
%> 
</body> 
</html>