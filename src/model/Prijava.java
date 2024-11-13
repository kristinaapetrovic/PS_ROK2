/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Prijava {
    private Rok rok;
    private Predmet predmet;
    private Student student;
    private Date datum;
    private int ocena;

    public Prijava() {
    }

    public Prijava(Rok rok, Predmet predmet, Student student, Date datum, int ocena) {
        this.rok = rok;
        this.predmet = predmet;
        this.student = student;
        this.datum = datum;
        this.ocena = ocena;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    

    public Rok getRok() {
        return rok;
    }

    public void setRok(Rok rok) {
        this.rok = rok;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prijava other = (Prijava) obj;
        if (!Objects.equals(this.rok, other.rok)) {
            return false;
        }
        if (!Objects.equals(this.predmet, other.predmet)) {
            return false;
        }
        return Objects.equals(this.student, other.student);
    }
    
    
    
}
