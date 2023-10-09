package modulos

object AlmacenPersona {
    var personas = ArrayList<Persona>()

    fun aniadirPersona(p:Persona){
        personas.add(p)
    }
}