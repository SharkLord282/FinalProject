const buttons = document.getElementsByClassName("areaButton")
const emptyButtons = document.getElementsByClassName("emptyArea")
const clickButtons = document.getElementsByClassName("click")
console.log(Array.from(clickButtons))
Array.from(clickButtons).forEach((button) => {
button.click()
})
console.log(Array.from(clickButtons))
Array.from(buttons).forEach((button) => {
    button.addEventListener("click", handleClick)
});

function handleClick() {
   this.style.display = "none";
    const square = this.nextElementSibling;
    square.style.display = "block";

    if(this.nextElementSibling.classList.contains("emptySpace") || (this.nextElementSibling.classList.contains("click") && !this.nextElementSibling.hasChildNodes())) {
        const x = parseInt(this.getAttribute('data-x'));
        const y = parseInt(this.getAttribute('data-y'));

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



function hideEmptyButtons() {
    Array.from(emptyButtons).forEach((button) => {
        button.style.display = "none";
    })
}

