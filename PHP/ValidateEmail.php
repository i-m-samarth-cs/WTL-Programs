<?php 
$reg = '/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,3})$/';
$email=$_POST["email"]; 
if (preg_match($reg, $email))  
{ 
 echo "Valid Email ID"; 
} 
else 
{ 
 echo "Invalid Email ID."; 
} 
?>