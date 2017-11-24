/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

/**
 *
 * @author USER
 */
public class ExcepcionSolicitudes extends Exception {
    
    public ExcepcionSolicitudes() {
    }

    public ExcepcionSolicitudes(String message) {
        super(message);
    }

    public ExcepcionSolicitudes(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcepcionSolicitudes(Throwable cause) {
        super(cause);
    } 
    
}
