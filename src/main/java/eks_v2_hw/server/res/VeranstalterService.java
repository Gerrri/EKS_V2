/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.server.res;

import eks_v2_hw.entity.Veranstalter;
import eks_v2_hw.server.db.AlleVeranstaltungen;
import javax.ws.rs.Consumes;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dustin
 */

@Path("veranstalter")
public class VeranstalterService {
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createKunde(Veranstalter veranstalter) {
        if (AlleVeranstaltungen.getInstance().addVeranstaler(veranstalter)) {
            return Response.status(Response.Status.CREATED).build();
        }
        else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
