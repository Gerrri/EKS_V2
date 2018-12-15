/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;

import eks_v2_hw.entity.Buchung;
import eks_v2_hw.entity.Reise;
import eks_v2_hw.server.db.AlleBuchungen;
import eks_v2_hw.server.db.AlleReisen;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dustin
 */
public class ReiseService {
    
        /**
         * Für eine Reise mit gegebener Reisenummer soll eine neue Buchung erstellt 
         * werden. Es wird hierbei auch der Name des buchendenKunden übergeben. Der 
         * Dienst liefert die Buchungsnummer der neu angelegte n Buchung als String 
         * zurück. Eine Buchungsnummer muss innerhalb des Reisebüros eindeutig sein. 
         * (Eine neue Ressource über eine Assoziation erstellen) 
         * @param registrierungsnummer
         * @param name
         * @return 
         */
    
        @POST
	@Path("reisen/{registrierungsnummer}/bestellung")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String createBuchung (@PathParam("registrierungsnummer") int registrierungsnummer, String name) {
		Reise reise = AlleReisen.getInstance().getReisebyReisenr(registrierungsnummer);
		if (reise != null) {

		        Buchung buchung = AlleBuchungen.getInstance().createBuchung(reise);
			buchung.setNameBesteller(name);

			return Integer.toString(buchung.getBuchungsnr());
		}
		return "";
	}
        
        
        
        
    
}
