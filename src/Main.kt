import ArmaDeFuego.Companion.cantidadMunicionExtra
import kotlin.random.Random

fun main() {
    //MAPA DE LAS TRES ARMAS QUE VAN A DISPARAR
    val mapaArmas = mapOf(
        "Pistola" to Pistola(5, "9mm", Random.nextInt(1,5), TipoRadio.entries.toTypedArray().random()),
        "Rifle" to Rifle(8, "7.72mm", Random.nextInt(5,10), TipoRadio.entries.toTypedArray().random()),
        "Bazooka" to Bazooka(6, "RPG", Random.nextInt(10,30), TipoRadio.entries.toTypedArray().random())
    )
    //CAJA DE MUNICION PARA RECARGA:
    val munucionExtraTodasArmas = cantidadMunicionExtra

    //DISPARAMOS Y RECARGAMOS LAS ARMAS, CUANDO SEA NECESARIO.
    println("Hay $munucionExtraTodasArmas balas extras para todas las armas.")

    while (munucionExtraTodasArmas > 0) {
        for ((nombre, arma) in mapaArmas) {
            if (arma.municion != 0) {
                println("$arma dispara: PIUN!!")
                arma.disparar()
                println(arma.toString())
                println("Quedan $munucionExtraTodasArmas balas extras.")
            }
            println("$nombre ha agotado su munición y tiene que recargar.")
            arma.recarga()
            println("**RECARGANDO**")
            println(arma.toString())
            Thread.sleep(2000)
        }
        /*
        if (cantidadMunicionExtra == 0){
            println("Se han acabado las balas extras!!")
            Thread.sleep(3000)
            break
        }

         */

    }
}
