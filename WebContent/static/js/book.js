function post(URL, PARAMS) {
    alert(URL);
        $.ajax({
            type: "POST",
            url: URL,
            contentType: "application/json", //必须有
            data: JSON.stringify(PARAMS),  //相当于 //data: "{'str1':'foovalue', 'str2':'barvalue'}",
            success: function (jsonResult) {
            }
        });
    }

function logout() {
    var logoutForm = document.getElementById("logoutForm");
    logoutForm.submit();
}