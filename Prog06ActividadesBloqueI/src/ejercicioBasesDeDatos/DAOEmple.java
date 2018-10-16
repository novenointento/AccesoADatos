/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBasesDeDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gnord
 */
public class DAOEmple {

    private MetodosGestionBBDD bbdd;
    private Empleado voEmple;
    int tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
    int tipoActualizacion = ResultSet.CONCUR_UPDATABLE;

    public DAOEmple(MetodosGestionBBDD bbdd) {
        this.bbdd = bbdd;
    }

    public ResultSet devolverDatosConsulta(String sql) {
        ResultSet juegoResultados;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);
        return juegoResultados;
    }

    public Empleado convertirAEmpleado(ResultSet juegoResultados, DAODepart d) {
        Departamento departamento;
        if (juegoResultados != null) {
            try {
                juegoResultados.first();
                GregorianCalendar fecha = null;
                fecha = new GregorianCalendar();
                fecha.setTime(juegoResultados.getDate("fecha_alt"));
                Persona p = new Persona(juegoResultados.getString("apellido"), juegoResultados.getInt("emp_no"));

                departamento = d.buscarDatosUnDepartamento(juegoResultados.getInt("dept_no"));
                Empleado emp = new Empleado(p,
                        juegoResultados.getString("oficio"),
                        juegoResultados.getInt("dir"),
                        juegoResultados.getInt("salario"),
                        juegoResultados.getInt("comision"),
                        departamento,
                        fecha);
                return emp;
            } catch (SQLException ex) {
                //  Logger.getLogger(DAOEmple.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("problemas al leer el empleado");
            }
        } else {
            voEmple = null;
        }
        return voEmple;
    }

    public void visualizarEmpleado(Empleado e) {
        e.mostrarEmpleado();

    }

    public void visualizarTodosLosEmpleados(ResultSet juegoResultados) {
        try {
            int contador = 0;
            while (juegoResultados.next()) {
                contador++;
                System.out.println(juegoResultados.getInt("dept_no")
                        + "\t" + juegoResultados.getInt("emp_no")
                        + "\t" + juegoResultados.getString("apellido")
                        + "\t " + juegoResultados.getString("oficio")
                        + "\t  " + juegoResultados.getInt("dir")
                        + "\t" + juegoResultados.getDate("fecha_alt")
                        + "\t " + juegoResultados.getInt("salario")
                        + "\t" + juegoResultados.getInt("comision")
                        + "\t" + (juegoResultados.getInt("salario") + juegoResultados.getInt("comision")));

            }
            System.out.println("\nTotal Empleados: " + contador);
            juegoResultados.close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmple.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
