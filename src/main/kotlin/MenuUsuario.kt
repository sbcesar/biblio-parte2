package org.pebiblioteca

fun main() {
    val libro1 = Libro("1","La ocarina del tiempo","Cesar",2177,"Aventura",Estado.PRESTADO)
    val libro2 = Libro("2","Regreso al reino de la fantasia","Geronmimo Stilton",2015,"Fantasia",Estado.DISPONIBLE)

    val registroPrestamos = RegistroPrestamo()
    val gestorBiblioteca = GestorBiblioteca()

    gestorBiblioteca.agregarLibro(libro1)
    gestorBiblioteca.agregarLibro(libro2)

    val usuario1 = Usuario("25", "Cesar")
    gestorBiblioteca.registrarPrestamo(libro2.titulo,usuario1)
    gestorBiblioteca.registrarPrestamo(libro1.titulo,usuario1)
    gestorBiblioteca.devolverLibro(usuario1,libro2)

    registroPrestamos.consultarHistorialPrestamos(usuario1)

}