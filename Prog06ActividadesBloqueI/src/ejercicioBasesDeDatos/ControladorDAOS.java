
package ejercicioBasesDeDatos;


/**
 *
 * @author gnord
 */
public class ControladorDAOS {

    private MetodosGestionBBDD gestor = new MetodosGestionBBDD();
    private DAODepart depart = new DAODepart(gestor);
    private DAOEmple emple = new DAOEmple(gestor);

    public void conectar(String usr, String pwd) {

        gestor.conexionBBDD("localhost", "xe", usr, pwd);

    }

    public String crearUsuario() {
        System.out.println("Introduzca el usuario");
        String cadena = LeerTeclado.leerCadena();
        return cadena;
    }

    public String crearContraseña() {
        System.out.println("Introduzca la contraseña");
        String cadena = LeerTeclado.leerCadena();
        return cadena;
    }

    public void desconeztar() {
        gestor.cerrarConexion();

    }

    public void buscarEmpleadoporNumero(int numero) {
        String sql = "Select * from emple where emp_no=" + numero;
        emple.visualizarEmpleado(emple.convertirAEmpleado(emple.devolverDatosConsulta(sql), depart));

    }
    
    public void mostrarTodosLosEmpleadosOrdenadosPorDepartamento(){
    String sql="select * from emple order by dept_no";
    emple.visualizarTodosLosEmpleados(emple.devolverDatosConsulta(sql));
    
    }
}
