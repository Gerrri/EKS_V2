/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;



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
