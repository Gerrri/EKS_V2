/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.db;

import eks_v2_hw.entity.Buchung;
import eks_v2_hw.entity.Reise;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Dustin
 */
public class AlleBuchungen {
    private static AlleBuchungen instance;
    private final List<Buchung> buchungen;
    
    private AlleBuchungen(){
        buchungen = new ArrayList<Buchung>();
    }
    
    public static synchronized AlleBuchungen getInstance() {
        if (instance == null) {
            instance = new AlleBuchungen();
        }
        return instance;
    }

    public List<Buchung> getBuchungen() {
        return buchungen;
    }
    
    public void addBuchung(Buchung b){
        buchungen.add(b);
    }
    
    public Buchung createBuchung(Reise reise){
      Buchung b = new Buchung();
      
      b.setBuchungsnr(this.buchungen.size()+1);
      reise.addBuchung(b);
      this.addBuchung(b);
      return b;
    }
    
    public List<Buchung> getBuchungByName(String name){
        List<Buchung> lb = new LinkedList<>();
        
        for(Buchung b: buchungen){
            if(b.getNameBesteller().equals(name)){
                lb.add(b);
            }
        }
        
        return lb;
    }
    
    
    
    
}
