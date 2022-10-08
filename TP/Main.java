package TP;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Prop p1 = new Prop("s", "w", "ia_srairi@esi.dz", 662279374, "M37");
        Prop p2 = new Prop("l", "a", "ia_srairii@esi.dz", 552279374, "M38");
        Prop p3 = new Prop("m", "s", "iia_srairi@esi.dz", 442279374, "M39");
        Prop p4 = new Prop("s", "t", "ia_sraiiri@esi.dz", 222279374, "M34");

        Biens b1 = new Appartement(Type_bien.Appartement, "ghghf", 1, 120, p2, Nature_biens.Vente, 4000000, true, "", 4, true, 1, mode_app.Simplexe, true);
        Biens b4 = new Appartement(Type_bien.Appartement, "hgjhfb", 3, 100, p2, Nature_biens.Location, 40000, true, "", 3, true, 1, mode_app.Simplexe, true);
        Biens b6 = new Appartement(Type_bien.Appartement, "geryr", 3, 50, p2, Nature_biens.Vente, 4000000, true, "", 1, true, 6, mode_app.Simplexe, false);
        Biens b2 = new Maison(Type_bien.Maison, "rityghf", 3, 200, p1, Nature_biens.Vente, 10000000, true, "", 10, true, 3, false, true, false, 170);
        Biens b5 = new Maison(Type_bien.Maison, "rifgfg", 1, 160, p3, Nature_biens.Location, 150000, true, "", 10, true, 3, false, false, true, 170);
        Biens b8 = new Maison(Type_bien.Maison, "rfjhsdjfb", 1, 200, p2, Nature_biens.Echange, 14000000, true, "", 10, true, 3, true, false, false, 170);
        b8.setEch_hors_wilaya(false);
        Biens b3 = new Terrain(Type_bien.Terrain, "lfidgh", 5, 500, p3, Nature_biens.Vente, 20000000, true, "", "", 3);
        Biens b7 = new Terrain(Type_bien.Terrain, "lfighdfghh", 5, 650, p1, Nature_biens.Echange, 18000000, true, "", "", 1);
        b7.setEch_hors_wilaya(true);

        Agence.add_bien(b1);
        Agence.add_bien(b2);
        Agence.add_bien(b3);
        Agence.add_bien(b4);
        Agence.add_bien(b5);
        Agence.add_bien(b6);
        Agence.add_bien(b7);
        Agence.add_bien(b8);

        Scanner sc = new Scanner(System.in);
        int choix;
        System.out.println("1-- Admin  \t  2--Client");
        do {
            choix = sc.nextInt();
        }while (choix != 1 && choix != 2);

        if (choix==1)  mAdmin();
        else  mClient();
    }

    public static void mAdmin(){
        Admin a = new Admin();
        Scanner sc = new Scanner(System.in);
        int ch;
        String ss;
        do {
            System.out.println("1--Afficher liste des biens sans details");
            System.out.println("2--Filtrer les biens");
            System.out.println("3--Afficher un bien");
            System.out.println("4--Ajouter un bien");
            System.out.println("5--Supprimer bien");
            System.out.println("6--Archiver bien");
            System.out.println("7--Modifier bien");
            System.out.println("8--Afficher la liste des biens d'un proprietaire");
            System.out.println("9--Afficher les proprietere");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    a.afficher_liste_biens();
                    break;
                case 2:
                    a.Filrer_biens();
                    break;
                case 3:
                    Scanner sc2 = new Scanner(System.in);
                    ss = sc2.nextLine();
                    a.Afficher_bien(ss);
                    break;
                case 4:
                    a.ajouter_bien();
                    break;
                case 5:
                    a.supp_bien();
                    break;
                case 6:
                    a.archive_bien();
                    break;
                case 7:
                    a.modifier_bien();
                    break;
                case 8:
                    a.info_prop_choisi();
                    break;
                case 9:
                    a.afficher_props();
                    break;
            }
        }while (ch != 10);
    }

    public static void mClient(){
        Client c = new Client();
        Scanner sc = new Scanner(System.in);
        int ch;
        String ss;
        System.out.println("1--Afficher liste des biens sans details");
        System.out.println("2--Filtrer les biens");
        System.out.println("3--Afficher un bien");
        System.out.println("4--Envoyer un msg");
        ch = sc.nextInt();
        switch (ch)
        {
            case 1: c.afficher_liste_biens(); break;
            case 2: c.Filrer_biens();         break;
            case 3:
                ss = sc.nextLine();
                c.Afficher_bien(ss);         break;
            case 4: c.envoyer_msg();          break;
        }
    }
}
