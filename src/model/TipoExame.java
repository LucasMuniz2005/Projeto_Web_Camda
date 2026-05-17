// GRUPO 13
// Componentes: Caio Santana, Lucas Muniz e Piersilvio Orlandini

package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_exame")
public class TipoExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao", nullable = false)
    private ClassificacaoTipoExame classificacao;

    @OneToMany(mappedBy = "tipoExame")
    private List<ResultadoExame> resultadosExame = new ArrayList<>();

    public TipoExame() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public ClassificacaoTipoExame getClassificacao() { return classificacao; }
    public void setClassificacao(ClassificacaoTipoExame classificacao) { this.classificacao = classificacao; }

    public List<ResultadoExame> getResultadosExame() { return new ArrayList<>(resultadosExame); }
    public void setResultadosExame(List<ResultadoExame> resultadosExame) { this.resultadosExame = resultadosExame; }
    public void adicionarResultadoExame(ResultadoExame r) { this.resultadosExame.add(r); }
    public void removerResultadoExame(ResultadoExame r) { this.resultadosExame.remove(r); }
}