/*function  output() {
    $.ajax({
        type: "post",
        url: "createImageCode.do",
        data: "data",
        dataType: "dataType",
        success: function (response) {
            
        }
    });
}*/
$(document).ready(function () {
    $("#number").blur(function (e) {
        var number=$(this).val(); 
        if(number==null || number==""){
            $("#numberError").text("单号不能为空");
        }else{
            $.ajax({
                type: "post",
                url: "checkNumController.do",
                data: {number:$(this).val()},
                dataType: "json",
                success: function (response) {
                    if(response.code==0){
                        $("#numberError").text(response.info);
                    }else{
                        $("#numberError").css("color", "green");
                        $("#numberError").text(response.info);
                        document.getElementById("yundaImage").src="createImageCode.do";
                        document.getElementById("btOutput").removeAttribute("hidden");
                    }
                }
            });
        }
        
    });
});