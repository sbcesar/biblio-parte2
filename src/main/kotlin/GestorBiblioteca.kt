package org.pebiblioteca


class GestorBiblioteca {
    private val catalogo = Catalogo()
    private val registroPrestamo = RegistroPrestamo()

    fun agregarLibro(libro: Libro) {
        val idUnico = UtilidadesBiblioteca.generarIdentificadorUnico()
        val libroConId = Libro(idUnico, libro.obtenerTitulo(),libro.obtenerAutor(),libro.obtenerAnioPublicacion(), libro.obtenerTematica(),libro.obtenerEstado())
        catalogo.agregarElemento(libroConId)
    }

    fun eliminarLibro(elemento: ElementoBiblioteca) {
        if (!catalogo.elementos.contains(elemento)) {
            println("El ${elemento.titulo} no existe.")
        } else {
            catalogo.desagregarElemento(elemento)
            println("El libro ${elemento.titulo} ha sido eliminado del catalogo.")
        }
    }

    fun registrarPrestamo(tituloElemento: String, usuario: Usuario) {
        val elemento = catalogo.elementos.find { it.titulo == tituloElemento }
        val estado = consultarDisponibilidad(tituloElemento)

        if (elemento != null && estado != null) {
            if (estado == Estado.DISPONIBLE) {
                elemento.estado = Estado.PRESTADO
                registroPrestamo.registrarPrestamo(usuario, elemento)
                println("El $tituloElemento ha sido prestado a ${usuario.nombre}")
            } else {
                println("El $tituloElemento no esta disponible porque ya esta siendo prestado")
            }
        } else {
            println("El $tituloElemento no existe.")
        }
    }

    fun devolverLibro(usuario: Usuario, elemento: ElementoBiblioteca) {
        registroPrestamo.registrarDevolucion(usuario, elemento)
    }

    private fun consultarDisponibilidad(tituloElemento: String): Estado {
        return catalogo.elementos.find { it.titulo == tituloElemento }!!.estado
    }


    fun obtenerLibro(): List<ElementoBiblioteca> {
        return catalogo.elementos.toList()
    }

    fun obtenerLibrosDisponibles(): List<ElementoBiblioteca>{
        return catalogo.elementos.filter { it.estado == Estado.DISPONIBLE }
    }

    fun obtenerLibrosPrestados(): List<ElementoBiblioteca>{
        return catalogo.elementos.filter { it.estado == Estado.PRESTADO }
    }
}