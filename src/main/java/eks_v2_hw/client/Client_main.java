/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw.client;

import eks_v2_hw.entity.Veranstalter;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Dustin
 */
public class Client_main {
    
    public static void main(String[] args) {
    Client client = ClientBuilder.newClient();
    
     WebTarget target = client.target("http://localhost:55554/reiseservice");
     Response resp;
     
     
     //1. Veranstalter anlegen
     Veranstalter tschiller = (new Veranstalter());
     tschiller.setName("Tschiller");
     tschiller.setAdresse("Hamburg");
     
     resp = target.path("veranstalter").request().post(Entity.entity(tschiller, MediaType.APPLICATION_XML));
     System.out.println("Tschiller: " + resp.getStatusInfo().toString());
     
    }
}
    
