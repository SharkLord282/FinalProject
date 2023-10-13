const buttons = document.getElementsByClassName("button")
let board;
let safeArea = 0;
const dificultyDiv = document.getElementById('dificulty')
let dificulty = dificultyDiv.getAttribute("dificulty")
console.log(dificulty)

Array.from(buttons).forEach((button) => {
    button.addEventListener("contextmenu", function (event) {
        event.preventDefault();
        if (event.button === 2) {
            handleRightClick(this);
        }
    })
})

Array.from(buttons).forEach((button) => {
   button.addEventListener("click", whenClicked)
})



function whenClicked() {
    if (board) {
        handleClick(this)
    } else {
        console.log("Brak danych w board");
        getMap(this)
    }
}



function handleClick(button) {
    button.style.display = "none";
    const square = button.nextElementSibling;
    square.style.display = "block";
   if (!square.classList.contains("bomb")) {
       safeArea--
   }else {
       button.nextElementSibling.style.backgroundColor = "red";
       Array.from(buttons).forEach((button) => {
           if (button.nextElementSibling.classList.contains("bomb")) {
               button.style.display = "none";
               button.nextElementSibling.style.display = "block";
           } else {
               button.disabled = true;
           }
       })
   }
    if(button.nextElementSibling.classList.contains("emptySpace") || (button.nextElementSibling.classList.contains("click") && button.nextElementSibling.getAttribute("number") == 0)) {
        let x = parseInt(button.getAttribute('data-x'));
        let y = parseInt(button.getAttribute('data-y'));

        if (board[y-1] !== undefined && board[y-1][x-1] !== undefined ) {
            let paramx = x -1
            let paramy = y -1
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display == "block"){
                click.click()
            }

        }
        if (board[y-1] !== undefined && board[y-1][x] !== undefined) {
            let paramx = x
            let paramy = y -1
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display === "block"){
                click.click()
            }
        }
        if (board[y-1] !== undefined && board[y-1][x+1] !== undefined) {
            let paramx = x +1
            let paramy = y -1
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display === "block"){
                click.click()
            }
        }
        if (board[y] !== undefined && board[y][x-1] !== undefined) {
            let paramx = x -1
            let paramy = y
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display === "block"){
                click.click()
            }
        }
        if (board[y] !== undefined && board[y][x+1] !== undefined) {
            let paramx = x +1
            let paramy = y
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display === "block"){
                click.click()
            }
        }
        if (board[y+1] !== undefined && board[y+1][x-1] !== undefined) {
            let paramx = x -1
            let paramy = y +1
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display === "block"){
                click.click()
            }
        }
        if (board[y+1] !== undefined && board[y+1][x] !== undefined) {
            let paramx = x
            let paramy = y +1
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display === "block"){
                click.click()
            }
        }
        if (board[y+1] !== undefined && board[y+1][x+1] !== undefined) {
            let paramx = x +1
            let paramy = y +1
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            if (click.style.display === "block"){
                click.click()
            }
        }

    }


}

function handleRightClick(button) {

    if(!button.hasChildNodes()) {
        const img = document.createElement('img');
        const bombCounter = document.getElementById("bombCounter")
        img.src = "/static/img/banner.png"
        img.textContent = "banner"
        img.classList.add("square")
        img.classList.add("banner")
        button.appendChild(img)
        button.disabled = true
        bombs--
        bombCounter.innerText = formatCounter(bombs)
        img.addEventListener("contextmenu", function (event) {
            event.preventDefault();
            const div = document.createElement('div')
            div.classList.add("square")
            div.classList.add("text")
            div.innerText = "?"
            button.appendChild(div)
            button.removeChild(img)
            button.disabled = false
            bombs++
            bombCounter.innerText = formatCounter(bombs)
        })
    } else {
        button.removeChild(button.firstChild)
    }
}

function getMap(button) {
    const paramx = button.getAttribute('data-x')
    const paramy = button.getAttribute('data-y')
    const area = {
        x: paramx,
        y: paramy,
        name: "click",
        number: 0
    };
    fetch('/saper/' + dificulty , {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(area)
    })
        .then(response => response.json())
        .then(responseData => {
            board = responseData
            generateMap(area.x, area.y)
            startTimer()
        })
        .catch(error => {
            console.error('Błąd:', error);
        });


}

function generateMap(paramx,paramy) {

    Array.from(buttons).forEach((button) => {
        const area = board[button.getAttribute('data-y')][button.getAttribute('data-x')]
        if (area.name === "bomb") {
            const square = document.createElement('img');
            square.src = "/static/img/bomb.png"
            square.alt = "bomb"
            square.classList.add('square');
            square.classList.add(area.name);
            square.setAttribute("number", area.number);
            square.style.display = 'none';
            button.parentElement.appendChild(square);
        } else {
            const square = document.createElement('div');
            if (area.number >= 1) {
                square.textContent = area.number
                square.classList.add("number");
            }else {
                square.classList.add(area.name);
            }
            square.classList.add('square');
            square.setAttribute("number", area.number);
            square.style.display = 'none';
            button.parentElement.appendChild(square);
            safeArea++
        }
        button.style.display = "block"

    })

    const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
       click.click()
}

const boardBack = document.getElementById("boardBody")
boardBack.addEventListener("contextmenu" ,function (event) {
    event.preventDefault()
} )

const bombCounter = document.getElementById("bombCounter")
let bombs;
if (dificulty === "easyMap") {
    bombs = 10
}

function formatCounter(bombs) {
    if (bombs >= 0) {
        return bombs.toString().padStart(3, '0');
    } else {
        return '-' + (-bombs).toString().padStart(2, '0');
    }
}
bombCounter.innerText = formatCounter(bombs);

let seconds = 0
let timeInterval
function startTimer() {
    timeInterval = setInterval(function () {
        seconds++
        updateTime()
    },1000)

}

function stopTimer() {
    clearInterval(timeInterval)
}

function resetTime() {
    seconds = 0
    updateTime()
}

function updateTime() {
    const timer = document.getElementById("timer");
    timer.innerText = seconds.toString().padStart(3,`0`);
}

