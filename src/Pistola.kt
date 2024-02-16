/**
 * Clase que representa una pistola.
 *
 * @property municion La cantidad actual de munición de la pistola.
 * @property tipoMunicion El tipo de munición de la pistola.
 * @property danio El daño producido por la pistola.
 * @property radio El radio de alcance de la pistola.
 */
class Pistola(municion: Int,
              tipoMunicion: String,
              danio: Int,
              radio: TipoRadio

) : ArmaDeFuego("Pistola", municion, 1, tipoMunicion) {

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
        require(danio in 1..5) { "Error en daño" }
    }

    private fun requireRadio(radio: TipoRadio){
        require(radio == TipoRadio.REDUCIDO || radio == TipoRadio.CORTO) { "Tipo de radio no comprendido." }
    }

    override fun toString(): String {
        return("Nombre: ${super.nombre}, Munición: ${super.municion}, Tipo de munición : ${super.tipoDeMunicion}, daño: $danio, Radio: ${radio.desc}")
    }

}