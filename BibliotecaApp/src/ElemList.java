import java.util.ArrayList;
import java.util.List;

public class ElemList<T extends ICompare<K>, K>{
    List<T> ElementsList = new ArrayList<>();

    public T insereazaObiect(T elem){
        ElementsList.add((T) elem);
        return (T) elem;
    }

    public T cautaObiect(K idObiect){
        for (T e: ElementsList) {
            if (e.Compare(idObiect)) return e;
        }
        return null;
    }

    public boolean stergeObiect(T obj){
        ElementsList.remove(obj);
        return true;
    }

    public List<T> getCatalog() {
        return this.ElementsList;
    }


}
