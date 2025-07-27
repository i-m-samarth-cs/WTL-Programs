<?php 
// Make a MySQL Connection 
$conn=mysqli_connect("localhost","root",""); 
if(!$conn) 
{ 
die('error in connection'.mysql_error()); 
} 
//Create a database 
if(mysqli_query($conn, "CREATE DATABASE mydb2")) 
 { 
   print "Database created"; 
 } 
 else 
 { 
   print "Error creating database: " . mysql_error(); 
 } 
mysqli_close($conn); //closing the database 
?>