package com.mayconn.api_series_tcc.input;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieInput {
    private String id;
    private String titulo;
    private String descricao;
    private String nota;
    private String anoDeLancamento;
    private CategoriaInput categoria;
}
