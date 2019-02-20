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
public class ListePersonne {
    private Personne[] listePersonnes;
    private int compteur;
    
    // Constructeur de la classe listePersonne
     public ListePersonne(int nbrePersonne)
     {
         listePersonnes = new Personne[nbrePersonne];
         compteur = 0;
     }
     
     
     // Ajouter une personne dans la liste de personnes
    public String ajouterUnePersonneDansListPersonne(String nomChoix, String prenomChoix,String statutChoix)
     {
         // Création de la personne
         listePersonnes[compteur] = new Personne();
         listePersonnes[compteur].nom = nomChoix;
         listePersonnes[compteur].prenom = prenomChoix;
         listePersonnes[compteur].statut = statutChoix;

         // Incrémente le compteur de personnes
         compteur++;

         return "La personne à l'id suivant : "+(compteur-1)+" a été cree."+
                 "\nIl possede les informations suivantes"+
                 "\nNom : "+listePersonnes[(compteur-1)].nom+
                 "\nPrenom : "+listePersonnes[(compteur-1)].prenom+
                 "\nStatut : "+listePersonnes[(compteur-1)].statut;
     }
     
    public String modifierUnePersonneDansListPersonne (int id_personne,String nom,String prenom,String statut)
    {
        listePersonnes[id_personne].nom=nom;
        listePersonnes[id_personne].prenom=prenom;
        listePersonnes[id_personne].statut=statut;
        
        return ("Modification effectuée\n");
    }
     
    public String supprimerUnePersonneDansListPersonne(int id_personne)
    {
        if (compteur==1){
            listePersonnes[0]=null;
            compteur--;
        }
        else {
            for (int i = id_personne; i < compteur-1; i++) {
                listePersonnes[i]=listePersonnes[i+1];
            }
            listePersonnes[compteur-1]=null;
            compteur--;
        }
        
        return ("Suppression effectuée\n");
    }

    public String consulterUnePersonneDansListPersonne(int id_personne)
    {
        return listePersonnes[id_personne].toString();
    }

    public String consulterListPersonne()
    {
        String list="";
        for (int i = 0; i < compteur; i++) {
            list+=consulterUnePersonneDansListPersonne(i)+"\n";
        }
        return (list);
    }

}
