package org.pebiblioteca

import Prestable


class Libro(
    override val id: String,
    override val titulo: String,
    private val autor: String,
    private val anioPublicacion: Int,
    private val tematica: String,
    override var estado: Estado
) : ElementoBiblioteca(), Prestable {

    init {
        require(titulo.isNotBlank()) { "El titulo no puede estar vacio." }
        require(autor.isNotBlank()) { "El titulo no puede estar vacio." }
        require(anioPublicacion.toString().length == 4) { "El año de publicación debe ser de 4 dígitos." }
        require(tematica.isNotBlank()) { "La tematica no puede estar vacia." }
    }

    override fun prestar(usuario: Usuario) {
        if (estado == Estado.DISPONIBLE) {
            estado = Estado.PRESTADO
            println("${usuario.nombre} ha tomado prestado el libro $titulo")
        } else {
            println("El libro $titulo no está disponible")
        }
    }

    override fun devolver(usuario: Usuario) {
        estado = Estado.DISPONIBLE
    }

    fun obtenerId(): String {
        return id
    }

    fun obtenerTitulo(): String {
        return titulo
    }

    fun obtenerAutor(): String {
        return autor
    }

    fun obtenerAnioPublicacion(): Int {
        return anioPublicacion
    }

    fun obtenerTematica(): String {
        return tematica
    }

    fun obtenerEstado(): Estado {
        return estado
    }

    fun establecerEstado(nuevoEstado: Estado) {
        estado = nuevoEstado
    }
}