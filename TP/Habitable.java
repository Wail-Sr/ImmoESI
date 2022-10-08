package TP;

public class Habitable extends Transactions{
    protected int nb_pieces;
    protected boolean meuble;

    public Habitable(Type_bien type_bien, String adress, int n_wilaya, double superficie, Prop prop, Nature_biens nature, long prix, boolean negociable, String Description, int nb_pieces, boolean meuble){
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
        this.nb_pieces = nb_pieces;
        this.meuble = meuble;
    }

    public int getNb_pieces() {
        return nb_pieces;
    }

    public boolean isMeuble() {
        return meuble;
    }

    public void setNb_pieces(int nb_pieces) {
        this.nb_pieces = nb_pieces;
    }

    public void setMeuble(boolean meuble) {
        this.meuble = meuble;
    }
}
