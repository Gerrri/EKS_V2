/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.db;

import eks_v2_hw.entity.Veranstalter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dustin
 */
public class AlleVeranstaltungen {
    private static AlleVeranstaltungen instance;
    private final List<Veranstalter> veranstalter;
    
    
    private AlleVeranstaltungen(){
        veranstalter = new ArrayList<Veranstalter>();
    }
    
    public static synchronized AlleVeranstaltungen getInstance() {
        if (instance == null) {
            instance = new AlleVeranstaltungen();
        }
        return instance;
    }
    
    public List<Veranstalter> getVeranstalter(){
        return this.veranstalter;
    } 
    
    public Veranstalter getVeranstalterByName(String name){
        for(Veranstalter v: veranstalter){
            if(v.getName() == name){
                return v;
            }
        }
        
        return null;
    }
    
    public boolean addVeranstaler(Veranstalter v){
        return this.veranstalter.add(v);
    }
    
    public boolean delVeranstaler(Veranstalter v){
        return this.veranstalter.remove(v);
    }
}
