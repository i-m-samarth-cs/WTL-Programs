<?php 
// Connect to MySQL
$conn = mysqli_connect("localhost", "root", "", "test");
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
echo "Connected to database!<br/>";

// Create table
$createTable = "
CREATE TABLE IF NOT EXISTS mytable (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30),
    phone INT,
    emailId VARCHAR(30)
)";
if (mysqli_query($conn, $createTable)) {
    echo "Table Created!<br/>";
} else {
    die("Error creating table: " . mysqli_error($conn));
}

// Insert data
$insert1 = "INSERT INTO mytable (name, phone, emailId) VALUES ('Priyanka', 11111, 'abc123@gmail.com')";
$insert2 = "INSERT INTO mytable (name, phone, emailId) VALUES ('Kumar', 22222, 'pqr11@yahoo.com')";
$insert3 = "INSERT INTO mytable (name, phone, emailId) VALUES ('Archana', 33333, 'xyz@rediffmail.com')";

mysqli_query($conn, $insert1) or die(mysqli_error($conn));
mysqli_query($conn, $insert2) or die(mysqli_error($conn));
mysqli_query($conn, $insert3) or die(mysqli_error($conn));

echo "Data Inserted!<br/><br/>";

// Display table
echo "<b>User Database</b>";
displayTable($conn);

// Update phone number
$update = "UPDATE mytable SET phone = 55555 WHERE phone = 22222";
mysqli_query($conn, $update) or die(mysqli_error($conn));
echo "<br/>Data Updated!<br/>";
displayTable($conn);

// Delete a record
$delete = "DELETE FROM mytable WHERE phone = 33333";
mysqli_query($conn, $delete) or die(mysqli_error($conn));
echo "<br/>Data Deleted!<br/>";
displayTable($conn);

// Close connection
mysqli_close($conn);

// Function to display table
function displayTable($conn) {
    $result = mysqli_query($conn, "SELECT * FROM mytable") or die(mysqli_error($conn));
    
    echo "<table border='1' cellpadding='5' cellspacing='0'>";
    echo "<tr><th>ID</th><th>Name</th><th>Phone</th><th>Email-ID</th></tr>";
    
    while ($row = mysqli_fetch_assoc($result)) {
        echo "<tr>";
        echo "<td>" . $row['id'] . "</td>";
        echo "<td>" . $row['name'] . "</td>";
        echo "<td>" . $row['phone'] . "</td>";
        echo "<td>" . $row['emailId'] . "</td>";
        echo "</tr>";
    }
    echo "</table><br/>";
}
?>
