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
                    <h5 class="card-title">Pieza</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los usuarios empleados del sistema</h6>
                    <div>
                        <form action="ManejadorFabrica?menuFabrica=Piezas" method="POST">
                            
                            <div class="form-group">
                                <label>Nombre de la pieza</label>
                                <input type="text" class="form-control" name="txtnombre" value="${piezaSeleccionado.getNombrePieza()}" required/>
                            </div>
                            <div class="form-group">
                                <label>Precio</label>
                                <input type="number" class="form-control" name="precio" step="any" value="${piezaSeleccionado.getPrecioPieza()}" required/>
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
                            <th scope="col">id</th>
                            <th scope="col">Nombre de la pieza</th>
                            <th scope="col">Precio</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pieza" items="${piezas}">

                            <tr>
                                <th scope="row">${pieza.getId()}</th>
                                <td>${pieza.getNombrePieza()}</td>
                                <td>${pieza.getPrecioPieza()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ManejadorFabr?menuFabrica=Piezas&accion=Cargar&id=${pieza.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="ManejadorFabr?menuFabrica=Piezas&accion=Eliminar&id=${pieza.getId()}">Eliminar</a>
                                    <a class="btn btn-danger" href="ManejadorFabr?menuFabrica=Piezas&accion=sumar&nombrePieza=${pieza.getNombrePieza()}&precioPieza=${pieza.getPrecioPieza()}">+</a>
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