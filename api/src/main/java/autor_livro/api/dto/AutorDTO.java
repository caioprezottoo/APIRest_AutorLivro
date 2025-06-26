package autor_livro.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AutorDTO {

    @Schema(description = "Identificador único do autor", example = "1")
    private Long id;

    @Schema(description = "Nome completo do autor", example = "Machado de Assis", required = true)
    @NotBlank
    private String nome;
}
