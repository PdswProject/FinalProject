/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.mailapp;

import javax.mail.MessagingException;

/**
 *
 * @author 2098325
 */
public interface EmailSender {
    void send(Email email) throws MessagingException;
    
}
