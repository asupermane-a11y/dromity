function insertelemoney(){
    var floor = document.getElementById("floor").value;
    var room = document.getElementById("room").value;
    var money = document.getElementById("money").value;
   if(floor===""||room===""||money===""){
       layer.open({
              title: '提交信息'
                , content: '请填写完整信息！'
                , icon: 2
                , time: 1500
            });
       }else{
             const xhr = new XMLHttpRequest();
              xhr.open("get", "http://localhost:8080/insertelepower?floor=" + floor + "&room=" + room + "&addmoney=" + money, true);
              xhr.send();
              xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                     const result = (xhr.responseText);
                     if (result === '1') {
                          layer.open({
                            title: '提交信息'
                            , content: '添加成功！'
                            , icon: 1
                            , time: 1500
                          });
                     } else if(result === '0'){
                         layer.open({
                             title: '提交信息'
                             , content: '抱歉，你没有权限操作！'
                             , icon: 2
                             , time: 1500
                         });

                     } else {
                          layer.open({
                            title: '提交信息'
                            , content: '添加失败,请重试！'
                            , icon: 2
                            , time: 1500
                          });
                     }
                }
              }
   }
}

function reducee() {
    //获取楼号
    var floor1 = document.getElementById("floor1").value;
    //获取房间号
    var room1 = document.getElementById("room1").value;
    //获取减少金额
    var money1 = document.getElementById("money1").value;
    var start_date = document.getElementById("start_date").value;
    var end_date = document.getElementById("end_date").value;
    if (floor1 === "" || room1 === "" || money1 === "" || start_date === "" || end_date === "") {
        layer.open({
            title: '提交信息'
            , content: '请填写完整信息！'
            , icon: 2
            , time: 1500
        });
    } else if (start_date > end_date) {
        layer.open({
            title: '提交信息'
            , content: '时间选择有误！'
            , icon: 2
            , time: 1500
        });
    } else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/reduceelepower?floor=" + floor1 + "&room=" + room1 + "&addmoney=" + money1 + "&start_date=" + start_date + "&end_date=" + end_date, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '1') {
                    layer.open({
                        title: '提交信息'
                        , content: '电费不足，请及时缴纳！'
                        , icon: 2
                        , time: 1500
                    });
                } else if (result === '0') {
                    layer.open({
                        title: '提交信息'
                        , content: '抱歉，你没有权限操作！'
                        , icon: 2
                        , time: 1500
                    });
                }else if(result==='2'){
                    layer.open({
                        title: '提交信息'
                        , content: '扣费成功！'
                        , icon: 1
                        , time: 1500
                    });
                }else {
                    layer.open({
                        title: '提交信息'
                        , content: '扣费失败，请重试！'
                        , icon: 2
                        , time: 1500
                    });
                }
            }
        }
    }
}


function  selectele(){
    var floor = document.getElementById("floor3").value;
    var room= document.getElementById("room3").value;
    var yue=document.getElementById("yue").value;
    var shunxu=document.getElementById("shunxu3").value;
    if(floor===""||room===""||shunxu===""){
        layer.open({
            title: '提交信息'
            , content: '请填写完整信息！'
            , icon: 2
            , time: 1500
        });
    }else {
        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/selectelepower?floor=" + floor + "&room=" + room + "&yue=" + yue + "&shunxu=" + shunxu, true);
        xhr.send();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                const result = (xhr.responseText);
                if (result === '') {
                    layer.open({
                        title: '查询电费'
                        , content: '没有权限操作，或者没有该信息！'
                        , icon: 2
                        , time: 1500
                    });
                }else {
                    var json = JSON.parse(result);

                    var tbody = document.getElementById("mybody4");
                    var mythead = document.getElementById("mythead4");
                    tbody.innerHTML = "";
                    mythead.innerHTML = "";
                    var tabledata="";
                    if (json.length !== 0) {
                        mythead.innerHTML =
                            "<tr><th style='text-align: center'>序号</th><th style='text-align: center'>楼</th><th style='text-align: center'>宿舍</th><th style='text-align: center;width: 100px'>变动金额</th><th style='text-align: center'>余额</th><th style='text-align: center;width: 600px'>缴费日期</th><th style='text-align: center;width: 200px'>扣费开始日期</th><th style='text-align: center;width: 200px'>扣费截止日期</th</tr>"

                        for (var i = 0; i < json.length; i++) {
                            json[i].start_date= (json[i].start_date!=null)?json[i].start_date:'';
                            json[i].end_date= (json[i].end_date!=null)?json[i].end_date:'';
                            json[i].thedate= (json[i].thedate=null)?'':new Date(json[i].thedate);
                            if(json[i].status===1){
                                json[i].addmoney='+ '+json[i].addmoney;
                            }else if(json[i].status===0){
                                json[i].addmoney='- '+json[i].addmoney;
                            }
                            tabledata+='<tr>';
                            tabledata+='<td style="text-align: center;font-size: 1px">'+(i+1)+'</td>';
                            tabledata+='<td style="text-align: center;font-size: 1px">'+json[i].floor+'</td>';
                            tabledata+='<td style="text-align: center;font-size: 1px">'+json[i].room+'</td>';
                            tabledata+='<td style="text-align: center;font-size: 1px;width:150px">'+json[i].addmoney+'</td>';
                            tabledata+='<td style="text-align: center;font-size: 1px;width:200px">'+json[i].yue+'</td>';
                            tabledata+='<td style="text-align: center;font-size: 1px">'+json[i].thedate+'</td>';
                            tabledata+='<td style="text-align: center;font-size: 1px">'+json[i].start_date+'</td>';
                            tabledata+='<td style="text-align: center;font-size: 1px">'+json[i].end_date+'</td>';
                            tabledata+='</tr>';
                        }
                        tbody.innerHTML=tabledata;
                }
            }

        }
    }
}
}