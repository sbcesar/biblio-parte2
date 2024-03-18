package org.pebiblioteca

import IGestorPrestamos


class RegistroPrestamo : IGestorPrestamos {

    private val prestamosActuales = mutableMapOf<Usuario, ElementoBiblioteca>()                   //Mapa mutable de nombre_usuario y libro
    private val historialPrestamos = mutableMapOf<String, MutableList<String>>()    //Mapa mutable de nombre_usuario y lista mutable de préstamos


    override fun registrarPrestamo(usuario: Usuario, elemento: ElementoBiblioteca) {
        prestamosActuales[usuario] = elemento

        val historialUsuario = historialPrestamos[usuario.nombre]

        if (historialUsuario != null) {                 //Si el usuario ya tiene historial, agrega el prestamo
            historialUsuario.add("Ha realizado un prestamo del ${elemento.titulo}")
        } else {                                        //Si el usuario no tiene el historial, lo crea y agrega el prestamo
            historialPrestamos[usuario.nombre] = mutableListOf("Ha realizado un prestamo del libro ${elemento.titulo}")
        }
    }


    override fun registrarDevolucion(usuario: Usuario, elemento: ElementoBiblioteca) {
        val elementoPrestado = prestamosActuales.remove(usuario)
        if (elementoPrestado != null) {
            elementoPrestado.estado = Estado.DISPONIBLE
            println("El ${elementoPrestado.titulo} ha sido devuelto")

            val historialUsuario = historialPrestamos[usuario.nombre]
            if (historialUsuario != null) {                 //Si el usuario ya tiene historial, agrega la devolucion
                historialUsuario.add("Ha realizado una devolucion de ${elementoPrestado.titulo}")
            } else {                                        //Si el usuario no tiene el historial, lo crea y agrega la devolucion
                historialPrestamos[usuario.nombre] = mutableListOf("Ha realizado una devolucion de ${elementoPrestado.titulo}")
            }
        } else {
            println("${usuario.nombre} no ha tomado prestado ningun libro")
        }
    }

    override fun consultarHistorialPrestamos(usuario: Usuario): List<String> {
        val historial = historialPrestamos[usuario.nombre]
        return if (historial != null && historial.isNotEmpty()) {
            println("Historial de prestamos para el usuario ${usuario.nombre}:")
            historial.forEach { println("- $it") }
            historial.toList()
        } else {
            println("El usuario ${usuario.nombre} es nuevo")
            emptyList()
        }
    }

}