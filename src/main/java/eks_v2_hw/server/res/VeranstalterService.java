/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;

import eks_v2_hw.entity.Veranstalter;
import eks_v2_hw.server.db.AlleVeranstaltungen;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dustin
 */
@Path("veranstalter")
public class VeranstalterService {
   

    /**
     * Nur zum Testen
     * @param nr Nummer des Veranstalters
     * @return Namen eines Veranstalters
     */
    @GET
    @Path("{nr}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getVeranstalter(@PathParam("nr") int nr) {
        Veranstalter v = AlleVeranstaltungen.getInstance().getVeranstalter().get(nr);
        if (v != null) {
            return v.getName();
        }
        return null;
    }
    
    /**
    Für einen Veranstalter mit gegebenem Namen soll eine neue Reise erstellt 
    werden. Es wird hierbei der Preis der neuen Reise als String übergeben. Der 
    Dienst liefert die Reisenummer der neu angelegten Reise als String zurück. Eine 
    Reisenummer muss innerhalb des Reisebüros eindeutig sein. 
    (Eine neue Ressource über eine Assoziation erstellen) 
    */
    
    
    
    
    
    
    
    
    
    
    
    
     
    /**
     * Erzeugung eines neuen Veranstalters. Hierbei werden der Name und die 
       Adresse des neuen Veranstalters in XML angegeben. 
       (Eine neue Ressource erzeugen)
     * @param veranstalter
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createVeranstalter(Veranstalter veranstalter) {
        if (AlleVeranstaltungen.getInstance().addVeranstaler(veranstalter)) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
            
            
            
    
}
