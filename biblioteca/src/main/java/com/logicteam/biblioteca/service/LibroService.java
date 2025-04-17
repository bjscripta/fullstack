package com.logicteam.biblioteca.service;
import com.logicteam.biblioteca.modelo.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.logicteam.biblioteca.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getLibros(){
        return libroRepository.obtenerLibro();
    }

    public Libro savedLibro(Libro libro){
        return libroRepository.guardaLibro(libro);
    }

    public Libro getLibroid(int id){
        return libroRepository.BuscarPorId(id);
    }

    public Libro updateLibro(Libro libro){
        return libroRepository.actualizarLibro(libro);
    }

    public String deleteLibro(int id){
        libroRepository.eliminarLibro(id);
        return "Producto eliminado";
    }
}
