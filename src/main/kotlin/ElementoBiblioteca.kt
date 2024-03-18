package org.pebiblioteca

abstract class ElementoBiblioteca {
    abstract val id: String
    abstract val titulo: String
    abstract var estado: Estado
}