package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.input.CategoriaInput;
import com.mayconn.api_series_tcc.input.SerieInput;
import com.mayconn.api_series_tcc.model.Categoria;
import com.mayconn.api_series_tcc.model.Serie;
import com.mayconn.api_series_tcc.repository.CategoriaRepository;
import com.mayconn.api_series_tcc.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;
    

    public List<Serie> findByTitulo(String titulo) {
        return serieRepository.findByTituloContainingIgnoreCase(titulo);
    }

    public List<Serie> findByCategoriaNome(String nomeCategoria) {
        List<Categoria> categorias = categoriaRepository.findByNomeContainingIgnoreCase(nomeCategoria);
        return serieRepository.findByCategoriaIn(categorias);
    }

    public List<Serie> findByAnoDeLancamento(String anoDeLancamento) {
        return serieRepository.findByAnoDeLancamento(anoDeLancamento);
    }

    public List<Serie> findByNotaMinima(Double nota) {
        return serieRepository.findAll().stream()
                .filter(serie -> Double.parseDouble(serie.getNota()) >= nota)
                .collect(Collectors.toList());
    }

    public Serie addSerie(SerieInput serieInput) {
        return serieRepository.save(new Serie(serieInput.getId(),
        serieInput.getTitulo(),
        serieInput.getDescricao(),
        serieInput.getNota(),
        serieInput.getAnoDeLancamento(),
        new Categoria(serieInput.getCategoria().getId(),
         serieInput.getCategoria().getNome())));
    }

    public Serie updateSerie(SerieInput serieInput) {

        Serie serie = serieRepository.findById(serieInput.getId()).orElse(null);

        if (serieInput.getTitulo() != null && !serieInput.getTitulo().isEmpty()) {
            serie.setTitulo(serieInput.getTitulo());
        }
        if (serieInput.getDescricao() != null && !serieInput.getDescricao().isEmpty()) {
            serie.setDescricao(serieInput.getDescricao());
        }
        if (serieInput.getNota() != null) {
            serie.setNota(serieInput.getNota());
        }
        if (serieInput.getAnoDeLancamento() != null) {
            serie.setAnoDeLancamento(serieInput.getAnoDeLancamento());
        }
        if (serieInput.getCategoria() != null) {
            CategoriaInput categoria = serieInput.getCategoria();
            if (categoria.getId() != null && !categoria.getId().isEmpty()) {
                serie.getCategoria().setId(categoria.getId());
            }
            if (categoria.getNome() != null && !categoria.getNome().isEmpty()) {
                serie.getCategoria().setNome(categoria.getNome());
            }
        }
    
        return serieRepository.save(serie);
    }
    

    public void deleteSerie(String id) {
        serieRepository.deleteById(id);
    }

    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    public Serie findById(String id) {
        return serieRepository.findById(id).orElse(null);
    }
}
