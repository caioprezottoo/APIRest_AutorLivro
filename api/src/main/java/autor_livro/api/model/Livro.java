package autor_livro.api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
// indicar que a classe Java é uma entidade JPA
@Table(name = "livro")
@Getter
@Setter
@NoArgsConstructor
// gera um construtor sem argumentos, para o JPA funcionar corretamente (ele precisa de um construtor vazio para instanciar entidades via reflexão)
@AllArgsConstructor
// gera um construtor com todos os atributos da classe como argumentos
@EqualsAndHashCode(of = "id")
// comparar objetos por id
@ToString(exclude = "autor")
// evita o problema do loop recursivo
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // gera automaticamente o id
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    // optional = false - todo livro deve ter um autor
    // fetch = FetchType.LAZY - autor é carregado quando for acessado explicitamente 
    @JoinColumn(name = "autor_id", nullable = false)
    private Autor autor;
}
