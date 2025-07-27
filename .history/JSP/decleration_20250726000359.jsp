<html> 
    <head> 
        <title>JSP Declaration Demo</title> 
    </head> 
   <%! 
       String msg = "Hello"; 
   %> 
  <body> 
 Message is: 
        <% out.println(msg); %>    
  </body> 
</html> 