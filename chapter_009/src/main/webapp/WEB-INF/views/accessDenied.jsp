<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Access Denied!</title>
    <style>
        .text {
            text-align:  center;
            font-size: 45px;
        }
    </style>
</head>
<body>

<script type="text/javascript">
    i=0;
    arr=new Array("000000", "00000A", "0000A0", "000A00", "00A000", "0A0000", "A00000");
    function blink() {
        document.getElementById("myText").style.color=arr[i++];
        if (i>arr.length) i=0;
        setTimeout("blink()",50);
    }
</script>

</br></br></br></br></br></br></br></br>
<div class="text" id="myText">Access Denied!</div>

<script type="text/javascript">
    blink();
</script>

</body>
</html>
