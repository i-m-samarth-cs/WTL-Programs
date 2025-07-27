<?php 
session_start(); 
if(isset($_SESSION['pgvisit'])) 
{ 
$_SESSION['pgvisit']=$_SESSION['pgvisit']+1; 
echo "<h3>You are visiting this page for <i>". $_SESSION['pgvisit']."</i> times</h3>"; 
} 
else 
{ 
$_SESSION['pgvisit']=1;
echo "<h3>You are visiting this page for the first time</h3>"; 
} 
?> 