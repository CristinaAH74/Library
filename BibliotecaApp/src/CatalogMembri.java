public class CatalogMembri extends ElemList<Membru,String>{
    //Singleton
    private static CatalogMembri instance = null;
    private CatalogMembri(){}
    public static CatalogMembri Instance(){
        if(instance == null) instance = new CatalogMembri();
        return instance;
    }

    public Membru adaugaMembruCatalog(Membru m){
        Membru membru;
        membru = insereazaObiect(m);
        return membru;

    }

    public Membru cautaMembru(String idM){
        Membru membru;
        membru = cautaObiect(idM);
        return membru;
    }

    public boolean stergeMembru(Membru m){
        boolean result = stergeObiect(m);
        return result;
    }
}
