
i=0;
arr=new Array("000000", "00000A", "0000A0", "000A00", "00A000", "0A0000", "A00000");
    function blink() {
        document.getElementById("myText").style.color=arr[i++];
        if (i>arr.length) i=0;
        setTimeout("blink()",50);
    }

