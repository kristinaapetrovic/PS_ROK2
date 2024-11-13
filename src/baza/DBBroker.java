/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.util.ArrayList;
import java.util.List;
import model.Rok;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Predmet;
import model.Prijava;
import model.Student;

/**
 *
 * @author Korisnik
 */
public class DBBroker {

    public List<Rok> vratiRokove() {

        try {
            List<Rok> lista = new ArrayList<>();
            String upit = "SELECT * FROM rok";
            Statement st = Konekcija.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                java.util.Date pocetak = new java.util.Date(rs.getDate("datumPocetka").getTime());
                java.util.Date zavrsetak = new java.util.Date(rs.getDate("datumZavrsetka").getTime());
                Rok r = new Rok(id, naziv, pocetak, zavrsetak);
                lista.add(r);
            }

            rs.close();
            st.close();

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Predmet> vratiPredmete() {
        try {
            List<Predmet> lista = new ArrayList<>();
            String upit = "SELECT * FROM predmet";
            Statement st = Konekcija.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int id = rs.getInt("id");
                String naziv = rs.getString("naziv");
                int espb = rs.getInt("espb");
                Predmet p = new Predmet(id, naziv, espb);
                lista.add(p);
            }

            rs.close();
            st.close();

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Prijava> vratiPrijavePoRoku(Rok rok) {

        try {
            List<Prijava> lista = new ArrayList<>();

            String upit = "SELECT * FROM prijava pr JOIN rok r ON r.id=pr.rok JOIN student s ON s.id=pr.student JOIN predmet p ON p.id=pr.predmet WHERE pr.rok=" + rok.getId()+" ORDER BY p.naziv";
            Statement st = Konekcija.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                int rid = rs.getInt("r.id");
                String naziv = rs.getString("r.naziv");
                java.util.Date pocetak = new java.util.Date(rs.getDate("r.datumPocetka").getTime());
                java.util.Date zavrsetak = new java.util.Date(rs.getDate("r.datumZavrsetka").getTime());

                Rok r = new Rok(rid, naziv, pocetak, zavrsetak);

                int pid = rs.getInt("p.id");
                String pnaziv = rs.getString("p.naziv");
                int espb = rs.getInt("p.espb");

                Predmet pred = new Predmet(pid, pnaziv, espb);

                int sid = rs.getInt("s.id");
                String brojIndeksa = rs.getString("s.brojIndeksa");
                String ime = rs.getString("s.ime");
                String prezime = rs.getString("s.prezime");

                Student s = new Student(sid, brojIndeksa, ime, prezime);

                int ocena = rs.getInt("pr.ocena");
                java.util.Date datum = new java.util.Date(rs.getDate("datum").getTime());

                Prijava prijava = new Prijava(rok, pred, s, datum, ocena);
                lista.add(prijava);

            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Prijava> vratiPrijavePoRokuIPredmetu(Rok rok, Predmet predmet) {
        try {
            List<Prijava> lista = new ArrayList<>();

            String upit = "SELECT * FROM prijava pr JOIN rok r ON r.id=pr.rok JOIN student s ON s.id=pr.student JOIN predmet p ON p.id=pr.predmet WHERE pr.rok=" + rok.getId()+" AND pr.predmet="+predmet.getId()+" ORDER BY p.naziv";
            Statement st = Konekcija.getInstance().getConnection().createStatement();

            ResultSet rs = st.executeQuery(upit);

            while (rs.next()) {
                int rid = rs.getInt("r.id");
                String naziv = rs.getString("r.naziv");
                java.util.Date pocetak = new java.util.Date(rs.getDate("r.datumPocetka").getTime());
                java.util.Date zavrsetak = new java.util.Date(rs.getDate("r.datumZavrsetka").getTime());

                Rok r = new Rok(rid, naziv, pocetak, zavrsetak);

                int pid = rs.getInt("p.id");
                String pnaziv = rs.getString("p.naziv");
                int espb = rs.getInt("p.espb");

                Predmet pred = new Predmet(pid, pnaziv, espb);

                int sid = rs.getInt("s.id");
                String brojIndeksa = rs.getString("s.brojIndeksa");
                String ime = rs.getString("s.ime");
                String prezime = rs.getString("s.prezime");

                Student s = new Student(sid, brojIndeksa, ime, prezime);

                int ocena = rs.getInt("pr.ocena");
                java.util.Date datum = new java.util.Date(rs.getDate("datum").getTime());

                Prijava prijava = new Prijava(rok, pred, s, datum, ocena);
                lista.add(prijava);

            }
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean obrisiPrijavu(Prijava prijava) {
   
        try {
            String upit="DELETE FROM prijava WHERE rok=? AND predmet=? AND student=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, prijava.getRok().getId());
            ps.setInt(2, prijava.getPredmet().getId());
            ps.setInt(3, prijava.getStudent().getId());
            
            int red=ps.executeUpdate();
            
            Konekcija.getInstance().getConnection().commit();
            
            return red>0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
