<?php 
$regex = "/[a-zA-Z]+ \d+/"; 
if (preg_match($regex, "May 16")) 
{ 
    // The expression "[a-zA-Z]+ \d+" matches the date string 
    echo "The date is matching with given regular expression!"; 
}  
else 
 { 
    // If preg_match() returns false, then the regex does not 
    // match the string 
    echo "The regex pattern does not match."; 
} 
?>