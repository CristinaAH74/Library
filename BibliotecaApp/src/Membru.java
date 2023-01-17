import java.util.Objects;

public class Membru implements ICompare<String> {

    public String Id;
    public String Nume;
    public String Adresa;
    public String Telefon;
    public ElementAbstract elemImprumutat;
    public String dataReturnare;
    public ElementAbstract elemRetinut;
    private ElemList<ElementAbstract,String> elemList = new ElemList<>();
    public int penalizare;


    public String getId() {
        return Id;
    }
    public void setId(String id) {
        Id = id;
    }

    public Membru(String nume, String adresa, String telefon) {
        Id = String.valueOf(genereazaMembruId());
        Nume = nume;
        Adresa = adresa;
        Telefon = telefon;
        this.elemImprumutat = null;
        this.dataReturnare = null;
        this.elemRetinut = null;
    }

    @Override
    public boolean Compare(String Id) {
        return  Objects.equals(this.Id, Id);
    }
    public Long genereazaMembruId(){return (long) elemList.getCatalog().size();}

    @Override
    public String toString() {
        return "Membru{" +
                "ID=" + Id +
                ", nume='" + Nume + '\'' +
                ", telefon='" + Telefon + '\'' +
                ", adresa='" + Adresa + '\'' +
                ", penalizare(RON) '" + penalizare + '\'' +
                '}';
    }
}
