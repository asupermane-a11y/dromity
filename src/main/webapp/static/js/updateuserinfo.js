random='';
email='';
xhr = new XMLHttpRequest();
phone='';
home_adress='';
message='';


function updateuserinfo() {
     phone= document.getElementById("phone").value;
     email = document.getElementById("email").value;
     home_adress= document.getElementById("home_adress").value;
     message=document.getElementById("message").value;

    if(phone===''&&email===""&&home_adress===''){
        layer.open({
            title: '修改信息'
            , content: '至少填写一项！'
            , icon: 2
            , time: 1500
        });
}else if(phone !== '' && !(/^1[34578]\d{9}$/.test(phone))){
        layer.open({
            title: '修改信息'
            , content: '手机号格式不正确！'
            , icon: 2
            , time: 1500
        });
    }else if(email !== '' && !(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(email))) {
        layer.open({
            title: '修改信息'
            , content: '邮箱格式不正确！'
            , icon: 2
            , time: 1500
        });
    }else if(email!==''&&message===''){
        layer.open({
            title: '修改信息'
            , content: '验证码不能为空！'
            , icon: 2
            , time: 1500
        })
    }else if(email!==''&&message!==random){
        layer.open({
            title: '修改信息'
            , content: '验证码错误！'
            , icon: 2
            , time: 1500
        })
    }else {
        xhr.open("get", "http://localhost:8080/updateuserinfo?phone="+phone+"&email="+email+"&home_adress="+home_adress, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '1') {
                    layer.open({
                        title: '修改信息'
                        , content: '修改成功！'
                        , icon: 1
                        , time: 1500
                    });
                }else if(result === '0'){
                    layer.open({
                        title: '修改信息'
                        , content: '修改失败！'
                        , icon: 2
                        , time: 1500
                    });
                }
            }
        }
    }
}


function getmessage2() {
    email = document.getElementById("email").value;
    if (email === '') {
        layer.open({
            title: '修改信息'
            , content: '请填写邮箱号！'
            , icon: 2
        });
    } else if (!(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(email))) {
        layer.open({
            title: '修改信息'
            , content: '邮箱格式不正确！'
            , icon: 2
        });
    } else {
        random = (Math.floor(Math.random() * 900000) + 100000).toString();
        xhr.open("get", "http://localhost:8080/getmessage2?message=" + random, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '1') {
                    layer.open({
                        title: '修改密码'
                        , content: '验证码已发送！'
                        , icon: 1
                        , time: 1500
                    });
                }
            }
        }
    }
}

