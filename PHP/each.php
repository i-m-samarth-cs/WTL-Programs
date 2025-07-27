<?php 
$mylist = array("Hello", "PHP","You","Are","Wonderful!!!"); 
while($myval=each($mylist)) 
{ 
 $val=$myval["value"]; 
print("The current value of the array is <b>$val</b>"); 
 print "<br/>"; 
} 
?>