/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.List;
import model.Predmet;
import model.Prijava;
import model.Rok;

/**
 *
 * @author Korisnik
 */
public class Controller {
    
    private static Controller instance;
    private DBBroker dbb=new DBBroker();
    
    private Rok odabraniRok;

    public Rok getOdabraniRok() {
        return odabraniRok;
    }

    public void setOdabraniRok(Rok odabraniRok) {
        this.odabraniRok = odabraniRok;
    }
    
    private Controller() {
        
        
    }

    
    
    public static Controller getInstance() {
        if(instance==null) instance=new Controller();
        return instance;
    }

    public List<Rok> vratiRokove() {
        return dbb.vratiRokove();
    }

    public List<Predmet> vratiPredmete() {
        return dbb.vratiPredmete();
    }

    

    public List<Prijava> vratiPrijavePoRoku(Rok rok) {
        return dbb.vratiPrijavePoRoku(rok);
    }

    public List<Prijava> vratiPrijavePoRokuIPredmetu(Rok rok, Predmet predmet) {
        return dbb.vratiPrijavePoRokuIPredmetu(rok, predmet);
    }

    public boolean obrisiPrijavu(Prijava prijava) {
        return dbb.obrisiPrijavu(prijava);
    }
    
    
    
}
