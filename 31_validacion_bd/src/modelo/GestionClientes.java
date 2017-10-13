package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import beans.Tema;

public class GestionClientes {
	DataSource ds;
    public GestionClientes(){
    	try {
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:comp/env/reflibros");
		} catch (NamingException e) {			
			e.printStackTrace();
		}
        
    }
	public boolean estaRegistrado(String user, String pass) {
		boolean res=false;
		try(Connection con=ds.getConnection();){
			String sql="select * from clientes where usuario=? and password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				res=true;
			}			
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		return res;
	}
	
    public void agregar(String usuario, String password, String email, Integer telefono){
        try(Connection cn=ds.getConnection();) {                       

            String sql="Insert into clientes  (usuario,password,email,telefono) ";
            sql+="values(?,?,?,?)";
            //creamos consulta preparada:
            PreparedStatement ps=cn.prepareStatement(sql);
               //Sustituimos parametros por valores
               ps.setString(1, usuario);
               ps.setString(2,password);
               ps.setString(3, email);
               ps.setInt(4, telefono);
               //ejecutamos
               ps.execute();
            
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }      
    }	
    
    public List<Tema> recuperarTemas(){

        ArrayList<Tema> temas=new ArrayList<>();
        try(Connection cn=ds.getConnection();) {
        	
            String sql="select * from temas";           
            //creamos consulta             
            Statement ps= cn.createStatement();
            ResultSet rs= ps.executeQuery(sql);
            while(rs.next()) {
            	Tema t= new Tema(rs.getInt("idTema"),rs.getString("tema"));
            	temas.add(t);			
			}
        }  catch (SQLException ex) {
            ex.printStackTrace();
        }   
        return temas;
    }    
    
}
