


function  doitem() {
    //获取物品
    var itemname = document.getElementById("gooditem").value;
    //获取楼号
    var floor = document.getElementById("floor").value;
    //获取地点
    var place = document.getElementById("place").value;
    //获取详细地址
    var all_place = document.getElementById("all_place").value;
    //获取描述
    var description = document.getElementById("describe").value;
    //获取人
    var person = document.getElementById("ofname").value;
    var  phone=document.getElementById("phone").value;

    if (itemname === '' || floor === '' || place === '' || all_place === '' || description === '' || person === ''||phone==='') {
        layer.open({
            title: '提交信息'
            , content: '请填写完整信息！'
            , icon: 2
            , time: 1500
        });
    } else if(!(/^1[3-9]\d{9}$/).test(phone)){
        layer.open({
            title: '提交信息'
            , content: '手机号格式有误！'
            , icon: 2
            , time: 1500
        });
    } else {

        const xhr = new XMLHttpRequest();
        xhr.open("get", "http://localhost:8080/insertitem?itemname=" + itemname + "&floor=" + floor + "&place=" + place + "&all_place=" + all_place + "&describ=" + description + "&personname=" + person+"&phone="+phone, true);
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
                    setTimeout(function() {
                        document.getElementById("form").submit();
                    }, (3000));

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


function selectitem() {
    var floor = document.getElementById("floor").value;
    var itemid = document.getElementById("itemid").value;
    var shunxu = document.getElementById("shunxu").value;
    var status = document.getElementById("status").value;
    const xhr = new XMLHttpRequest();
    xhr.open("get", "http://localhost:8080/selectitems?floor=" + floor + "&itemid=" + itemid + "&shunxu=" + shunxu + "&status=" + status, true);
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const result = (xhr.responseText);
            if (result === '') {
                layer.open({
                    title: '查询保修'
                    , content: '没有权限查询或没有该信息！'
                    , icon: 2
                    , time: 1500
                });
            } else {
                var json1 = JSON.parse(result);

                var tbody3 = document.getElementById("mybody");
                var mythead3 = document.getElementById("mythead");
                tbody3.innerHTML = "";
                mythead3.innerHTML = "";
                var tabledata3 = "";
                var id = 0;
                if (json1.length !== 0) {
                    mythead3.innerHTML =
                        "<tr><th style='text-align: center'>序号</th><th style='text-align: center'>物品ID</th><th style='text-align: center'>物品名</th><th style='text-align: center'>楼号</th><th style='text-align: center'>地点</th><th style='text-align: center'>描述</th><th style='text-align: center'>报修人</th><th style='text-align: center'>身份</th><th style='text-align: center'>状态</th><th style='text-align: center'>照片</th></tr>"

                    for (var i = 0; i < json1.length; i++) {
                        if(json1[i].status === 1){
                            json1[i].status = '待维修';
                        }else if(json1[i].status === 2){
                            json1[i].status = '已维修';
                        }else if(json1[i].status === 3){
                            json1[i].status = '已报废';
                        }
                        if(json1[i].capacity === 1){
                            json1[i].capacity = '学生';
                        }else if(json1[i].capacity === 2){
                            json1[i].capacity = '宿管';
                        }else if(json1[i].capacity === 3){
                            json1[i].capacity = '辅导员';
                        }

                        tabledata3 += '<tr>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + (i+1) + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].itemid + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].itemname + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].floor + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].place+json1[i].all_place + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].describ + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].personname + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].capacity + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px">' + json1[i].status + '</td>';
                        tabledata3 += '<td style="text-align: center;font-size: 1px"><a href='+json1[i].images+'>图片</a></td>'

                    }
                    tbody3.innerHTML = tabledata3;
                }
            }

        }
    }

}

