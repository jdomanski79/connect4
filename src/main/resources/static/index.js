let stompClient = null;
let count = 0;
const appUri = "/app/hello";
const messageParagraph = document.getElementById("message");

document.getElementById("connect").addEventListener("click", ()=>{
    connect();
});

document.getElementById("sendHello").addEventListener("click", (event)=>{
    //console.log("Hello from sendHello");
    count++;
    stompClient.send(appUri, {}, "Sending hello " + count);
});

const cells = document.querySelectorAll(".board-column");
cells.forEach( cell => {
    cell.addEventListener("click", (event)=>{ 
        sendColumn(event.target.dataset.column);
    })
  });

// websocket connection
function connect(){
    let socket = new SockJS('/game');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame){
        console.log("Connected!!! " + frame);
         
        stompClient.subscribe('/topic/game', function(message) {
            messageParagraph.innerHTML += "Column clicked :" + message.body +"\n";
            toggleColumn(message.body);
        })
    })
}



function sendColumn(column){
    stompClient.send(appUri, {}, column);
}

function toggleColumn(column){
    const col = document.querySelector(`.board-column[data-column="${column}"]`);
    for( let i = 0; i< col.children.length; i++) {
        col.children[i].classList.toggle("clicked");
    }
}