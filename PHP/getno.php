<?php 
print "The number is: "; 
print $_POST["mynum"]; 
$a= $_POST["mynum"]; 
if($a%2==1) 
 print "<br/> The number is odd "; 
else 
 print "<br/> The number is even "; 
?>