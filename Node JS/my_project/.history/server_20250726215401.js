const express = require('express'); // Import Express
const path = require('path');     // Import path module for directory paths

const app = express(); // Create an Express application
const PORT = 8082;     // Define the port

// Serve static files from the 'public' directory
// This line is crucial for serving your HTML, CSS, JS, images, etc.
app.use(express.static(path.join(__dirname, 'public')));

// Define a simple API route
app.get('/api/data', (req, res) => {
    res.json({
        message: "Hello from the Node.js API!",
        timestamp: new Date().toISOString(),
        data: [
            { id: 1, name: "Item A" },
            { id: 2, name: "Item B" },
            { id: 3, name: "Item C" }
        ]
    });
});

// Handle all other routes (for single-page applications or simple index serving)
// This ensures that if a user directly navigates to '/', index.html is served.
app.get('/', (req, res) => {
    res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

// Start the server
app.listen(PORT, () => {
    console.log(`Express server running at http://localhost:${PORT}`);
    console.log(`Access the frontend at: http://localhost:${PORT}/`);
    console.log(`Test the API at: http://localhost:${PORT}/api/data`);
});