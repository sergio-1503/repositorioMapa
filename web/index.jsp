<%@page import="entidad.ubicacion"%>
<%@page import="controller.ubicacionController"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <title>Simple markers</title>
    <style>
      html, body {
        height: 100%;
        margin: 0;
        padding: 0;
      }
      #map {
        height: 100%;
      }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maps.googleapis.com/maps/api/js?v3"></script>

  </head>
  <body>
    <script>
         <%
            ubicacionController cont = new ubicacionController();
            ubicacion aux = new ubicacion();
            aux= cont.obt();
        %>
	var lati = <%=aux.getLat()%>;
	var long= <%=aux.getLongi()%>;
	var myLatLng ;
  	var mapOptions;
    var map  ;
	var marker  ;


function initialize() {

   myLatLng = {lat: lati, lng: long};
   mapOptions = {
    zoom:11,
    center:myLatLng
  };

   map = new google.maps.Map(document.getElementById('map'), mapOptions);

   marker = new google.maps.Marker({
    position: myLatLng,
    map: map,
    title: 'AQUI ESTOY'
  });
}

google.maps.event.addDomListener(window, 'load', initialize);
</script>
    <input id="latitud" name="prodId" type="hidden" >
    <input id="longitud" name="prodId" type="hidden">
    <div id="map"></div>
   <script>
    
    
    function latitu(){
        
        var a;
        $.ajax({
                url: "buscarServlet",
                
                success: function(respuesta) {
                    a=respuesta;
                    $('#latitud').val(a);
                },
                
            
        });
        
       
    }
    function longi(){
        
        var b;
        $.ajax({
                url: "buscarServlet1",
                
                success: function(respuesta) {
                    b=respuesta;
                    $('#longitud').val(b);
                },
                
            
        });
        
       
    }
    
    function change() {
        latitu();
        longi();
        var a= document.getElementById('latitud').value;
        var b= document.getElementById('longitud').value;
        
        
        lati=a;
        long=b;
        console.log(lati);
        console.log(long);
         marker.setPosition(new google.maps.LatLng(lati,long));
    }
    
    
    
    setInterval(change, 1000);
    </script>
    
  </body>
</html>