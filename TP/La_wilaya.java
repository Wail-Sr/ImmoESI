package TP;

public enum La_wilaya {
    ADRAR, CHLEF, LAGHOUAT, OUM_BOUAGHI, BATNA, BEJAIA, BISKRA, BECHAR, BLIDA, BOUIRA, TAMANRASSET, TEBESSA, TLEMCEN, TIARET, TIZI_OUZOU,
    ALGER, DJELFA, JIJEL, SETIF, SAIDA, SKIKDA, SIDI_BEL_ABBES, ANNABA, GUELMA, CONSTANTINE, MEDEA, MOSTAGANEM, MSILA, MASCARA, OUARGLA, ORAN,
    EL_BAYDH, ILLIZI, BORDJ_BOU_ARRERIDJ, BOUMERDES, EL_TAREF, TINDOUF, TISSEMSILT, EL_OUED, KHENCHLA, SOUK_AHRASS, TIPAZA, MILA, AÏN_DEFLA,
    NÂAMA, AÏN_TEMOUCHENT, GHARDAÏA, RELIZANE;

    static La_wilaya[] w = La_wilaya.values();

    public static La_wilaya getwilaya(int n)
    {
        return w[n-1];
    }
    public static long getprix(int n)
    {
        return n*2000;
    }
}
