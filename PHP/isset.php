<!DOCTYPE html> 
<html> 
<body> 
<?php 
$Student =  array(1=>"AAA",2=>"BBB"); 
echo "<br/>Original Array<br/>"; 
print_r($Student); 
if(isset($Student[0])) 
 echo "<br/>There is no value set at index 0<br/>"; 
if(isset($Student[1])) 
 echo "The value present at index 1 is: ".$Student[1]; 
?> 
</body> 
</html>