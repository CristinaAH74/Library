import java.util.Objects;

public class Revista extends ElementAbstract{

    private ElemList<ElementAbstract,String> elemList = new ElemList<>();

    public Revista(String titlu) {
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
        return "Revista{" +
                "ID=" + idElemAbs +
                ", titlu='" + titlu + '\'' +
                '}';
    }


}
