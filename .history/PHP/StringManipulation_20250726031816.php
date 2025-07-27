<?php 
 $Str1="PHP is Fun";  
 $length = strlen($Str1); 
 echo "<b> Length:</b>The length of string: $Str1 is = $length"; 
 echo "<br/><b>Position: </b>The position of word Fun in the $Str1 is ".strpos($Str1,'Fun'); 
 $Str1="Hello"; 
 $Str2="hello"; 
 if(strcmp($Str1,$Str2)) 
  echo "<br/><b>Comparison: </b> The two strings $Str1 and $Str2 are not equal"; 
 else 
  echo "<br/><b>Comparision: </b> The two strings $Str1 and $Str2 are equal"; 
 $Str1="HELLO"; 
 echo "<br/><b>Changing Case: </b> The string $Str1 becomes ".strtolower($Str1); 
 echo "<br/><b>Reversing String: </b> The string $Str1 is reversed as ".strrev($Str1); 
 $Str1="Hello"; 
 $Str2="Friend"; 
 echo "<br/><b>Concatenating strings: </b> The string $Str1 and $Str2 are concatenated 
".$Str1.$Str2; 
 echo "<br/><b>Replacing all instances of string: </b> The string tictactoe is now "; 
 echo str_replace("t","p","tictactoe"); 
 $Str1="PHP is fun"; 
 $newstring=substr_replace($Str1,"FUN",7,9); 
 echo "<br><b>Replacing substring: </b> $Str1 becomes $newstring"; 
?>