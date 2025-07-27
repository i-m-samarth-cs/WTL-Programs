<?php
// create.php - Page to add a new student record

// Include database connection and header
include_once 'dbconn.php';
include_once 'header.php';

$message = ''; // To store success or error messages

// Check if the form has been submitted
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Sanitize and validate input data
    $name = htmlspecialchars(trim($_POST['name']));
    $branch = htmlspecialchars(trim($_POST['branch']));
    $age = filter_var($_POST['age'], FILTER_VALIDATE_INT);

    // Basic validation
    if (empty($name) || empty($branch) || $age === false || $age <= 0) {
        $message = "<p class='text-red-500 text-center mb-4'>Please fill all fields correctly. Age must be a positive number.</p>";
    } else {
        // Prepare an SQL INSERT statement
        $stmt = $conn->prepare("INSERT INTO student_info (name, branch, age) VALUES (?, ?, ?)");
        // Bind parameters to the prepared statement
        $stmt->bind_param("ssi", $name, $branch, $age); // "ssi" indicates string, string, integer

        // Execute the statement
        if ($stmt->execute()) {
            // Redirect to index.php on success
            header("Location: index.php?status=created");
            exit(); // Ensure no further code is executed after redirection
        } else {
            $message = "<p class='text-red-500 text-center mb-4'>Error: " . $stmt->error . "</p>";
        }

        // Close the statement
        $stmt->close();
    }
}
?>

<h1 class="text-3xl font-bold text-gray-800 mb-6 text-center">Add New Student</h1>

<?php echo $message; ?>

<form action="create.php" method="POST" class="space-y-4">
    <div>
        <label for="name" class="block text-sm font-medium text-gray-700 mb-1">Name:</label>
        <input type="text" id="name" name="name" required class="focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
    </div>
    <div>
        <label for="branch" class="block text-sm font-medium text-gray-700 mb-1">Branch:</label>
        <input type="text" id="branch" name="branch" required class="focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
    </div>
    <div>
        <label for="age" class="block text-sm font-medium text-gray-700 mb-1">Age:</label>
        <input type="number" id="age" name="age" required class="focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
    </div>
    <div class="flex justify-between items-center">
        <button type="submit" class="btn btn-success">Add Student</button>
        <a href="index.php" class="btn btn-info">Back to List</a>
    </div>
</form>

<?php
// Close the database connection
$conn->close();

// Include footer
include_once 'footer.php';
?>
