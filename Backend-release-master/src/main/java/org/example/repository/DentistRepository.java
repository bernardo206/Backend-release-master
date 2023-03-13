package org.example.repository;
import java.util.List;

public interface DentistRepository<T> {

    T save(T t);
    List<T>findAll();
    T findById(int id);
    void deleteById(int id);
    void deleteAll();

}
