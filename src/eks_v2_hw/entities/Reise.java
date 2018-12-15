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
public class Reise {
    int reisenr;
    int preis;
    
    //Reise -> Buchung
    List<Buchung> buchungen;

    public Reise() {
        //Reise -> Buchung
        this.buchungen = new ArrayList<>();
    }
    
    @XmlElement(name="reisenr")
    public int getReisenr() {
        return reisenr;
    }

    public void setReisenr(int reisenr) {
        this.reisenr = reisenr;
    }

    @XmlElement(name="preis")
    public int getPreis() {
        return preis;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }
    
    //Reise -> Buchung
    public void addBuchung(Buchung b){
        buchungen.add(b);
    }
    
    //Reise -> Buchung
    @XmlElement(name="buchungen")
    public List<Buchung> getBuchungen(){
        return buchungen;
    }
    
    
    
}
