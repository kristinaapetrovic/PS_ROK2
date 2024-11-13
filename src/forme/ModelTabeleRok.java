/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Rok;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleRok extends AbstractTableModel {

    List<Rok> lista=new ArrayList<>();
    String [] kolone={"naziv", "datum pocetka","datum zavrsetka"};

    public ModelTabeleRok(List<Rok> lista) {
        this.lista = lista;
    }

    public List<Rok> getLista() {
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
        SimpleDateFormat format=new SimpleDateFormat("dd.MM.yyyy.");
        Rok r=lista.get(rowIndex);
        switch(columnIndex){
            case 0: return r.getNaziv();
            case 1: return format.format(r.getDatumPocetka());
            case 2: return format.format(r.getDatumZavrsetka());
            default: return "n/a";
        }
    
    
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}
