package br.com.agenda.dao;

import br.com.agenda.jdbc.FazConexao;
import br.com.agenda.modelo.ContatoModelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ContatoDao {

    PreparedStatement pst;
    ResultSet rs;
    String sql;
    Connection conexao;
    
    
    public void salvar(ContatoModelo cont){
        
        sql="INSERT INTO contato(nome,email,sexo,telefone,rua,complemento,numero,bairro,cidade,uf) values(?,?,?,?,?,?,?,?,?,?) ";
        
        try {
            Connection conecta= FazConexao.getConexao();
            pst=(PreparedStatement) conecta.prepareStatement(sql);
            pst.setString(1, cont.getNome());
            pst.setString(2, cont.getEmail());
            pst.setString(3, cont.getSexo());
            pst.setString(4, cont.getTelefone());
            pst.setString(5, cont.getRua());
            pst.setString(6, cont.getComplemento());
            pst.setInt(7, cont.getNumero());
            pst.setString(8, cont.getBairro());
            pst.setString(9, cont.getCidade());
            pst.setString(10, cont.getUf());
            
            pst.execute();  // faz O cadastro no banco.
            FazConexao.getConexao().close();
            System.out.println("Cadastrou");
            
            
            
            
        } catch (Exception e) {
                System.out.println("Não cadastrou "+e);
            
        }
        
        
    }
    
    public List busca(){
        sql = "select * from contato";
        List<ContatoModelo> lista = new ArrayList<>();
        
        try {
            conexao = FazConexao.getConexao();
            pst = (PreparedStatement) conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
            ContatoModelo cont = new ContatoModelo();
            cont.setId(rs.getInt("id"));
            cont.setNome(rs.getString("nome"));
            cont.setEmail(rs.getString("email"));
            cont.setSexo(rs.getString("sexo"));
            cont.setTelefone(rs.getString("telefone"));
            cont.setRua(rs.getString("rua"));
            cont.setComplemento(rs.getString("complemento"));
            cont.setNumero(rs.getInt("numero"));
            cont.setBairro(rs.getString("bairro"));
            cont.setCidade(rs.getString("cidade"));
            cont.setUf(rs.getString("uf"));
            lista.add(cont);                
            }
           FazConexao.getConexao().close();
        }catch (Exception e) {
            System.out.println("Erro na consulta!");
        }        
        return lista;
    }
    public void deletar (ContatoModelo cont) {
        sql= "DELETE FROM contato where id=?";
        try{
            conexao=FazConexao.getConexao();
            pst = (PreparedStatement) conexao.prepareStatement(sql);
            pst.setInt(1, cont.getId());
            pst.execute();
            FazConexao.getConexao().close();
            System.out.println("Apagou");
        } catch (Exception e) {
            System.out.println("Não Apagou" +e);
        }
    }
    
    public void alterar(ContatoModelo dado){
        sql="UPDATE contato SET nome=?, email=?, sexo=?, telefone=?, rua=?, complemento=?, numero=?, bairro=?, cidade=?, uf=? where id=?";
        
        try {
            conexao=FazConexao.getConexao();
            pst=(PreparedStatement)conexao.prepareStatement(sql);
            pst.setString(1,dado.getNome());
            pst.setString(2,dado.getEmail());
            pst.setString(3,dado.getSexo());
            pst.setString(4,dado.getTelefone());
            pst.setString(5,dado.getRua());
            pst.setString(6,dado.getComplemento());
            pst.setInt(7,dado.getNumero());
            pst.setString(8,dado.getBairro());
            pst.setString(9,dado.getCidade());
            pst.setString(10,dado.getUf());
            pst.setInt(11,dado.getId());
            pst.execute();
            FazConexao.getConexao().close();
            System.out.println("Alterou");        
        } catch (Exception e) {
            System.out.println ("Não alterou)"+e);
        }
    }
    
    
    ////////////////////// evento ////
    
    public void salvar1(ContatoModelo cont){
        
        sql="INSERT INTO contato(evento,data) values(?,?) ";
        
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
    
    public List busca1(){
        sql = "select * from contato";
        List<ContatoModelo> lista1 = new ArrayList<>();
        
        try {
            conexao = FazConexao.getConexao();
            pst = (PreparedStatement) conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
            ContatoModelo cont = new ContatoModelo();
            cont.setEvento(rs.getString("evento"));
            cont.setData(rs.getString("data"));         
            lista1.add(cont);                
            }
           FazConexao.getConexao().close();
        }catch (Exception e) {
            System.out.println("Erro na consulta!");
        }        
        return lista1;
    }
    
    public void deletar1 (ContatoModelo cont) {
        sql= "DELETE FROM contato where id=?";
        try{
            conexao=FazConexao.getConexao();
            pst = (PreparedStatement) conexao.prepareStatement(sql);
            pst.setInt(1, cont.getId());
            pst.execute();
            FazConexao.getConexao().close();
            System.out.println("Apagou");
        } catch (Exception e) {
            System.out.println("Não Apagou" +e);
        }
    }
    
    
    public void alterar1(ContatoModelo dado){
        sql="UPDATE contato SET evento=?, data=?";
        
        try {
            conexao=FazConexao.getConexao();
            pst=(PreparedStatement)conexao.prepareStatement(sql);
            pst.setString(1,dado.getEvento());
            pst.setString(2,dado.getData());           
            pst.execute();
            FazConexao.getConexao().close();
            System.out.println("Alterou");        
        } catch (Exception e) {
            System.out.println ("Não alterou)"+e);
        }
    }
    
    
}

    
    
    
    
    
    
    
    
    
    
