/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.controle;

import br.com.agenda.dao.ContatoDao;
import br.com.agenda.modelo.ContatoModelo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author GUSTAVO
 */
@ManagedBean(name="contatoBean")
@SessionScoped
public class Contatobean {
    
    private ContatoModelo contMode = new ContatoModelo();
    private ContatoDao contatodao = new ContatoDao();
    private List<ContatoModelo> lista = new ArrayList<>();
    
    private ContatoModelo contMode1 = new ContatoModelo();
    private ContatoDao contatodado1 = new ContatoDao();
    private List<ContatoModelo> lista1 = new ArrayList<>();
    
    
    
    
    public Contatobean() {
        buscar();
    }
     
    public ContatoModelo getContMode() {
        return contMode;
    }

    public void setContMode(ContatoModelo contMode) {
        this.contMode = contMode;
    }

    public ContatoDao getContatodao() {
        return contatodao;
    }

    public void setContatodao(ContatoDao contatodao) {
        this.contatodao = contatodao;
    }

    public List<ContatoModelo> getLista() {
        return lista;
    }

    public void setLista(List<ContatoModelo> lista) {
        this.lista = lista;
    }
     
   
    public void salvarDados(){
        if (contMode.getId()==null){
            contatodao.salvar(contMode);
            contMode = new ContatoModelo();
            buscar();
        }else{
          contatodao.alterar(contMode);
          contMode = new ContatoModelo();
          buscar();
        }
    }
    
    public void buscar(){
        lista = contatodao.busca();
    }
    
    public void excluir(ContatoModelo c){
        contMode=c;
        contatodao.deletar(contMode);
        contMode = new ContatoModelo();
        buscar();    
    }
    
    public void alterar(ContatoModelo cont){
        contMode= cont;
    }
    
    ///////////////////evento////
    
    
    
    
    
}
