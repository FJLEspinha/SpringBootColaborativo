package com.example.cebemPrueba.services;




import java.util.ArrayList;

import com.example.cebemPrueba.models.Dato;
import com.example.cebemPrueba.repositories.DatoRepositorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DatoService {
    @Autowired
    DatoRepositorie datoRepositorie;

    public Dato saveDato(Dato dato) {
        Dato newDato = datoRepositorie.save(dato);
        return newDato;
    }

    public ArrayList<Dato> getAllDatos() {
        // SELECT * FROM joke
        ArrayList<Dato> datos = (ArrayList<Dato>) datoRepositorie.findAll();
        return datos;
    }
}

