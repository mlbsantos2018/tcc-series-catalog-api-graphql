package com.mayconn.api_series_tcc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "series")
public class Serie {
    @Id
    private String id;
    private String titulo;
    private String descricao;
    private String nota;
    private String anoDeLancamento;
    @DBRef
    private Categoria categoria;
}
