package TP;

public class Maison extends Habitable {
    protected int nb_etages;
    protected boolean garage;
    protected boolean jardin;
    protected boolean piscine;
    protected double superficie_habitable;

    public Maison(Type_bien type_bien, String adress, int n_wilaya, double superficie, Prop prop, Nature_biens nature, long prix, boolean negociable, String Description, int nb_pieces, boolean meuble, int nb_etages, boolean garage, boolean jardin, boolean piscine, double superficie_habitable) {
        super(type_bien, adress, n_wilaya, superficie, prop, nature, prix, negociable, Description, nb_pieces, meuble);
        this.nb_etages = nb_etages;
        this.garage = garage;
        this.jardin = jardin;
        this.piscine = piscine;
        this.superficie_habitable = superficie_habitable;
        frais_maison(nature);
    }

    public int getNb_etages() {
        return nb_etages;
    }

    public boolean isGarage() {
        return garage;
    }

    public boolean isJardin() {
        return jardin;
    }

    public boolean isPiscine() {
        return piscine;
    }

    public double getSuperficie_habitable() {
        return superficie_habitable;
    }

    public void setNb_etages(int nb_etages) {
        this.nb_etages = nb_etages;
    }

    public void setGarage(boolean garage) {
        this.garage = garage;
    }

    public void setJardin(boolean jardin) {
        this.jardin = jardin;
    }

    public void setPiscine(boolean piscine) {
        this.piscine = piscine;
    }

    public void setSuperficie_habitable(double superficie_habitable) {
        this.superficie_habitable = superficie_habitable;
    }

    public void afficher_maison(){
        super.afficher_bien();
        System.out.println("Nombre de pieces : \t" + getNb_pieces());
        System.out.println("Est-il meublé : \t" + isMeuble());
        System.out.println("Nombre d'etages : \t" + nb_etages);
        System.out.println("Il y a un garage : \t" + garage);
        System.out.println("Il y a un jardin : \t" + jardin);
        System.out.println("Il y a une piscine : \t" + piscine);
        if(jardin || piscine) System.out.println("La superficie habitable : \t" + superficie_habitable);
    }


    public void frais_maison(Nature_biens n)
    {
        switch (n)
        {
            case Vente: frais_vente_maison();break;
            case Location: frais_loc_maison();break;
            case Echange: frais_ech_maison();break;
        }
    }

    public void frais_vente_maison(){
        long p = frais_vente();
        if(garage || jardin || piscine) {
            p = p + getPrix()/100/2;
        }
        setPrix_agence(p);
    }

    public void frais_loc_maison(){
        long p = frais_Location();
        if (piscine) {
            p = p + 50000;
        }
        setPrix_agence(p);
    }

    public void frais_ech_maison(){
        long p = frais_Echange();
        if(garage || jardin || piscine) {
            p = p + getPrix()/100/2;
        }
        setPrix_agence(p);
    }
}
