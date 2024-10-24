package com.mayconn.api_series_tcc.controller;

import com.mayconn.api_series_tcc.input.SerieInput;
import com.mayconn.api_series_tcc.model.Serie;
import com.mayconn.api_series_tcc.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;

    @QueryMapping("findAllSeries")
    public List<Serie> findAll() {
        return serieService.findAll();
    }

    @QueryMapping("findSeriesById")
    public Serie findById(@Argument String id) {
        Serie serie = serieService.findById(id);
        return serie;
    }

    @QueryMapping
    public List<Serie> findByTitulo(@Argument String titulo) {
        return serieService.findByTitulo(titulo);
    }

    @QueryMapping
    public List<Serie> findByCategoriaNome(@Argument String nomeCategoria) {
        return serieService.findByCategoriaNome(nomeCategoria);
    }

    @QueryMapping
    public List<Serie> findByAnoDeLancamento(@Argument String anoDeLancamento) {
        return serieService.findByAnoDeLancamento(anoDeLancamento);
    }

    @QueryMapping
    public List<Serie> findByNotaMinima(@Argument Double nota) {
        return serieService.findByNotaMinima(nota);
    }

    @MutationMapping("saveSerie")
    public Serie save(@Argument SerieInput serieInput) {
        return serieService.addSerie(serieInput);
    }

    @MutationMapping("updateSerie")
    public Serie update(@Argument SerieInput serieInput) {
        serieInput.setId(serieInput.getId());  
        return serieService.updateSerie(serieInput);
    }

    @MutationMapping("deleteSerie")
    public String delete(@Argument String id) {
        serieService.deleteSerie(id);
        return "Serie deletada com sucesso";
    }
}
