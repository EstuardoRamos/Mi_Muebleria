<%-- 
    Document   : Cliente
    Created on : 5 sept. 2021, 17:44:42
    Author     : Estuardo Ramos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card col-md-4">
                <div class="card-body">
                    <h5 class="card-title">Pieza</h5>
                    <h6 class="card-subtitle mb-2 text-muted">En este panel podras gestionar los datos de los usuarios empleados del sistema</h6>
                    <div>
                        <form action="ManejadorFabrica?menuFabrica=Piezas" method="POST">
                            
                            <div class="form-group">
                                <label>Ingrese NIT;</label>
                                <input type="text" class="form-control" name="txtnombre" value="${piezaSeleccionado.getNombrePieza()}" required/>
                            </div>
                            <input type="submit" class="btn btn-primary" name="accion" value="Validar" >
                            
                            <div class="form-group">
                                <label>Nombre del cliente</label>
                                <input type="text" class="form-control" name="txtnombre" value="${piezaSeleccionado.getNombrePieza()}" required/>
                            </div>
                            <div class="form-group">
                                <label>Direccion:</label>
                                <input type="text" class="form-control" name="direccion" step="any" value="${piezaSeleccionado.getPrecioPieza()}" required/>
                            </div>
                            <div class="form-group">
                                <label>Municipio</label>
                                <input type="text" class="form-control" name="municipio" value="${piezaSeleccionado.getNombrePieza()}" required>
                            </div>
                            <div class="form-group">
                                <label>Departamento:</label>
                                <input type="text" class="form-control" name="departamento" value="${piezaSeleccionado.getNombrePieza()}" required>
                            </div>

                            <input type="submit" class="btn btn-primary" name="accion" value="Regitrar" >
                            <input type="submit" class="btn btn-success" style="background-color: blue" name="accion" value="Actualizar" >
                        </form>
                    </div>
                </div>
            </div>
    </body>
</html>
