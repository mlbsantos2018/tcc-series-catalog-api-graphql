package com.mayconn.api_series_tcc.controller;

import com.mayconn.api_series_tcc.input.CategoriaInput;
import com.mayconn.api_series_tcc.model.Categoria;
import com.mayconn.api_series_tcc.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @QueryMapping("findAllCategorias")
    public List<Categoria> findAll() {
        return categoriaService.findAll();
    }

    @QueryMapping("findCategoriaById")
    public Categoria findById(@Argument String id) {
        Categoria categoria = categoriaService.findById(id);
        return categoria;
    }

    @MutationMapping("saveCategoria")
    public Categoria save(@Argument CategoriaInput categoriaInput) {
        return categoriaService.save(categoriaInput);
    }

    @MutationMapping("updateCategoria")
    public Categoria update(@Argument CategoriaInput categoriaInput) {
        return categoriaService.update(categoriaInput);
    }

    @MutationMapping("deleteCategoria")
    public String delete(@Argument String id) {
        categoriaService.delete(id);
        return "Categoria deletada com sucesso";
    }
}
