import java.util.Objects;

public class ElemInSala extends ElementAbstract{
    private ElemList<ElementAbstract,String> elemList = new ElemList<>();
    public ElementAbstract AbsElem;
    public boolean inSala;

    public ElemInSala(ElementAbstract elemAbs, boolean inSala, int taxa) {
        this.AbsElem = elemAbs;
        this.idElemAbs = String.valueOf(genereazaElemId());
        this.inSala = inSala;
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
        return "ElemInSala{" +
                "Elementul cu ID " + idElemAbs +
                ", cu titlul " + titlu +
                ", se poate citi in sala = " + inSala +
                ", cu taxa = " + taxa +
                '}';
    }
}
