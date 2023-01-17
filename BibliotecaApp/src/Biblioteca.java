import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;


public class Biblioteca {
    //Singleton
    private static Biblioteca instance = null;
    public Biblioteca(){}

    public static Biblioteca Instance(){
        if (instance == null) instance = new Biblioteca();
        return instance;
    }
    private ElemList<ElementAbstract,String> elemList = new ElemList<>();
    static CatalogMembri catalogMembri = CatalogMembri.Instance();
    static CatalogElemente catalogElemente = CatalogElemente.Instance();
    private static IAbstractElemVisitor iAbstractElemVisitor = new FormatAfisare();
    Calendar cal = Calendar.getInstance();
    Calendar calCurent = Calendar.getInstance();
    LocalDate dataCurenta = LocalDate.now();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public static int PenalizareReturIntarziat = 1;

   static ListaTranzactii listaTranzactii = ListaTranzactii.Instance();
//    static Retinere retinere = Retinere.Instance();


    public static int getPenalizareReturIntarziat() {
        return PenalizareReturIntarziat;
    }

    public static void setPenalizareReturIntarziat(int penalizareReturIntarziat) {
        PenalizareReturIntarziat = penalizareReturIntarziat;
    }

    public static Membru adaugaMembrul(String Nume, String Adresa, String Telefon){
        Membru membru = new Membru(Nume, Adresa, Telefon);
        membru.setId(String.valueOf(catalogMembri.getCatalog().size()));
        CatalogMembri.Instance().adaugaMembruCatalog(membru);
        return membru;
    }

    public static Membru cautaMembrul(String Id){
        Membru membru = catalogMembri.cautaMembru(Id);
        return membru;
    }

    public static String stergeMembrul(String IDm){
        Membru m = catalogMembri.cautaMembru(IDm);
        if(m.elemImprumutat != null) return "membrul are o carte imprumutata";
        if(m.elemRetinut != null) return "membrul are o carte retinuta";
        boolean result = catalogMembri.stergeMembru(m);
        if(!result) return "membrul nu a putut fi sters";
        return null;
    }

    public static ElementAbstract adaugaElementul(String autor, String titlu, String tip, int taxa, boolean inSala){
            ElementAbstractFactory elemAbsFactory = ElementAbstractFactory.Instance();
            ElementAbstract elemAbs = elemAbsFactory.CreazaElementConcret(autor,titlu, tip, taxa, inSala);
            elemAbs.setIdElemAbs(String.valueOf(catalogElemente.getCatalog().size()+1));
            catalogElemente.adaugaElem(elemAbs);
            return elemAbs;
    }

    public ElemList<ElementAbstract, String> afiseazaCatalog() {
        System.out.println("\nCATALOG     ");
        for(ElementAbstract elemAbs : catalogElemente.getCatalogElemente()){
            elemAbs.accept(iAbstractElemVisitor);
        }
        System.out.println("\n");
        return catalogElemente;
    }

    public static ElementAbstract cautaElementul(String Id){
        ElementAbstract elemAbs = catalogElemente.cautaElem(Id);
        return elemAbs;
    }

    public static String stergeElementul(String IdElem){
        ElementAbstract elemAbs = catalogElemente.cautaElem(IdElem);
        if(elemAbs != null){
            if(elemAbs.imprumutatDe != null) return "Cartea nu a putut fi stearsa pentru ca este imprumutata";
            if(elemAbs.retinutDe != null) return "Cartea nu a putut fi stearsa pentru ca este rezervata";
            boolean result = catalogElemente.stergeElem(elemAbs);
            if(!result) return "nu poate fi sters";
            return null;
        }
        return null;
    }

    public Tranzactie imprumutaElement(String m_id, String e_id){
        Membru membru = cautaMembrul(m_id);
        ElementAbstract elemAbs = cautaElementul(e_id);
//        if(membru.elemImprumutat != null) return "are o carte imprumutata";
//        if(membru.elemRetinut != null) return  "are o carte retinuta";
//        if(membru.penalizare > 0) return "membrul are penalizare";
        if(elemAbs.imprumutatDe != null) return new Tranzactie(); //verifica daca cartea e imprumutata
        membru.elemImprumutat = elemAbs;
        try{
            cal.setTime(sdf.parse(String.valueOf(dataCurenta)));
        }catch(ParseException e){
            e.printStackTrace();
        }
        cal.add(Calendar.DAY_OF_MONTH, -15);
        elemAbs.imprumutatDe = membru;
        elemAbs.dataDeReturnare = sdf.format(cal.getTime());
        Tranzactie tr = new Tranzactie(elemList.ElementsList.toString(),(sdf.format(cal.getTime())),"Imprumuta", membru.Nume, elemAbs.titlu);
        String.valueOf(ListaTranzactii.Instance().adaugaTranzactie(tr));
        return tr;
    }

    public Tranzactie returneazaElement(String m_id){
        Membru membru = cautaMembrul(m_id);
        ElementAbstract elemAbs = membru.elemImprumutat;
       // if(membru.elemImprumutat == null) return new Tranzactie(); //membrul nu are carti imprumutate

        Tranzactie tr = new Tranzactie(elemList.ElementsList.toString(),(sdf.format(calCurent.getTime())),"Returnare", membru.Nume, elemAbs.titlu);
        String.valueOf(ListaTranzactii.Instance().adaugaTranzactie(tr));
        membru.dataReturnare = sdf.format(calCurent.getTime());
        int comparaData =membru.dataReturnare.compareTo(elemAbs.dataDeReturnare);
            if(comparaData > 0 ){ // data de retur este depasita
                LocalDate dataElement = LocalDate.parse(elemAbs.dataDeReturnare);
                LocalDate dataMembru = LocalDate.parse(membru.dataReturnare);
                Period perioadaIntarziere = Period.between(dataMembru,dataElement);
                int zileIntarziere = Math.abs(perioadaIntarziere.getDays());
                int penalizari = (zileIntarziere * PenalizareReturIntarziat);
                if (elemAbs.retinutDe != null) penalizari *=2; //penalizarea creste de 2 ori daca elementul are o retinere
                membru.penalizare = penalizari;
                elemAbs.imprumutatDe = null;
        }
            if(membru.elemImprumutat.retinutDe !=null) //cartea e retinuta de cineva
            {
                imprumutaElement(membru.elemImprumutat.idElemAbs, membru.elemImprumutat.retinutDe.Id);
                Tranzactie tr2 = new Tranzactie(elemList.ElementsList.toString(),(sdf.format(calCurent.getTime())),"Imprumuta", membru.Nume, elemAbs.titlu);
                Tranzactie adaugat = ListaTranzactii.Instance().adaugaTranzactie(tr2);
                return adaugat;
            }
            return tr;
    }

    public static String retineElementul(String m_id, String elem_id){
        Membru mem = cautaMembrul(m_id);
        ElementAbstract elemAbs = cautaElementul(elem_id);
       // if(mem.elemImprumutat !=null) return "membrul are deja o carte imprumutata";
       // if(mem.elemRetinut !=null) return "membrul are deja o carte retinuta";
       // if(elemAbs.retinutDe ==null) return "cartea nu este acum retinuta";
        if(elemAbs.imprumutatDe !=null) return "cartea este imprumutata";
        mem.elemRetinut = elemAbs;
        elemAbs.retinutDe = mem;
        Retinere ret = new Retinere((catalogElemente.getCatalog().size() +1),mem,elemAbs);
        Retinere adaugata = ListaRetineri.Instance().adaugaRetinere(ret, ret.IdRetinere);
        return null;
    }

}
