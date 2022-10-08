package TP;

import java.util.*;

public class Agence {
    protected static Map<String, Prop> liste_prop = new HashMap<String, Prop>();
    protected static Map<String, Biens> lesbiens = new LinkedHashMap<String, Biens>();
    protected static Map<String, Biens> archive = new LinkedHashMap<String, Biens>();

    public static HashMap<String, Prop> getListe_prop() {
        return (HashMap<String, Prop>) liste_prop;
    }

    public static LinkedHashMap<String, Biens> getLesbiens() {
        return (LinkedHashMap<String, Biens>) lesbiens;
    }

    public static LinkedHashMap<String, Biens> getArchive() {
        return (LinkedHashMap<String, Biens>) archive;
    }

    public static void add_prop(Prop p)
    {
        liste_prop.put(p.getEmail(), p);
    }

    public static void add_bien(Biens b)
    {
        if (archive.containsKey(b.getAdress()))
        {
            System.out.println("Le bien existe deja dans l'archive ..!");
            return;
        }
        if(!lesbiens.containsKey(b.getAdress()))
        {
            lesbiens.put(b.getAdress(), b);
            if(!liste_prop.containsKey(b.getProp().getEmail()))
                add_prop(b.getProp());
            liste_prop.get(b.getProp().getEmail()).addBien(b);
        }
        else System.out.println("Le bien existe deja ..!");
    }

    public static void remove_bien(Biens b)
    {
             lesbiens.remove(b.getAdress());
    }

    public static void archiver_bien(Biens b)
    {
        archive.put(b.getAdress(), b);
        remove_bien(b);
    }



}
