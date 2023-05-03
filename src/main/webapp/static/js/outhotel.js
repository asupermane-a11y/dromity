function outhotel(){
   var studentid = document.getElementById("studentid").value;
    var studentname = document.getElementById("studentname").value;
    if(studentid===''||studentname==='') {
        layer.open({
            title: '退宿'
            , content: '请输入完整信息！'
            , icon: 2
            , time: 1500
        });
    }else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/deletehotel?studentid=" + studentid + "&studentname=" + studentname, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '0') {
                    layer.open({
                        title: '退宿'
                        , content: '抱歉，你没有权限操作！'
                        , icon: 2
                        , time: 1500
                    });
                } else if(result === '1'){
                    layer.open({
                        title: '退宿'
                        , content: '退宿成功！'
                        , icon: 1
                        , time: 1500
                    });
            }else {
                    layer.open({
                        title: '退宿'
                        , content: '退宿失败，请重试！'
                        , icon: 2
                        , time: 1500
                    });
                }
            }
        }
    }
}



function outall() {
    var studentid1 = document.getElementById("studentid1").value;
    var studentname1 = document.getElementById("studentname1").value;
    if (studentname1 === '' || studentid1 === '') {
        layer.open({
            title: '退宿'
            , content: '请输入完整信息！'
            , icon: 2
            , time: 1500
        });
    } else {
        if (confirm("确定要注销吗？")) {
            const xhr = new XMLHttpRequest();
            xhr.open("get", "http://localhost:8080/deletealll?studentid=" + studentid1 + "&studentname=" + studentname1, true);
            xhr.send();
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    const result = (xhr.responseText);
                    if (result === '0') {
                        layer.open({
                            title: '期末注销'
                            , content: '抱歉，你没有权限操作！'
                            , icon: 2
                            , time: 1500
                        });
                    } else if(result === '1'){
                        layer.open({
                            title: '期末注销'
                            , content: '注销成功！'
                            , icon: 1
                            , time: 1500
                        });
                    }else {
                        layer.open({
                            title: '期末注销'
                            , content: '注销失败，请重试！'
                            , icon: 2
                            , time: 1500
                        });
                    }
                }
            }

        } else {
            // 取消注销操作
        }

    }
}