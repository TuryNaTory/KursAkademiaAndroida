package ak.www.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}