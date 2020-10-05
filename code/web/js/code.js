/**
 * A helper function to modify a specific piece of data.
 */
function modify() {
    $(".modal-header").children("h4").text("修改员工信息");
    $(".modal-body").attr("id", "changeInfo");

    // get which row is checked
    var arr = $(".check");
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].checked) break;
    }

    // if i equals to arr.length, then nothing is checked, return
    if (i == arr.length) {
        alert("暂无元素被选中，请选中后操作！");
        return;
    }

    // modify modal-footer button's id for further check
    $(".modal-footer").children("button").attr("id", i);

    // trigger click event, re-call insert() function
    $("#new").trigger("click");
}

/**
 * A helper function to insert a specific piece of data.
 */
function insert(all){

    location.href = "checkStudentSidServlet";

    // get class modal-footer id for further use
    var i = $(".modal-footer").children("button").attr("id");
    // change back to "insert"
    $(".modal-footer").children("button").attr("id", "insert");
    // change back modal-body's id towards newInfo
    $(".modal-body").attr("id", "newInfo");

    // get information from user
    var wid = $("#newInfo").children("p").eq(0).children().val();
    var name = $("#newInfo").children("p").eq(1).children().val();
    var sex = $("#newInfo").children("p").eq(2).children().val();
    var password = $("#newInfo").children("p").eq(3).children().val();
    var age = $("#newInfo").children("p").eq(4).children().val();
    var birthday = $("#newInfo").children("p").eq(5).children().val();
    // alert(`${wid} + ${name} + ${sex} + ${password} + ${age} + ${birthday}`);

    
    // create new label for this element
    var newtr = $(`
    <tr>
        <td><input type="checkbox" class="check"></td>
        <td>${wid}</td>
        <td>${name}</td>
        <td>${sex}</td>
        <td>${password}</td>
        <td>${age}</td>
        <td>${birthday}</td>
    </tr>
    `);
    if (i !== "insert") {
        // modify mode
        // insert after the exact element after that element
        $("tbody").children("tr").eq(i).after(newtr);
        // delete the existing element
        $("tbody").children().eq(i).remove();
    } else {
        // insert mode
        newtr.appendTo("tbody");
    }

    // empty the form for further use
    for (var i = 0; i <= 5; i++) {
        $("#newInfo").children("p").eq(i).children().val("");
    }
    
    $(".modal-header").children("h4").text("添加新员工");
    $(".modal-body").attr("id", "newInfo");
}

/**
 * A helper function to delete a specific piece of data.
 */
$(".delete").click(function() {
    location.href = "removeStudentBySid";
    // get which row is checked
    var arr = $(".check");
    for (var i = 0; i < arr.length; i++) {
        if (arr[i].checked) break;
    }
    // if i equals to arr.length, then nothing is checked, return
    if (i == arr.length) {
        alert("暂无元素被选中，请选中后操作！");
        return;
    }


    // remove the element
    $("tbody").children().eq(i).remove();
});

/**
 * A helper function for searching a specific piece of data.
 */
function search() {
    // get input blank content
    var wid = $("#head-buttons").children("input").eq(0).val();
    var name = $("#head-buttons").children("input").eq(1).val();

    // if nothing in blank, return
    if (wid === "" && name === "") {
        alert("未输入查询内容！");
        return;
    }
    // declare object array, wid array, name array
    var arr = $("tbody").children();
    var idArr = new Array();
    var nameArr = new Array();

    // iterate thru all data and get name and id array
    for (var i = 0; i < arr.length; i++) {
        idArr[i] = $("tbody").children("tr").eq(i).children("td").eq(1).text();
        nameArr[i] = $("tbody").children("tr").eq(i).children("td").eq(2).text();
    }

    if (wid !== "" && name === "") {
        // search by wid
        for (var i = 0; i < arr.length; i++) {
            if (idArr[i] == wid) {
                alert(`查询结果：
                工号：${$("tbody").children("tr").eq(i).children("td").eq(1).text()}
                姓名：${$("tbody").children("tr").eq(i).children("td").eq(2).text()}
                性别：${$("tbody").children("tr").eq(i).children("td").eq(3).text()}
                密码：${$("tbody").children("tr").eq(i).children("td").eq(4).text()}
                年龄：${$("tbody").children("tr").eq(i).children("td").eq(5).text()}
                出生日期：${$("tbody").children("tr").eq(i).children("td").eq(6).text()}
                `);
                return;
            } 
        }
        alert("查询失败：未找到该结果");
    } else if (wid === "" && name !== "") {
        // search by name
        for (var i = 0; i < arr.length; i++) {
            if (nameArr[i] == name) {
                alert(`查询结果：
                工号：${$("tbody").children("tr").eq(i).children("td").eq(1).text()}
                姓名：${$("tbody").children("tr").eq(i).children("td").eq(2).text()}
                性别：${$("tbody").children("tr").eq(i).children("td").eq(3).text()}
                密码：${$("tbody").children("tr").eq(i).children("td").eq(4).text()}
                年龄：${$("tbody").children("tr").eq(i).children("td").eq(5).text()}
                出生日期：${$("tbody").children("tr").eq(i).children("td").eq(6).text()}
                `);
                return;
            } 
        }
        alert("查询失败：未找到该结果");
    } else {
        // search by both wid and name
        for (var i = 0; i < arr.length; i++) {
            if (idArr[i] == wid && nameArr[i] == name) {
                alert(`查询结果：
                工号：${$("tbody").children("tr").eq(i).children("td").eq(1).text()}
                姓名：${$("tbody").children("tr").eq(i).children("td").eq(2).text()}
                性别：${$("tbody").children("tr").eq(i).children("td").eq(3).text()}
                密码：${$("tbody").children("tr").eq(i).children("td").eq(4).text()}
                年龄：${$("tbody").children("tr").eq(i).children("td").eq(5).text()}
                出生日期：${$("tbody").children("tr").eq(i).children("td").eq(6).text()}
                `);
                return;
            } 
        }
        alert("查询失败：未找到该结果");
    }
}