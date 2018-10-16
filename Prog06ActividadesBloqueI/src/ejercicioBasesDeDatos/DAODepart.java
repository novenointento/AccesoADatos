/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioBasesDeDatos;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gnord
 */
public class DAODepart {

    private MetodosGestionBBDD bbdd;
    private Departamento voDepart;
    int tipoResultado = ResultSet.TYPE_SCROLL_SENSITIVE;
    int tipoActualizacion = ResultSet.CONCUR_UPDATABLE;

    public DAODepart(MetodosGestionBBDD bbdd) {
        this.bbdd = bbdd;
    }

    public Departamento buscarDatosUnDepartamento(int dept_no) {
        ResultSet juegoResultados;
        String sql = "select * from depart where dept_no = " + dept_no;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);

        if (juegoResultados != null) {
            try {
                while (juegoResultados.next()) {

                    voDepart = new Departamento(juegoResultados.getInt("dept_no"),
                            juegoResultados.getString("dnombre"),
                            juegoResultados.getString("loc"));
                }
                juegoResultados.close();
            } catch (SQLException ex) {
                System.out.println("Problemas con el departamento no existe");
            }
        } else {
            voDepart = null;
        }

        return voDepart;

    }

    public ResultSet devolverDatosConsultaDepart(String sql) {
        ResultSet juegoResultados;
        juegoResultados = bbdd.ejecutarStatementSELECT(sql, tipoResultado, tipoActualizacion);
        return juegoResultados;
    }

}
