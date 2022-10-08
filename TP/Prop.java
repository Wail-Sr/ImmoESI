package TP;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Prop{
    protected String nom, prenom, email, adress;
    protected int tel;
    protected Set<Biens> biens;
    public Prop(String nom, String prenom, String email, int tel, String adress)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.adress = adress;
        biens = new TreeSet<Biens>();
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getTel() {
        return tel;
    }

    public String getAdress() {
        return adress;
    }

    public Set<Biens> getBiens() {
        return biens;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void addBien(Biens bien){
        biens.add(bien);
    }

    @Override
    public boolean equals(Object obj) {
        Prop p = (Prop)obj;
        return (this.email.equals(p.getEmail()));
    }

    public void afficher_liste_biens()
    {
        Biens b = null;
        Iterator<Biens> it = biens.iterator();
        while(it.hasNext()) {
            b = it.next();
            b.affiche_petit_bien();
        }
    }

    public void afficher_prop_info(){
        System.out.println("Nom : " + this.nom + "      Prenom : " + this.prenom + "        email : " + this.email + "      tel : " + this.tel + "      adresse : " + this.adress + "       Nbr des biens : " + this.biens.size());
    }
}
