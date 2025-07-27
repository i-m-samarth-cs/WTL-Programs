<?php 
// Connect to MySQL and select existing database
$conn = mysqli_connect("localhost", "root", "", "mydb2");

// Check connection
if (!$conn) {
    die("Error in connection: " . mysqli_connect_error());
}

// Create table
$query = "CREATE TABLE my_table (
    id INT(4),
    name VARCHAR(20)
)";

if (mysqli_query($conn, $query)) {
    echo "Table 'my_table' created successfully";
} else {
    echo "Error creating table: " . mysqli_error($conn);
}

// Close connection
mysqli_close($conn);
?>
