<!DOCTYPE html>
<html>
   <head>

      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
      <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
      <meta name="theme-color" content="#2196F3">

      <!-- FAVICON -->
      <link rel="shortcut icon" type="image/png" href="img/favicon.png"/>

      <!-- TITLE  -->
      <title>OrganizeMe</title>

      <!-- CSS  -->
      <link type="text/css" rel="stylesheet" href="fonts/material-design-icons/material-icons.css">
      <link type="text/css" rel="stylesheet" href="css/font-awesome.min.css">
      <link type="text/css" rel="stylesheet" href="css/materialize.min.css">
      <link type="text/css" rel="stylesheet" href="css/animate.css">
      <link type="text/css" rel="stylesheet" href="css/estilo.css">

   </head>

   <body id="top" class="scrollspy sin-espaciado-inferior">

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

      <!-- NAVIGATION LARGE -->
      <div class="navbar-fixed animated fadeInDown">

         <!-- Dropdown Structure -->
         <ul id="dropdown1" class="dropdown-content">
            <li><a class="blue-text span_h2" href="">
               <i class="material-icons prefix">mode_edit</i> Perfil
            </a></li>
            <li class="divider"></li>
            <li><a class="orange-text span_h2" href="index2.php">
               <i class="material-icons orange-text">power_settings_new</i> Salir
            </a></li>
         </ul>

         <!-- Nav Structure -->
         <nav id="nav_f" class="grey lighten-5" role="navigation">
            <div class="row center">
               <div class="container">
                  <div class="nav-wrapper">

                     <a href="index.php" id="logo-container" class="brand-logo hide-on-med-and-down">
                        <span class="black-text">Organize</span><span class="orange-text span_h1">Me</span>
                     </a>

                     <div class="right hide-on-med-and-down espaciado-izquierda">
                        <!-- Dropdown Trigger -->
                        <a class="dropdown-button blue-text span_h2" href="" data-activates="dropdown1">
                           ¡Hola, Luck9081! <i class="fa fa-user-o fa-2x"></i>
                        </a>
                     </div>

                  </div>
               </div>
               <a href="#" data-activates="nav-mobile" class="button-collapse blue-text"><i class="fa fa-bars fa-2x"></i></a>
               <a id="logo-container" class="brand-logo-small hide-on-large-only">
                  <span class="black-text">Organize</span>
                  <span class="orange-text span_h1">Me</span>
               </a>
            </div>
         </nav>
      </div>

      <!-- NAVIGATION SMALL -->
      <ul id="nav-mobile" class="side-nav hide-on-large-only">

      </ul>

      <!-- SECTION MAIN -->
      <div class="section scrollspy">

         <!-- Moderador -->
         <div class="row container animated fadeIn">

            <!-- Moderar Usuarios -->
            <div class="col s12 m12 l6 offset-l3">
               <div class="tarjeta grey lighten-4 animated zoomIn">

                  <h3 class="span_h2">Moderar Usuarios</h3>

                  <ul class="collection subcategories-list">
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle blue darken-2">face</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <a class="secondary-content">
                           <i class="material-icons green-text waves-effect waves-green accept-user">done</i>
                           <i class="material-icons red-text delete waves-effect">clear</i>
                        </a>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle blue darken-2">face</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <a href="#modal1"><i class="material-icons blue-text waves-effect" href="#modal1">mode_edit</i></a>
                           <i class="material-icons red-text delete waves-effect">clear</i>
                        </div>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle blue darken-2">face</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <a href="#modal1"><i class="material-icons blue-text waves-effect" href="#modal1">mode_edit</i></a>
                           <i class="material-icons red-text delete waves-effect">clear</i>
                        </div>
                     </li>
                  </ul>

               </div>
            </div>

         </div>


         <!-- Modal Registro -->
         <div id="modal1" class="modal center">
            <div class="modal-content espaciado-superior">
               <h4 class="orange-text finito">Editar Usuario</h4>
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
   <script src="js/materialize.min.js"></script>
   <script src="js/pre-loader.js"></script>
   <script src="js/init.js"></script>
   <script src="js/funciones.js"></script>

</html>
