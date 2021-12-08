$('.message a').click(function () {
    loginRegisterSwitch();
});

function showAlertAfterRegistration() {
    $('div.alert.alert-success').css("display", "block");
}

function loginRegisterSwitch() {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
}

$(document).ready(function () {
    $("button.register").click(function () {
        let firstname = $("form.register-form input.firstname").val();
        let lastname = $("form.register-form input.lastname").val();
        let email = $("form.register-form input.email").val();
        let password = $("form.register-form input.password").val();
        let cpassword = $("form.register-form input.cpassword").val();
        if (firstname == '' || email == '' || lastname == '' || password == '' || cpassword == '') {
            alert("Please fill all fields...!!!!!!");
        } else if ((password.length) < 3) {
            alert("Password should atleast 8 character in length...!!!!!!");
        } else if (!(password).match(cpassword)) {
            alert("Your passwords don't match. Try again?");
        } else {
            let userRegistration = {
                firstname: firstname,
                lastname: lastname,
                email: email,
                password: password,
            };

            $.post("registration", userRegistration, function (data) {
                if (data == 'Success!') {
                    $("form")[0].reset();
                    $("form")[1].reset();
                    loginRegisterSwitch();
                    showAlertAfterRegistration();
                }
            });
        }
    });

    $("button.login").click(function () {
        let email = $("form.login-form input.email").val();
        let password = $("form.login-form input.password").val();
        if (email == '' || password == '') {
            alert("Please login!");
        } else {
            let userLogin = {
                email: email,
                password: password,
            };

            $.post("login", userLogin, function (data) {
                if (data !== "") {
                    let customUrl = "";
                    let urlContent = window.location.href.split("/");
                    for (let i = 0; i < urlContent.length - 1; i++) {
                        customUrl += urlContent[i] + "/";
                    }
                    customUrl += data.destinationUrl;
                    window.location = customUrl;
                }
            });
        }
    });
});



