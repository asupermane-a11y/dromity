
var userinfo;
function professionalinfo() {

    const xhr = new XMLHttpRequest();
    xhr.open("get", "http://localhost:8080/showuserinfo", true);
    xhr.send();
    xhr.onreadystatechange = function () {
        let result1;
        if (xhr.readyState === 4 && xhr.status === 200) {
            document.getElementById("userinfo").innerHTML="";
            result1 = (xhr.responseText);
            userinfo = JSON.parse(result1);
            userinfo.sex=((userinfo.sex===1)?"男":"女")
            if(userinfo.capacity===1){
               if(userinfo.floor===null){
                     userinfo.floor="未入住"
               }
               if(userinfo.room===null){
                        userinfo.room="未入住"
               }
               if(userinfo.bed===null){
                        userinfo.bed="未入住"
               }
             document.getElementById("userinfo").innerHTML="学号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.studentid+"<br/>"+
                "姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.name+"<br/>"+
                "性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.sex+"<br/>"+
                "学院：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.college+"<br/>"+
                "系别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.mysystem+"<br/>"+
                "专业：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.professional+"<br/>"+
                "班级：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.classid+"<br/>"+
                "楼号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.floor+"<br/>"+
                "宿舍：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.room+"<br/>"+
                "床号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.bed+"<br/>"+
                "邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.email+"<br/>"+
                "家庭住址：&nbsp;&nbsp;"+userinfo.home_adress+"<br/>"+
                "身份：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生<br/>"

        }else if(userinfo.capacity===2){
                userinfo.floor=userinfo.floor==null?"未入住":userinfo.floor;
                document.getElementById("userinfo").innerHTML=
                    "姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.name+"<br/>"+
                    "性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.sex+"<br/>"+
                    "楼号：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.floor+"<br/>"+
                    "邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.email+"<br/>"+
                    "家庭住址：&nbsp;&nbsp;"+userinfo.home_adress+"<br/>"+
                    "身份：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;宿管<br/>"
            }else{
                document.getElementById("userinfo").innerHTML=
                    "姓名：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.name+"<br/>"+
                    "性别：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.sex+"<br/>"+
                    "邮箱：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.email+"<br/>"+
                    "班级：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+userinfo.classid+"<br/>"+
                    "家庭住址：&nbsp;&nbsp;"+userinfo.home_adress+"<br/>"+
                    "身份：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;辅导员<br/>"

            }
        }
    }
}

function  sendbuginfo(){
    var buginfo=document.getElementById("buginfo").value;
    if(buginfo===""){
        layer.open({
            title: '反馈问题'
            , content: '请填写要反馈的问题！'
            , icon: 2
            , time: 1500
        });
    }
    const xhr = new XMLHttpRequest();
    xhr.open("get", "http://localhost:8080/sendbug?bug="+buginfo, true);
    xhr.send();
    xhr.onreadystatechange = function () {
        let result1;
        if (xhr.readyState === 4 && xhr.status === 200) {
            result1 = (xhr.responseText);
            if(result1==='1'){
                layer.open({
                    title: '反馈问题'
                    , content: '反馈成功！'
                    , icon: 1
                    , time: 1500
                });
            }
            }
        }

}