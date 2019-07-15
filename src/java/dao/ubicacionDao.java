/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import databse.bd;
import entidad.ubicacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ubicacionDao implements uni.dao.Icrud<ubicacion> {

    @Override
    public void graba(ubicacion o) throws Exception {
    
        Connection cn = null;
        try {
            cn = bd.getConnection();
            String query = "insert into dbo.ubicacion(latitud,longitud) values(?,?)";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setFloat(1, o.getLat());
            pstm.setFloat(2, o.getLongi());
            
            pstm.executeUpdate();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception ex) {
            }
        }
    }

    @Override
    public void modifica(ubicacion o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void elimina(ubicacion o) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ubicacion> lista() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ubicacion obtener() throws Exception{
        
        ubicacion aux = null;
        
        Connection cn = null;
        try {
            cn = bd.getConnection();
            String query = "SELECT TOP 1 * FROM dbo.ubicacion order by 1 desc ;";
            PreparedStatement pstm = cn.prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            //if porque recorre un sola fila
            if (rs.next()) {
                
                aux = new ubicacion();
                aux.setId(rs.getInt(1));
                aux.setLat(rs.getFloat(2));
                aux.setLongi(rs.getFloat(3));
                               
                
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
            throw e;
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        
        return aux;
    }
    
    
    
}
