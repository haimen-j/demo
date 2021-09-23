$(function(){
    ceshi();
})

function ceshi() {
    $.ajax({
        type: "GET",
        url: "/test/test",
        dataType: "text",
        contentType: 'application/json',
        success:function (data) {
            $("#h3").html(data);
        },
        error:function (data) {
            console.log(JSON.stringify(data));
        }
    })
}