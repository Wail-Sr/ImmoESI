package TP;

import java.util.Date;

public abstract class Biens implements Comparable<Biens>{
    protected Type_bien type_bien;
    protected String adress;
    protected Wilaya wilaya;
    protected double superficie;
    protected Prop prop;
    protected Nature_biens nature;
    protected boolean ech_hors_wilaya;
    protected long prix;
    protected boolean negociable;
    protected String Description;
    protected long date_ajoute;
    protected long prix_agence;

    public Type_bien getType_bien() {
        return type_bien;
    }

    public String getAdress() {
        return adress;
    }

    public Wilaya getWilaya() {
        return wilaya;
    }

    public double getSuperficie() {
        return superficie;
    }

    public long getPrix() {
        return prix;
    }

    public long getDate_ajoute() {
        return date_ajoute;
    }

    public Nature_biens getNature() {
        return nature;
    }

    public boolean isEch_hors_wilaya() {
        return ech_hors_wilaya;
    }

    public String getDescription() {
        return Description;
    }

    public Prop getProp() {
        return prop;
    }

    public boolean isNegociable() {
        return negociable;
    }

    public long getPrix_agence() {
        return prix_agence;
    }

    public void setType_bien(Type_bien type_bien) {
        this.type_bien = type_bien;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setN_wilya(int n_wilya) {
        this.wilaya = new Wilaya(n_wilya);
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    public void setDate_ajoute() {
        this.date_ajoute = System.currentTimeMillis() ;;
    }

    public void setNature(Nature_biens nature) {
        this.nature = nature;
    }

    public void setEch_hors_wilaya(boolean ech_hors_wilaya) {
        this.ech_hors_wilaya = ech_hors_wilaya;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public void setNegociable(boolean negociable) {
        this.negociable = negociable;
    }

    public void setPrix_agence(long prix_agence) {
        this.prix_agence = prix_agence;
    }

    @Override
    public boolean equals(Object obj) {
        Biens b = (Biens)obj;
        return this.prop.getEmail().equals(b.getProp().getEmail());
    }

    @Override
    public int compareTo(Biens o) {
        long d = o.getDate_ajoute();
        if (this.date_ajoute < d) return 1;
        else if (this.date_ajoute > d) return -1;
        return 0;
    }

    public void afficher_bien(){
        Date date = new Date(date_ajoute) ;
        System.out.println("Le type : \t" + type_bien);
        System.out.println("L'adresse : \t" + adress);
        System.out.println("Wilaya : \t" + wilaya.getW());
        System.out.println("La superficie totale : \t" + superficie + " m²");
        System.out.println("Les informations du propietere  :  ");
        System.out.println("        Nom :  " + prop.getNom());
        System.out.println("        Prenom :  " + prop.getPrenom());
        System.out.println("        E-mail :  "+ prop.email);
        System.out.println("        Tel :  " + prop.getTel());
        System.out.println("        L'adresse  :  " + prop.getAdress());
        System.out.println("La nature : \t" + nature);
        if (nature == Nature_biens.Echange) System.out.println("Echange hors wilaya : \t" + ech_hors_wilaya);
        System.out.println("La description : ");
        System.out.println("        " + Description);
        System.out.println("La date d'ajoute : \t" + date);
        System.out.println("Le prix : \t" + prix + " DA");
        System.out.println("Negociable : \t" + negociable);
        System.out.println("Feais d'agence : \t" + prix_agence + " DA");
        System.out.println("Prix totale : \t" + (prix + prix_agence) + " DA");
    }

    public void affiche_petit_bien(){
        System.out.println("Type : " + type_bien + ",  Nature : " + nature + ",  Wilaya : " + wilaya.getW() + ",  Prix : " + (prix+prix_agence));
    }
}
