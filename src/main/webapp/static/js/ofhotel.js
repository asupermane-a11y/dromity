function  selechotel(){
   var classid=document.getElementById("classid").value;
    var room=document.getElementById("room").value;
    var sex = document.getElementById("sex").value;
   if(classid===''&&room===''){
       layer.open({
           title: '提交信息'
           , content: '至少填写一项！'
           , icon: 2
           , time: 1500
       });
}else {
       const xhr = new XMLHttpRequest();
       xhr.open("get", "http://localhost:8080/gethotel?classid=" + classid + "&room=" + room + "&sex=" + sex, true);
       xhr.send();
       xhr.onreadystatechange = function () {
           if (xhr.readyState === 4 && xhr.status === 200) {
               const result = (xhr.responseText);
               if (result === '') {
                   layer.open({
                       title: '登录信息'
                       , content: '抱歉，你没有权限查看！'
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
                           "<tr><th style='text-align: center' >序号</th><th style='text-align: center;width: 300px'>班级号</th><th style='text-align: center;width: 300px'>楼号</th><th style='text-align: center;width: 300px'>宿舍号</th><th style='text-align: center;width: 300px;'>床号</th></tr>"

                       for (var i = 0; i < json.length; i++) {
                           tabledata += '<tr>';
                           tabledata += '<td style="text-align: center;font-size: 1px">' + (i + 1) + '</td>';
                           tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].classid + '</td>';
                           tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].floor + '</td>';
                           tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].room + '</td>';
                           tabledata += '<td style="text-align: center;font-size: 1px">' + json[i].bed + '</td>';
                           tabledata += '</tr>';
                       }
                       tbody.innerHTML = tabledata;


                   }

               }
           }
       }
   }
}
