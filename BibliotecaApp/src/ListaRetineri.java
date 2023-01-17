public class ListaRetineri extends ElemList<Retinere, String> {
    private static  ListaRetineri instance = null;
    public static ListaRetineri Instance(){
        if(instance == null) instance = new ListaRetineri();
        return instance;
    }

    public Retinere adaugaRetinere(Retinere r, String Id){
        Retinere retinere;
        retinere = insereazaObiect(r);
        return retinere;
    }

    public Retinere cautaRetinere(String id){
        Retinere retinere;
        retinere = cautaObiect(id);
        return retinere;
    }

    public boolean stergeRetinere(Retinere r){
        boolean rezultat = stergeObiect(r);
        return rezultat;
    }
}
