/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author flbouligan
 */
@Path("GestionListe")
public class WebServiceGestionListe {

    @Context
    private UriInfo context;
    
     // Création d'un tableau de liste de personnes
    static protected ListePersonne [] tableauPersonnes = new ListePersonne[5];

    // Indice de création dans le tableau de liste
    static public int indiceTableau = 0;

    /**
     * Creates a new instance of WebServiceGestionListe
     */
    public WebServiceGestionListe() {
        
    }

    /**
     * Retrieves representation of an instance of webService.WebServiceGestionListe
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
               
        //throw new UnsupportedOperationException();
        
        return ("Bonjour vous etes dans la methode getJson() sur le web service REST");
    }

    /**
     * PUT method for updating or creating an instance of WebServiceGestionListe
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
    
    // Méthode permettant la création d'une liste de personne
     @POST
     @Path("creerListePersonne/{nbrePersonne}")
     @Produces("application/json")
     public String creerListePersonne(@PathParam("nbrePersonne") int nbrePersonne)
     {
         // Création de la liste de personne
         tableauPersonnes[indiceTableau] = new ListePersonne(nbrePersonne);

         // On avance l'indice dans le tableau pour la prochaine liste
         indiceTableau++;
         return "La liste de personne est bien créée avec l'id liste suivant :"+(indiceTableau-1);
     }
     
     // Méthode permettant d'ajouter une personne à une liste de personne
     @POST
     @Path("ajouterPersonneDansListePersonne/{idListe}/ajouterNomPrenomStatut/{nom}-{prenom}-{statut}")
     @Produces("application/json")
     public String ajouterPersonneDansListePersonne(@PathParam("idListe") int idListe,@PathParam("nom") String nom,@PathParam("prenom") String prenom, @PathParam("statut") String statut)
     {
         // On ajoute la personne demandée dans la liste
         String resultat = tableauPersonnes[idListe].ajouterUnePersonneDansListPersonne(nom,prenom,statut);
         return resultat;
     }
     
     
     // Méthode permettant de modifier le nom et le prénom d'une personne dans la liste
     @PUT
     @Path("modifierPersonneDansListePersonne/{idListe}/modifierNomPrenomStatut/{idPersonne}-{nom}-{prenom}-{statut}")
     @Produces("application/json")
     public String modifierPersonneDansListePersonne(@PathParam("idListe") int idListe,@PathParam("idPersonne") int id_personne,@PathParam("nom") String nom,@PathParam("prenom") String prenom, @PathParam("statut") String statut)
     {
         // On modifie la personne demandée dans la liste
         String resultat = tableauPersonnes[idListe].modifierUnePersonneDansListPersonne(id_personne, nom, prenom, statut);
         return resultat;
     }
     
          
     // Méthode permettant de consulter une personne dans la liste
     @DELETE
     @Path("supprimerPersonneDansListePersonne/{idListe}/supprimeridPersonne/{idPersonne}")
     @Produces("application/json")
     public String supprimerPersonneDansListePersonne (@PathParam("idListe") int idListe,@PathParam("idPersonne") int id_personne){
         // On supprime la personne demandée dans la liste
         String resultat = tableauPersonnes[idListe].supprimerUnePersonneDansListPersonne(id_personne);
         return resultat;
     }
     
     // Méthode permettant de consulter toutes les personnes d’une liste de personne
     @GET
     @Path("consulterPersonneDansListePersonne/{idListe}/consulteridPersonne/{idPersonne}")
     @Produces("application/json")
     public String consulterPersonneDansListePersonne(@PathParam("idListe") int idListe,@PathParam("idPersonne") int id_personne){
         
         // On consulte la personne demandée dans la liste
         String resultat = tableauPersonnes[idListe].consulterUnePersonneDansListPersonne(id_personne);
         return resultat;
     }
     
     // Méthode permettant de supprimer une personne d'une liste de personnes
    @GET
    @Path("consulterListePersonne/{idListe}")
    @Produces("application/json")
     public String consulterListePersonne(@PathParam("idListe") int idListe){
         // On consulte toutes les personnes demandées dans la liste
         String resultat = tableauPersonnes[idListe].consulterListPersonne();
         return resultat;
    }


}
