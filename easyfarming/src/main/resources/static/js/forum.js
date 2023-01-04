setTimeout(function(){
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
                children.appendChild(addToChild(d["username"], "h1"));
                children.appendChild(addToChild(d["question"], "h1"));
                children.appendChild(addToChild(d["username1"], "p"));
                children.appendChild(addToChild(d["answer1"], "p"));
                children.appendChild(addToChild(d["username2"], "p"));
                children.appendChild(addToChild(d["answer2"], "p"));
                children.appendChild(addToChild(d["username3"], "p"));
                children.appendChild(addToChild(d["answer3"], "p"));
                children.appendChild(addToChild(d["username4"], "p"));
                children.appendChild(addToChild(d["answer4"], "p"));
                children.appendChild(addToChild(d["username5"], "p"));
                children.appendChild(addToChild(d["answer5"], "p"));
                list_message.appendChild(children);
            }

        })
        .catch(error => {
            console.log(error);
        });
}, 10000)

function addToChild(data, tag) {
    const children = document.createElement(tag);
    children.className = "forumMessage";
    children.innerText = data;
    return children;
}
