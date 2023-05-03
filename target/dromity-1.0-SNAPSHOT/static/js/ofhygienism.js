function Hygienism() {
    var floor = document.getElementById("floor").value;
    var room = document.getElementById("room").value;
    var score = document.getElementById("score").value;
    var beizhu = document.getElementById("beizhu").value;
    var start_date = document.getElementById("start_date").value;
    var end_date = document.getElementById("end_date").value;

    if (floor === "" || room === "" || score === "" || beizhu === "" || start_date === "" || end_date === "") {
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
        xhr.open("get", "http://localhost:8080/insertenvironment?floor=" + floor + "&room=" + room + "&score=" + score + "&beizhu=" + beizhu + "&start_date=" + start_date + "&end_date=" + end_date, true);
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

                }
            }
        }
    }
}