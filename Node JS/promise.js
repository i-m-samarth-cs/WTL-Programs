function fetchDataPromise() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('Data fetched with Promise');
        }, 1000);
    });
}

fetchDataPromise()
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });