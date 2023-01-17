public abstract class ElementAbstract implements ICompare<String> {
    public String idElemAbs;
    public String titlu;
    public Membru imprumutatDe;
    public String dataDeReturnare;
    public Membru retinutDe;
    public int taxa;
    private ElemList<ElementAbstract,String> elemList = new ElemList<>();

    public void setIdElemAbs(String idElemAbs) {
        this.idElemAbs = idElemAbs;
    }

    public void accept(IAbstractElemVisitor iAbstractElemVisitor){
        iAbstractElemVisitor.Visit(this);
    }

    @Override
    public boolean Compare(String Id) {
        if(this.idElemAbs == Id) return true;
        if(this instanceof ElemInSala){
            ElemInSala elemSala = (ElemInSala)this;
            if(elemSala.AbsElem.idElemAbs == Id) return true;
        }
        if(this instanceof ElemCuTaxa){
            ElemCuTaxa elemTaxa = (ElemCuTaxa)this;
            if(elemTaxa.AbsElem instanceof ElemInSala){
                ElemInSala elemSala = (ElemInSala) elemTaxa.AbsElem;
                if(elemSala.AbsElem.idElemAbs == Id)return true;
            }
            else if (elemTaxa.AbsElem.idElemAbs == Id) return true;
        }
        return false;
    }
}
