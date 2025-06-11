package autor_livro.api.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "livro")
@Entity(name = "Livro")
// indicar que a classe Java é uma entidade JPA
@Getter
@Setter
@NoArgsConstructor
// gera um construtor sem argumentos, para o JPA funcionar corretamente (ele precisa de um construtor vazio para instanciar entidades via reflexão)
@AllArgsConstructor
// gera um construtor com todos os atributos da classe como argumentos
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

}
