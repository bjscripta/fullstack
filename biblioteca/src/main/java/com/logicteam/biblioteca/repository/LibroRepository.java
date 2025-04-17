package com.logicteam.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.logicteam.biblioteca.modelo.Libro;

@Repository
public class LibroRepository {
        private List<Libro> Listalibros = new ArrayList<>();

    public List<Libro> obtenerLibro(){
        return Listalibros;
    }

    public Libro BuscarPorId(int id){
        for (Libro libro : Listalibros) {
            if(libro.getId()==id)
            return libro;
        }
        return null;
    }

    public Libro buscarPorIsbn(String isbn){
        for (Libro libro : Listalibros) {
            if(libro.getIsbn().equals(isbn)){
                return libro;
            }
        }
        return null;
    }

    public Libro guardaLibro(Libro lid){
        Listalibros.add(lid);
        return lid;
    }
    
    public Libro actualizarLibro(Libro lid){
        int id = 0;
        int idposicion = 0;
        for(int i = 0; i< Listalibros.size(); i++){
            if(Listalibros.get(i).getId()==lid.getId()){
                id=lid.getId();
                idposicion=1;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(id);
        libro1.setTitulo(lid.getTitulo());
        libro1.setAutor(lid.getAutor());
        libro1.setFechapublicacion(lid.getFechapublicacion());
        libro1.setEditorial(lid.getEditorial());
        libro1.setIsbn(lid.getIsbn());
        Listalibros.set(idposicion, libro1);
        return libro1;
    }

    public void eliminarLibro(int id){
        Libro libro = BuscarPorId(id);
        if(libro != null){
            Listalibros.remove(libro);
        }
    }

}
