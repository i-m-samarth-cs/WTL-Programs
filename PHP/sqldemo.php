<?php 
// Make a MySQL Connection 
$conn=mysqli_connect("localhost:3306/mydb","root",""); 
if(!$conn) 
{ 
die('error in connection'.mysql_error()); 
} 
else 
{ 
print"connected"; 
} 
mysqli_close($conn); //closing the database 
?> 