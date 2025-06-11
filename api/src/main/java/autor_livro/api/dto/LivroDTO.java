package autor_livro.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    private Long autorId;

}
