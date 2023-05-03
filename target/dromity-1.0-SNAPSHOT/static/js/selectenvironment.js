function selectenvironment() {
    var floor = document.getElementById("floor").value;
    var room = document.getElementById("room").value;


    const xhr = new XMLHttpRequest();
    xhr.open("get", "http://localhost:8080/getenvironment?floor=" + floor + "&room=" + room, true);
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var result = xhr.responseText;
            if (result === '') {
                layer.open({
                    title: '查询学生'
                    , content: '你没有权限或没有该学生！'
                    , icon: 2
                    , time: 1500
                });
            } else {
                var json = JSON.parse(result);
                var tbody = document.getElementById("mybody");
                var mythead = document.getElementById("mythead");
                tbody.innerHTML = "";
                mythead.innerHTML = "";
                var tabledata = "";
                if (json.length !== 0) {
                    mythead.innerHTML =
                        "<tr><th style='text-align: center'>序号</th><th style='text-align: center'>楼号</th><th style='text-align: center'>宿舍</th><th style='text-align: center'>分数</th><th style='text-align: center;width: 400px'>备注</th><th style='text-align: center'>开始日期</th><th style='text-align: center'>结束日期</th></tr>"

                    for (var i = 0; i < json.length; i++) {

                        tabledata += '<tr>';
                        tabledata += '<td style="text-align: center;font-size: 1px">' + (i + 1) + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].floor + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].room + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].score + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].beizhu + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].start_date + '</td>';
                        tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].end_date + '</td>';
                        tabledata += '</tr>';
                    }
                    tbody.innerHTML = tabledata;

                }
            }
        }
    }
}