    <%@include file="WEB-INF/fragmentos/top.jspf"%>


     <nav class="carousel"> 
   <div id="carousel-ejemplo" class="carousel slide" data-ride="carousel">
            <!-- Indicadores -->
            <ol class="carousel-indicators">
              <li data-target="#carousel-ejemplo" data-slide-to="0" class="active"></li>
              <li data-target="#carousel-ejemplo" data-slide-to="1"></li>
              <li data-target="#carousel-ejemplo" data-slide-to="2"></li>
            <li data-target="#carousel-ejemplo" data-slide-to="3"></li>
              <li data-target="#carousel-ejemplo" data-slide-to="4"></li>
            <li data-target="#carousel-ejemplo" data-slide-to="5"></li>
              <li data-target="#carousel-ejemplo" data-slide-to="6"></li>
            </ol>
 
            <!-- Contenido imágenes -->
            <div class="carousel-inner" role="listbox">
          
              <div class="item active">
                <img src="imagen/001.jpg" width="1370" alt="">
                <div class="carousel-caption">
                 <h3>Av Peru #135 Morales-San Martin  Cell:#941888900</h3>
                </div>
              </div>
            
              <div class="item">
                <img src="imagen/02.jpg" width="1370" alt="">
                <div class="carousel-caption">
                 <h3>Av Peru #135 Morales-San Martin  Cell:#941888900</h3>
               <p></p>
                </div>
             
              </div>
            
            <div class="item">
                <img src="imagen/03.jpg" width="1370" alt="">
                <div class="carousel-caption">
                <h3>Av Peru #135 Morales-San Martin  Cell:#941888900</h3>
                </div>
              </div>
            
            <div class="item">
                <img src="imagen/04.jpg" width="1370" alt="...">
                <div class="carousel-caption">
                <h3>Av Peru #135 Morales-San Martin  Cell:#941888900</h3>
                </div>
              </div>
            
             <div class="item">
                <img src="imagen/05.jpg" width="1370" alt="...">
                <div class="carousel-caption">
                <h3>Av Perutilde #135 Morales-San Martin  Cell:#941888900</h3>
                </div>
              </div>
            
            
             <div class="item">
                <img src="imagen/06.jpg"  width="1370" alt="...">
                <div class="carousel-caption">
                <h3>Av Peru #135 Morales-San Martin  Cell:#941888900</h3>
                </div>
              </div>
            
            
             <div class="item">
                <img src="imagen/07.jpg" width="1370" alt="...">
                <div class="carousel-caption">
                <h3>Av Peru #135 Morales-San Martin  Cell:#941888900</h3>
                </div>
              </div>
            
            </div>
 
             <!-- Controles -->
            <a class="left carousel-control" href="#carousel-ejemplo" role="button" data-slide="prev">
              <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
              <span class="sr-only">Previo</span>
            </a>
            <a class="right carousel-control" href="#carousel-ejemplo" role="button" data-slide="next">
              <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
              <span class="sr-only">Siguiente</span>
            </a>
          
          </div>
 
          
      

     <script>
     
     $('.carousel').carousel({
 
          interval: 1000,
          pause:"hover"
 
     });
     </script>
 </nav>

<%@include file="WEB-INF/fragmentos/bottom.jspf"%>