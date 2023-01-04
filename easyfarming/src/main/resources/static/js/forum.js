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
                children.className = "forumDiv";
                children.appendChild(addToChild(d["username"], "h2"));
                children.appendChild(addToChild(d["question"], "h2"));
                children.appendChild(addToChild(d["username1"], "a"));
                children.appendChild(addToChild(d["answer1"], "div"));
                children.appendChild(addToChild(d["username2"], "a"));
                children.appendChild(addToChild(d["answer2"], "div"));
                children.appendChild(addToChild(d["username3"], "a"));
                children.appendChild(addToChild(d["answer3"], "div"));
                children.appendChild(addToChild(d["username4"], "a"));
                children.appendChild(addToChild(d["answer4"], "div"));
                children.appendChild(addToChild(d["username5"], "a"));
                children.appendChild(addToChild(d["answer5"], "div"));
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
