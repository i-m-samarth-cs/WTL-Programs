function fetchDataAsyncAwait() {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve('Data fetched with Async/Await');
        }, 1000);
    });
}

async function getData() {
    try {
        const data = await fetchDataAsyncAwait();
        console.log(data);
    } catch (error) {
        console.error(error);
    }
}

getData();