import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
//        System.out.println("Hello world!");

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adaugaElementul("autorul1", "titlu1", "revista", 2, true);
        biblioteca.adaugaElementul("autorul2", "titlu2", "carte", 0, false);
        biblioteca.adaugaElementul("autorul3", "titlu4", "carteTaxa", 5, false);
        biblioteca.adaugaElementul("autorul3", "titlu5", "carteSala", 0, true);
        biblioteca.adaugaElementul("autorul3", "titlu6", "carteSalaTaxa", 3, true);

        System.out.println("Elemente in catalogul de obiecte: " + Biblioteca.catalogElemente.ElementsList);
        biblioteca.adaugaMembrul("Andrei", "Razboieni 5", "0734555555" );
        System.out.println("Membri: " + Biblioteca.catalogMembri.ElementsList);

        ElementAbstract restult = biblioteca.cautaElementul(String.valueOf(1));
        System.out.println("Am cautat: " + restult);
//        biblioteca.stergeElementul(String.valueOf(1));
//        System.out.println("Catalogul de elemente dupa ce am sters ce am cautat: " + Biblioteca.catalogElemente.ElementsList);

        Tranzactie tranzactie = biblioteca.imprumutaElement("0", "2");
        System.out.println("Tranzactie: " + tranzactie );

        //biblioteca.stergeElementul(String.valueOf(2));
        System.out.println("\nCatalogul de elemente dupa metoda de stergere: " + Biblioteca.catalogElemente.ElementsList);
        String status = biblioteca.stergeElementul(String.valueOf(2));
        System.out.println(status + "\n");

        Tranzactie retur = biblioteca.returneazaElement("0");
        System.out.println("Retur: " + retur );
        System.out.println("Membru: " + Biblioteca.cautaMembrul("0") );

        biblioteca.afiseazaCatalog();

        Membru rezultat = biblioteca.adaugaMembrul("George", "Apateului 5", "9403583495");
        System.out.println("Am cautat: " + rezultat);
        Membru rezultat2 = biblioteca.adaugaMembrul("George", "Apateului 5", "9403583495");
        System.out.println("Am cautat: " + rezultat2);

    }
}