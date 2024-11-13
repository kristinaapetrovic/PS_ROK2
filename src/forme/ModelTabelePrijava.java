/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Prijava;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePrijava extends AbstractTableModel{

    List<Prijava> lista=new ArrayList<>();
    String [] kolone={"naziv predmeta","broj indeksa","ime","prezime","datum","ocena"};

    public ModelTabelePrijava(List<Prijava> lista) {
        this.lista = lista;
    }

    public List<Prijava> getLista() {
        return lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    
        Prijava p=lista.get(rowIndex);
        SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
        
        switch(columnIndex){
            case 0: return p.getPredmet().getNaziv();
            case 1: return p.getStudent().getBrojIndeksa();
            case 2: return p.getStudent().getIme();
            case 3: return p.getStudent().getPrezime();
            case 4: return format.format(p.getDatum());
            case 5: return p.getOcena()+"";
            default: return "n/a";
        }
    
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
