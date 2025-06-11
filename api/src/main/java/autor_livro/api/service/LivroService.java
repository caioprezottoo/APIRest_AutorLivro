package autor_livro.api.service;

import autor_livro.api.dto.LivroDTO;
import autor_livro.api.exception.ResourceNotFoundException;
import autor_livro.api.model.Autor;
import autor_livro.api.model.Livro;
import autor_livro.api.repository.AutorRepository;
import autor_livro.api.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public List<LivroDTO> listarTodos() {
        return livroRepository.findAll().stream().map(livro -> {
            LivroDTO dto = new LivroDTO();
            dto.setId(livro.getId());
            dto.setTitulo(livro.getTitulo());
            dto.setAutorId(livro.getAutor().getId());
            return dto;
        }).collect(Collectors.toList());
    }

    public LivroDTO salvar(LivroDTO dto) {
        Autor autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado"));

        Livro livro = new Livro();
        livro.setTitulo(dto.getTitulo());
        livro.setAutor(autor);
        livro = livroRepository.save(livro);

        dto.setId(livro.getId());
        return dto;
    }

    public LivroDTO atualizar(Long id, LivroDTO dto) {
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro não encontrado"));

        Autor autor = autorRepository.findById(dto.getAutorId())
                .orElseThrow(() -> new ResourceNotFoundException("Autor não encontrado"));

        livro.setTitulo(dto.getTitulo());
        livro.setAutor(autor);
        livro = livroRepository.save(livro);

        dto.setId(livro.getId());
        return dto;
    }

    public void excluir(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new ResourceNotFoundException("Livro não encontrado");
        }
        livroRepository.deleteById(id);
    }
}
