// BORRAR TAREAS
$('.delete').click(function() {
   $(this).parent().parent().parent().addClass("animated fadeOutLeft").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){$(this).remove()});
   //document.location.replace("index.php");
});

//BORRAR USERS
$('.delete-user').click(function() {
   $(this).parent().parent().addClass("animated fadeOutLeft").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){$(this).remove()});
   //document.location.replace("index.php");
});

// ACEPTAR USUARIO
$('.accept-user').click(function() {
   $(this).addClass("animated fadeOut").one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function(){$(this).remove()});
   //document.location.replace("index.php");
});

// ACTIVAR MODAL EDITAR TAREA
$(".modalEditarTarea").click(function(){
   $('#modalEditarTarea .descripcion').val($(this).data('descripcion'));
   $('#modalEditarTarea .idTarea').val($(this).data('tarea'));
   $('#modalEditarTarea label').addClass('active');
});
