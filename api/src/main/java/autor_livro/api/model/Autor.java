package autor_livro.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "autor")
@Entity(name = "Autor")
// indicar que a classe Java é uma entidade JPA
@Getter
@Setter
@NoArgsConstructor
// gera um construtor sem argumentos, para o JPA funcionar corretamente (ele precisa de um construtor vazio para instanciar entidades via reflexão)
@AllArgsConstructor
// gera um construtor com todos os atributos da classe como argumentos
@EqualsAndHashCode(of = "id")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Livro> livros;

    // Getters e Setters
}
