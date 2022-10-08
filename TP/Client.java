package TP;
import java.util.*;

public class Client extends Agence {

    public void afficher_liste_biens(){
        for (String q : lesbiens.keySet())
        {
                lesbiens.get(q).affiche_petit_bien();
        }
    }

    public void Afficher_bien(String adress){
        Biens b = lesbiens.get(adress);
        if (b != null )
        {
            if (b.getType_bien() == Type_bien.Appartement)
                ((Appartement)b).afficher_app();
            else if (b.getType_bien() == Type_bien.Maison)
                ((Maison)b).afficher_maison();
            else ((Terrain)b).afficher_terrain();
        }
        else System.out.println("L'dresse est incorrecte..!");
    }

    public void Filrer_biens()
    {

    }

    public void envoyer_msg()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Donnez l'adresse du bien conserne :  \t");
        String adresse = sc.nextLine();
        System.out.println("Le message  :");
        String msg = sc.nextLine();
    }
}
