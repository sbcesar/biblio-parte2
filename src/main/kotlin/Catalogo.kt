package org.pebiblioteca

class Catalogo {
    val elementos = mutableListOf<ElementoBiblioteca>()

    fun agregarElemento(elemento: ElementoBiblioteca) {
        elementos.add(elemento)
    }

    fun desagregarElemento(elemento: ElementoBiblioteca): Boolean {
        return elementos.remove(elemento)
    }
}