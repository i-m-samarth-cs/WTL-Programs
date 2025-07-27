<!DOCTYPE html> 
<html> 
<body>
    <?php 
$Student =  array("AAA","BBB","CCC","DDD","EEE"); 
echo "<br/>Original Array<br/>"; 
print_r($Student); 
echo "<br/>Deleting element at index 2<br/>"; 
unset($Student[2]); 
print_r($Student); 
echo "<br/>Adjusting gap<br/>"; 
$Student=array_values($Student); 
print_r($Student); 
?> 
</body> 
</html>