package TP;

public class Terrain extends Transactions{
    protected String statut_jurdique;
    protected int nb_façade;

    public Terrain(Type_bien type_bien, String adress, int n_wilaya, double superficie, Prop prop, Nature_biens nature, long prix, boolean negociable, String Description, String statut_jurdique, int nb_façade){
        setType_bien(type_bien);
        setAdress(adress);
        setN_wilya(n_wilaya);
        setSuperficie(superficie);
        setProp(prop);
        setNature(nature);
        setPrix(prix);
        setNegociable(negociable);
        setDescription(Description);
        setDate_ajoute();
        this.statut_jurdique = statut_jurdique;
        this.nb_façade = nb_façade;
        frais_terrain(nature);
    }

    public void setStatut_jurdique(String statut_jurdique) {
        this.statut_jurdique = statut_jurdique;
    }

    public void setNb_façade(int nb_façade) {
        this.nb_façade = nb_façade;
    }

    public String getStatut_jurdique() {
        return statut_jurdique;
    }

    public int getNb_façade() {
        return nb_façade;
    }

    public void afficher_terrain(){
        super.afficher_bien();
        System.out.println("Statut jurdique : \t" + statut_jurdique);
        System.out.println("Nombre des façade : \t" + nb_façade);
    }

    public void frais_terrain(Nature_biens n)
    {
        switch (n)
        {
            case Vente: frais_vente_terrain();break;
            case Location: frais_loc_terrain();break;
            case Echange: frais_ech_terrain();break;
        }
    }

    public void frais_vente_terrain(){
        long p = frais_vente();
        if (nb_façade > 1) p = p + nb_façade*getPrix()/100/2;
        setPrix_agence(p);
    }

    public void frais_loc_terrain(){
        setPrix_agence(frais_Location());
    }

    public void frais_ech_terrain(){
        long p = frais_Echange();
        if (nb_façade > 1) p = p + nb_façade*getPrix()/100/2;
        setPrix_agence(p);
    }
}
