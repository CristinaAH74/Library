public class ListaTranzactii extends ElemList<Tranzactie, String> {

    private static ListaTranzactii instance = null;

    public static ListaTranzactii Instance() {
        if(instance == null) instance = new ListaTranzactii();
        return instance;
    }

    public Tranzactie adaugaTranzactie(Tranzactie t){
        Tranzactie tr;
        tr = insereazaObiect(t);
        return tr;
    }

    public Tranzactie cautaTranzactie(String Id){
        Tranzactie tr;
        tr = cautaObiect(Id);
        return tr;
    }

    public boolean stergeTranzactie(Tranzactie t){
        boolean rezultat = stergeObiect(t);
        return rezultat;
    }
}
