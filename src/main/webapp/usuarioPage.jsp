<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

        <title>Finanzas y administracion</title>
    </head>
    <body>
        <div class="row">
            <div class="card col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Empleados</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En esta area podra ingresar a los usuarios de este sistema</h6>
                    <div>
                        <form action="ManejadorAdmin?menu=Empleados" method="POST">

                            <div class="form-group">
                                <label>Nombre</label>
                                <input type="text" class="form-control" name="txtnombre" value="${usuarioSeleccionado.getNombre()}" required/>
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="txtpassword" value="${usuarioSeleccionado.getPassword()}" required/>
                            </div>
                            
                            <div class="form-group">
                                <label>Tipo</label>
                                <select class="form-control form-control-sm" name="txttipo">
                                    <option value="1">Fabrica</option>         
                                    <option value="2">Punto de venta</option>
                                    <option value="3">Financiero</option>
                                </select>
                            </div>
                            

                            <input type="submit" class="btn btn-primary" name="accion" value="Agregar" >
                            <input type="submit" class="btn btn-success" name="accion" value="Actualizar" >
                        </form>
                    </div>
                </div>
            </div>

            <div class="col-md-8">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th scope="col">id</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Tipo</th>
                            <th scope="col">Tipo en numero</th>
                            <th scope="col">Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${usuarios}">

                            <tr>
                                <th scope="row">${usuario.getId()}</th>
                                <td>${usuario.getNombre()}</td>
                                <td>${usuario.getTipoStr()}</td>
                                <td>${usuario.getTipoNum()}</td>
                                <td>
                                    <a class="btn btn-warning" href="ManejadorAdmin?menu=Empleados&accion=Cargar&id=${usuario.getId()}">Editar</a>
                                    <a class="btn btn-danger" href="ManejadorAdmin?menu=Empleados&accion=Eliminar&id=${usuario.getId()}">Eliminar</a>
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