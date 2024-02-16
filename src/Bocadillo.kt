/**
 * Clase que representa un bocadillo.
 *
 * @property municion La cantidad actual de munición del bocadillo.
 * @property tipoMunicion El tipo de munición del bocadillo.
 * @property danio El daño producido por el olor.
 * @property radio El radio de alcance del olor.
 */
open class Bocadillo(municion: Int,
           tipoMunicion: String,
           danio: Int,
           radio: TipoRadio

) : ArmaDeFuego("Bocadillo", municion, 1, tipoMunicion)  {
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
        require(danio in 20..50) { "Error en daño" }
    }

    private fun requireRadio(radio: TipoRadio){
        require(radio == TipoRadio.OLOR) { "Tipo de radio no comprendido." }
    }

    override fun toString(): String {
        return("Nombre: ${super.nombre}, Munición: ${super.municion}, Tipo de munición : ${super.tipoDeMunicion}, daño: $danio, Radio: ${radio.desc}")
    }
}