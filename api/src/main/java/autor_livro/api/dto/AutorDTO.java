package autor_livro.api.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AutorDTO {

    private Long id;

    @NotBlank
    private String nome;
}
