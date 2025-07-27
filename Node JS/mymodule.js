function greet(name) {
    return `Hello, ${name}!`;
}

const PI = 3.14159;

module.exports = {  // Export the function as a module
    greetUser: greet,
    mathPI: PI
};