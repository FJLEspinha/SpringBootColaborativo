package com.example.cebemPrueba.repositories;



import org.springframework.stereotype.Repository;

import com.example.cebemPrueba.models.Dato;


import org.springframework.data.repository.CrudRepository;

@Repository
public interface DatoRepositorie extends CrudRepository<Dato, Long> {

}
