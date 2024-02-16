import ArmaDeFuego.Companion.cantidadMunicionExtra
import com.sun.source.tree.WhileLoopTree
import kotlin.random.Random

fun pausa() {
    Thread.sleep(1500)
}

fun espacio() {
    println()
}

fun main() {
    //MAPA DE LAS TRES ARMAS QUE VAN A DISPARAR
    val armero = listOf(
        "Pistola" to Pistola(5, "9mm", Random.nextInt(1, 5), TipoRadio.entries.toTypedArray().random()),
        "Rifle" to Rifle(8, "7.72mm", Random.nextInt(5, 10), TipoRadio.entries.toTypedArray().random()),
        "Bazooka" to Bazooka(6, "RPG", Random.nextInt(10, 30), TipoRadio.entries.toTypedArray().random())
    )
    //CAJA DE MUNICION PARA RECARGA:
    val cajaMunicionExtra = cantidadMunicionExtra

    // MAPA QUE REGISTRA ALEATORIAMENTE DE 1-3 DISPAROS POR CADA ARMA DE UN GRUPO DE 12
    val disparos = (1..12).map { armero.random() to (1..3).random() }
    //DISPARAMOS Y RECARGAMOS LAS ARMAS, CUANDO SEA NECESARIO.
    println("Hay $cantidadMunicionExtra balas extras para todas las armas.")
    pausa()
    espacio()

    /*
    //RONDA DE TIROS HASTA ACABAR LA MUNICIÓN EXTRA.
    while (cantidadMunicionExtra > 0) {
        for ((nombre, arma) in armero) {
            println("**Quedan $cantidadMunicionExtra balas extras.**")
            espacio()
            if (arma.municion != 0) {
                arma.disparar()
                println(arma.toString())
                espacio()
                pausa()

            } else {
                println("$nombre ha agotado su munición y tiene que recargar.")
                arma.recarga()
                println(arma.toString())
                espacio()
                pausa()
            }
        }

        if (cantidadMunicionExtra == 0) {
            espacio()
            println("Se han acabado las balas extras!!")
            pausa()
        }
    } */

    while (cantidadMunicionExtra > 0) {
        for ((index, disparo) in disparos.withIndex()) {
            println("Disparo Nº${index + 1}")
            val arma = disparo.first.second
            for (tiro in 1..disparo.second) {
                println("**QUEDAN $cantidadMunicionExtra BALAS EXTRAS!!")
                espacio()
                if (arma.municion != 0) {
                    arma.disparar()
                    println(arma.toString())
                    espacio()
                    pausa()

                } else {
                    println("${arma.nombre} ha agotado su munición y tiene que recargar.")
                    arma.recarga()
                    println(arma.toString())
                    espacio()
                    pausa()
                }
            }
        }

    }
    espacio()
    println("Se acabaron las balas, nos vamos pa' casa.")
    pausa()
}
