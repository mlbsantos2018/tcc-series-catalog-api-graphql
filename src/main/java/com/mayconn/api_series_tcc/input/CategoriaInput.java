package com.mayconn.api_series_tcc.input;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaInput {
    private String id;
    private String nome;
}