const buttons = document.getElementsByClassName("button")
let board;


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
   console.log(button)
    if(button.nextElementSibling.classList.contains("emptySpace") || (button.nextElementSibling.classList.contains("click") && button.nextElementSibling.getAttribute("number") == 0)) {
        let x = parseInt(button.getAttribute('data-x'));
        let y = parseInt(button.getAttribute('data-y'));

        if (board[y-1] !== undefined && board[y-1][x-1] !== undefined ) {
            let paramx = x -1
            let paramy = y -1
            const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
            console.log(click.style.display)
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

function getMap(button) {
    const paramx = button.getAttribute('data-x')
    const paramy = button.getAttribute('data-y')
    const area = {
        x: paramx,
        y: paramy,
        name: "click",
        number: 0
    };
    fetch('/saper/easyMap', {
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
        })
        .catch(error => {
            console.error('Błąd:', error);
        });


}

function generateMap(paramx,paramy) {

    Array.from(buttons).forEach((button) => {
        const area = board[button.getAttribute('data-y')][button.getAttribute('data-x')]
        const square = document.createElement('div');
        square.classList.add('square');
        square.classList.add(area.name);
        square.setAttribute("number", area.number);
        square.style.display = 'none';
        button.parentElement.appendChild(square);
        button.style.display = "block"
    })

    const click = document.querySelector(`[data-x="${paramx}"][data-y="${paramy}"]`)
       click.click()
}




