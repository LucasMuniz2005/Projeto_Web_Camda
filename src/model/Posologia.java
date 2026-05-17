// GRUPO 13
// Componentes: Caio Santana, Lucas Muniz e Piersilvio Orlandini

package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "posologia")
public class Posologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "medicamento_id")
    private Medicamento medicamento;

    @ManyToMany(mappedBy = "posologias")
    private List<Consulta> consultas = new ArrayList<>();

    public Posologia() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Medicamento getMedicamento() { return medicamento; }
    public void setMedicamento(Medicamento medicamento) { this.medicamento = medicamento; }

    public List<Consulta> getConsultas() { return new ArrayList<>(consultas); }
    public void setConsultas(List<Consulta> consultas) { this.consultas = consultas; }
    public void adicionarConsulta(Consulta c) { this.consultas.add(c); }
    public void removerConsulta(Consulta c) { this.consultas.remove(c); }
}