studentid='';
studentname='';
studentfloor='';
studentprofession='';
room='';
function selectstudent() {
    studentid = document.getElementById("studentid").value;
    studentname = document.getElementById("name").value;
    studentfloor = document.getElementById("floor").value;
    studentprofession = document.getElementById("profession").value;
    room = document.getElementById("room").value;
    const xhr = new XMLHttpRequest();
    xhr.open("get", "http://localhost:8080/selectstudent?studentid=" + studentid + "&studentname=" + studentname + "&floor=" + studentfloor + "&profession=" + studentprofession + "&room=" + room, true);
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
            }
            var json = JSON.parse(result);
            var tbody = document.getElementById("mybody");
            var mythead = document.getElementById("mythead");
            tbody.innerHTML = "";
            mythead.innerHTML = "";
            var tabledata = "";
            if (json.length !== 0) {
                mythead.innerHTML =
                    "<tr><th style='text-align: center;width: 1px'>序号</th><th style='text-align: center'>学号</th><th style='text-align: center'>姓名</th><th style='text-align: center'>学院</th><th style='text-align: center'>系</th><th style='text-align: center'>专业</th><th style='text-align: center'>性别</th><th style='text-align: center'>宿舍</th><th style='text-align: center'>电话</th><th style='text-align: center'>家庭住址</th></tr>"

                for (var i = 0; i < json.length; i++) {
                    var sushe=json[i].floor==null?'未入住': json[i].floor + '#-' + json[i].room + '-' + json[i].bed
                    json[i].sex = (json[i].sex === 1) ? '男' : '女';
                    tabledata += '<tr>';
                    tabledata += '<td style="text-align: center;font-size: 1px;width: 1px">' + (i + 1) + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].studentid + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].name + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].college + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].mysystem + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].professional + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].sex + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + sushe+'</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].phone + '</td>';
                    tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].home_adress + '</td>';
                    tabledata += '</tr>';
                }
                tbody.innerHTML = tabledata;

            }
        }
    }
}