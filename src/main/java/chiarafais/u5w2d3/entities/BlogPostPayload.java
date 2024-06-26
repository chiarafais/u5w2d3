package chiarafais.u5w2d3.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class BlogPostPayload {
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;
    private int authorId;
}
