/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw;

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
     
    //Es sollen die Veranstalter „Tschiller“ mit Adresse „Hamburg“, „Odenthal“ mit 
    //Adresse „Ludwigshafen“ und „Lessing“ mit Adresse „Weimar“ angelegt werden. 
    
        //1. Veranstalter anlegen
        Veranstalter tschiller = (new Veranstalter());
        tschiller.setName("Tschiller");
        tschiller.setAdresse("Hamburg");
        resp = target.path("veranstalter").request().post(Entity.entity(tschiller, MediaType.APPLICATION_XML));
        System.out.println("Tschiller: " + resp.getStatusInfo().toString());

        //2. Veranstalter anlegen
        Veranstalter Odenthal = (new Veranstalter());
        tschiller.setName("Odenthal");
        tschiller.setAdresse("Ludwigshafen");
        resp = target.path("veranstalter").request().post(Entity.entity(tschiller, MediaType.APPLICATION_XML));
        System.out.println("Odenthal: " + resp.getStatusInfo().toString());

        //3. Veranstalter anlegen
        Veranstalter Lessing = (new Veranstalter());
        tschiller.setName("Lessing");
        tschiller.setAdresse("Weimar");
        resp = target.path("veranstalter").request().post(Entity.entity(tschiller, MediaType.APPLICATION_XML));
        System.out.println("Lessing: " + resp.getStatusInfo().toString());
        
        
    //Es soll die Veranstalter-Ressource für den Veranstalter mit Namen „Tschiller“ 
    //erfragt werden und die Attribute der Rückgabe sollen ausgegeben werden. 
     
    }
}
    
