package com.mayconn.api_series_tcc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mayconn.api_series_tcc.model.Categoria;
import com.mayconn.api_series_tcc.model.Serie;

@Repository
public interface SerieRepository extends MongoRepository<Serie, String> {
    List<Serie> findByTituloContainingIgnoreCase(String titulo);
    List<Serie> findByCategoriaNomeContainingIgnoreCase(String nomeCategoria);
    List<Serie> findByCategoriaIn(List<Categoria> categorias);
    List<Serie> findByAnoDeLancamento(String anoDeLancamento);
    List<Serie> findByNotaGreaterThanEqual(Double nota);
}
