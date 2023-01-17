import java.time.LocalDate;

public class Retinere implements ICompare<String> {

    private ElemList<ElementAbstract,String> elemList = new ElemList<>();
    public String IdRetinere;
    public Membru idMembru;
    public ElementAbstract idElement;
    public LocalDate dataPlasare;

    public Retinere(int i, Membru mem, ElementAbstract elemAbs) {
    }


    public Retinere(String idRetinere, Membru idMembru, ElementAbstract idElement, LocalDate dataPlasare) {
        IdRetinere = idRetinere;
        this.idMembru = idMembru;
        this.idElement = idElement;
        this.dataPlasare = dataPlasare;
    }

    @Override
    public boolean Compare(String id) {
        if(this.IdRetinere == id) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Retinere{" +
                "Id='" + IdRetinere + '\'' +
                ", idMembru=" + idMembru +
                ", idElement=" + idElement +
                ", dataPlasare=" + dataPlasare +
                '}';
    }
}
