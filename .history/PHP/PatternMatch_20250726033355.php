<?php 
print "<h3>Use of preg_match function</h3>"; 
if (preg_match("/gram/", "I like Programming in PHP!"))  
  print "The pattern is matching <br />"; 
 else  
  print "The pattern does not match <br />"; 
 print "<h3>Use of preg_split function</h3>"; 
 $text ="Hello:friends:how:are:you?"; 
 print "The original string is<b> $text</b>"; 
 print "<br/>"; 
 print "The split is as follows ...<br/>"; 
 $chunks=preg_split("/:/",$text); 
 while($myval=each($chunks)) 
 { 
 $val=$myval["value"]; 
 print("<b>$val</b>"); 
 print "<br/>"; 
 } 
?> 