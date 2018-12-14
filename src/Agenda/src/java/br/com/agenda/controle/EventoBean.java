/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.controle;

import br.com.agenda.dao.EventoDAO;
import br.com.agenda.modelo.EventoModelo;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author GUSTAVO
 */
@ManagedBean(name="eventoBean")
@SessionScoped
public class EventoBean {
    
    private EventoModelo eventoModelo = new EventoModelo();
    private EventoDAO contatodao1 = new EventoDAO();
    private List<EventoModelo> lista = new ArrayList<>();
    
    
    
    
    public EventoBean() {
        buscar1();
        
    }
     
  

    public EventoDAO getContatodao1() {
        return contatodao1;
    }

    public void setContatodao1(EventoDAO contatodao1) {
        this.contatodao1 = contatodao1;
    }

    public List<EventoModelo> getLista() {
        return lista;
    }

    public void setLista(List<EventoModelo> lista) {
        this.lista = lista;
    }

    public EventoModelo getEvento() {
        return eventoModelo;
    }

    public void seteEvento(EventoModelo eventoModel) {
        this.eventoModelo = eventoModel;
    }

    
    
  
    
     
   
    public void salvarDados1(){
        if (eventoModelo.getId()==null){
            contatodao1.salvar(eventoModelo);
            eventoModelo = new EventoModelo();
            buscar1();
        }else{
          contatodao1.alterar(eventoModelo);
          eventoModelo = new EventoModelo();
          buscar1();
        }
    }
    
    public void buscar1(){
        lista = contatodao1.busca();
    }
    
    public void excluir1(EventoModelo c){
        eventoModelo=c;
        contatodao1.deletar(eventoModelo);
        eventoModelo = new EventoModelo();
        buscar1();    
    }
    
    public void alterar1(EventoModelo cont){
        eventoModelo= cont;
    }
    
}
