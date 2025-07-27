<?php
// index.php - Main page to display student list and actions

// Include database connection and header
include_once 'dbconn.php';
include_once 'header.php';

// SQL query to select all records from student_info table
$sql = "SELECT id, name, branch, age FROM student_info";
$result = $conn->query($sql);
?>

<h1 class="text-3xl font-bold text-gray-800 mb-6 text-center">Student Management System</h1>

<div class="flex justify-end mb-4">
    <!-- Link to create new student page -->
    <a href="create.php" class="btn btn-primary">Add New Student</a>
</div>

<?php
// Check if there are any records
if ($result->num_rows > 0) {
    echo "<table class='min-w-full bg-white rounded-lg shadow-sm overflow-hidden'>";
    echo "<thead>";
    echo "<tr>";
    echo "<th class='py-3 px-4'>ID</th>";
    echo "<th class='py-3 px-4'>Name</th>";
    echo "<th class='py-3 px-4'>Branch</th>";
    echo "<th class='py-3 px-4'>Age</th>";
    echo "<th class='py-3 px-4'>Actions</th>";
    echo "</tr>";
    echo "</thead>";
    echo "<tbody>";

    // Loop through each row of the result set
    while($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td class='py-3 px-4'>" . htmlspecialchars($row["id"]) . "</td>";
        echo "<td class='py-3 px-4'>" . htmlspecialchars($row["name"]) . "</td>";
        echo "<td class='py-3 px-4'>" . htmlspecialchars($row["branch"]) . "</td>";
        echo "<td class='py-3 px-4'>" . htmlspecialchars($row["age"]) . "</td>";
        echo "<td class='py-3 px-4 flex space-x-2'>";
        // Link to edit student page with student ID as GET parameter
        echo "<a href='edit.php?id=" . htmlspecialchars($row["id"]) . "' class='btn btn-info text-sm'>Edit</a>";
        // Link to delete student script with student ID as GET parameter
        // A confirmation dialog is typically handled by JavaScript in a real application,
        // but for a simple GET redirect, we'll rely on the delete.php handling.
        echo "<a href='delete.php?id=" . htmlspecialchars($row["id"]) . "' class='btn btn-danger text-sm' onclick=\"return confirm('Are you sure you want to delete this record?');\">Delete</a>";
        echo "</td>";
        echo "</tr>";
    }
    echo "</tbody>";
    echo "</table>";
} else {
    // Message if no records found
    echo "<p class='text-center text-gray-600'>No students found. Please add some records.</p>";
}

// Close the database connection
$conn->close();

// Include footer
include_once 'footer.php';
?>
