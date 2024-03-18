package org.pebiblioteca

import java.util.UUID

object UtilidadesBiblioteca {

    fun generarIdentificadorUnico(): String {
        return UUID.randomUUID().toString()
    }
}