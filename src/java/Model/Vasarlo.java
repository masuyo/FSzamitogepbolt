/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Cressida
 */
public class Vasarlo {
    
    private String nev;
    private String password;
    private ArrayList<Alkatresz> alkatreszek;
    
    public Vasarlo(String nev, String password){
        
        this.alkatreszek = new ArrayList<>();
        this.nev = nev;
        this.password = password;       
    }

    /**
     * @param nev the nev to set
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
     
           /**
     * @return the nev
     */
    public String getNev() {
        return nev;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }
    
        /**
     * @return the alkatreszek
     */
    public ArrayList<Alkatresz> getAlkatreszek() {
        return alkatreszek;
    }

    /**
     * @param alkatreszek the alkatreszek to set
     */
    public void setAlkatreszek(ArrayList<Alkatresz> alkatreszek) {
        this.alkatreszek = alkatreszek;
    }
    
    // nagyon fontos, mert ez hívódik meg, amikor vizsgáljuk egy Vásárló létezését
    // enélkül nem fogja megtalálni a Vásárlót
    @Override
    public boolean equals(Object o) {
        Vasarlo v = ((Vasarlo) o);
        return v.getNev().equals(this.nev) && v.getPassword().equals(v.password);
    }
    
    public void Vasarol(Alkatresz a){
        this.alkatreszek.add(a);
    }
}
