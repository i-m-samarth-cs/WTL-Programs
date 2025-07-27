<?php
// edit.php - Page to edit an existing student record

// Include database connection and header
include_once 'dbconn.php';
include_once 'header.php';

$message = ''; // To store success or error messages
$student = null; // To store student data

// Check if an ID is provided in the GET request
if (isset($_GET['id']) && !empty($_GET['id'])) {
    $id = filter_var($_GET['id'], FILTER_VALIDATE_INT);

    if ($id === false || $id <= 0) {
        $message = "<p class='text-red-500 text-center mb-4'>Invalid student ID.</p>";
        $student = false; // Indicate an error state
    } else {
        // Prepare a SELECT statement to fetch the student's current data
        $stmt = $conn->prepare("SELECT id, name, branch, age FROM student_info WHERE id = ?");
        $stmt->bind_param("i", $id);
        $stmt->execute();
        $result = $stmt->get_result();

        if ($result->num_rows == 1) {
            $student = $result->fetch_assoc();
        } else {
            $message = "<p class='text-red-500 text-center mb-4'>Student not found.</p>";
            $student = false; // Indicate student not found
        }
        $stmt->close();
    }
} else {
    // If no ID is provided, redirect back to index.php
    header("Location: index.php?status=no_id");
    exit();
}

// Check if the form has been submitted (for updating)
if ($_SERVER["REQUEST_METHOD"] == "POST" && $student !== false) {
    // Sanitize and validate input data
    $id_post = filter_var($_POST['id'], FILTER_VALIDATE_INT);
    $name = htmlspecialchars(trim($_POST['name']));
    $branch = htmlspecialchars(trim($_POST['branch']));
    $age = filter_var($_POST['age'], FILTER_VALIDATE_INT);

    // Ensure the ID from POST matches the ID from GET (for security)
    if ($id_post !== $id) {
        $message = "<p class='text-red-500 text-center mb-4'>Security error: ID mismatch.</p>";
    } elseif (empty($name) || empty($branch) || $age === false || $age <= 0) {
        $message = "<p class='text-red-500 text-center mb-4'>Please fill all fields correctly. Age must be a positive number.</p>";
    } else {
        // Prepare an SQL UPDATE statement
        $stmt = $conn->prepare("UPDATE student_info SET name = ?, branch = ?, age = ? WHERE id = ?");
        // Bind parameters
        $stmt->bind_param("ssii", $name, $branch, $age, $id_post); // "ssii" indicates string, string, integer, integer

        // Execute the statement
        if ($stmt->execute()) {
            // Redirect to index.php on success
            header("Location: index.php?status=updated");
            exit();
        } else {
            $message = "<p class='text-red-500 text-center mb-4'>Error updating record: " . $stmt->error . "</p>";
        }
        $stmt->close();
    }
}
?>

<h1 class="text-3xl font-bold text-gray-800 mb-6 text-center">Edit Student</h1>

<?php echo $message; ?>

<?php if ($student !== false): ?>
<form action="edit.php?id=<?php echo htmlspecialchars($student['id']); ?>" method="POST" class="space-y-4">
    <!-- Hidden input for ID to pass it back on POST -->
    <input type="hidden" name="id" value="<?php echo htmlspecialchars($student['id']); ?>">

    <div>
        <label for="name" class="block text-sm font-medium text-gray-700 mb-1">Name:</label>
        <input type="text" id="name" name="name" value="<?php echo htmlspecialchars($student['name']); ?>" required class="focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
    </div>
    <div>
        <label for="branch" class="block text-sm font-medium text-gray-700 mb-1">Branch:</label>
        <input type="text" id="branch" name="branch" value="<?php echo htmlspecialchars($student['branch']); ?>" required class="focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
    </div>
    <div>
        <label for="age" class="block text-sm font-medium text-gray-700 mb-1">Age:</label>
        <input type="number" id="age" name="age" value="<?php echo htmlspecialchars($student['age']); ?>" required class="focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
    </div>
    <div class="flex justify-between items-center">
        <button type="submit" class="btn btn-success">Update Student</button>
        <a href="index.php" class="btn btn-info">Back to List</a>
    </div>
</form>
<?php endif; ?>

<?php
// Close the database connection
$conn->close();

// Include footer
include_once 'footer.php';
?>
