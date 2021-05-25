<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todos los Autores</title>
</head>
<body>
    <center>
        <h1>Admininstracion Autores</h1>
    </center>
    <div align="center">
        <c:if test="${autor != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${autor == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${autor != null}">
                        Edit Autor
                    </c:if>
                    <c:if test="${autor == null}">
                        Añadir Autor
                    </c:if>
                </h2>
            </caption>
                <c:if test="${autor != null}">
                    <input type="hidden" name="id" value="<c:out value='${autor.id}' />" />
                </c:if>           
            <tr>
                <th>Edad: </th>
                <td>
                    <input type="text" name="edad" size="45"
                            value="<c:out value='${autor.edad}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Genero: </th>
                <td>
                    <input type="text" name="genero" size="45"
                            value="<c:out value='${autor.genero}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Nombre: </th>
                <td>
                    <input type="text" name="nombre" size="5"
                            value="<c:out value='${autor.nombre}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>