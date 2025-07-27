function fetchData(callback) {
    setTimeout(() => {
        callback(null, 'Data fetched with callback');
    }, 1000);
}

fetchData((error, data) => {
    if (error) {
        console.error(error);
    } else {
        console.log(data);
    }
});