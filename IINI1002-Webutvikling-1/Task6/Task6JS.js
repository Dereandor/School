function validateForm() {

    var fornavn = document.forms.innmelding.fornavn.value;
    if (fornavn == "") {
        alert("Fornavn må fylles ut");
        return false;
    }
    var etternavn = document.forms.innmelding.etternavn.value;
    if (etternavn == "") {
        alert("Etternavn må fylles ut");
        return false;
    }
    var alder = document.forms.innmelding.alder.value;
    if (alder <= 13) {
        alert("Må være over 12år for å bli medlem");
        return false;
    }
    if (alder == "") {
        alert("Alder må fylles ut");
        return false;
    }
    var brukernavn = document.forms.innmelding.brukernavn.value;
    if (brukernavn == "") {
        alert("Brukernavn må fylles ut");
        return false;
    }
    var passord = document.forms.innmelding.passord.value;
    var passord2 = document.forms.innmelding.passord2.value;
    if (passord == "") {
        alert("Passord må fylles ut");
        return false;
    }
    if (!(passord === passord2)) {
        alert("Begge passord må være like");
        return false;
    }
    //if no if's run then
    alert("Du er nå registrert i HEBIP's nettforum :)")
    return true;

}