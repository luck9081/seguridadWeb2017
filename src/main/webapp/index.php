<!DOCTYPE html>
<html>
   <head>

      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
      <meta name="theme-color" content="#2196F3">

      <!-- FAVICON -->
      <link rel="shortcut icon" type="image/png" href="img/favicon.png"/>

      <!-- TITLE -->
      <title>OrganizeMe</title>

      <!-- CSS -->
      <link type="text/css" rel="stylesheet" href="fonts/material-design-icons/material-icons.css">
      <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css">
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css">
      <link type="text/css" rel="stylesheet" href="css/animate.css">
      <link type="text/css" rel="stylesheet" href="css/estilo.css">

   </head>

   <body class="altura-total" style="padding-top:15%">

      <!-- PRELOADER -->
      <div class="preloader-background">
         <div class="preloader-wrapper big active">
            <div class="spinner-layer spinner-blue">
               <div class="circle-clipper left">
                  <div class="circle"></div>
               </div>
               <div class="gap-patch">
                  <div class="circle"></div>
               </div>
               <div class="circle-clipper right">
                  <div class="circle"></div>
               </div>
            </div>

            <div class="spinner-layer spinner-red">
               <div class="circle-clipper left">
                  <div class="circle"></div>
               </div>
               <div class="gap-patch">
                  <div class="circle"></div>
               </div><div class="circle-clipper right">
                  <div class="circle"></div>
               </div>
            </div>

            <div class="spinner-layer spinner-yellow">
               <div class="circle-clipper left">
                  <div class="circle"></div>
               </div>
               <div class="gap-patch">
                  <div class="circle"></div>
               </div>
               <div class="circle-clipper right">
                  <div class="circle"></div>
               </div>
            </div>

            <div class="spinner-layer spinner-green">
               <div class="circle-clipper left">
                  <div class="circle"></div>
               </div>
               <div class="gap-patch">
                  <div class="circle"></div>
               </div>
               <div class="circle-clipper right">
                  <div class="circle"></div>
               </div>
            </div>
         </div>
      </div>

      <!-- MAIN SECTION -->
      <div class="row container center">
         <h3 class="finito animated fadeInDown">Bienvenido a</h3>
         <h1 class="span_h1 font-large finito animated fadeInDown hide-on-small-only">
            <span >Organize</span><span class="orange-text">Me</span>
         </h1>
         <h1 class="span_h1 finito animated fadeInDown hide-on-med-and-up">
            <span>Organize</span><span class="orange-text">Me</span>
         </h1>
         <a href="#modal1" class="btn btn-large waves-effect waves-light blue animated fadeInUp">Ingresar</a>
         <a href="#modal2" class="btn btn-large waves-effect waves-light orange animated fadeInUp">¿Eres nuevo?</a>

         <!-- Modal Login -->
         <div id="modal1" class="modal">
            <div class="modal-content espaciado-superior">
               <h4 class="blue-text finito">¡Hora de <span class="span_h2">Organizar</span>!</h4>
            </div>
            <form class="container left-align espaciado-inferior" action="usuario.php" method="post">
               <div class="input-field">
                  <input id="first_name" type="text" class="validate">
                  <label for="first_name">Usuario</label>
               </div>
               <div class="input-field">
                  <input id="password" type="password" class="validate">
                  <label for="password">Password</label>
               </div>
               <!-- Switch -->
               <div class="switch">
                  <label class="black-text">
                     Recordar
                     <input type="checkbox">
                     <span class="lever"></span>
                  </label>
               </div>
               <div class="center">
                  <button class="btn btn-floating btn-large blue waves-effect waves-light" type="submit" name="">
                      <i class="large material-icons">input</i>
                  </button>
               </div>
            </form>
         </div>

         <!-- Modal Registro -->
         <div id="modal2" class="modal">
            <div class="modal-content espaciado-superior">
               <h4 class="orange-text finito">Registrate Aquí</h4>
            </div>
            <form class="container left-align espaciado-inferior">
               <div class="input-field">
                  <input id="first_name" type="text" class="validate">
                  <label for="first_name">Nombre</label>
               </div>
               <div class="input-field">
                  <input id="last_name" type="text" class="validate">
                  <label for="last_name">Apellido</label>
               </div>
               <div class="input-field">
                  <input id="email" type="email" class="validate">
                  <label for="email">Email</label>
               </div>
               <div class="input-field">
                  <input id="password" type="password" class="validate">
                  <label for="password">Password</label>
               </div>
               <div class="input-field">
                  <input id="password" type="password" class="validate">
                  <label for="password">Confirmación Password</label>
               </div>
               <div class="center">
                  <button class="btn btn-floating btn-large orange waves-effect waves-light" type="submit" name="">
                      <i class="large material-icons">done</i>
                  </button>
               </div>
            </form>
         </div>

      </div>

   </body>

   <!-- SCRIPTS -->
   <script src="js/jquery-2.1.1.min.js"></script>
   <script src="js/materialize.js"></script>
   <script src="js/pre-loader.js"></script>
   <script src="js/init.js"></script>

</html>
