package com.mayconn.api_series_tcc.controller;

import com.mayconn.api_series_tcc.input.ComentarioInput;
import com.mayconn.api_series_tcc.model.Comentario;
import com.mayconn.api_series_tcc.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @QueryMapping("findAllComentarios")
    public List<Comentario> findAll() {
        return comentarioService.findAll();
    }

    @QueryMapping("findComentarioById")
    public Comentario findById(@Argument String id) {
        Comentario comentario = comentarioService.findById(id);
        return comentario;
    }

    @QueryMapping
    public List<Comentario> findBySerieId(@Argument String serieId) {
        return comentarioService.findBySerieId(serieId);
    }

    @MutationMapping("saveComentario")
    public Comentario save(@Argument ComentarioInput comentarioInput) {
        return comentarioService.save(comentarioInput);
    }

    @MutationMapping("updateComentario")
    public Comentario update(@Argument ComentarioInput  comentarioInput) {
        return comentarioService.update(comentarioInput);
    }

    @MutationMapping("deleteComentario")
    public String delete(@Argument String id) {
        comentarioService.delete(id);
        return "Comentario deletado com sucesso";
    }
}
