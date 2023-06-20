$(document).ready(function() {
    // Obtener la lista de productos al cargar la página
    obtenerListaProductos();

    // Agregar un nuevo producto
    $("#agregarForm").submit(function(event) {
        event.preventDefault();

        var referencia = $("#referenciaInput").val();
        var nombre = $("#nombreInput").val();
        var categoria = $("#categoriaInput").val();
        var precioUnidad = $("#precioInput").val();
        var cantidad = $("#cantidadInput").val();

        agregarProducto(referencia, nombre, categoria, precioUnidad, cantidad);
    });

    // Buscar productos por categoría
    $("#buscarForm").submit(function(event) {
        event.preventDefault();

        var categoria = $("#categoriaBusquedaInput").val();

        buscarPorCategoria(categoria);
    });
});

function obtenerListaProductos() {
    $.ajax({
        url: "http://localhost:8080/listar",
        type: "GET",
        success: function(data) {
            mostrarProductos(data);
        },
        error: function() {
            alert("Error al obtener la lista de productos.");
        }
    });
}

function mostrarProductos(productos) {
    $("#productosTable").find("tr:gt(0)").remove(); // Limpiar la tabla excepto la primera fila de encabezados

    for (var i = 0; i < productos.length; i++) {
        var producto = productos[i];

        var row = $("<tr>");
        row.append($("<td>").text(producto.referencia));
        row.append($("<td>").text(producto.nombre));
        row.append($("<td>").text(producto.categoria));
        row.append($("<td>").text(producto.precioUnidad));
        row.append($("<td>").text(producto.cantidad));
        row.append($("<td>").text(producto.descuento));
        row.append($("<td>").text(producto.total));

        $("#productosTable").append(row);
    }
}

function agregarProducto(referencia, nombre, categoria, precioUnidad, cantidad) {
    var producto = {
        referencia: referencia,
        nombre: nombre,
        categoria: categoria,
        precioUnidad: precioUnidad,
        cantidad: cantidad
    };

    $.ajax({
        url: "http://localhost:8080/agregar",
        type: "POST",
        data: JSON.stringify(producto),
        contentType: "application/json",
        success: function(data) {
            mostrarProductos(data);
            limpiarFormulario();
        },
        error: function(xhr, textStatus, errorThrown) {
            if (xhr.status === 400) {
                alert("La referencia del producto ya existe.");
            } else {
                alert("Error al agregar el producto.");
            }
        }
    });
}

function buscarPorCategoria(categoria) {
    $.ajax({
        url: "http://localhost:8080/categoria/" + categoria,
        type: "GET",
        success: function(data) {
            mostrarProductos(data);
        },
        error: function(xhr, textStatus, errorThrown) {
            if (xhr.status === 400) {
                alert("No se encontraron productos para la categoría especificada.");
            } else {
                alert("Error al buscar productos por categoría.");
            }
        }
    });
}

function limpiarFormulario() {
    $("#referenciaInput").val("");
    $("#nombreInput").val("");
    $("#categoriaInput").val("");
    $("#precioInput").val("");
    $("#cantidadInput").val("");
}
