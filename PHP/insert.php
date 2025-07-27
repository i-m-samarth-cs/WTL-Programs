<?php 
// Make a MySQL Connection 
$conn = mysqli_connect("localhost", "root", "", "mydb2"); 
if (!$conn) { 
    die('Error in connection: ' . mysqli_connect_error()); 
}

// Insert data into the table
$query1 = "INSERT INTO my_table (id, name) VALUES (1, 'SHILPA')";
mysqli_query($conn, $query1);

$query2 = "INSERT INTO my_table (id, name) VALUES (2, 'MONIKA')";
mysqli_query($conn, $query2);

mysqli_close($conn); // closing the database 
?> 
