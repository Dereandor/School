let url = "http://bigdata.stud.iie.ntnu.no/sentiment/webresources/sentiment/log";
let security = "?api-key=Happy!!!";
let text = "";

// Background color
let colorArray = ["#FF0000", "#FF8C00", "#FFD700", "#9ACD32", "#00FF00"];

// Mood image
let imgArray = new Array();
imgArray[0] = new Image();
imgArray[0].src = "Smley0.JPG";

imgArray[1] = new Image();
imgArray[1].src = "Smley1.JPG";

imgArray[2] = new Image();
imgArray[2].src = "Smley2.JPG";

imgArray[3] = new Image();
imgArray[3].src = "Smley3.JPG";

imgArray[4] = new Image();
imgArray[4].src = "Smley4.JPG";



document.querySelector("#sendText").addEventListener("click", e => {
    text = document.getElementById("myInput").value;
    fetch(url + security, {
        method: "POST",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            sentence: text,
        })
    })
        .then(response => response.json())
        .then(json => handleResponse(json))
        .catch(error => console.error("Error: ", error))
});

function handleResponse(json) {
    document.querySelector("#mySentence").innerHTML = text;
    document.querySelector("#value").innerHTML = json.value;
    document.body.style.backgroundColor = colorArray[json.value];
    document.getElementById("smly").src = imgArray[json.value].src;
}