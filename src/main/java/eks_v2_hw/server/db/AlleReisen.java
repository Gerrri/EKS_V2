/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.db;

import eks_v2_hw.entity.Reise;
import eks_v2_hw.entity.Veranstalter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dustin
 */
public class AlleReisen {
    private static AlleReisen instance;
    private final List<Reise> reisen;

    private  AlleReisen() {
        this.reisen = new ArrayList<Reise>();
    }
    
    public static synchronized AlleReisen getInstance() {
        if (instance == null) {
            instance = new AlleReisen();
        }
        return instance;
    }
    
    public List<Reise> getReisen (){
        return this.reisen;
    }
    
    public Reise getReisebyReisenr(int nr){
        
        for(Reise r:reisen){
            if(r.getReisenr()==nr){
                return r;
            }
        }
        
        return null;
        
    }
    
    public boolean addReise(Reise r){
        return this.reisen.add(r);
    }
    
    public boolean removeReisen (Reise r){
        return this.reisen.remove(r);
    }
    
    public Reise createReise(Veranstalter v){
        Reise r = new Reise();
        r.setReisenr(reisen.size()+1);
        v.addReise(r);
        
        return r;
    }
}
