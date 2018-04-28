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
public class VasarloDB {
    
    private ArrayList<Vasarlo> vasarlok;
    
    public VasarloDB(){
        
       this.vasarlok = new ArrayList<>(); 
       this.vasarlok.add(new Vasarlo("Babayaga","aaa"));
       this.vasarlok.add(new Vasarlo("Lolita","aaa"));
       this.vasarlok.add(new Vasarlo("Bobby","aaa"));
    }

    // adatrejtés miatt csekkolom így, hogy kívülről ne legyen fölöslegesen elérhető ennek
    // az osztálynak a listája, amikor csak arra az információra van szükségem, hogy tartalmazza-e
    // az általam keresett Vásárló objektumot
    public boolean IsVasarloExist(Vasarlo v){
        return this.vasarlok.contains(v);
    }
    
    // itt addolom a Vásárlók listámhoz az új Vásárlókat, a regisztrációnál van rá szükség
    public void AddVasarlo(Vasarlo v){
        this.vasarlok.add(v);
    }
}
