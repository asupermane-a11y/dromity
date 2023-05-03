function  gethotel() {
    var classid = document.getElementById("classid").value;
    var sex = document.getElementById("sex").value;
    if (classid === '') {
        layer.open({
            title: '退宿'
            , content: '请输入班级号！'
            , icon: 2
            , time: 1500
        });
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/togethotel?classid=" + classid + "&sex=" + sex, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '') {
                    layer.open({
                        title: '办理入住'
                        , content: '抱歉，你没有权限操作！'
                        , icon: 2
                        , time: 1500
                    });
                }else {
                    var result1=JSON.parse(result);
                    document.getElementById("floor").innerHTML="";
                    document.getElementById("room").innerHTML="";

                    var floor=result1[0].floor;
                    document.getElementById("floor").innerHTML='<option value='+floor+'>'+floor+'</option>'
                    var option='';
                    for(var i=0;i<result1.length;i++){

                        option+='<option value='+result1[i].room+'>'+result1[i].room+'</option>'
                    }
                  document.getElementById("room").innerHTML=option;
                }
            }
        }
    }
}


function ruzhu() {
    var studentid = document.getElementById("studentid").value;
    var floor = document.getElementById("floor").value;
    var room = document.getElementById("room").value;
    if (studentid === '' || floor === '' || room === '') {
        layer.open({
            title: '办理入住'
            , content: '请填写完整信息！'
            , icon: 2
            , time: 1500
        });
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/ruzhu?studentid=" + studentid + "&floor=" + floor + "&room=" + room, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '0') {
                    layer.open({
                        title: '办理入住'
                        , content: '抱歉，你没有权限操作！'
                        , icon: 2
                        , time: 1500
                    });
                }else if(result==='1'){
                    layer.open({
                        title: '办理入住'
                        , content: '没有该学生！'
                        , icon: 2
                        , time: 1500
                    });
                }else if(result==='2'){
                    layer.open({
                        title: '办理入住'
                        , content: '该学生已经入住了，或者住宿异常！'
                        , icon: 2
                        , time: 1500
                    });
                }else if(result==='3'){
                    layer.open({
                        title: '办理入住'
                        , content: '该宿舍已经住满了！'
                        , icon: 2
                        , time: 1500
                    });
                }else if(result==='4'){
                    layer.open({
                        title: '办理入住'
                        , content: '办理入住成功！'
                        , icon: 1
                        , time: 1500
                    });
                }
            }else {
                layer.open({
                    title: '办理入住'
                    , content: '办理入住失败请重试！'
                    , icon: 2
                    , time: 1500
                });
            }
        }
    }
}