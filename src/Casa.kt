/**
 * Clase que representa una casa.
 *
 * @property municion La cantidad actual de munición de la casa.
 * @property tipoMunicion El tipo de munición de la casa.
 * @property danio El daño producido por el confetti.
 * @property radio El radio de alcance del confetti.
 */
open class Casa(municion: Int,
           tipoMunicion: String,
           danio: Int,
           radio: TipoRadio

) : ArmaDeFuego("Confetti", municion, 20, tipoMunicion)  {
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
        require(danio in 0..1) { "Error en daño" }
    }

    private fun requireRadio(radio: TipoRadio){
        require(radio == TipoRadio.REDUCIDO || radio == TipoRadio.DISPERSION) { "Tipo de radio no comprendido." }
    }

    override fun toString(): String {
        return("Nombre: ${super.nombre}, Munición: ${super.municion}, Tipo de munición : ${super.tipoDeMunicion}, daño: $danio, Radio: ${radio.desc}")
    }
}