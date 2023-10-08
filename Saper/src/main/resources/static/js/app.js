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
        handleClick(this)
    }


}


function handleClick(button) {
    button.style.display = "none";
    const square = button.nextElementSibling;
    square.style.display = "block";

    if(button.nextElementSibling.classList.contains("emptySpace") || (button.nextElementSibling.classList.contains("click") && !button.nextElementSibling.hasChildNodes())) {
        const x = parseInt(button.getAttribute('data-x'));
        const y = parseInt(button.getAttribute('data-y'));

        Array.from(buttons).forEach((button) => {
            const buttonx = parseInt(button.getAttribute('data-x'));
            const buttony = parseInt(button.getAttribute('data-y'));

            if (buttonx === x-1 && buttony === y){
                button.click()

            }
            if (buttonx === x+1 && buttony === y){
                button.click()
            }
            if (buttonx === x && buttony === y-1){
                button.click()
            }
            if (buttonx === x && buttony === y+1){
                button.click()
            }
        })
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
            generateMap()
        })
        .catch(error => {
            console.error('Błąd:', error);
        });


}

function generateMap() {
    Array.from(buttons).forEach((button) => {
        const area = board[button.getAttribute('data-y')][button.getAttribute('data-x')]
        console.log("button x " + button.getAttribute('data-x') + " y " + button.getAttribute('data-y') + " area x" + area.x + " y " + area.y)
    })
}




