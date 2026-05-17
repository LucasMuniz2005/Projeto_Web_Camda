// GRUPO 13
// Componentes: Caio Santana, Lucas Muniz e Piersilvio Orlandini

package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "registro_doenca")
public class RegistroDoenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "eh_cronica")
    private Boolean ehCronica;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "problema_de_saude_id")
    private ProblemaDeSaude problemaDeSaude;

    @ManyToMany(mappedBy = "registrosDoenca")
    private List<Consulta> consultas = new ArrayList<>();

    public RegistroDoenca() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Boolean getEhCronica() { return ehCronica; }
    public void setEhCronica(Boolean ehCronica) { this.ehCronica = ehCronica; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ProblemaDeSaude getProblemaDeSaude() { return problemaDeSaude; }
    public void setProblemaDeSaude(ProblemaDeSaude problemaDeSaude) { this.problemaDeSaude = problemaDeSaude; }

    public List<Consulta> getConsultas() { return new ArrayList<>(consultas); }
    public void setConsultas(List<Consulta> consultas) { this.consultas = consultas; }
    public void adicionarConsulta(Consulta c) { this.consultas.add(c); }
    public void removerConsulta(Consulta c) { this.consultas.remove(c); }
}