<html> 
<head> 
 <title>Selection Demo</title> 
</head>
<body> 
<?php 
 print "<h2>Selection Statement </h2>"; 
 $a=10; 
 $b=20; 
 $c=30; 
 if($a>$b) 
 if($a>$c) 
 print "<b><I>a is the largest number </I></b>"; 
else 
  print "<b><I> c is the largest number</I></b>"; 
 else 
 if($b>$c) 
  print "<b><I>b is the largest number</I></b>"; 
else 
 print "<b><I>c is the largest number</I></b>"; 
?> 
</body> 
</html>