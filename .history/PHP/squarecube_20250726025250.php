<html> 
<head> 
<title>Square and Cube Table </title> 
</head> 
<body> 
<center> 
<?php 
print "<table border =1>"; 
print "<tr>"; 
print "<th>Number</th>"; 
print "<th>Square</th>"; 
print "<th>Cube</th>"; 
print "</tr>"; 
for($i=1;$i<=10;$i++) 
{ 
print "<tr>"; 
print "<td>$i"; 
print "</td>"; 
print "<td>"; 
print $i*$i; 
print "</td>"; 
print "<td>"; 
printpow($i,3); 
print "</td>"; 
print "</tr>"; 
} 
print "</table>"; 
?> 
</center> 
</body> 
</html> 