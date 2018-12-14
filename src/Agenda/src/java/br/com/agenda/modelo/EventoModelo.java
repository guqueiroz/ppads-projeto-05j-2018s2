/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.modelo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author t.lucas.ismael
 */
public class EventoModelo {
    
    
    private Long id;
    private String evento;
    private String data;

    public Long getId() {
        return id;
    }

    public String getEvento() {
        return evento;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getDate() {
        return data;
    }

    public void setDate(String data) {
        this.data = data;
    }

  
    


    
    
    
    
    
    
}
