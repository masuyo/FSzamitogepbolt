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
       
       Vasarlo V1 = new Vasarlo("Babayaga","aaa");
       V1.Vasarol(Raktar.getAlkatreszValasztek().get(0));
       V1.Vasarol(Raktar.getAlkatreszValasztek().get(1));
       this.vasarlok.add(V1);
       
       Vasarlo V2 = new Vasarlo("Lolita","aaa");
       V2.Vasarol(Raktar.getAlkatreszValasztek().get(1));
       V2.Vasarol(Raktar.getAlkatreszValasztek().get(2));
       V2.Vasarol(Raktar.getAlkatreszValasztek().get(3));
       V2.Vasarol(Raktar.getAlkatreszValasztek().get(1));
       this.vasarlok.add(V2);
       
       Vasarlo V3 = new Vasarlo("Bobby","aaa");
       V3.Vasarol(Raktar.getAlkatreszValasztek().get(1));
       V3.Vasarol(Raktar.getAlkatreszValasztek().get(1));
       V3.Vasarol(Raktar.getAlkatreszValasztek().get(3));
       V3.Vasarol(Raktar.getAlkatreszValasztek().get(2));
       V3.Vasarol(Raktar.getAlkatreszValasztek().get(0));
       V3.Vasarol(Raktar.getAlkatreszValasztek().get(1));
       this.vasarlok.add(V3);
    }

    /**
     * @return the vasarlok
     */
    public ArrayList<Vasarlo> getVasarlok() {
        return vasarlok;
    }
    
    // adatrejtés miatt csekkolom így, hogy kívülről ne legyen fölöslegesen elérhető ennek
    // az osztálynak a listája, amikor csak arra az információra van szükségem, hogy tartalmazza-e
    // az általam keresett Vásárló objektumot
    public boolean IsVasarloExist(Vasarlo v){
        return this.getVasarlok().contains(v);
    }
    
    // itt addolom a Vásárlók listámhoz az új Vásárlókat, a regisztrációnál van rá szükség
    public void AddVasarlo(Vasarlo v){
        this.getVasarlok().add(v);
    }
    
    // így nyerem ki a listát, mivel sessionbe csak a bejelentkezett, új Vásárló objektumot mentem,
    // így az nem rendelkezik a "behuzalozott" lista elemeivel
    public ArrayList<Alkatresz> getCurrentAlkatreszek(Vasarlo v){
        
        int i;
        i = this.vasarlok.indexOf(v);
        return this.vasarlok.get(i).getAlkatreszek();
    }
}
