package com.logicteam.biblioteca.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Libro {

    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int Fechapublicacion;
    private String autor;
    
}
