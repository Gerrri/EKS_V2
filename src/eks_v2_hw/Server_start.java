/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw;

import com.sun.net.httpserver.*;
import eks_v2_hw.server.res.BuchungService;
import eks_v2_hw.server.res.VeranstalterService;
import java.net.URI;
import java.net.URISyntaxException;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Dustin
 */
public class Server_start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         URI endpoint;
        try {
            // WADL file: http://localhost:55554/reiseservice/application.wadl
            endpoint = new URI("http://localhost:55554/reiseservice");
        } catch (URISyntaxException ex) {
            //Logger.getLogger(this.class).log(Level.SEVERE, null, ex);
            return;
        }
        
        ResourceConfig rc = new ResourceConfig(new Class<?>[] {
            BuchungService.class,
            VeranstalterService.class
        });
        HttpServer server = HttpServerFactory.createHttpServer(endpoint, rc);
    }
    
}
