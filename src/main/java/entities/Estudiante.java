/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author USER
 */
public class Estudiante {
    int id;
    String nombre;
    String apellido;
    int semestre;
    int creditos_aprobados;
    int solicitud_cancelacion;
    int acudiente;
    int consejero_academico;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCreditos_aprobados() {
        return creditos_aprobados;
    }

    public void setCreditos_aprobados(int creditos_aprobados) {
        this.creditos_aprobados = creditos_aprobados;
    }

    public int getSolicitud_cancelacion() {
        return solicitud_cancelacion;
    }

    public void setSolicitud_cancelacion(int solicitud_cancelacion) {
        this.solicitud_cancelacion = solicitud_cancelacion;
    }

    public int getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(int acudiente) {
        this.acudiente = acudiente;
    }

    public int getConsejero_academico() {
        return consejero_academico;
    }

    public void setConsejero_academico(int consejero_academico) {
        this.consejero_academico = consejero_academico;
    }
    
    
}
