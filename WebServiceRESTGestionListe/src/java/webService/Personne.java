/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webService;

/**
 *
 * @author flbouligan
 */
public class Personne {
    // attributs de la classe personne
    protected String nom;
    protected String prenom;
    protected String statut;

    @Override
    public String toString() {
        return "nom ="+nom +"\n"+
               "prenom ="+prenom +"\n"+
               "statut ="+statut ;
    }
    
    
}

