package autor_livro.api.controller;

import autor_livro.api.dto.LivroDTO;
import autor_livro.api.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDTO> listar() {
        return livroService.listarTodos();
    }

    @PostMapping
    public LivroDTO criar(@Valid @RequestBody LivroDTO dto) {
        return livroService.salvar(dto);
    }

    @PutMapping("/{id}")
    public LivroDTO atualizar(@PathVariable Long id, @Valid @RequestBody LivroDTO dto) {
        return livroService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        livroService.excluir(id);
    }
}