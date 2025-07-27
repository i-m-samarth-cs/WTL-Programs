 <html> 
 <body> 
<%@ page language="java" contentType="text/html"%> 
<%@ page import="java.io.*"%> 
 <% 
for(int i=1;i<=50;i++) 
{ 
if(i%2==0) 
out.println("<p>"+i+"</p>"); 
} 
 %> 
 </body> 
 </html>