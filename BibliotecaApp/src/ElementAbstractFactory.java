public class ElementAbstractFactory {
    //Singleton
    private static ElementAbstractFactory instance;
    public ElementAbstractFactory() {}
    public static ElementAbstractFactory Instance(){
        if(instance == null) instance = new ElementAbstractFactory();
        return instance;
    }

    public ElementAbstract CreazaElementConcret(String autor, String titlu, String tip, int taxa, boolean inSala){
        switch (tip) {
            case "carte" -> {
                Carte carte = new Carte(autor, titlu);
                return carte;
            }
            case "revista" -> {
                Revista revista = new Revista(titlu);
                return revista;
            }
            case "carteTaxa" -> {
                ElemCuTaxa carteCuTaxa = new ElemCuTaxa(new Carte(autor, titlu),taxa);
                return carteCuTaxa;
            }
            case "carteSala" -> {
                ElemInSala carteInSala = new ElemInSala(new Carte(autor, titlu),true, taxa);
                return carteInSala;
            }
            case "carteSalaTaxa" -> {
                ElemInSala carteInSalaTaxa = new ElemInSala(new ElemCuTaxa(new Carte(autor,titlu),taxa),true, taxa);
                return carteInSalaTaxa;
            }
            case "revistaTaxa"->{
                ElemCuTaxa revistaCuTaxa = new ElemCuTaxa(new Revista(titlu),taxa);
                return revistaCuTaxa;
            }
            case "revistaSala"->{
                ElemInSala revistaInSala = new ElemInSala(new Revista(titlu),true, taxa);
                return revistaInSala;
            }
            case "revistaSalaTaxa"->{
                ElemInSala revistaInSalaTaxa = new ElemInSala(new ElemCuTaxa(new Revista(titlu),taxa),true, taxa);
                return revistaInSalaTaxa;
            }
        }
        return null;
    }
}
