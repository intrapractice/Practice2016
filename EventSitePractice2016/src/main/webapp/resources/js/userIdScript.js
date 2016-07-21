function newPath() {
	var userId = window.user;
	if (typeof userId !== "number") {
		setTimeout(newPath, 200);
		return;
	}
	$("#rounded").click(function () {
		$("#rounded").attr("href", $("#rounded").attr("href")+userId);
	});
}

$(document).ready(function(){
	newPath();
});