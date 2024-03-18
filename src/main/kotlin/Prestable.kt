import org.pebiblioteca.Usuario

interface Prestable {
    fun prestar(usuario: Usuario)
    fun devolver(usuario: Usuario)
}