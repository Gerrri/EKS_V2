/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;

import eks_v2_hw.entity.Buchung;
import eks_v2_hw.server.db.AlleBuchungen;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author Dustin
 */
@Path("buchungen")
public class BuchungService {
    /**
    *  Es sollen alle Buchungen für einen gegebenen Kunden abgefragt werden 
       können. Der Kundenname wird hierbei als String übergeben. Rückgabe ist die 
       Menge an entsprechenden Buchungsobjekte in XML. (Selektion)
    */
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_XML)
    public List<Buchung> getBuchung(@QueryParam("name") String name){
        List<Buchung> lb = AlleBuchungen.getInstance().getBuchungByName(name);
        return lb;
    }
}
