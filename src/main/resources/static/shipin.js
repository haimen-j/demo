var ocx;
$(function(){

})
var preview = {
    divId : "playWnd",
}
ocx = new PreviewOCX(preview);
//初始化视频插件
function initVideo() {
    // ocx.setWindowsLayout(1);
    ocx.registerCallback(PREVIEW_EVENT_TOKEN,tokenCallEvent)
    ocx.registerCallback(PREVIEW_EVENT_START,getxml)
    tokenCallEvent();
    getxml();
}

function tokenCallEvent(reqID){
    console.log("获取token开始");
    console.log(ocx);
    $.ajax({
        url : "/api/SVController/applyToken",
        type : "post",
        dataType : "text",
        success : function(token) {
            console.log("获取的token"+token);
            ocx.setToken(reqID, token);
        }
    });
}

//开始播放
$("#startPreview").click(function () {
    initVideo();
});
function getxml(){
    var indexCode = $("#cameraIndexCode").val();
    var xml = null;
    var token = null;
    $.ajax({
        url : "/api/SVController/getPreviewOcxOptions",
        type : "post",
        dataType : "text",
        data:{
            pointCode:indexCode
        },
        success : function(xml) {
            ocx.startPreview(0,xml);
        }
    });
}
//停止预览
$("#stopAllPreview").click(function(){
    ocx.stopPreview(-1);
});