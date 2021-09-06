<%-- 
    Document   : Mueble
    Created on : 6 sept. 2021, 5:16:09
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
                    <h5 class="card-title">Muebles</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel podra crear o modificar los mueble</h6>
                    <div>
                        <form action="ManejadorAdmin?menu=Muebles" method="POST">
                            
                            <div class="form-group">
                                <label>Nombre del mueble</label>
                                <input id="prodId" name="nombreAntiguo" type="hidden" value="${muebleSeleccionado.getNombre()}">
                                <input type="text" class="form-control" name="txtnombre" value="${muebleSeleccionado.getNombre()}" required/>
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="number" class="form-control" name="precio" step="any" value="${muebleSeleccionado.getPrecio()}" required/>
                            </div>

                            <input type="submit" class="btn btn-primary" name="accion" value="Agregar" >
                            <input type="submit" class="btn btn-success" style="background-color: blue" name="accion" value="Actualizar" >
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">Nombre mueble</th>
                            <th scope="col">Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="mueble" items="${muebles}">

                            <tr>
                                <th scope="row">${mueble.getNombre()}</th>
                                <td>${mueble.getPrecio()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ManejadorAdmin?menu=Muebles&accion=Cargar&nombre=${mueble.getNombre()}">Editar</a>
                                    <a class="btn btn-danger"  href="ManejadorAdmin?menu=Muebles&accion=Eliminar&nombre=${mueble.getNombre()}">Eliminar</a>
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
    </div>
   </body>
</html>