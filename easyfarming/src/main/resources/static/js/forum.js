window.addEventListener("load", async () => {
    const list_message = document.querySelector("#forum");
    fetch('/forumMessages/allForumMessages',
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

            for(let d of data) {
                const children = document.createElement("div");
                // add all the question and answer stuff here
                children.appendChild(addToChild(d["question"], "h1"));
                children.appendChild(addToChild(d["answer1"], "p"));
                children.appendChild(addToChild(d["answer2"], "p"));
                children.appendChild(addToChild(d["answer3"], "p"));
                children.appendChild(addToChild(d["answer4"], "p"));
                children.appendChild(addToChild(d["answer5"], "p"));
                list_message.appendChild(children);
            }

        })
        .catch(error => {
            console.log(error);
        });
});

function addToChild(data, tag) {
    const children = document.createElement(tag);
    children.className = "forumMessage";
    children.innerText = data;
    return children;
}
