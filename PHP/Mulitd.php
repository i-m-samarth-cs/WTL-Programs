<!DOCTYPE html> 
<html> 
<body> 
<?php 
$Student = array 
 ( 
  array(10,"AAA"), 
  array(20,"BBB"), 
  array(30,"CCC"), 
  ); 
echo "The elements in Two dimensional array...<br/>"; 
for ($row = 0; $row < 3; $row++) { 
  for ($col = 0; $col < 2; $col++) { 
    echo " ".$Student[$row][$col]; 
  } 
  echo "<br/>"; 
} 
?> 
</body> 
</html>