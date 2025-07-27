<html> 
<head> 
 <title>Book Information</title> 
</head> 
<body> 
<?php 
$BName=$_POST["BName"]; 
$PUBName=$_POST["PUBName"]; 
$Price=$_POST["Price"]; 
$Qty=$_POST["Qty"]; 
?> 
<center> 
<h3> Book Data </h3> 
<table border=1> 
<tr> 
 <th>Book name</th> 
 <th>Publisher</th> 
 <th>Price</th> 
 <th>Quantity</th> 
</tr> 
<tr> 
 <td><?php print ("$BName"); ?></td> 
 <td><?php print ("$PUBName"); ?></td> 
 <td><?php printf("%3.2f",$Price); ?></td> 
 <td><?php printf("%d",$Qty); ?></td> 
</tr> 
</table> 
</center> 
</body> 
</html> 