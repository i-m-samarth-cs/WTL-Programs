<?php 
// Make a MySQL Connection 
$conn = mysqli_connect("localhost", "root", "", "", 3306);
if (!$conn) {
    die('Error in connection: ' . mysqli_connect_error());
}

// Execute the query to show all databases
$result = mysqli_query($conn, "SHOW DATABASES");

if ($result) {
    echo "<h3>Available Databases:</h3>";
    echo "<ul>";
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<li>" . $row['Database'] . "</li>";
    }
    echo "</ul>";
} else {
    echo "Failed to retrieve databases: " . mysqli_error($conn);
}

mysqli_close($conn); // Closing the database connection
?>
