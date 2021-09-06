<%-- 
    Document   : PiezasEnsamble
    Created on : 6 sept. 2021, 10:40:55
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
                    <h5 class="card-title">Piezas para ensamble</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel debera agragar las el nombre y cantidad de piezas que lleva un mueble</h6>
                    <div>
                        <form action="ManejadorAdmin?menu=piezasEnsamble" method="POST">
                            
                            <div class="form-group">
                                <label>Nombre del mueble</label>
                                <input id="prodId" name="nombreAntiguoM" type="hidden" value="${ensamblePieza.getNombreMueble()}">
                                <input type="text" class="form-control" name="txtnombreM" value="${ensamblePieza.getNombreMueble()}" required/>
                            </div>
                            <div class="form-group">
                                <label>Nombre de la pieza</label>
                                <input id="prodId" name="nombreAntiguoP" type="hidden" value="${ensamblePieza.getNombrePieza()}">
                                <input type="text" class="form-control" name="txtnombreP" value="${ensamblePieza.getNombrePieza()}" required/>
                            </div>
                            <div class="form-group">
                                <label>Cantidad</label>
                                <input type="number" class="form-control" name="cantidad" value="${ensamblePieza.getCantidad()}" required/>
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
                            <th scope="col">Nombre pieza</th>
                            <th scope="col">Cantidad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="piezasEnsamble" items="${piezaEnsamble}">

                            <tr>
                                <th scope="row">${piezaEnsamble.getNombreMueble()}</th>
                                <th scope="row">${piezaEnsamble.getNombrePieza()}</th>
                                <td>${piezaEnsamble.getCantidad()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ManejadorAdmin?menu=Muebles&accion=Cargar&nombre=${piezaEnsamble.getNombreMueble()}">Editar</a>
                                    <a class="btn btn-danger"  href="ManejadorAdmin?menu=Muebles&accion=Eliminar&nombre=${piezaEnsamble.getNombreMueble()}">Eliminar</a>
                                </td>

                            </tr>
                        </c:forEach>


                    </tbody>
                </table>
            </div>