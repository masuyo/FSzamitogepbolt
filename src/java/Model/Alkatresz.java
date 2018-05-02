/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Cressida
 */
public class Alkatresz implements Comparable<Alkatresz> {
    
    private String nev;
    private int ar;
    
    
    public Alkatresz(String nev, int ar)
    {
        this.nev = nev;
        this.ar = ar;
    }
    
         /**
     * @return the nev
     */
    public String getNev() {
        return nev;
    }

    /**
     * @param nev the nev to set
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * @return the ar
     */
    public int getAr() {
        return ar;
    }

    /**
     * @param ar the ar to set
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    @Override
    public int compareTo(Alkatresz o) {
        int compareint = this.nev.compareTo(o.nev);
        return compareint;
    }
}
