$( document ).ready(function() {

    // SUBMIT FORM
    $("#loginForm").submit(function(event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost(){
        // PREPARE FORM DATA
        var formData = {
            username : $("#username").val(),
            password :  $("#password").val()
        };
        console.log(formData);
        // DO POST
        $.ajax({
            type : "POST",
            //contentType : "application/json",
            url : window.location + "login",
            data : formData,
            //dataType : 'json',
            success : function(result) {
                console.log(result);
                window.location.replace(result);
            },
            error : function(e) {
                console.log("ERROR: ", e);
            }
        });
    }
})

