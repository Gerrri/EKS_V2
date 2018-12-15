/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw;

import com.sun.net.httpserver.HttpServer;
import eks_v2_hw.server.res.VeranstalterService;
import java.net.URI;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;


/**
 *
 * @author Dustin
 */
public class Server_main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception{
        URI endpoint = new URI("http://localhost:55554/reiseservice");
        ResourceConfig rc = new ResourceConfig(VeranstalterService.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(endpoint, rc);
        System.out.println("Server wurde gestarten :)");
    }
    
}
