package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.input.CategoriaInput;
import com.mayconn.api_series_tcc.model.Categoria;
import com.mayconn.api_series_tcc.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria findById(String id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    public Categoria save(CategoriaInput categoriaInput) {
        return categoriaRepository.save(new Categoria(categoriaInput.getId(), categoriaInput.getNome() ));
    }

    public Categoria update(CategoriaInput categoriaInput) {
        Categoria existingCategoria = findById(categoriaInput.getId());
        existingCategoria.setNome(categoriaInput.getNome());
        return categoriaRepository.save(existingCategoria);
    }

    public void delete(String id) {
        Categoria existingCategoria = findById(id);
        categoriaRepository.delete(existingCategoria);
    }
}
