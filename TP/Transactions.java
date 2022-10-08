package TP;

public class Transactions extends Biens{


    public long frais_vente()
    {
        if (getPrix() < 5000000){
            if (getWilaya().getPrix_m_carre() < 50000) return ((getPrix()*3)/100);
            return ((getPrix()*35/100)/100);
        }
        else if (getPrix() > 15000000){
            if (getWilaya().getPrix_m_carre() < 70000) return ((getPrix()*1)/100);
            return ((getPrix()*2)/100);
        }
        if (getWilaya().getPrix_m_carre() < 50000) return ((getPrix()*2)/100);
        return ((getPrix()*5/2)/100);
    }

    public long frais_Location(){
        if (getSuperficie() < 60){
            if (getWilaya().getPrix_m_carre() < 50000) return ((getPrix()*1)/100);
            return ((getPrix()*3/2)/100);
        }
        else if (getSuperficie() > 150){
            if (getWilaya().getPrix_m_carre() < 50000) return ((getPrix()*3)/100);
            return ((getPrix()*7/2)/100);
        }
        if (getWilaya().getPrix_m_carre() < 50000) return ((getPrix()*2)/100);
        return ((getPrix()*5/2)/100);
    }

    public long frais_Echange(){
        if(isEch_hors_wilaya()) return frais_vente()+ getPrix()/100/4;
        return frais_vente();
    }
}
