/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dustin
 */
@XmlRootElement
public class Buchung {
    int buchungsnr;
    String nameBesteller;
    
    //Buchung -> Reise
    Reise reise;

    public Buchung() {
        
    }

    @XmlElement(name="buchungsnr")
    public int getBuchungsnr() {
        return buchungsnr;
    }

    public void setBuchungsnr(int buchungsnr) {
        this.buchungsnr = buchungsnr;
    }

    @XmlElement(name="nameBesteller")
    public String getNameBesteller() {
        return nameBesteller;
    }

    public void setNameBesteller(String nameBesteller) {
        this.nameBesteller = nameBesteller;
    }

    //Buchung -> Reise
    @XmlElement(name="reise")
    public Reise getReise() {
        return reise;
    }

    public void setReise(Reise reise) {
        this.reise = reise;
    }
    
    
    
}
