public interface IAbstractElemVisitor {

    String Visit(ElementAbstract elementAbstract);
    String Visit(Carte carte);
    String Visit(Revista revista);
    String Visit(ElemInSala elemInSala);
    String Visit(ElemCuTaxa elemCuTaxa);
}
