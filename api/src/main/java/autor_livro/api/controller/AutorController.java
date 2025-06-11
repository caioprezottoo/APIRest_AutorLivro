package autor_livro.api.controller;

import autor_livro.api.dto.AutorDTO;
import autor_livro.api.service.AutorService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<AutorDTO> listar() {
        return autorService.listarTodos();
    }

    @PostMapping
    public AutorDTO criar(@Valid @RequestBody AutorDTO dto) {
        return autorService.salvar(dto);
    }

    @PutMapping("/{id}")
    public AutorDTO atualizar(@PathVariable Long id, @Valid @RequestBody AutorDTO dto) {
        return autorService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        autorService.excluir(id);
    }
}
