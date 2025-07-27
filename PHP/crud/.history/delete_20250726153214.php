<?php
// delete.php - Script to delete a student record

// Include database connection
include_once 'dbconn.php';

// Check if an ID is provided in the GET request
if (isset($_GET['id']) && !empty($_GET['id'])) {
    $id = filter_var($_GET['id'], FILTER_VALIDATE_INT);

    if ($id === false || $id <= 0) {
        // Invalid ID, redirect with error status
        header("Location: index.php?status=delete_invalid_id");
        exit();
    } else {
        // Prepare a DELETE statement
        $stmt = $conn->prepare("DELETE FROM student_info WHERE id = ?");
        $stmt->bind_param("i", $id); // "i" indicates integer

        // Execute the statement
        if ($stmt->execute()) {
            // Redirect to index.php on successful deletion
            header("Location: index.php?status=deleted");
            exit();
        } else {
            // Redirect with error status if deletion fails
            header("Location: index.php?status=delete_failed&error=" . urlencode($stmt->error));
            exit();
        }
        $stmt->close();
    }
} else {
    // If no ID is provided, redirect back to index.php
    header("Location: index.php?status=delete_no_id");
    exit();
}

// Close the database connection
$conn->close();
?>
