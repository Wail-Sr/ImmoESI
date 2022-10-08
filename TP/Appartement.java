package TP;

public class Appartement extends Habitable {
    protected int etage;
    protected mode_app mode;
    protected boolean ascenseur;

    public Appartement(Type_bien type_bien, String adress, int n_wilaya, double superficie, Prop prop, Nature_biens nature, long prix, boolean negociable, String Description, int nb_pieces, boolean meuble, int etage, mode_app mode, boolean ascenseur){
        super(type_bien, adress, n_wilaya, superficie, prop, nature, prix, negociable, Description, nb_pieces, meuble);
        this.etage = etage;
        this.mode = mode;
        this.ascenseur = ascenseur;
        frais_app(nature);
    }

    public int getEtage() {
        return etage;
    }

    public mode_app getMode() {
        return mode;
    }

    public boolean isAscenseur() {
        return ascenseur;
    }

    public void setEtage(int etage) {
        this.etage = etage;
    }

    public void setMode(mode_app mode) {
        this.mode = mode;
    }

    public void setAscenseur(boolean ascenseur) {
        this.ascenseur = ascenseur;
    }


    public void afficher_app(){
        super.afficher_bien();
        System.out.println("Nombre de pieces : \t" + getNb_pieces());
        System.out.println("Est-il meublé : \t" + isMeuble());
        System.out.println("L'etage : \t " + etage);
        System.out.println("Il y a une ascenseur : \t" + ascenseur);
        System.out.println("Mode d'appartement : \t" + mode);
    }


    public void frais_app(Nature_biens n)
    {
        switch (n)
        {
            case Vente: frais_vente_app();break;
            case Location: frais_location_app();break;
            case Echange: frais_ech_app();break;
        }
    }

    public void frais_vente_app(){
        long p = frais_vente();
        if (etage < 3) p = p + 50000;
        setPrix_agence(p);
    }



    public void frais_location_app(){
       long p = frais_Location();
       if (etage < 3) p = p + 50000;
       if (etage > 5 && !ascenseur) p = p + 500*getWilaya().getPrix_m_carre();
       setPrix_agence(p);
    }

    public void frais_ech_app(){
        long p = frais_Echange();
        if (etage < 3) p = p + 50000;
        setPrix_agence(p);
    }
}
