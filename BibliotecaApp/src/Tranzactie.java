import java.time.LocalDate;
import java.util.Date;

public class Tranzactie implements ICompare<String> {

    public String Id;
    public String data;
    public String tip;
    public String nume_membru;
    public String titlu_carte;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Tranzactie() {
    }

    public Tranzactie(String id, String data, String tip, String nume_membru, String titlu_carte) {
        Id = id;
        this.data = data;
        this.tip = tip;
        this.nume_membru = nume_membru;
        this.titlu_carte = titlu_carte;
    }

    @Override
    public boolean Compare(String id) {
        if(this.Id == id) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Tranzactie{" +
                "Id='" + Id + '\'' +
                ", data retur='" + data + '\'' +
                ", tip='" + tip + '\'' +
                ", nume_membru='" + nume_membru + '\'' +
                ", titlu_carte='" + titlu_carte + '\'' +
                '}';
    }
}
