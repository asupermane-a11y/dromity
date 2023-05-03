function updatestudentinfo(){
    var studentid = document.getElementById("studentid").value;
    var college = document.getElementById("college").value;
    var mysystem= document.getElementById("system").value;
    var professional = document.getElementById("professional").value;
    var classid= document.getElementById("classid").value;
    var email= document.getElementById("email").value;
    if(studentid===''){
        layer.open({
            title: '提交信息'
            , content: '学号为必填！'
            , icon: 2
            , time: 1500
        });
    }else if(college===''&&mysystem===''&&professional===''&&classid===''&&email===''){
        layer.open({
            title: '提交信息'
            , content: '至少填一项！'
            , icon: 2
            , time: 1500
        });
    }else if(email!==''&&!(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(email))){
        layer.open({
            title: '提交信息'
            , content: '邮箱格式有误！'
            , icon: 2
            , time: 1500
        });
    }else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/updatestudent?studentid=" + studentid + "&college=" + college+"&system="+mysystem+"&profession="+professional+"&classid="+classid+"&email="+email, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '0') {
                    layer.open({
                        title: '提交信息'
                        , content: '抱歉,你没有权限操作！'
                        , icon: 2
                        , time: 1500
                    });
                }else if(result==='1'){
                    layer.open({
                        title: '提交信息'
                        , content: '修改成功！'
                        , icon: 1
                        , time: 1500
                    });
                }else {
                    layer.open({
                        title: '提交信息'
                        , content: '修改失败，请重试！'
                        , icon: 2
                        , time: 1500
                    });
                }
            }
            }
    }
}