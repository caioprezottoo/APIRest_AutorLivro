package autor_livro.api.service;

import autor_livro.api.dto.AutorDTO;
import autor_livro.api.exception.ResourceNotFoundException;
import autor_livro.api.model.Autor;
import autor_livro.api.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorDTO> listarTodos() {
        return autorRepository.findAll().stream().map(a -> {
            AutorDTO dto = new AutorDTO();
            dto.setId(a.getId());
            dto.setNome(a.getNome());
            return dto;
        }).collect(Collectors.toList());
    }

    public AutorDTO salvar(AutorDTO dto) {
        Autor autor = new Autor();
        autor.setNome(dto.getNome());
        autor = autorRepository.save(autor);
        dto.setId(autor.getId());
        return dto;
    }

    public AutorDTO atualizar(Long id, AutorDTO dto) {
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado"));
        autor.setNome(dto.getNome());
        autor = autorRepository.save(autor);
        dto.setId(autor.getId());
        return dto;
    }

    public void excluir(Long id) {
        if (!autorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Autor não encontrado");
        }
        autorRepository.deleteById(id);
    }
}