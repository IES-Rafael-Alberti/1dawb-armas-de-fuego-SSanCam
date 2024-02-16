/**
 * Clase que representa un coche.
 *
 * @property municion La cantidad actual de munición de la coche.
 * @property tipoMunicion El tipo de munición de la coche.
 * @property danio El daño producido por el haz de luz.
 * @property radio El radio de alcance del haz de luz.
 */
open class Coche(municion: Int,
           tipoMunicion: String,
           danio: Int,
           radio: TipoRadio

) : ArmaDeFuego("Ráfaga luminosa", municion, 1, tipoMunicion)  {
    override var danio: Int = danio
        set(value) {
            requireDanio(value)
            field = value
        }
    override var radio: TipoRadio = radio
        set(value) {
            requireRadio(value)
            field = value
        }

    private fun requireDanio(danio: Int){
        require(danio == 0) { "Error en daño" }
    }

    private fun requireRadio(radio: TipoRadio){
        require(radio == TipoRadio.RAYO_LUZ) { "Tipo de radio no comprendido." }
    }

    override fun toString(): String {
        return("Nombre: ${super.nombre}, Munición: ${super.municion}, Tipo de munición : ${super.tipoDeMunicion}, daño: $danio, Radio: ${radio.desc}")
    }
}