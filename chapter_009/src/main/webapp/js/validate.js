function validate() {
    var result = true;

    if (document.getElementsByName("name")[0].value == ''
        || check(document.getElementsByName("name")[0].value, "^[a-zA-Z]+$")) {
        document.getElementById("errorName").textContent = "Error! Name must not be empty and consist of letters.";
        result = false;
    } else {
        document.getElementById("errorName").textContent = "";
    }

    if (document.getElementsByName("login")[0].value == ''
        || check(document.getElementsByName("login")[0].value, "^[a-z]+$")) {
        document.getElementById("errorLogin").textContent = "Error! Login must not be empty and consist of letters.";
        result = false;
    } else {
        document.getElementById("errorLogin").textContent = "";
    }

    if (document.getElementsByName("password")[0].value == ''
        || check(document.getElementsByName("password")[0].value, "^[a-zA-Z0-9_]{3,}$")) {
        document.getElementById("errorPass").textContent = "Error! Pass must not be empty and consist not least of 3 characters.";
        result = false;
    } else {
        document.getElementById("errorPass").textContent = "";
    }

    if (document.getElementsByName("email")[0].value == ''
        || check(document.getElementsByName("email")[0].value, "^([a-z0-9_-]+\.)*[a-z0-9_-]+@[a-z0-9_-]+(\.[a-z0-9_-]+)*\.[a-z]{2,6}$")) {
        document.getElementById("errorEmail").textContent = "Error! Email must not be empty and be like 'name@domain.my'.";
        result = false;
    } else {
        document.getElementById("errorEmail").textContent = "";
    }

    return result;

}

function check(string, pattern) {
    var patt = new RegExp(pattern);

    var result = string.search(patt);

    if (result == -1) {
        return true;
    }
    return false;
}