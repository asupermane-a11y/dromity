//创建全局变量
var  random;
var message;
var email;




//获取邮箱的验证码
function  getmessage(){
    email  =  document.getElementById(  "email"  ).value;
    message  =  document.getElementById(  "message"  ).value;
    //生成6位随机数
    random  =  Math.floor(Math.random()  *  900000)  +  100000;
    if(email===''){
        layer.open({
            title:  '修改密码'
            ,  content:  '请填写邮箱号！'
            ,  icon:  2
        });
    }  else  if(!(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(email))){
        layer.open({
            title:  '修改密码'
            ,  content:  '邮箱格式不正确！'
            ,  icon:  2
        });
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/getmessage?email="+email+"&message="+random, true);

        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '1') {
                    layer.open({
                        title:  '修改密码'
                        ,  content:  '验证码已发送！'
                        ,  icon:  1
                        ,time:  1500
                    });
                }
                }
                }
            }
}

function updatepassword() {
    email = document.getElementById("email").value;
    message = document.getElementById("message").value;
    newpassword = document.getElementById("newpassword").value;
    newpasswordagain = document.getElementById("newpasswordagain").value;
    //将random转换为字符串
    random = random.toString();
    if (email === '' || message === '' || newpassword === '' || newpasswordagain === '') {
        layer.open({
            title: '修改密码'
            , content: '请填写完整信息！'
            , icon: 2
            , time: 1500
        });
    } else if (!(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(email))) {
        layer.open({
            title: '修改密码'
            , content: '邮箱格式不正确！'
            , icon: 2
            , time: 1500
        });
    } else if (message !== random) {
        layer.open({
            title: '修改密码'
            , content: '验证码错误！'
            , icon: 2
            , time: 1500
        });
    } else if (!(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_])[a-zA-Z\d\W_]{8,}$/).test(newpassword)) {
        layer.open({
            title: '修改密码'
            , content: '密码需长度大于8，至少包含大写,小写，特殊字符！'
            , icon: 2
            , time: 2500
        });
    } else if (newpassword !== newpasswordagain) {
        layer.open({
            title: '修改密码'
            , content: '两次密码不一致！'
            , icon: 2
            , time: 1500
        });
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/updatepassword?email=" + email + "&password=" + newpassword, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '1') {
                    layer.open({
                        title: '修改密码'
                        , content: '修改成功！'
                        , icon: 1
                        , time: 1500
                    });
                }else if(result === '0'){
                    layer.open({
                        title: '修改密码'
                        , content: '修改失败,请重试！'
                        , icon: 2
                        , time: 1500
                    });
                }
            }

        }
    }
}



