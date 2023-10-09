package com.example.planetas

class Planeta(
    var nombre: String,
    var tipo: String,
    var radio: Double,
    var gravedad: Double,
    var masa: Double,
    var distancia_Sol: Double) {

    override fun toString(): String {
        return "Nombre: $nombre \nTipo: $tipo \nRadio: $radio \nGravedad: $gravedad \nMasa: $masa \nDistancia del sol: $distancia_Sol"
    }
}