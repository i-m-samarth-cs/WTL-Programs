<?php
// dbconn.php - Database connection file

// Database configuration
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', ''); // No password as per your request
define('DB_NAME', 'student');

// Create a new MySQLi connection
$conn = new mysqli(DB_HOST, DB_USER, DB_PASS, DB_NAME);

// Check connection
if ($conn->connect_error) {
    // If connection fails, terminate and display error
    die("Connection failed: " . $conn->connect_error);
}
?>
