<html> 
<head> 
<title> Sum and Average </title> 
</head> 
<body> 
<center> 
<?php 
$sum=0; 
for($i=1;$i<=10;$i++) 
{ 
 $sum+=$i; 
} 
$avg=$sum/10; 
print "The Sum is:  $sum"; 
print "<br/>"; 
print "the Average is: $avg"; 
?> 
</center> 
</body> 
</html> 