/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Cressida
 */
public class Raktar {
    
    private static ArrayList<Alkatresz> alkatreszValasztek = new ArrayList<>();
    
    static {
        
        getAlkatreszValasztek().add(new Alkatresz("fluxuskondenzator",500));
        getAlkatreszValasztek().add(new Alkatresz("videokartya",1000));
        getAlkatreszValasztek().add(new Alkatresz("vincseszter",500));
        getAlkatreszValasztek().add(new Alkatresz("processzor",100));
       
    }
    
    public static void AddNewAlkatresz(Alkatresz a){
        
        getAlkatreszValasztek().add(a);
        
    }
    
        /**
     * @return the alkatreszValasztek
     */
    public static ArrayList<Alkatresz> getAlkatreszValasztek() {
        return alkatreszValasztek;
    }
    
    public static Alkatresz getAlkatresz(Alkatresz a){
        
        int index = getAlkatreszValasztek().indexOf(a);
        return getAlkatreszValasztek().get(index);
    }
}
