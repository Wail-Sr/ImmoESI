package TP;

import java.util.Scanner;

public class Admin extends Client {

    public void ajouter_bien(){
        Biens ap = null;
        int nb_pieces;
        boolean meuble;
        Type_bien type_bien = Type_bien.Appartement;
        String adress;
        int n_wilaya;
        double superficie;
        Prop prop;
        Nature_biens nature = null;
        boolean ech_hors_wilaya = false;
        long prix;
        boolean negociable;
        String Description;
        long prix_agence;
        Scanner sc = new Scanner(System.in);
        prop = info_prop();
        System.out.print("Donnez le type du bien : (1-Appartement, 2-Maison, 3-Terrain)   \t");
        int t;
        do {
            t = sc.nextInt();
        }while (t != 1 && t != 2 && t != 3);
        switch (t)
        {
            case 1:
                type_bien = Type_bien.Appartement;
                break;
            case 2:
                type_bien = Type_bien.Maison;
                break;
            case 3:
                type_bien = Type_bien.Terrain;
                break;
        }

        System.out.print("L'addresse : \t");
        sc = new Scanner(System.in);
        adress = sc.nextLine();
        System.out.print("Numero du Wilaya : \t");
        n_wilaya = sc.nextInt();
        System.out.print("Superficie : \t");
        superficie = sc.nextDouble();
        System.out.print("Le bien est pour   (1-Vente, 2-Location, 3-Echange) : \t");
        do {
            t = sc.nextInt();
        }while (t != 1 && t != 2 && t != 3);
        switch (t)
        {
            case 1:
                nature = Nature_biens.Vente;
                break;
            case 2:
                nature = Nature_biens.Location;
                break;
            case 3:
            {
                nature = Nature_biens.Echange;
                System.out.print("Echange hors Wilaya  (1/0) : \t");
                t = sc.nextInt();
                if(t==1) ech_hors_wilaya = true;
                else ech_hors_wilaya = false;
            }break;
        }

        System.out.print("Le prix : \t");
        prix = sc.nextLong();
        System.out.print("Negociable ou pas (1/0) : \t");
        t = sc.nextInt();
        if(t==1) negociable = true;
        else negociable = false;
        System.out.println("Ajouter un description : ");
        Description = sc.nextLine();


        switch (type_bien)
        {
            case Appartement:
            {
                System.out.print("Nombre des pieces :  \t");
                nb_pieces = sc.nextInt();
                System.out.print("Meuble ou pas :  (true/false)\t");
                meuble = sc.nextBoolean();
                int etage;
                mode_app mode;
                boolean ascenseur;

                System.out.print("L'etage :  \t");
                etage = sc.nextInt();

                System.out.print("Le mode d'appartement :  (1-Simplex, 2-Duplex)\t");
                t = sc.nextInt();
                if (t==1) mode = mode_app.Simplexe;
                else mode = mode_app.Duplexe;

                System.out.print("Ascenseur ou pas :  (true/false)\t");
                ascenseur = sc.nextBoolean();

                ap = new Appartement(type_bien, adress, n_wilaya, superficie, prop, nature, prix, negociable, Description, nb_pieces, meuble, etage, mode, ascenseur);

            }break;

            case Maison:
            {
                System.out.print("Nombre des pieces :  \t");
                nb_pieces = sc.nextInt();
                System.out.print("Meuble ou pas :  (true/false)\t");
                meuble = sc.nextBoolean();
                int nb_etages;
                boolean garage;
                boolean jardin;
                boolean piscine;
                double superficie_habitable = superficie;
                System.out.print("Nombre des etages :  \t");
                nb_etages = sc.nextInt();
                System.out.print("Il y a un garage : \t");
                garage = sc.nextBoolean();

                System.out.print("Il y a un jardin : \t");
                jardin = sc.nextBoolean();
                System.out.print("Il y a une piscine : \t");
                piscine = sc.nextBoolean();

                if(jardin || piscine)
                {
                    System.out.print("Superficie habitable : \t");
                    superficie_habitable = sc.nextDouble();
                }

                ap = new Maison(type_bien, adress, n_wilaya, superficie, prop, nature, prix, negociable, Description, nb_pieces, meuble, nb_etages, garage, jardin, piscine, superficie_habitable);
            }break;

            case Terrain:
            {
                System.out.print("Statut jurdique : ");
                sc = new Scanner(System.in);
                String statut_jurdique = sc.nextLine();

                System.out.print("nombre de facade : \t");
                int nb_facade = sc.nextInt();

                ap = new Terrain(type_bien, adress, n_wilaya, superficie, prop, nature, prix, negociable, Description, statut_jurdique, nb_facade);
            }break;
        }

        ap.setEch_hors_wilaya(ech_hors_wilaya);

        add_bien(ap);
    }

    public Prop info_prop(){
        String nom, prenom, email, adresse_p;
        int tel;
        Scanner sc = new Scanner(System.in);
        System.out.print("Le nom : \t");
        nom = sc.nextLine();
        System.out.print("Le prenom : \t");
        prenom = sc.nextLine();
        System.out.print("L'email : \t");
        email = sc.nextLine();
        System.out.print("L'adresse : \t");
        adresse_p = sc.nextLine();
        System.out.print("Le numero de telephone (9 chiffres) : \t");
        tel = sc.nextInt();
        Prop p = liste_prop.get(email);
        if (p == null)
        {
            p = new Prop(nom, prenom, email, tel, adresse_p);
        }
        else System.out.println("Le proprietere deja existe ...!");
        return p;
    }

    public void afficher_props(){
        for (String s : liste_prop.keySet())
        {
            liste_prop.get(s).afficher_prop_info();
        }
    }

    public void info_prop_choisi(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Donnez l'email du proprietere : \t");
        String email = sc.nextLine();
        if (liste_prop.containsKey(email))
            liste_prop.get(email).afficher_liste_biens();
        else System.out.println("L'email est incorrecte..!");
    }

    public void supp_bien(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Donnez l'adresse du bien pour le supp : \t");
        String adresse = sc.nextLine();
        if (lesbiens.containsKey(adresse))
            Agence.remove_bien(lesbiens.get(adresse));
        else System.out.println("Le bien n'existe pas deja..!");
    }

    public void archive_bien(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Donnez l'adresse du bien pour le archive : \t");
        String adresse = sc.nextLine();
        if (lesbiens.containsKey(adresse))
            Agence.archiver_bien(lesbiens.get(adresse));
        else if (archive.containsKey(adresse)) System.out.println("Le bien existe deja dans l'archive..!");
        else System.out.println("Le bien n'existe pas..!");
    }

    public void modifier_bien(){
        int[] choix = new int[50];
        int i, j;
        Scanner sc = new Scanner(System.in);
        System.out.print("Donnez l'adresse du bien pour le modifier : \t");
        String adresse = sc.nextLine();
        Biens b = lesbiens.get(adresse);
        if (lesbiens.containsKey(adresse))
        {
            System.out.println("You want to change : \t");
            System.out.println("\t 1---L'adresse du bien");
            System.out.println("\t 2---Wilaya");
            System.out.println("\t 3---Superficie");
            System.out.println("\t 4---Les info du proprietere");
            System.out.println("\t 5---Nature du bien");
            System.out.println("\t 6---Prix");
            System.out.println("\t 7---Negociable ou pas");
            System.out.println("\t 8---Description");
            switch (b.getType_bien())
            {
                case Appartement:
                {
                    System.out.println("\t 9---Nombre des pieces");
                    System.out.println("\t 10---Meuble ou non");
                    System.out.println("\t 11---L'etage");
                    System.out.println("\t 12---Mode d'appartement");
                    System.out.println("\t 13---L'existence d'ascenseur");
                    if (b.getNature()==Nature_biens.Echange) System.out.println("\t 14---Echange hors wilaya");

                }break;
                case Maison:
                {
                    System.out.println("\t 9---Nombre des pieces");
                    System.out.println("\t 10---Meuble ou non");
                    System.out.println("\t 11---Nombre des etages");
                    System.out.println("\t 12---L'existence du garage");
                    System.out.println("\t 13---L'existence du jardin");
                    System.out.println("\t 14---L'existence du piscine");
                    System.out.println("\t 15---Superficie habitable");
                    if (b.getNature()==Nature_biens.Echange) System.out.println("\t 16---Echange hors wilaya");
                }break;
                case Terrain:
                {
                    System.out.println("\t 9---Statut jurdique");
                    System.out.println("\t 10---Nombre des facades");
                    if (b.getNature()==Nature_biens.Echange) System.out.println("\t 11---Echange hors wilaya");
                }
            }

            System.out.println("Nombre des parametres vous voulez les changer : \t");
            i = sc.nextInt();

            for (j = 0; j < i; j++)
            {
                System.out.print("Donc vous voulez changer le parametre numero   :   ");
                choix[j] = sc.nextInt();
            }

            for (j = 0; j < i; j++)
            {
                if (choix[j] < 9)
                {
                    switch (choix[j])
                    {
                        case 1:
                        {
                            System.out.println("**L'ancien adresse  ::  " + b.getAdress());
                            System.out.print("--Donnez le nouveau adresse : \t");
                            b.setAdress(sc.nextLine());
                        }break;
                        case 2:
                        {
                            System.out.println("**L'ancien wilaya  ::  " + b.getWilaya().getNw() + "-" + b.getWilaya().getW());
                            System.out.print("--Donnez le nouveau numero du wilaya : \t");
                            b.getWilaya().set(sc.nextInt());
                        }break;
                        case 3:
                        {
                            System.out.println("**L'ancien superficie  ::  " + b.getSuperficie());
                            System.out.print("--Donnez la nouvelle superficie : \t");
                            b.setSuperficie(sc.nextDouble());
                        }break;
                        case 4:
                        {
                            System.out.print("**L'ancien proprietere  ::  ");  b.getProp().afficher_prop_info();
                            System.out.println("--Donnez les nouveaux infos du prop : \t");
                            System.out.print("      Le nom : \t");
                            b.getProp().setNom(sc.nextLine());
                            System.out.print("      Le prenom : \t");
                            b.getProp().setPrenom(sc.nextLine());
                            System.out.print("      L'email : \t");
                            b.getProp().setEmail(sc.nextLine());
                            System.out.print("      L'adresse : \t");
                            b.getProp().setAdress(sc.nextLine());
                            System.out.print("      Le numero de telephone (9 chiffres) : \t");
                            b.getProp().setTel(sc.nextInt());
                        }break;
                        case 5:
                        {
                            System.out.println("**L'ancien nature du bien  ::  " + b.getNature());
                            System.out.print("--Donnez la nouvelle nature : (1/Vente        2/Location      3/Echange)\t");
                            b.setNature(Nature_biens.n[sc.nextInt()-1]);
                        }break;
                        case 6:
                        {
                            System.out.println("**L'ancien prix  ::  " + b.getPrix());
                            System.out.print("--Donnez le nouveau prix : \t");
                            b.setPrix(sc.nextLong());
                        }break;
                        case 7:
                        {
                            System.out.println("**Negociable  ::  " + b.isNegociable());
                            System.out.print("--Donnez la nouvelle valeur : \t");
                            b.setNegociable(sc.nextBoolean());
                        }break;
                        case 8:
                        {
                            System.out.println("**L'ancien Description  ::  " + b.getDescription());
                            System.out.print("--Donnez la nouvelle description : \t");
                            b.setDescription(sc.nextLine());
                        }break;

                    }
                }
                else
                {
                    switch (b.getType_bien())
                    {
                        case Appartement:
                        {
                            switch (choix[j])
                            {
                                case 9:
                                {
                                    System.out.println("**L'ancien nombre des pieces  ::  " + ((Appartement)b).getNb_pieces());
                                    System.out.print("--Donnez le nouveau nombre des pieces : \t");
                                    ((Appartement)b).setNb_pieces(sc.nextInt());
                                }break;
                                case 10:
                                {
                                    System.out.println("**Meuble ou non  ::  " + ((Appartement)b).isMeuble());
                                    System.out.print("--La nouvelle valeur : \t");
                                    ((Appartement)b).setMeuble(sc.nextBoolean());
                                }break;
                                case 11:
                                {
                                    System.out.println("**L'ancien numero d'etage  ::  " + ((Appartement)b).getEtage());
                                    System.out.print("--Donnez le nouveau num d'etage : \t");
                                    ((Appartement)b).setEtage(sc.nextInt());
                                }break;
                                case 12:
                                {
                                    System.out.println("**L'ancien mode d'appartemenr  ::  " + ((Appartement)b).getMode());
                                    System.out.print("--Donnez le nouveau mode : (1/Simplex     2/duplexe)\t");
                                    ((Appartement)b).setMode(mode_app.m[sc.nextInt()-1]);
                                }break;
                                case 13:
                                {
                                    System.out.println("**Ascenseur ou non  ::  " + ((Appartement)b).isAscenseur());
                                    System.out.print("--La nouvelle valeur : \t");
                                    ((Appartement)b).setAscenseur(sc.nextBoolean());
                                }break;
                                case 14:
                                {
                                    System.out.println("**Echange hors wilaya  ::  " + b.isEch_hors_wilaya());
                                    System.out.print("--La nouvelle valeur : \t");
                                    b.setEch_hors_wilaya(sc.nextBoolean());
                                }break;
                            }
                        }break;
                        case Maison:
                        {
                            switch (choix[j])
                            {
                                case 9:
                                {
                                    System.out.println("**L'ancien nombre des pieces  ::  " + ((Maison)b).getNb_pieces());
                                    System.out.print("--Donnez le nouveau nombre des pieces : \t");
                                    ((Maison)b).setNb_pieces(sc.nextInt());
                                }break;
                                case 10:
                                {
                                    System.out.println("**Meuble ou non  ::  " + ((Maison)b).isMeuble());
                                    System.out.print("--La nouvelle valeur : \t");
                                    ((Maison)b).setMeuble(sc.nextBoolean());
                                }break;
                                case 11:
                                {
                                    System.out.println("**L'ancien nombre des etages  ::  " + ((Maison)b).getNb_etages());
                                    System.out.print("--Donnez le nouveau nombre des etages : \t");
                                    ((Maison)b).setNb_etages(sc.nextInt());
                                }break;
                                case 12:
                                {
                                    System.out.println("**Garage ou non  ::  " + ((Maison)b).isGarage());
                                    System.out.print("--La nouvelle valeur : \t");
                                    ((Maison)b).setGarage(sc.nextBoolean());
                                }break;
                                case 13:
                                {
                                    System.out.println("**Jardin ou non  ::  " + ((Maison)b).isJardin());
                                    System.out.print("--La nouvelle valeur : \t");
                                    ((Maison)b).setJardin(sc.nextBoolean());
                                }break;
                                case 14:
                                {
                                    System.out.println("**Piscine ou non  ::  " + ((Maison)b).isPiscine());
                                    System.out.print("--La nouvelle valeur : \t");
                                    ((Maison)b).setPiscine(sc.nextBoolean());
                                }break;
                                case 15:
                                {
                                    System.out.println("**L'ancien Superficie habitable  ::  " + ((Maison)b).getSuperficie_habitable());
                                    System.out.print("--Donnez la nouvelle superficie habitable : \t");
                                    ((Maison)b).setSuperficie_habitable(sc.nextDouble());
                                }break;
                                case 16:
                                {
                                    System.out.println("**Echange hors wilaya  ::  " + b.isEch_hors_wilaya());
                                    System.out.print("--La nouvelle valeur : \t");
                                    b.setEch_hors_wilaya(sc.nextBoolean());
                                }break;
                            }
                        }break;
                        case Terrain:
                        {
                            switch (choix[j])
                            {
                                case 9:
                                {
                                    System.out.println("**L'ancien statut jurdique  ::  " + ((Terrain)b).getStatut_jurdique());
                                    System.out.print("--Donnez la nouvelle statut jurdique : \t");
                                    ((Terrain)b).setStatut_jurdique(sc.nextLine());
                                }break;
                                case 10:
                                {
                                    System.out.println("**L'ancien nombre des facades  ::  " + ((Terrain)b).getNb_façade());
                                    System.out.print("--Donnez le nouveau nombre des facades : \t");
                                    ((Terrain)b).setNb_façade(sc.nextInt());
                                }break;
                                case 11:
                                {
                                    System.out.println("**Echange hors wilaya  ::  " + b.isEch_hors_wilaya());
                                    System.out.print("--La nouvelle valeur : \t");
                                    b.setEch_hors_wilaya(sc.nextBoolean());
                                }break;
                            }
                        }
                    }
                }
            }

            switch (b.getType_bien())
            {
                case Appartement:
                {
                    ((Appartement)b).frais_app(b.getNature());
                }break;

                case Maison:
                {
                    ((Maison)b).frais_maison(b.getNature());
                }break;

                case Terrain:
                {
                    ((Terrain)b).frais_terrain(b.getNature());
                }break;
            }

            System.out.println("Les modification sont bien enregis");
            System.out.println("Le nouveau prix "  +  (b.getPrix()+b.getPrix_agence()));
        }
        else System.out.println("Le bien n'existe pas..!");
    }
}
