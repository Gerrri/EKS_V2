/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;


import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;
import javax.ws.rs.Consumes;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Dustin
 */
public class BuchungService {
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
