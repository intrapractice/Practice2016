$(document).ready(function(){
        $("select.selectpicker").change(function(){
        var selectedCategory = $(".selectpicker option:selected").val();
        });
        });
function createCategory(){
	var categoryName = $("#textboxCat").val();
	$.getJSON("/EventSitePractice2016/createCategory?categoryTitle="+categoryName)
	.done(function(json){
		if(json && json!=""){
			$(".selectpicker").append("<option  value="+json.id+">"+json.title+"</option>");
		}
	});
	return false;
}

 