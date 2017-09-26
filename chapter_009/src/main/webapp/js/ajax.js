function foo() {

    $.ajax({
        url: '/www/ajax',
        type : 'GET',
        data: 'country=' + document.getElementById("country").value,
        dataType : "json",
        success: function (data) {
            var select = document.getElementById("city");
            var arr = data.toString().split(',');
            var result = '';
            for(var i = 0; i < arr.length; i++) {
                result += "<option>" + arr[i] + "</option>";
            }
            select.innerHTML = result;
        }
    });
}
