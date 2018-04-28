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
public class Vasarlo {
        private String nev;
    private String password;
//    private static Vector alkatreszek = new Vector();
//    private static Vector lehetsegesAlkatreszek = new Vector();
//    
    public Vasarlo(String nev, String password){
        
        this.nev = nev;
        this.password = password;
       
    }
    
//    static
//    {
//        getLehetsegesAlkatreszek().add(new Alkatresz("fluxuskondenzator",500));
//        getLehetsegesAlkatreszek().add(new Alkatresz("videokartya",1000));
//        getLehetsegesAlkatreszek().add(new Alkatresz("vincseszter",500));
//        getLehetsegesAlkatreszek().add(new Alkatresz("processzor",100));
//    }
//    
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
//    public static Vector getAlkatreszek() {
//        return alkatreszek;
//    }
//
//    /**
//     * @param aAlkatreszek the alkatreszek to set
//     */
//    public static void setAlkatreszek(Vector aAlkatreszek) {
//        alkatreszek = aAlkatreszek;
//    }
//
//    /**
//     * @return the lehetsegesAlkatreszek
//     */
//    public static Vector getLehetsegesAlkatreszek() {
//        return lehetsegesAlkatreszek;
//    }
}
