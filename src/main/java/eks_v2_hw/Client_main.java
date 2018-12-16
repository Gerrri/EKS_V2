/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eks_v2_hw;

import eks_v2_hw.entity.Buchung;
import eks_v2_hw.entity.Reise;
import eks_v2_hw.entity.Veranstalter;
import java.util.List;
import static javax.swing.UIManager.get;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
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
    
    System.out.println("------------------------- 1 -------------------------");
    //Es sollen die Veranstalter „Tschiller“ mit Adresse „Hamburg“, „Odenthal“ mit 
    //Adresse „Ludwigshafen“ und „Lessing“ mit Adresse „Weimar“ angelegt werden. 
    
        //1. Veranstalter anlegen
        Veranstalter tschiller = (new Veranstalter());
        tschiller.setName("Tschiller");
        tschiller.setAdresse("Hamburg");
        resp = target.path("veranstalter").request().post(Entity.entity(tschiller, MediaType.APPLICATION_XML));
        System.out.println("Tschiller: " + resp.getStatusInfo().toString());

        //2. Veranstalter anlegen
        Veranstalter odenthal = (new Veranstalter());
        odenthal.setName("Odenthal");
        odenthal.setAdresse("Ludwigshafen");
        resp = target.path("veranstalter").request().post(Entity.entity(odenthal, MediaType.APPLICATION_XML));
        System.out.println("Odenthal: " + resp.getStatusInfo().toString());

        //3. Veranstalter anlegen
        Veranstalter lessing = (new Veranstalter());
        lessing.setName("Lessing");
        lessing.setAdresse("Weimar");
        resp = target.path("veranstalter").request().post(Entity.entity(lessing, MediaType.APPLICATION_XML));
        System.out.println("Lessing: " + resp.getStatusInfo().toString());
        
        
    System.out.println("------------------------- 2 -------------------------");
    //Es soll die Veranstalter-Ressource für den Veranstalter mit Namen „Tschiller“ 
    //erfragt werden und die Attribute der Rückgabe sollen ausgegeben werden. 
        Veranstalter v = target.path("veranstalter").path(tschiller.getName()).request().accept(MediaType.APPLICATION_XML).get(Veranstalter.class);
        System.out.println("Veranstalter: " + v.getName() + ", in " + v.getAdresse());
    
    System.out.println("------------------------- 3 -------------------------");    
    //Es soll für jeden Veranstalter jeweils eine Reise angelegt werden mit dem Preis 
    //300€ für „Tschiller“, 750€ für „Odenthal“ und 990€ 
    //für „Lessing“. Es sollen die vergebenen Reisenummern ausgegeben werden. 
        String tschiller_nr = target.path("veranstalter").path(tschiller.getName()).path("reise").request().post(Entity.entity(300, MediaType.TEXT_PLAIN), String.class);
        System.out.println("Reisenummer "+tschiller.getName()+": "+tschiller_nr);
        
        String lessing_nr = target.path("veranstalter").path(lessing.getName()).path("reise").request().post(Entity.entity(750, MediaType.TEXT_PLAIN), String.class);
        System.out.println("Reisenummer "+lessing.getName()+": "+lessing_nr);
        
        String odenthal_nr = target.path("veranstalter").path(odenthal.getName()).path("reise").request().post(Entity.entity(990, MediaType.TEXT_PLAIN), String.class);
        System.out.println("Reisenummer "+odenthal.getName()+": "+odenthal_nr);
    
        
    System.out.println("------------------------- 4 -------------------------");
    //Für die vom Veranstalter „Tschiller“ veranstaltete Reise soll eine Buchung vom 
    //Kunden mit dem Namen „Werner“ erstellt werden. Die 
    //Daten der Rückgabe sollen ausgegeben werden. 
        String buchungs_nr = target.path("reisen").path(tschiller_nr).path("bestellung").request().post(Entity.entity("Werner", MediaType.TEXT_PLAIN), String.class);
        System.out.println("Buchungsnummer Werner: "+buchungs_nr);
        
        //String buchungs_nr2 = target.path("reisen").path(lessing_nr).path("bestellung").request().post(Entity.entity("Otto", MediaType.TEXT_PLAIN), String.class);
        //System.out.println("Buchungsnummer Otto: "+buchungs_nr2);
        
    System.out.println("------------------------- 5 -------------------------");
    //Es sollen alle Buchungen von „Werner“ erfragt werden und die jeweiligen 
    //Buchungsnummern ausgegeben werden.  
        List<Buchung> lb = target.path("buchungen").queryParam("name", "Werner").request().accept(MediaType.APPLICATION_XML).get(new GenericType<List<Buchung>>() {});
    
        System.out.println("Buchungen (Werner): ");
        for(Buchung b : lb){
            System.out.println("Buchungsnummer: "+ b.getBuchungsnr());
        }
    
    System.out.println("------------------------- 6 -------------------------");
    //Für die vom Veranstalter „Tschiller“ veranstaltete Reise soll eine Buchung vom 
    //Kunden mit dem Namen „Mueller“ erstellt werden. Die Daten der Rückgabe sollen ausgegeben werden. 
        String buchungs_nr2 = target.path("reisen").path(tschiller_nr).path("bestellung").request().post(Entity.entity("Mueller", MediaType.TEXT_PLAIN), String.class);
        System.out.println("Buchungsnummer Mueller: "+buchungs_nr2);
    
     
    System.out.println("------------------------- 7 -------------------------");
    //Für die vom Veranstalter „Tschiller“ veranstaltete Reise sollen alle Buchungen 
    //ermittelt und die zugehörigen Attributwerte ausgegeben werden. 
    //List<Buchung> lb2 = target.path("buchungen").request().accept(MediaType.APPLICATION_XML).get(new GenericType<List<Buchung>>() {});
    /*
    List<Reise> lr2 = target.path("reisen").request().accept(MediaType.APPLICATION_XML).get(new GenericType<List<Reise>>() {});
   
    tschiller = target.path("veranstalter").path(tschiller.getName()).request().accept(MediaType.APPLICATION_XML).get(Veranstalter.class);
    
    for(Reise r:lr2){
        for(Reise r_t:tschiller.getReisen()){
         if(r_t.contains(r)){
            System.out.println("Reisenummer: "+r.getPreis()+"  |  Preis: "+r.getPreis());
         }  
        }
    }
    */
    
    
    System.out.println("------------------------- 8 -------------------------");
    //Für die vom Veranstalter „Odenthal“ veranstaltete Reise soll der Preis 
    //abgefragt und ausgegeben werden.  
        String preis_odenthal = target.path("reisen").path(odenthal_nr).path("preis").request().accept(MediaType.TEXT_PLAIN).get(String.class);
        System.out.println("Preis odenthal: "+preis_odenthal);
    
        
    System.out.println("------------------------- 9 -------------------------");
    //Es soll die Liste aller Reisen erfragt werden und dann die Preise und 
    //Reisenummern der Reisen ausgegeben werden. 
        List<Reise> lr = target.path("reisen").request().accept(MediaType.APPLICATION_XML).get(new GenericType<List<Reise>>() {});
        
        for(Reise r: lr){
            System.out.println("Reisenummer : "+ r.getReisenr()+"  |  Preis: "+r.getPreis());
        }
        
        
        
        
        
    client.close();
    }
    
    
}
    
