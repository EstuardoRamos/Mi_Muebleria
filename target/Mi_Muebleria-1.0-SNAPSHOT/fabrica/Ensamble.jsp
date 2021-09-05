<%-- 
    Document   : Ensamble
    Created on : 4 sept. 2021, 2:48:33
    Author     : Estuardo Ramos
--%>
<%-- 
    Document   : Pieza
    Created on : 2 sept. 2021, 3:05:30
    Author     : Estuardo Ramos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Hello, world!</title>
    </head>
    <body>
        <div class="row">
            <div class="card col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Ensamble</h5>
                    <h6 class="card-subtitle mb-2 text-muted">Se muestran las piezas que son necesarias para el ensmble de un mueble</h6>
                    <div class="col-md-8">
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">Nombre pieza</th>
                                    <th scope="col">Nombre del mueble</th>
                                    <th scope="col">Catidad pieza que se necesita</th>
                                    <th scope="col">Catidad pieza disponible</th>
                                </tr>
                            </thead>
                            <tbody >
                                <c:forEach var="muebleT" items="${muebleT}">

                                    <tr>
                                        <th scope="row">${muebleT.getNombreMT()}</th>
                                        <td>${muebleT.getNombrePieza()}</td>
                                        <td>${muebleT.getCantidadPieza()}</td>
                                        
                                    </tr>
                                </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Nombre del mueble</th>
                            <th scope="col">Precio costo</th>
                        </tr>
                    </thead>
                    <tbody >
                        <c:forEach var="muebleFr" items="${muebleFr}">

                            <tr>
                                <th scope="row">${muebleFr.getId()}</th>
                                <td>${muebleFr.getNombre()}</td>
                                <td>${muebleFr.getPrecio()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ManejadorFabrica?menuFabrica=Ensamble&accion=Ensamblar&nombreMueble=${muebleFr.getNombre()}">Ensamblar</a>
                                    <a class="btn btn-danger" href="ManejadorFabrica?menuFabrica=Ensamble&accion=Eliminar&id=${muebleFr.getId()}">Eliminar</a>
                                    <a class="btn btn-danger" href="ManejadorFabrica?menuFabrica=Ensamble&accion=sumar&nombrePieza=${pieza.getNombrePieza()}&precioPieza=${pieza.getPrecioPieza()}">+</a>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>

            <!-- Optional JavaScript -->
            <!-- jQuery first, then Popper.js, then Bootstrap JS -->
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>