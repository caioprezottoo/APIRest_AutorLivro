package autor_livro.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
// indicar que a classe Java é uma entidade JPA
@Table(name = "autor")
@Getter
@Setter
@NoArgsConstructor
// gera um construtor sem argumentos, para o JPA funcionar corretamente (ele precisa de um construtor vazio para instanciar entidades via reflexão)
@AllArgsConstructor
// gera um construtor com todos os atributos da classe como argumentos
@EqualsAndHashCode(of = "id")
// comparar objetos por id
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // gera automaticamente o id
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, orphanRemoval = true)
    // mappedBy = "autor" - indica que o relacionamento é mapeado pelo autor
    // cascade = CascadeType.ALL - todas as operações feitas em Autor serão replicadas para os livros relacionados
    // orphanRemoval = true - evita "órfãos" no banco
    private List<Livro> livros;
}
