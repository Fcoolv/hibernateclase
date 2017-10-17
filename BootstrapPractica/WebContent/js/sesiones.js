function sesion(){
	
	localStorage.setItem("Usuario", "Fran");
	var pass = document.getElementById("pass").value;
	var errorusu =document.getElementById("usuerror");
	var errorpass =document.getElementById("passerror");
	
	if(document.getElementById("usu").value == localStorage.getItem("Usuario") && pass == "Altair123"){
		window.location.href="menu.html";     
	}else if(document.getElementById("usu").value == localStorage.getItem("Usuario") && pass != "Altair123"){
		errorusu.style.display = "none";
		errorpass.style.display = "inline";
	}else{
		errorusu.style.display = "inline";
		errorpass.style.display = "none";
	}
}
function init() {
	var usu = localStorage.getItem("Usuario");
	document.getElementById("saludo").innerHTML = "Bienvenido, " + usu; 
   }
   
window.addEventListener("load", init, false);