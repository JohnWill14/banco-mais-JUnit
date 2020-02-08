/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.bean.Categoria;

/**
 *
 * @author usuario
 */
public class CategoriaDao {
    private Connection con;
    {
        try {
            con=ConectionFactory.getConnection();
        } catch (SQLException ex) {
            System.err.println("Erro ao inicializar Conexao:\n=>"+ex);
        }
    }
    public CategoriaDao() {
    }
    
    public boolean save(Categoria categoria){
        String sql="Insert into categoria "
                + "(nome) "
                + "values"
                + "(?);";
        PreparedStatement stm=null;
        try {
            stm=this.con.prepareStatement(sql);
            stm.setString(1, categoria.getNome());
            stm.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar\n=>"+ex);
            return false;
        }finally{
            ConectionFactory.closeConection(con, stm);
        }
        
    }
    public boolean update(Categoria categoria){
        String sql="update categoria "
                + "set nome=? "
                + "where "
                + "id=?;";
        PreparedStatement stm=null;
        try {
            stm=this.con.prepareStatement(sql);
            stm.setString(1, categoria.getNome());
            stm.setInt(2, categoria.getId());
            stm.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar\n=>"+ex);
            return false;
        }finally{
            ConectionFactory.closeConection(con, stm);
        }
        
    }
    public List<Categoria> findAll(){
         String sql="select * from categoria; ";
        PreparedStatement stm=null;
        ResultSet rs=null;
        List<Categoria> lista=new ArrayList<>();
        
        try {
            stm=this.con.prepareStatement(sql);
            rs=stm.executeQuery();
            Categoria cat;
            while(rs.next()){
                cat=new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setNome(rs.getString("nome"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException ex) {
            System.err.println("Erro ao salvar\n=>"+ex);
            return null;
        }finally{
            ConectionFactory.closeConection(con, stm,rs);
        }
    }
    
}
