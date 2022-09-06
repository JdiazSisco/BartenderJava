/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.List;
import domain.Vaso;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class VasoDAO {

    //Cadena SQL utilizada para la consulta de los vasos
    private static final String SQL_SELECT = "SELECT * FROM arrays WHERE id=?";

    /**
     * Metodo que realiza la consulta de todos los registros de la tabla vasos
     *
     * @return Listado de Vasos
     */
//    public List<Vaso> consultaVasos(int idArray) {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//        Vaso vaso = null;
//        List<Vaso> vasos = new ArrayList<>();
//
//        try {
//            conn = Conexion.getConnection();
//            stmt = conn.prepareStatement(SQL_SELECT);
//            stmt.setInt(1, idArray);
//            rs = stmt.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String inputArray = rs.getString("input_array");
//                vaso = new Vaso(id, inputArray);
//                vasos.add(vaso);
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace(System.out);
//        } finally {
//            try {
//                Conexion.close(rs);
//                Conexion.close(stmt);
//                Conexion.close(conn);
//            } catch (SQLException ex) {
//                ex.printStackTrace(System.out);
//            }
//        }
//        return vasos;
//    }
    public String consultaVasos(int idArray) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vaso vaso = null;
        String cadena = "";

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setInt(1, idArray);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                cadena = rs.getString("input_array");

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return cadena;
    }
}
