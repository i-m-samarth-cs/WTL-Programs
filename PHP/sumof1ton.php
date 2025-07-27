<html> 
 <head> 
  <title> PHP Demo </title> 
 </head> 
 <body> 
  <form method="post"> 
   <input type="text" name="num"/> 
   <input type="submit" value="Submit"/> 
  </form> 
 </body> 
</html> 
<?php 
 //getting values from HTML form 
 $n = intval($_POST['num']); 
 $sum=0; 
 for($i=1;$i<=$n;$i++) 
  $sum=$sum+$i; 
 echo "The sum of all numbers from 1 to ".$n." is ".$sum; 
?>