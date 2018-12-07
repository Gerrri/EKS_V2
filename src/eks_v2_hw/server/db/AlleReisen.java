/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.db;

import eks_v2_hw.entities.Reise;
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
    
    public boolean addReise(Reise r){
        return this.reisen.add(r);
    }
    
    public boolean removeReisen (Reise r){
        return this.reisen.remove(r);
    }
}
