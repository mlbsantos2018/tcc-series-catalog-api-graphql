package com.mayconn.api_series_tcc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mayconn.api_series_tcc.model.Categoria;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria, String> {
    List<Categoria> findByNomeContainingIgnoreCase(String nome);
}
