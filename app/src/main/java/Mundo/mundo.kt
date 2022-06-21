package Mundo
import ean.collections.TArrayList

class Ubica_geografica_punto:Comparable<Ubica_geografica_punto>{
    private var calle = 0
    private var carrera = 0

    //Constructores
    constructor()

    constructor(calle: Int, carrera: Int)
    {this.calle = calle
        this.carrera = carrera
    }

    //analizadores
    fun getCalle()=this.calle
    fun getCarrera()=this.carrera

    //modificadores
    fun setCalle(new_calle:Int){
        if(new_calle >0){this.calle = new_calle}
    }
    fun setCarrera(new_carrera: Int){
        if (new_carrera >0)this.carrera = new_carrera
    }

    override fun compareTo(other: Ubica_geografica_punto): Int {
        if (this.getCalle()>other.getCalle()) {
            return 1
        }else if (other.getCalle()>this.calle)
            return -1
        else{
            if(this.getCarrera()>other.getCarrera()){
                return 1
            }else if (other.getCarrera()>this.carrera){
                return -1
            }else{
                return 0
            }
        }
    }
}
class Accidentado:Comparable<Accidentado>{
    private var nombre:String=""
    private var motivo:String=""
    private var ubicacion=Ubica_geografica_punto()
    constructor()
    constructor(nombre:String, motivo:String, ubicacion:Ubica_geografica_punto){
        this.nombre
        this.motivo
        this.ubicacion
    }
    //analizadores
    fun getNombre()=this.nombre
    fun getMotivo()=this.motivo
    fun getUbicacion()=this.ubicacion

    //modificadoes
    fun setNombre(new_nombre:String){
        if (new_nombre!=null)this.nombre=new_nombre
    }
    fun setMotivo(new_motivo:String){
        if (new_motivo!=null)this.motivo=new_motivo
    }

    fun setUbicacion(new_ubicacion:Ubica_geografica_punto){
        if (new_ubicacion!=null)this.ubicacion=new_ubicacion
    }

    override fun compareTo(other: Accidentado): Int {
        if (this.getNombre() > other.getNombre()) {
          return  1
        }else if (other.getNombre() > this.nombre)
            return -1
        else{
            return 0
        }
}
}
class Ambulancia {
    private var ubicacion= Ubica_geografica_punto()
    private var codigo: Int = 0
    private var estado: Boolean = false
    private var paciente: Accidentado? = null

    constructor()
    constructor(ubicacion: Ubica_geografica_punto, codigo: Int, estado: Boolean, paciente: Accidentado?) {
        this.ubicacion = ubicacion
        this.codigo = codigo
        this.estado = estado
        this.paciente = paciente
    }


    //Analizadores
    fun getCodigo() = this.codigo
    fun getEstado() = this.estado
    fun getPaciente() = this.paciente
    fun getUbicacion() = this.ubicacion
    //Modificadores
    fun setUbicacion(new_ubicacion: Ubica_geografica_punto) {
        if (new_ubicacion != null) this.ubicacion = new_ubicacion
    }
    fun setCodigo(new_codigo: Int) {
        if (new_codigo > 0) this.codigo = new_codigo
    }
    fun setEstado(new_estado: Boolean) {
        if (new_estado != null) this.estado = new_estado
    }
    fun setPaciente(new_paciente: Accidentado?) {
        if (new_paciente != null) this.paciente = new_paciente
    }

//Metodos

    /*
Ingresa un accidentado a la ambulancia
 */
    fun ingresarAccidentado(pacientes: Accidentado) {
        require(estado==false)
        paciente= pacientes
        estado=true
    }

    /*
    Funcion que desocupa una ambulancia
     */
    fun liberarAmbulancia(){
        require(estado==true)
            paciente=null
            estado = false
        }

        /*
        Funcion que obtiene la ubicacion de la ambulancia
         */

        fun cambiarUbicacion(nueva_ubi: Ubica_geografica_punto){
            ubicacion=nueva_ubi
        }

    }
class Hospital:Comparable<Hospital>{
    private var codigo:Int = 0
    private var name:String = ""
    private var hospitalizados =TArrayList<Accidentado>()//Ean coleccion
    private var paciente: Accidentado? = null   //Paciente que se atendera en el hospital
    private var especialidad_uno: String =""
    private var especialidad_dos: String =""
    private var ubicacion: Ubica_geografica_punto = Ubica_geografica_punto()    //Ubicacion del hospital

    constructor()
    constructor(codigo: Int, name: String, hospitalizados: TArrayList<Accidentado>?, paciente: Accidentado?, especialidad_uno: String, especialidad_dos: String, ubicacion: Ubica_geografica_punto) {
        this.codigo = codigo
        this.name = name
        this.hospitalizados = hospitalizados!!
        this.paciente = paciente
        this.especialidad_uno = especialidad_uno
        this.especialidad_dos = especialidad_dos
        this.ubicacion = ubicacion
    }


    //analizadores
    fun getCodigo()=this.codigo
    fun getName()=this.name
    fun getPaciente()=this.paciente
    fun getEspecialidad_uno()=this.especialidad_uno
    fun getEspecialidad_dos()=this.especialidad_dos
    fun getUbicacion()=this.ubicacion
    fun getHospitalizados()=this.hospitalizados

    //modificadores
    fun setCodigo(new_codigo:Int){
        if(new_codigo>0)this.codigo=new_codigo
    }
    fun setName(new_name:String){
        if(new_name!=null)this.name=new_name
    }
    fun setPaciente(new_paciente:Accidentado){
        if(new_paciente!=null)this.paciente=new_paciente
    }
    fun setEspecialidad_uno(new_especialidad_uno:String){
        if(new_especialidad_uno!=null)this.especialidad_uno=new_especialidad_uno
    }
    fun setEspecialidad_dos(new_especialidad_dos:String){
        if(new_especialidad_dos!=null)this.especialidad_dos=new_especialidad_dos
    }
    fun setUbicacion(new_ubicacion:Ubica_geografica_punto){
        if(new_ubicacion!=null)this.ubicacion=new_ubicacion
    }

    fun setHospitalizados(new_hospitalizados:TArrayList<Accidentado>){
        if(new_hospitalizados!=null)this.hospitalizados=new_hospitalizados
    }

    //Metodos
    fun buscarPaciente(nombre: String):Boolean {
        return paciente!!.getNombre() == nombre
        }


fun consultarEspecialidad(especialidad: String):Boolean {
    return especialidad == especialidad_uno || especialidad == especialidad_dos
}

fun ingresarPaciente(paciente: Accidentado, urgencia: String){
    require(urgencia==especialidad_uno || urgencia==especialidad_dos && !hospitalizados.contains(paciente))
        hospitalizados.add(paciente)
    }

    fun retirarPaciente(nombre: String){
    val paciente = hospitalizados.find { it.getNombre() == nombre }
        hospitalizados.removeElement(paciente!!)?: throw Exception("No se encontro el paciente")
    }

    override fun compareTo(other: Hospital): Int {
        if(this.getCodigo()>other.getCodigo()){
            return 1
        }else if(other.getCodigo()>this.codigo){
            return -1
    }
            return 0

    }

    }
fun distancia(pt_inicial: Ubica_geografica_punto, pt_final: Ubica_geografica_punto): Int {
    return (pt_final.getCalle()-pt_inicial.getCalle())+(pt_final.getCarrera()-pt_inicial.getCarrera())
}

//----------------------------------------------Controlador------------------------------------------------------
object sistema_de_emergencia{
     var hospitales = TArrayList<Hospital>()
     var ambulancias = TArrayList<Ambulancia>()

    //Agregar Ambulancia
    fun agregarAmbulancia(codigo: Int, calle: Int, carrera: Int){
        fun verificarAmbulancia(codigo: Int):Boolean{
            for (i in ambulancias){
                if (i.getCodigo()==codigo)return true
            }
            return false
        }
        var a =verificarAmbulancia(codigo)
        if (a!=true){
            ambulancias.add(Ambulancia(Ubica_geografica_punto(calle,carrera),codigo, false,null,))
        }
    }
    //Agregar Hospital
    fun agregarHospital(codigo: Int, nombre: String, calle: Int, carrera: Int, especialidad_uno: String, especialidad_dos: String){
            fun verificarHospital(codigo: Int):Boolean{
                for (i in hospitales){
                    if (i.getCodigo()==codigo)return true
                }
                return false
            }
        val h = verificarHospital(codigo)

        if (h!= true){
            hospitales.add(Hospital(codigo, nombre, null, null, especialidad_uno, especialidad_dos,
                                Ubica_geografica_punto(calle,carrera) ))
        }
    }
    //funcion accidentado
    fun nuev_accidentado(accidentado: Accidentado):Ambulancia?{
        var distacia_minima = distancia(accidentado.getUbicacion(), hospitales[0].getUbicacion())
        var ambulancia_libre = ambulancias[0]
        for (i in ambulancias){
            if(!i.getEstado()){
                if (distancia(i.getUbicacion(),accidentado.getUbicacion())< distacia_minima){
                    distacia_minima = distancia(i.getUbicacion(),accidentado.getUbicacion())
                    ambulancia_libre = i
                }
                return null
                }
            }
        return ambulancia_libre
        }
    //Funcion que actualiza la ubicacion de la ambulancia  ????debemos retornar un valor??
    fun act_ubi_ambulancia(codigo: Int, new_ubi_ambu: Ubica_geografica_punto) {
        //busca la ambulancia con el mismo codigo
        val ambulancia = ambulancias.find { it.getCodigo() == codigo }
        //Verifica si la ambulancia esta libre
        if (!ambulancia!!.getEstado()) {
            //Actualiza la ubicacion de la ambulancia
            ambulancia.cambiarUbicacion(new_ubi_ambu)
        }
    }
    //Funcion que asigna un accidentado a una ambulancia
    fun asignar_ambulancia(ambulancia: Ambulancia, accidentado: Accidentado){
            //Verifica si la ambulancia esta libre
            if(!ambulancia.getEstado()){
                //Asigna el accidentado a la ambulancia
                ambulancia.ingresarAccidentado(accidentado)
                //Actualiza el estado de la ambulancia
                ambulancia.setEstado(true)
            }
        }
    fun buscar_hospital(ambulancia: Ambulancia):Hospital{
            require(ambulancia.getEstado())
            //Verificar los hopitales que atienden la especialidad del accidentado
            val hospital = hospitales.filter { it.consultarEspecialidad(ambulancia.getPaciente()?.getMotivo() !!) }

            val hospital_cerca = hospital.minByOrNull { distancia(it.getUbicacion(), ambulancia.getUbicacion()) }
//--------------------------------------------------------------------
          //verificar que accidentado no exista en los pacientes del hopital
            return if(hospital_cerca?.buscarPaciente(ambulancia.getPaciente()?.getNombre()!!)==true) {
                hospital_cerca
            }else
                null!!
            }
    //llegada de una ambulancia a un hospital
    fun llegada_ambulancia(ambulancia:Ambulancia){
        require(ambulancia.getEstado()==true)
        //buscar el hospital que atiende la especialidad del accidentado
        val hospital = buscar_hospital(ambulancia)
        if(hospital!=null){
            ambulancia.liberarAmbulancia()
            hospital.ingresarPaciente(ambulancia.getPaciente()!! ,ambulancia.getPaciente()!!.getMotivo())
        }

    }
    //Funcion que da de alta a un accidentado
    fun dar_de_alta(codigo: Int, nombre:String){
        //validamos si el hospital existe
        val hospital = hospitales.find { it.getCodigo() == codigo }
        val paciente = hospital!!.getHospitalizados().find { it.getNombre() == nombre }
        if(paciente!=null){
            hospital!!.retirarPaciente(nombre)
        }
    }
}






