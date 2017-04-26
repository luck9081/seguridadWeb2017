$(document).ready(function(){

   // DROPDOWN BUTTON
   $(".dropdown-button").dropdown();

   // SIDENAV
   $('.button-collapse').sideNav({
      menuWidth: 200, // Default is 300
      edge: 'left', // Choose the horizontal origin
      closeOnClick: true, // Closes side-nav on <a> clicks, useful for Angular/Meteor
      draggable: true // Choose whether you can drag to open on touch screens
   });

   // SOCIAL TOOLTIP
   $(document).ready(function(){
      $('.tooltipped').tooltip({delay: 50});
   });

   // COLLAPSIBLE
   $(document).ready(function(){
      $('.collapsible').collapsible();
   });

   // MODAL
   $(document).ready(function(){
      $('.modal').modal(); // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
   });

   // PARALAX
   $('.parallax').parallax();

   // CAROUSEL LARGE
   $('#carousel-grande').carousel({
      fullWidth:false
   });

   // CAROUSEL SMALL
   $('#carousel-pequeño').carousel({
      fullWidth:true
   });

   // CAROUSEL INTERVAL
   setInterval(function() {  // Setear el intervalo
      $('.carousel').carousel('next')
   }, 4000);

   // SCROLLFIRE
   Materialize.scrollFire([
      {selector: '.colleccion', offset: 200, callback: function(el) { Materialize.showStaggeredList($(el)); } }
      /*{selector: '.other-class', offset: 200, callback: function() {
         customCallbackFunc();
      } },*/
   ]);

   // DATEPICKER
   $('.datepicker').pickadate({
      selectMonths: true, // Creates a dropdown to control month
      selectYears: 15 // Creates a dropdown of 15 years to control year
   });

});
