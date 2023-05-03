// function getcountinfo(){
//     const xhr = new XMLHttpRequest();
//     xhr.open("get", "http://localhost:8080/getcountinfo", true);
//     xhr.send();
//     xhr.onreadystatechange = function () {
//         if (xhr.readyState === 4 && xhr.status === 200) {
//             const result = (xhr.responseText);
//             var newresult=JSON.parse(result);
//             document.getElementById("manview").style.width="";
//             document.getElementById("countman").innerText="";
//             document.getElementById("womanview").style.width="";
//             document.getElementById("countwoman").innerText="";
//             document.getElementById("suguanview").style.width="";
//             document.getElementById("suguan").innerText="";
//             document.getElementById("fudaoyuanview").style.width="";
//             document.getElementById("fudaoyuan").innerText="";
//             document.getElementById("manview").style.width=newresult.cout_studentman;
//             document.getElementById("countman").innerText=newresult.cout_studentman;
//             document.getElementById("womanview").style.width=newresult.cout_studentwoman;
//             document.getElementById("countwoman").innerText=newresult.cout_studentwoman;
//             document.getElementById("suguanview").style.width=newresult.count_suguan;
//             document.getElementById("suguan").innerText=newresult.count_suguan;
//             document.getElementById("fudaoyuanview").style.width=newresult.count_fudaoyuan;
//             document.getElementById("fudaoyuan").innerText=newresult.count_fudaoyuan;
//
//
//
//         }
// }
// }

window.onload = function(){

    const xhr = new XMLHttpRequest();
    xhr.open("get", "http://localhost:8080/getcountinfo", true);
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const result = (xhr.responseText);
            var newresult=JSON.parse(result);
            document.getElementById("manview").style.width="";
            document.getElementById("countman").innerText="";
            document.getElementById("womanview").style.width="";
            document.getElementById("countwoman").innerText="";
            document.getElementById("suguanview").style.width="";
            document.getElementById("suguan").innerText="";
            document.getElementById("fudaoyuanview").style.width="";
            document.getElementById("fudaoyuan").innerText="";
            document.getElementById("manview").style.width=newresult.cout_studentman;
            document.getElementById("countman").innerText=newresult.cout_studentman;
            document.getElementById("womanview").style.width=newresult.cout_studentwoman;
            document.getElementById("countwoman").innerText=newresult.cout_studentwoman;
            document.getElementById("suguanview").style.width=newresult.count_suguan;
            document.getElementById("suguan").innerText=newresult.count_suguan;
            document.getElementById("fudaoyuanview").style.width=newresult.count_fudaoyuan;
            document.getElementById("fudaoyuan").innerText=newresult.count_fudaoyuan;


        }
    }
}