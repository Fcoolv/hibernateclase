<html>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to.fit=no">

<link rel="stylesheet" href=css/bootstrap.min.css>

<link rel="stylesheet" href=css/font-awesome.min.css>
<style type="text/css">
.container:before {
	content: "";
	position: fixed;
	left: 0;
	right: 0;
	z-index: -1;
	display: block;
	background-image: url(images/fondo2.gif);
	background-size: cover;
	width: 100%;
	height: 100%;
	-webkit-filter: blur(5px);
	-moz-filter: blur(5px);
	-o-filter: blur(5px);
	-ms-filter: blur(5px);
	filter: blur(3px);
}

.Centro {
	margin: auto;
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
}

.Centro.Responsive {
	width: 50%;
	height: 50%;
	min-width: 200px;
	max-width: 400px;
	padding: 40px;
}

.error {
	color: red;
	display: none;
}
</style>



</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="Centro Responsive">
				<form class="form-group" name="login" onsubmit="return false">
					<h1 class="form-signin-heading text-muted">Inicio de Sesion</h1>
					<input type="text" id="usu" class="form-control"
						placeholder="Usuario" autofocus="autofocus"><span
						class="error" id="usuerror"> Usuario incorrecto</span> <input
						type="password" id="pass" class="form-control"
						placeholder="Password"><span class="error" id="passerror">
						Contrase�a incorrecta</span> 
						<br />
					<button class="btn btn-lg btn-primary" onclick="sesion()">
						Iniciar Sesion</button>
					<button type="button" class="btn btn-default" onclick="location.href='jsp/registrarUsu.jsp'">Registrar</button>
				</form>
			</div>
		</div>
	</div>


	<script src="js/jquery-3.2.1.slim.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/sesiones.js"></script>
</body>
</html>
