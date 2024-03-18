package org.pebiblioteca

class Usuario(
    val id: String,
    val nombre: String,
) {
    private val listaLibrosPrestados = mutableListOf<Libro>()

    fun agregarLibroPrestado(libro: Libro) {
        listaLibrosPrestados.add(libro)
    }

    fun quitarLibro(libro: Libro) {
        listaLibrosPrestados.add(libro)
    }

    fun consultarLibro(): List<Libro> {
        return listaLibrosPrestados
    }
}