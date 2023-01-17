import java.util.Objects;

public class ElemCuTaxa extends ElementAbstract {
    private ElemList<ElementAbstract,String> elemList = new ElemList<>();
    public ElementAbstract AbsElem;

    public ElemCuTaxa(ElementAbstract elemAbs, int taxa) {
        this.AbsElem = elemAbs;
        this.idElemAbs = String.valueOf(genereazaElemId());
        this.taxa = taxa;
    }
    public Long genereazaElemId(){
        return (long) elemList.getCatalog().size();
    }
    @Override
    public boolean Compare(String Id) {
        return Objects.equals(this.idElemAbs, Id);
    }
    public void accept(IAbstractElemVisitor iAbstractElemVisitor){
        iAbstractElemVisitor.Visit(this);
    }

    @Override
    public String toString() {
        return "ElemCuTaxa{" +
                "Elementul cu ID " + idElemAbs +
                ", cu titlul " + titlu +
                ", taxa=" + taxa +
                '}';
    }
}
