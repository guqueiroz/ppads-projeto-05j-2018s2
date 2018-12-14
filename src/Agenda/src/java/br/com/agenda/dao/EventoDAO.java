package br.com.agenda.dao;

import br.com.agenda.jdbc.FazConexao;
import br.com.agenda.modelo.ContatoModelo;
import br.com.agenda.modelo.EventoModelo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class EventoDAO {

    PreparedStatement pst;
    ResultSet rs;
    String sql;
    Connection conexao;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    
    public void salvar(EventoModelo eventoModelo){
        
        sql="INSERT INTO agenda.Evento (evento,data) values(?,?) ";
        
        try {
            Connection conecta= FazConexao.getConexao();
            pst=(PreparedStatement) conecta.prepareStatement(sql);
            pst.setString(1, eventoModelo.getEvento());
            pst.setDate(2, new Date(sdf.parse(eventoModelo.getDate()).getTime()));
     
            
            pst.execute();  // faz O cadastro no banco.
            FazConexao.getConexao().close();
            System.out.println("Cadastrou");
            
            
            
            
        } catch (Exception e) {
                System.out.println("Não cadastrou "+e);
            
        }
        
        
    }
    
    public List busca(){
        sql = "select id,evento,data from agenda.Evento";
        List<EventoModelo> lista = new ArrayList<>();
        
        try {
            conexao = FazConexao.getConexao();
            pst = (PreparedStatement) conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
            EventoModelo eventoModelo = new EventoModelo();
            eventoModelo.setId(rs.getLong("id"));
            eventoModelo.setEvento(rs.getString("evento"));
            eventoModelo.setDate(sdf.format(rs.getDate("data")));
        
            lista.add(eventoModelo);                
            }
           FazConexao.getConexao().close();
        }catch (Exception e) {
            System.out.println("Erro na consulta!");
        }        
        return lista;
    }
    public void deletar (EventoModelo eventoModelo) {
        sql= "DELETE FROM agenda.Evento where id=?";
        try{
            conexao=FazConexao.getConexao();
            pst = (PreparedStatement) conexao.prepareStatement(sql);
            pst.setLong(1, eventoModelo.getId());
            pst.execute();
            FazConexao.getConexao().close();
            System.out.println("Apagou");
        } catch (Exception e) {
            System.out.println("Não Apagou" +e);
        }
    }
    
    public void alterar(EventoModelo eventoModelo){
        sql="UPDATE agenda.Evento SET evento=?, data=? where id=?";
        
        try {
            conexao=FazConexao.getConexao();
            pst=(PreparedStatement)conexao.prepareStatement(sql);
           pst.setString(1, eventoModelo.getEvento());
            pst.setDate(2, new Date(sdf.parse(eventoModelo.getDate()).getTime()));
            pst.setLong(3,eventoModelo.getId());
            
            pst.execute();
            FazConexao.getConexao().close();
            System.out.println("Alterou");        
        } catch (Exception e) {
            System.out.println ("Não alterou)"+e);
        }
    }
    
    
    ////////////////////// evento ////
    
    public void salvar1(ContatoModelo cont){
        
        sql="INSERT INTO agenda.Evento(evento,data) values(?,?) ";
        
        try {
            Connection conecta= FazConexao.getConexao();
            pst=(PreparedStatement) conecta.prepareStatement(sql);
            pst.setString(1, cont.getEvento());
            pst.setString(2, cont.getData());                       
            pst.execute();  // faz O cadastro no banco.
            FazConexao.getConexao().close();
            System.out.println("Cadastrou");       
        } catch (Exception e) {
                System.out.println("Não cadastrou "+e);           
        }       
    }
    
    }
    


    
    
    
    
    
    
    
    
    
    
