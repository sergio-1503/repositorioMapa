package uni.dao;

import java.util.List;


public interface Icrud<T> {

    abstract void graba(T o) throws Exception;

    abstract void modifica(T o) throws Exception;

    abstract void elimina(T o) throws Exception;

    abstract List<T> lista() throws Exception;
}
