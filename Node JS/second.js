console.log("Start");

setTimeout(() => {
    console.log("This will be executed after a delay (asynchronously)");
}, 2000); // Simulates an I/O operation taking 2 seconds

console.log("End (This runs before the setTimeout callback)");