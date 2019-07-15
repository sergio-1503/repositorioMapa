/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ubicacionDao;
import entidad.ubicacion;

/**
 *
 * @author Usuario
 */
public class ubicacionController {
    
    ubicacionDao dao = null;

    public ubicacionController() {
        
        dao = new ubicacionDao();
        
    }
    
    
    public void inser(ubicacion o) throws Exception{
        
        dao.graba(o);
        
    }
    
    public ubicacion obt() throws Exception{
        
        return dao.obtener();
        
        
    }
    
}
