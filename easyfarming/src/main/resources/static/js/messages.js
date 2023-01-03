window.addEventListener("load", async () => {
        const list_message = document.querySelector("#messages");
        fetch('/messages/allmessages',
        {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                const count = data.length;
                for(let i = -1; i > -4; i--) {
                    child = document.createElement("li");
                    child.className = "message";
                    child.innerHTML = `<p>${data[count+i].message}</p>`;
                    list_message.appendChild(child);
                }
                //console.log(document.referrer)

            })
            .catch(error => {
                console.log(error);
            });
});

