import org.pebiblioteca.ElementoBiblioteca
import org.pebiblioteca.Usuario

interface IGestorPrestamos {
    fun registrarPrestamo(usuario: Usuario, elemento: ElementoBiblioteca)
    fun registrarDevolucion(usuario: Usuario, elemento: ElementoBiblioteca)
    fun consultarHistorialPrestamos(usuario: Usuario): List<String>
}