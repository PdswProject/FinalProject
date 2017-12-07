/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.mailapp;

/**
 *
 * @author 2098325
 */
public interface Email {
    
    String getFrom();

    String getTo();

    String getCc();

    String getBcc();

    String getSubject();

    String getMessage();
    
}
