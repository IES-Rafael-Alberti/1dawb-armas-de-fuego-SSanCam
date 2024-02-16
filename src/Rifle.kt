class Rifle(municion: Int,
    tipoMunicion: String,
    danio: Int,
    radio: TipoRadio

) : ArmaDeFuego("Rifle", municion, 2, tipoMunicion) {

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
        require(danio in 5..10) { "Error en daño" }
    }

    private fun requireRadio(radio: TipoRadio){
        require(radio == TipoRadio.CORTO || radio == TipoRadio.INTERMEDIO) { "Error en radio." }
    }

    override fun toString(): String {
        return("Nombre: ${super.nombre}, Munición: ${super.municion}, Tipo de munición : ${super.tipoDeMunicion}, daño: $danio, Radio: ${radio.desc}")
    }
}
