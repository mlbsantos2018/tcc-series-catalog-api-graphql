package com.mayconn.api_series_tcc.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comentarios")
public class Comentario {
    @Id
    private String id;
    private String texto;
    private String usuario;
    private String serieId;
}
