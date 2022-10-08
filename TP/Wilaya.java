package TP;

public class Wilaya {
    protected int nw;
    protected La_wilaya w;
    protected long prix_m_carre;
    public Wilaya(int w){
        this.nw = w;
        this.w = La_wilaya.getwilaya(w);
        this.prix_m_carre = La_wilaya.getprix(w);
    }

    public long getPrix_m_carre() {
        return prix_m_carre;
    }

    public int getNw() {
        return nw;
    }

    public La_wilaya getW() {
        return w;
    }

    public void setPrix_m_carre(long prix_m_carre) {
        this.prix_m_carre = prix_m_carre;
    }

    public void setNw(int nw) {
        this.nw = nw;
    }

    public void setW(La_wilaya w) {
        this.w = w;
    }

    public void set(int n)
    {
        this.nw = n;
        this.w = La_wilaya.getwilaya(n);
        this.prix_m_carre = La_wilaya.getprix(n);
    }
}
