$(document).ready(function(){
	time();
});
function time()
{
    var date = new Date;
    var year = date.getFullYear();
    var month = date.getMonth();
    var months = new Array('Ianuarie', 'Februarie', 'Martie', 'Aprilie', 'Mai', 'Iunie', 'Iulie', 'August', 'Septembrie', 'Octombrie', 'Noiembrie', 'Decembrie');
    var d = date.getDate();
    var day = date.getDay();
    var days = new Array('Duminică', 'Luni', 'Marți', 'Miercuri', 'Joi', 'Vineri', 'Sâmbătă');
    var h = date.getHours();
    if(h<10){
        h = "0"+h;
    }
    var m = date.getMinutes();
    if(m<10){
        m = "0"+m;
    }
    var s = date.getSeconds();
    if(s<10){
       s = "0"+s;
    }
    var result = ''+days[day]+' '+d+' '+months[month]+' '+year+' '+h+':'+m+':'+s;
    document.getElementById("time").innerHTML = result;
    setTimeout("time()", "1000");
}