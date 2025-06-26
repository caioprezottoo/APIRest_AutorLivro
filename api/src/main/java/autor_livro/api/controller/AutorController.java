package autor_livro.api.controller;

import autor_livro.api.dto.AutorDTO;
import autor_livro.api.service.AutorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @Operation(summary = "Listar todos os autores")
    @ApiResponse(responseCode = "200", description = "Autores listados com sucesso")
    @GetMapping
    public List<AutorDTO> listar() {
        return autorService.listarTodos();
    }

    @Operation(summary = "Criar um novo autor")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Autor criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })
    @PostMapping
    public AutorDTO criar(@Valid @RequestBody AutorDTO dto) {
        return autorService.salvar(dto);
    }

    @Operation(summary = "Atualizar um autor existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Autor atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados de entrada inválidos")
    })
    @PutMapping("/{id}")
    public AutorDTO atualizar(@PathVariable Long id, @Valid @RequestBody AutorDTO dto) {
        return autorService.atualizar(id, dto);
    }

    @Operation(summary = "Excluir um autor por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Autor excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado")
    })
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        autorService.excluir(id);
    }
}
