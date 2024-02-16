/**
 * Clase que representa un bazooka.
 *
 * @property municion La cantidad actual de munición del bazooka.
 * @property tipoMunicion El tipo de munición del bazooka.
 * @property danio El daño producido por el bazooka.
 * @property radio El radio de alcance del bazooka.
 */
class Bazooka(municion: Int,
              tipoMunicion: String,
              danio: Int,
              radio: TipoRadio

) : ArmaDeFuego("Bazooka", municion, 3, tipoMunicion) {

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
        require(danio in 10..30) { "Error en daño" }
    }

    private fun requireRadio(radio: TipoRadio){
        require(radio == TipoRadio.INTERMEDIO || radio == TipoRadio.ENORME) { "Tipo de radio no comprendido." }
    }

    override fun toString(): String {
        return("Nombre: ${super.nombre}, Munición: ${super.municion}, Tipo de munición : ${super.tipoDeMunicion}, daño: $danio, Radio: ${radio.desc}")
    }
}