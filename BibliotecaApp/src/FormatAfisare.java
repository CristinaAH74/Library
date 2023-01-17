public class FormatAfisare implements IAbstractElemVisitor{

    @Override
    public String Visit(Carte carte) {
            System.out.println("[Rezultat] Cartea a fost adaugata cu succes! [Info:] ID:" + carte.idElemAbs + " Titlu: " + carte.titlu + " Autor:" + carte.autor);
            return null;
        }
    @Override
    public String Visit(Revista revista) {
        System.out.println("[Rezultat] Revista a fost gasita! [Info:] ID:" + revista.idElemAbs + " Titlu:" + revista.titlu);
        return null;
    }

    @Override
    public String Visit(ElementAbstract elementAbstract) {
        System.out.println("ID:" + elementAbstract.idElemAbs + " Titlu: " + elementAbstract.titlu);
        return null;
    }

    @Override
    public String Visit(ElemInSala elemInSala) {
        Carte carte;
        if(elemInSala.AbsElem instanceof Carte){
            carte = (Carte) elemInSala.AbsElem;
            return  Visit(carte) + "Citire: in sala";
        }
        return null;
    }

    @Override
    public String Visit(ElemCuTaxa elemCuTaxa) {
        if(elemCuTaxa.AbsElem instanceof ElemInSala){
            return  Visit((ElemInSala) elemCuTaxa.AbsElem) + "Taxa: " + elemCuTaxa.taxa;
        }
        else {
            if(elemCuTaxa.AbsElem instanceof Carte){
                Carte carte;
                carte = (Carte) elemCuTaxa.AbsElem;
                return Visit(carte) + "Citire: poate fi imprumutata ;" + "Taxa: " + elemCuTaxa.taxa;
            }
        }
        return null;
    }
}
