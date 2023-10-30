package Modelo

object FactoriaListaCubos {
    fun generaLista (n: Int): ArrayList<Cubo>{
        var lista = ArrayList<Cubo>(1)
        for(i in 0 until n){
            lista.add(FactoriaCubo.generarCubos())
        }
        return lista
    }
}