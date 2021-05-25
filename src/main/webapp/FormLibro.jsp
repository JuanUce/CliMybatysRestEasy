<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Todos los Libros</title>
</head>
<body>
    <center>
        <h1>Administracion de Libros</h1>
    </center>
    <div align="center">
        <c:if test="${libro != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${libro == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${libro != null}">
                        Edit Libro
                    </c:if>
                    <c:if test="${libro == null}">
                        Añadir Libro
                    </c:if>
                </h2>
            </caption>
                <c:if test="${libro != null}">
                    <input type="hidden" name="id" value="<c:out value='${libro.id}' />" />
                </c:if>           
            <tr>
                <th>Isbn: </th>
                <td>
                    <input type="text" name="edad" size="45"
                            value="<c:out value='${libro.isbn}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Titulo: </th>
                <td>
                    <input type="text" name="genero" size="45"
                            value="<c:out value='${lirbo.title}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Autor id: </th>
                <td>
                    <input type="text" name="nombre" size="5"
                            value="<c:out value='${autor.autor_id}' />"
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