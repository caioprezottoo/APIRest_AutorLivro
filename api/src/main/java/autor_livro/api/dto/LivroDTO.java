package autor_livro.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LivroDTO {

    @Schema(description = "Identificador único do livro", example = "10")
    private Long id;

    @Schema(description = "Título do livro", example = "Dom Casmurro", required = true)
    @NotBlank
    private String titulo;

    @Schema(description = "ID do autor relacionado ao livro", example = "1", required = true)
    @NotNull
    private Long autorId;
}
