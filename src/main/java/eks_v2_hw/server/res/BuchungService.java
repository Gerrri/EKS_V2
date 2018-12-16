/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;

import eks_v2_hw.entity.Buchung;
import eks_v2_hw.entity.Reise;
import eks_v2_hw.server.db.AlleBuchungen;
import java.util.List;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author Dustin
 */
@Path("buchung")
public class BuchungService {
    
    
    /**
    *  Es sollen alle Buchungen für einen gegebenen Kunden abgefragt werden 
       können. Der Kundenname wird hierbei als String übergeben. Rückgabe ist die 
       Menge an entsprechenden Buchungsobjekte in XML. (Selektion)
    */
    @GET
    @Path("{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_XML)
    public List<Buchung> getBuchung(@PathParam("{name}") String name){
        return AlleBuchungen.getInstance().getBuchungByName(name);
    }
    
    /**
     * Abfrage der Veranstalter-Ressource für einen Veranstalter mit gegebenem 
       Namen. Als Rückgabe soll eine XML-Beschreibung der Ressource geliefert werden. 
       (Eine einzelne Ressource adressieren)
     */
    
    
    
    
    
   /* @POST
    @Path("{nr}/transaktionen")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public TransaktionResponse addTransaktion(@PathParam("nr") int nr, Transaktion transaktion) {
        Konto konto = AlleKonten.getInstance().getKonto(nr);
        if (konto != null) {
            if (konto.addAktionen(transaktion)) {
                return new TransaktionResponse(konto.getKunde().getName(), konto.getStand());
            }
        }
        return null;
    }
*/
}
