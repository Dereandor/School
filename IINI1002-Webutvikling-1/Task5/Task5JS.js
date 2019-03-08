function browserCheck(){
    document.getElementById("browser").innerHTML =
        "Browser Code is " + navigator.appCodeName;
}

function clockCheck() {
    var date = new Date();
    document.getElementById("clock").innerHTML = "Klokken er: " + date.getHours() + ":" + date.getMinutes();

}

if (document.images) {
    homebuttonup       = new Image();
    homebuttonup.src   = "home.png" ;
    homebuttondown     = new Image() ;
    homebuttondown.src = "house-outline.png" ;

    Task3buttonup = new Image();
    Task3buttonup.src = "number3.png" ;
    Task3buttondown = new Image() ;
    Task3buttondown.src = "number-three-in-a-circle.png" ;

    Task2buttonup = new Image();
    Task2buttonup.src = "number2.png" ;
    Task2buttondown = new Image() ;
    Task2buttondown.src = "number-two-in-a-circle.png" ;
}
function OnMouseOver( buttonname )
{
    if (document.images) {
        document[ buttonname ].src = eval( buttonname + "down.src" );
    }
}
function OnMouseOut ( buttonname )
{
    if (document.images) {
        document[ buttonname ].src = eval( buttonname + "up.src" );
    }
}
