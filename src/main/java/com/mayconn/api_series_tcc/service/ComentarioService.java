package com.mayconn.api_series_tcc.service;

import com.mayconn.api_series_tcc.input.ComentarioInput;
import com.mayconn.api_series_tcc.model.Comentario;
import com.mayconn.api_series_tcc.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    public Comentario findById(String id) {
        return comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    public List<Comentario> findBySerieId(String serieId) {
        return comentarioRepository.findBySerieId(serieId);
    }

    public Comentario save(ComentarioInput comentarioInput) {
        return comentarioRepository.save(new Comentario(comentarioInput.getId(), 
        comentarioInput.getTexto(),
        comentarioInput.getUsuario(), 
        comentarioInput.getSerieId()));
    }

    public Comentario update(ComentarioInput comentarioInput) {
        Comentario existingComentario = findById(comentarioInput.getId());
    
        if (comentarioInput.getTexto() != null && !comentarioInput.getTexto().isEmpty()) {
            existingComentario.setTexto(comentarioInput.getTexto());
        }
        if (comentarioInput.getUsuario() != null && !comentarioInput.getUsuario().isEmpty()) {
            existingComentario.setUsuario(comentarioInput.getUsuario());
        }
        if (comentarioInput.getSerieId() != null && !comentarioInput.getSerieId().isEmpty()) {
            existingComentario.setSerieId(comentarioInput.getSerieId());
        }
        return comentarioRepository.save(existingComentario);
    }
    

    public void delete(String id) {
        Comentario existingComentario = findById(id);
        comentarioRepository.delete(existingComentario);
    }
}
