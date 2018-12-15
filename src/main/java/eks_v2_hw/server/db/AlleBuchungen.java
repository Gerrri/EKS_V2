/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.db;

import eks_v2_hw.entity.Buchung;
import java.util.ArrayList;
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
    
    
    
    
}
