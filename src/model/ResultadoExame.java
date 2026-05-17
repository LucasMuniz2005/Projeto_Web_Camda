// GRUPO 13
// Componentes: Caio Santana, Lucas Muniz e Piersilvio Orlandini

package model;

import jakarta.persistence.*;

@Entity
@Table(name = "resultado_exame")
public class ResultadoExame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_obtido")
    private String valorObtido;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "arquivo_resultado")
    private String arquivoResultado;

    @ManyToOne
    @JoinColumn(name = "consulta_id")
    private Consulta consulta;

    @ManyToOne
    @JoinColumn(name = "tipo_exame_id")
    private TipoExame tipoExame;

    public ResultadoExame() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getValorObtido() { return valorObtido; }
    public void setValorObtido(String valorObtido) { this.valorObtido = valorObtido; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getArquivoResultado() { return arquivoResultado; }
    public void setArquivoResultado(String arquivoResultado) { this.arquivoResultado = arquivoResultado; }

    public Consulta getConsulta() { return consulta; }
    public void setConsulta(Consulta consulta) { this.consulta = consulta; }

    public TipoExame getTipoExame() { return tipoExame; }
    public void setTipoExame(TipoExame tipoExame) { this.tipoExame = tipoExame; }
}
