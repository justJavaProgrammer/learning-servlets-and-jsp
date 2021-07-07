package edu.odeyalko.servlets.crudservlet;

public interface CrudInterface {
    void create();
    void read(int id);
    void update(int id);
    void delete(int id);
}
