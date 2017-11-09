
function getAll() {
    $.ajax({
        url: '/todo/ajax',
        type : 'GET',
        data : 'sort=' + document.getElementById("all_chb").checked,
        dataType : "json",
        success: function (data) {
            var select = document.getElementById("table");
            var result = '';
            for(var i = 0; i < data.length; i++) {
                result += "<tr>" +
                    "<td>" + data[i].id + "</td>" +
                    "<td>" + data[i].desc + "</td>" +
                    "<td>" + dateParse(data[i].created) + "</td>" +
                    "<td>" + setCheckbox(data[i]) + "</td>"
                    + "</tr>";
            }
            select.innerHTML = result;
        }
    });
}

function update(id) {
    $.ajax({
        url: '/todo/update',
        type : 'POST',
        data : 'id=' + id
    });
}

function dateParse(d) {
    return d.date.year + "-" + d.date.month + "-" + d.date.day +
        " " + d.time.hour + ":" + d.time.minute + ":" + d.time.second;
}

function setCheckbox(d) {
    return d.done == true ? '<input type="checkBox" checked id=' + d.id + ' onclick="update(id)">' : '<input type="checkBox" id= ' + d.id + ' onclick="update(id)">';
}
