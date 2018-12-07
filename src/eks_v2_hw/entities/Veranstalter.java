/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dustin
 */
@XmlRootElement
public class Veranstalter {
    private String name;
    private String adresse;
    
    //Assoziation -> Reise
    private List<Reise> reisen;

    public Veranstalter() {
        //Assoziation -> Reise
        this.reisen = new ArrayList<Reise>();
    }

    @XmlElement(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name="adresse")
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    //Assoziation -> Reise
    public void addReise(Reise r){
        reisen.add(r);
    }
    //Assoziation -> Reise
    @XmlElement(name="reisen")
    public List<Reise> getReisen(){
        return reisen;
    }
    
    
    
}
