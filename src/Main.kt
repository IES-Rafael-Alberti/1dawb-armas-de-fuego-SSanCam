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
    //CAJA DE MUNICION EXTRA PARA TODAS LAS ARMAS:
    val cajaMunicionExtra = cantidadMunicionExtra

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

    /*//Deben dispararse 12 armas, cada una entre 1 y 3 veces... muestra también un mensaje que identifique cada comienzo de los 12 disparos

    // MAPA QUE REGISTRA ALEATORIAMENTE DE 1-3 DISPAROS POR CADA ARMA DE UN GRUPO DE 12
    val disparos = (1..12).map { armero.random() to (1..3).random() }
    //DISPARAMOS Y RECARGAMOS LAS ARMAS, CUANDO SEA NECESARIO.
    println("Hay $cantidadMunicionExtra balas extras para todas las armas.")
    pausa()
    espacio()

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
    */
    val tiposDispersionPistola = listOf(TipoRadio.REDUCIDO, TipoRadio.CORTO)
    val tiposDispersionRifle = listOf(TipoRadio.CORTO, TipoRadio.INTERMEDIO)
    val tiposDispersionBazooka = listOf(TipoRadio.AMPLIO, TipoRadio.ENORME)

    //1. Genera aleatoriamente disparos, en este caso 9, para las armas de fuego y para tres clases más (Casa, Coche y Bocadillo).
    val armas = listOf(
        "Casa" to Casa(10, "Confetti", Random.nextInt(0, 1), TipoRadio.DISPERSION),
        "Coche" to Coche(20, "Luz", 0, TipoRadio.RAYO_LUZ),
        "Bocadillo" to Bocadillo(10, "Olor", Random.nextInt(20, 50), TipoRadio.OLOR),
        "Pistola" to Pistola(5, "9mm", Random.nextInt(1, 5), tiposDispersionPistola.random()),
        "Rifle" to Rifle(8, "7.72mm", Random.nextInt(5, 10), tiposDispersionRifle.random()),
        "Bazooka" to Bazooka(6, "RPG", Random.nextInt(10, 30), tiposDispersionBazooka.random())
    )
    val disparos = (1..9).map { armas.random() to (1..6).random() }

    println("Hay $cantidadMunicionExtra balas extras para todas las armas.")
    pausa()
    espacio()

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
}
