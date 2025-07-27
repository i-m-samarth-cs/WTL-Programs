console.log('First');

setTimeout(() => {
    console.log('Second (from setTimeout)');
}, 0); // Even with 0ms, it goes into the event queue

Promise.resolve().then(() => {
    console.log('Third (from Promise - microtask queue)');
});

console.log('Fourth');