import java.util.Objects;

public class Carte extends ElementAbstract {
    private ElemList<ElementAbstract,String> elemList = new ElemList<>();
    public String autor;


    public Carte(String autor, String titlu) {
        this.autor = autor;
        this.titlu = titlu;
        this.idElemAbs = String.valueOf(genereazaElemId());
        this.imprumutatDe = null;
        this.retinutDe = null;
        this.dataDeReturnare = null;
    }

    @Override
    public boolean Compare(String Id) {
        return Objects.equals(this.idElemAbs, Id);
    }
    public Long genereazaElemId(){
        return (long) elemList.getCatalog().size();
    }

    @Override
    public String toString() {
        return "Carte{" +
                "ID=" + idElemAbs +
                ", titlu='" + titlu + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
