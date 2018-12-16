/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;

import eks_v2_hw.entity.Reise;
import eks_v2_hw.entity.Veranstalter;
import eks_v2_hw.server.db.AlleReisen;
import eks_v2_hw.server.db.AlleVeranstaltungen;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
    @Path("id/{nr}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getVeranstalter(@PathParam("nr") int nr) {
        Veranstalter v = AlleVeranstaltungen.getInstance().getVeranstalter().get(nr);
        if (v != null) {
            return v.getName();
        }
        return null;
    }
    
    /**
    *Für einen Veranstalter mit gegebenem Namen soll eine neue Reise erstellt 
    *werden. Es wird hierbei der Preis der neuen Reise als String übergeben. Der 
    *Dienst liefert die Reisenummer der neu angelegten Reise als String zurück. Eine 
    *Reisenummer muss innerhalb des Reisebüros eindeutig sein. 
    *(Eine neue Ressource über eine Assoziation erstellen) 
    */
    @POST
    @Path("{name}/reise")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String createReise(@PathParam("name") String name,String preis){
        Veranstalter v = AlleVeranstaltungen.getInstance().getVeranstalterByName(name);
        
        if(v!=null){
            
        Reise r = AlleReisen.getInstance().createReise(v);
        r.setPreis(Integer.parseInt(preis));
        
        return Integer.toString(r.getReisenr());
        }
    return "";
    }
    
    /**
     * Erzeugung eines neuen Veranstalters. Hierbei werden der Name und die 
     *  Adresse des neuen Veranstalters in XML angegeben. 
     * (Eine neue Ressource erzeugen)
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
         
    /**
     * Abfrage der Veranstalter-Ressource für einen Veranstalter mit gegebenem 
       Namen. Als Rückgabe soll eine XML-Beschreibung der Ressource geliefert werden. 
       (Eine einzelne Ressource adressieren)
     */
    @GET
    @Path("{name}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_XML)
    public Veranstalter getVeranstalterResByVeranstalter(@PathParam("name") String name){
        return AlleVeranstaltungen.getInstance().getVeranstalterByName(name);
    }
    
            
            
    
}
