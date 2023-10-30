package Modelo

import kotlin.random.Random

object FactoriaCubo {
    fun generarCubos(): Cubo{
        val rng = Random
        var nombres = listOf("Cubo 3x3", "Cubo 4x4", "Cubo 5x5", "Megamix", "Mirror")
        var imagenes = listOf("cubo3x3.jpg","cubo4x4.jpg","cubo5x5.webp","cubomirror.jpg","cubomegamix.jpg")
        val marcasDeCubos = listOf("Rubik's Cube", "GAN", "MoYu", "QiYi", "YJ", "Valk", "Dayan", "Cyclone Boys")
        var indices = rng.nextInt(4)
        var cubo = listOf(nombres[indices],imagenes[indices])
        var marcas = marcasDeCubos.indices.random()
        var rating = rng.nextInt(6)
        var c = Cubo(cubo[0],cubo[1],rating, marcasDeCubos[(marcasDeCubos.indices).random()])
        return c
    }
}