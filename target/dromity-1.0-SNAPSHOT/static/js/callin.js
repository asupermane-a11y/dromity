function callin() {
    var callfromname = document.getElementById("callinname").value;
    var callfromphone = document.getElementById("callinphone").value;
    var relationship = document.getElementById("relationship").value;
    var callofname = document.getElementById("callofname").value;
    var floor = document.getElementById("floor").value;
    var room = document.getElementById("room").value;
    if (callfromname === '' || callfromphone === '' || relationship === '' || callofname === '' || floor === '' || room === '') {
        layer.open({
            title: '来访登记'
            , content: '请填写完整信息！'
            , icon: 2
            , time: 1500
        });

    } else if (callfromphone !== '' && !(/^1[34578]\d{9}$/.test(callfromphone))) {
        layer.open({
            title: '修改信息'
            , content: '手机号格式不正确！'
            , icon: 2
            , time: 1500
        });
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/insertcallin?callfromname=" + callfromname + "&callfromphone=" + callfromphone + "&relationship=" + relationship + "&callofname=" + callofname + "&floor=" + floor + "&room=" + room, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '1') {
                    layer.open({
                        title: '来访登记'
                        , content: '登记成功！'
                        , icon: 1
                        , time: 1500
                    });
                }else if(result === '0'){
                    layer.open({
                        title: '来访登记'
                        , content: '抱歉,你没有权限操作！'
                        , icon: 2
                        , time: 1500
                    });
                }else {
                    layer.open({
                        title: '来访登记'
                        , content: '登记失败,请重试！'
                        , icon: 2
                        , time: 1500
                    });
                }
            }
        }
    }
}

function selectcallin() {
    var callinfromname = document.getElementById("callinfromname").value;
    var calllofname = document.getElementById("calllofname").value;
    var callinDate = document.getElementById("calllinDate").value;
    var shunxu = document.getElementById("shunxu").value;
    const xhr = new XMLHttpRequest();
    xhr.open("get", "http://localhost:8080/selectcallin?callinfromname=" + callinfromname + "&callofname=" + calllofname + "&callindate=" + callinDate + "&shunxu=" + shunxu, true);

    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const result = (xhr.responseText);
            if (result === '') {
                layer.open({
                    title: '查询学生'
                    , content: '你没有权限或没有该学生！'
                    , icon: 2
                    , time: 1500
                });
            } else {
                var json = JSON.parse(result);
                var tbody = document.getElementById("mybody1");
                var mythead = document.getElementById("mythead1");
                tbody.innerHTML = "";
                mythead.innerHTML = "";
                var tabledata = "";
                if (json.length !== 0) {
                    mythead.innerHTML =
                        "<tr><th style='text-align: center'>序号</th><th style='text-align: center'>来访人姓名</th><th style='text-align: center'>联系方式</th><th style='text-align: center'>关系</th><th style='text-align: center'>被访者姓名</th><th style='text-align: center'>宿舍</th><th style='text-align: center'>时间</th></tr>"

                    for (var i = 0; i < json.length; i++) {
                        tabledata += '<tr>';
                        tabledata += '<td style="text-align: center;font-size: 1px;width: 300px">' + (i + 1) + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px;width: 500px">' + json[i].callfromname + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px;width: 300px">' + json[i].callfromphone + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px;width: 400px">' + json[i].relationship + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px;width: 500px">' + json[i].callofname + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px;width: 500px">' + json[i].floor + "#-" + json[i].room + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px;width: 500px">' + json[i].thetime + '</td>';
                        tabledata += '</tr>';
                    }
                    tbody.innerHTML=tabledata;
                }
            }
        }
    }
}