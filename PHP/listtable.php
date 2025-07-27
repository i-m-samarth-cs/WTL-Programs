<?php 
// Make a MySQL Connection using mysqli
$conn = mysqli_connect("localhost", "root", "", "mysql", 3306);

if (!$conn) {
    die('Error in connection: ' . mysqli_connect_error());
}

// Show tables from the selected database
$table_list = mysqli_query($conn, "SHOW TABLES");

if (!$table_list) {
    echo "Error!!! " . mysqli_error($conn);
} else {
    echo "<h3>Tables in 'mydb' database:</h3><ul>";
    while ($row = mysqli_fetch_row($table_list)) {
        echo "<li>" . $row[0] . "</li>";
    }
    echo "</ul>";
}

// Close the connection
mysqli_close($conn);
?>
