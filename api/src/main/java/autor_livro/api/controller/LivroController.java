package autor_livro.api.controller;

import autor_livro.api.dto.LivroDTO;
import autor_livro.api.service.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @Operation(summary = "Listar todos os livros")
    @ApiResponse(responseCode = "200", description = "Livros listados com sucesso")
    @GetMapping
    public List<LivroDTO> listar() {
        return livroService.listarTodos();
    }

    @Operation(summary = "Criar um novo livro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Livro criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PostMapping
    public LivroDTO criar(@Valid @RequestBody LivroDTO dto) {
        return livroService.salvar(dto);
    }

    @Operation(summary = "Atualizar um livro existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos")
    })
    @PutMapping("/{id}")
    public LivroDTO atualizar(@PathVariable Long id, @Valid @RequestBody LivroDTO dto) {
        return livroService.atualizar(id, dto);
    }

    @Operation(summary = "Excluir um livro por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Livro excluído com sucesso"),
            @ApiResponse(responseCode = "404", description = "Livro não encontrado")
    })
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        livroService.excluir(id);
    }
}
