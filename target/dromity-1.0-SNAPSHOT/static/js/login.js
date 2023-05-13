var useremail;
var userpassword;
function login() {
    useremail = document.getElementById("useremail").value;
    userpassword = document.getElementById("password").value;
    if (useremail === "" || userpassword === "") {
        layer.open({
            title: '登录信息'
            , content: '填写完整信息！'
            , icon: 2
            , time: 1500
        });
    }else if(!(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(useremail))) {
        layer.open({
            title: '登录信息'
            , content: '邮箱格式不正确！'
            , icon: 2
            , time: 1500
        });
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/login?useremail=" + useremail + "&password=" + userpassword, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '0') {
                    layer.open({
                        title: '登录信息'
                        , content: '你无法使用该系统！'
                        , icon: 2
                        , time: 1500
                    });

                } else if(result === '1') {
                    layer.open({
                        title: '登录信息'
                        , content: '密码错误，请重新输入！'
                        , icon: 2
                        , time: 1500
                    });
                }else{
                    setTimeout(function () {
                        window.location.href = "http://localhost:8080/home.view";
                    }, 1500);
                }
            }
        }
    }
}


function returntoview(){
  document.getElementById("login").style.display="none";
  document.getElementById("login1").style.display="block";
}


function oflogin(){
    document.getElementById("login1").style.display="none";
    document.getElementById("login").style.display="block";
}


