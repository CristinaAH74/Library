import java.util.List;

public class CatalogElemente extends ElemList<ElementAbstract,String> {
    //Singleton
    private static CatalogElemente instance;
    private CatalogElemente() {}
    public static CatalogElemente Instance(){
        if(instance == null) instance = new CatalogElemente();
        return instance;
    }

    public ElementAbstract adaugaElem(ElementAbstract elemAbs){
        ElementAbstract elementAbs;
        elementAbs = insereazaObiect(elemAbs);
        return elementAbs;
    }

    public ElementAbstract cautaElem (String Id){
        ElementAbstract elementAbs;
        elementAbs = cautaObiect(Id);
        return elementAbs;
    }

    public boolean stergeElem(ElementAbstract elemAbs){
        boolean result = stergeObiect(elemAbs);
        return result;
    }


    public List<ElementAbstract>getCatalogElemente(){
        return super.getCatalog();
    }
}
