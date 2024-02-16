import kotlin.random.Random
/**
 * Clase abstracta que representa una arma de fuego genérica.
 *
 * @property nombre El nombre del arma de fuego.
 * @property municion La cantidad actual de munición del arma.
 * @property municionARestar La cantidad de municiones a restar al disparar.
 * @property tipoDeMunicion El tipo de munición del arma.
 */
abstract class ArmaDeFuego(
    val nombre: String,
    var municion: Int,
    private val municionARestar: Int,
    val tipoDeMunicion: String,
    ) {

    //VARIABLES ABSTRACTAS:
    abstract  val danio: Int
    abstract val radio: TipoRadio

    companion object{
        //var cantidadMunicionExtra = (5..15).random() //Random.NextInt(5..<16)
        var cantidadMunicionExtra = Random.nextInt(5 , 16)
    }

    //MÉTODOS DE CLASE:
    /**
     * Método para disparar el arma.
     */
    open fun disparar(){
        println("$nombre dispara>> PIUM!!")
        if (municion > 0 ){
            municion -= municionARestar
            if (municion < 0 ){
                println("No puede disparar, no le quedan balas.")
                municion = 0
            }
        }
    }

    /**
     * Método para recargar el arma.
     */
    open fun recarga() {
        println("$nombre intenta recargar.")
        val cantidadARecargar = when (nombre){
            "Pistola" -> 1
            "Rifle" -> 2
            "Bazooka" -> 3
            "Casa" -> 4
            "Coche" -> 5
            else -> 6
        }

        if (cantidadMunicionExtra > 0 && municion <= 0){
            municion += cantidadARecargar
            cantidadMunicionExtra -= cantidadARecargar
            cantidadMunicionExtra = maxOf(0, cantidadMunicionExtra) // Restablecer a 0 si es negativo
        }
    }

    //MOSTRAR INFORMACIÓN:
    /**
     * Representación textual del arma de fuego.
     */
    override fun toString(): String {
        return "Nombre: $nombre, Munición: $municion, Tipo de munición : $tipoDeMunicion, daño: $danio, Radio: ${radio.desc}"
    }

}