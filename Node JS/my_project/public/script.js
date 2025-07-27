document.addEventListener('DOMContentLoaded', () => {
    const fetchDataBtn = document.getElementById('fetchDataBtn');
    const dataContainer = document.getElementById('dataContainer');

    fetchDataBtn.addEventListener('click', async () => {
        try {
            const response = await fetch('/api/data'); // Fetch from our backend API route
            const data = await response.json();
            dataContainer.innerHTML = `
                <h2>Fetched Data:</h2>
                <pre>${JSON.stringify(data, null, 2)}</pre>
            `;
        } catch (error) {
            dataContainer.innerHTML = `<p style="color: red;">Error fetching data: ${error.message}</p>`;
            console.error('Error fetching data:', error);
        }
    });
});