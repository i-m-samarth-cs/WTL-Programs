var http = require('http'); 
http.createServer(function (req, res) { 
    res.writeHead(200, {'Content-Type': 'text/html'}); 
    res.end("Welcome to the Learn NodeJS!"); 
}).listen(8082); 
console.log('Server is running at http://localhost:8082/');