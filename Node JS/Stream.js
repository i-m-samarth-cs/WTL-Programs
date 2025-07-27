const fs = require('fs');
const readableStream = fs.createReadStream('demo.txt', 'utf8'); // Assuming large_file.txt exists

let data = '';

readableStream.on('data', (chunk) => {
    data += chunk;
    console.log(`Received ${chunk.length} bytes of data.`);
});

readableStream.on('end', () => {
    console.log('Finished reading data.');
    // console.log(data); // Uncomment to see all data, but be cautious with large files
});

readableStream.on('error', (err) => {
    console.error('Error reading file:', err);
});