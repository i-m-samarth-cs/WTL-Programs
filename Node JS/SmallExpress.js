// In your project, you might install 'express' using npm:
// npm install express

// Then in your code:
const express = require('express');
const app = express();

app.get('/', (req, res) => {
    res.send('Hello from Express!');
});

app.listen(3000, () => {
    console.log('Express app listening on port 3000');
});