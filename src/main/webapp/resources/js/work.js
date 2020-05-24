function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
	
    console.log(cityName);
	var http = new XMLHttpRequest();
	var url = "http://localhost:8080/arakaru/table/list/setData/";
	var params = "monthParam="+cityName;
	http.open('POST', url, true);
	http.setRequestHeader('Content-type', "application/x-www-form-urlencoded;charset=utf-8");
	http.send(params);
	
	
	
	
	window.location.href = "http://localhost:8080/arakaru/table/list";
	//location.reload();
}