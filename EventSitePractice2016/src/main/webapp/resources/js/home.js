$(document).ready(function(){
    $("body").on('click', 'span.flatpickr-next-month',function(){
    	getMonthAndYear();
    })
})
function getMonthAndYear(){
	
	var monthWord = $(".cur_month").html().trim();
	var year = $(".cur_year").html();
	var month = -1;
	switch (monthWord) {
	case "January":
		month = 0;
		break;
	case "February":
		month = 1;
		break;
	case "March":
		month = 2;
		break;
	case "April":
		month = 3;
		break;
	case "May":
		month = 4;
		break;
	case "June":
		month = 5;
		break;
	case "July":
		month = 6;
		break;
	case "August":
		month = 7;
		break;
	case "September":
		month = 8;
		break;
	case "October":
		month = 9;
		break;
	case "November":
		month = 10;
		break;
	case "December":
		month = 11;
		break;
	}
	window.location = "/EventSitePractice2016?month="+month;
	return false;
}
