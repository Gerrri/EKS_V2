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
import java.util.LinkedList;
import java.util.List;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dustin
 */
@Path("reisen")
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
	@Path("{registrierungsnummer}/bestellung")
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
        /**
         * Es soll die Liste aller Reise-Objekte im Format 
         * XML erfragt werden können. 
         * (Auf alle Ressourcen eines Containers zugreifen)
        */
        @GET
        @Path("reisen")
        @Produces(MediaType.APPLICATION_XML)
        public List<Reise> getReisen() {
            List<Reise> reisen = new LinkedList<>();
            
            //erzeuge Return Liste
            for(Reise r: AlleReisen.getInstance().getReisen()){
                Reise help = new Reise();
                help.setPreis(r.getPreis());
                help.setReisenr(r.getReisenr());
                reisen.add(help);
            }
            
            return reisen;
        }
        
        
        /**
         *  Für eine Reise mit gegebener Reisenummer soll die Liste aller Buchungs-
            Objekte dieser Reise im Format XML geliefert werden. 
            (Verfolgung einer Assoziation) 
         * @param reisenr
         * @return 
         */
        @GET
        @Path("{reisenr}/buchungen")
        @Produces(MediaType.APPLICATION_XML)
        public List<Buchung> getReisenByReisenr(@PathParam("{reisenr}")int reisenr) {
            Reise r = AlleReisen.getInstance().getReisebyReisenr(reisenr);
            
            return r.getBuchungen();
        }
        
        
        
        /**
        * Für eine Reise mit gegebener Reisenummer soll der aktuelle Preis erfragt 
          werden. Der Preis wird vom Server als String geliefert. 
          (Projektion)
        */
        @GET
        @Path("{reisenr}/preis")
        @Produces(MediaType.TEXT_PLAIN)
        public String getReisePreisByreisenr(@PathParam("{reisenr}")int reisenr){
            //hole passende Reise und Parse Int werde zu String
            return Integer.toString(AlleReisen.getInstance().getReisebyReisenr(reisenr).getPreis());
        }
        
        
        
        
       
        
        
    
}
