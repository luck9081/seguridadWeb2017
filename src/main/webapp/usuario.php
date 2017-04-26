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
            <li><a class="orange-text span_h2" href="index.php">
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

         <!-- Nueva Tarea Trigger -->
         <div class="row container">
            <div class="col s12 m12 l4">
               <a href="#modal1">
                  <div class="tarjeta-new light-blue darken-1 waves-effect waves-light animated fadeInLeft">
                     <h4 class="span_h2 white-text">Añadir Tarea</h4>
                  </div>
               </a>
            </div>
         </div>

         <!-- Hoy y Mañana -->
         <div class="row container animated zoomIn">

            <div class="col s12 m12 l7">
               <div class="tarjeta grey lighten-4">

                  <h3 class="span_h2">Hoy</h3>

                  <ul class="collection subcategories-list">
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle green">insert_chart</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <input type="checkbox" id="test1" />
                           <label for="test1"></label>
                           <a href="#modal2"><i class="material-icons blue-text">share</i></a>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle">folder</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <input type="checkbox" id="test2" />
                           <label for="test2"></label>
                           <a href="#modal2"><i class="material-icons blue-text">share</i></a>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle red">play_arrow</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <input type="checkbox" id="test3" />
                           <label for="test3"></label>
                           <a href="#modal2"><i class="material-icons blue-text">share</i></a>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                  </ul>

               </div>
            </div>

            <div class="col s12 m12 l5">
               <div class="tarjeta grey lighten-4">

                  <h3 class="span_h2">Mañana</h3>

                  <ul class="collection subcategories-list">
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle green">insert_chart</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <a href="#modal2"><i class="material-icons blue-text">share</i></a>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </a>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle">folder</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <a href="#modal2"><i class="material-icons blue-text">share</i></a>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle red">play_arrow</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <a href="#modal2"><i class="material-icons blue-text">share</i></a>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                  </ul>

               </div>
            </div>

         </div>

         <!-- Completas - Pendientes -->
         <div class="row container animated zoomIn">

            <div class="col s12 m12 l7">
               <div class="tarjeta grey lighten-4">

                  <h3 class="span_h2">Completas</h3>

                  <ul class="collection subcategories-list">
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle green">insert_chart</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle">folder</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle red">play_arrow</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                     </li>
                  </ul>

               </div>
            </div>

            <div class="col s12 m12 l5">
               <div class="tarjeta grey lighten-4">

                  <h3 class="span_h2">Pendientes</h3>

                  <ul class="collection subcategories-list">
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle green">insert_chart</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <i class="material-icons blue-text">share</i>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle">folder</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <i class="material-icons blue-text">share</i>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle red">play_arrow</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <div class="secondary-content">
                           <i class="material-icons blue-text">share</i>
                           <a><i class="material-icons grey-text delete">delete</i></a>
                        </div>
                     </li>
                  </ul>

               </div>
            </div>

         </div>

         <!-- Modal Nueva Tarea -->
         <div id="modal1" class="modal center">
            <form class="container left-align espaciado-superior-inferior">
               <div class="input-field">
                  <input id="first_name" type="text" class="validate">
                  <label for="first_name">Título de Tarea</label>
               </div>
               <div class="input-field">
                  <input id="last_name" type="text" class="validate">
                  <label for="last_name">Descripción</label>
               </div>
               <div class="input-field">
                  <input id="taskDate" type="date" class="datepicker">
                  <label for="taskDate">Fecha</label>
               </div>
               <div class="input-field">
                  <input id="taskTime" type="time" class="timepicker">
                  <label for="taskTime" class="active">Hora</label>
               </div>
               <div class="switch">
                  <label>
                     Privada
                     <input type="checkbox">
                     <span class="lever"></span>
                  </label>
               </div>
               <div class="center">
                  <button class="btn btn-floating btn-large orange waves-effect waves-light" type="submit" name="">
                      <i class="large material-icons">done</i>
                  </button>
               </div>
            </form>
         </div>

         <!-- Modal Compartir Tarea -->
         <div id="modal2" class="modal center grey lighten-4">
            <div class="espaciado-superior">
               <h3 class="span_h2 orange-text">Compartir la Tarea</h3>
            </div>

            <form class="container left-align espaciado-superior-inferior">
               <div class="tarjeta grey lighten-4">

                  <ul class="collection subcategories-list">
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle green">insert_chart</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <a class="secondary-content">
                           <input type="checkbox" id="test1" />
                           <label for="test1"></label>
                        </a>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle">folder</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <a class="secondary-content">
                           <input type="checkbox" id="test2" />
                           <label for="test2"></label>
                        </a>
                     </li>
                     <li class="collection-item avatar grey lighten-4">
                        <i class="material-icons circle red">play_arrow</i>
                        <span class="title">Title</span>
                        <p>First Line <br>
                           Second Line
                        </p>
                        <a class="secondary-content">
                           <input type="checkbox" id="test3" />
                           <label for="test3"></label>
                        </a>
                     </li>
                  </ul>

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
