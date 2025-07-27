<html> 
 <head><title>Reading Cookies</title> 
<body> 
 <?php 
 if (isset($_COOKIE["Myname"])) 
   echo "<h3>Welcome " . $_COOKIE["Myname"]."!!!</h3>"; 
 else 
   echo "<h3>Welcome guest!</h3>"; 
 ?> 
</body> 
</html> 