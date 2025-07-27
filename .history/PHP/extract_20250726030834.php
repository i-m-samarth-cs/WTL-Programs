<!DOCTYPE html> 
<html> 
<body> 
<?php 
$arr = array("a" => "Pune","b" => "Mumbai", "c" => "Chennai"); 
extract($arr); 
echo "\$a = $a; \$b = $b; \$c = $c"; 
?> 
</body> 
</html>