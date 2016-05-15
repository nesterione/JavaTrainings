package javaselast.examples.app.persistance;

import java.util.List;

public interface Repository<T,K> {

    List<T> find();
    List<T> find( Predicate<T> predicate );
    T findById(K key);
    void delete(T entity);
    void update(T entity);

    /**
     * SDfsfsdfsdfsdfs sdfsdf.
     *
     * sdfj <p>sdfs</p>
     * f sfsdfsfsdf
     *
     * @param entity (don't check)
     * @return
     */
    T insert(T entity);
    Repository<K,T> copy(Repository<K,T> repository);

    void saveChanges();
}
