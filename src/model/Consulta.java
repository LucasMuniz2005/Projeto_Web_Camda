// GRUPO 13
// Componentes: Caio Santana, Lucas Muniz e Piersilvio Orlandini

package model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_hora_agendamento")
    private LocalDateTime dataHoraAgendamento;

    @Column(name = "data_hora_efetiva")
    private LocalDateTime dataHoraEfetiva;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario canceladaPor;

    @ManyToOne
    @JoinColumn(name = "configuracao_perfil_profissional_saude_id")
    private ConfiguracaoPerfilProfissionalSaude foiRegistradaPor;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<ResultadoExame> resultadosExame = new ArrayList<>();

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "consulta_registro_doenca",
        joinColumns = @JoinColumn(name = "consulta_id"),
        inverseJoinColumns = @JoinColumn(name = "registro_doenca_id")
    )
    private List<RegistroDoenca> registrosDoenca = new ArrayList<>();

    @ManyToMany
    @JoinTable(
        name = "consulta_posologia",
        joinColumns = @JoinColumn(name = "consulta_id"),
        inverseJoinColumns = @JoinColumn(name = "posologia_id")
    )
    private List<Posologia> posologias = new ArrayList<>();

    public Consulta() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDataHoraAgendamento() { return dataHoraAgendamento; }
    public void setDataHoraAgendamento(LocalDateTime dataHoraAgendamento) { this.dataHoraAgendamento = dataHoraAgendamento; }

    public LocalDateTime getDataHoraEfetiva() { return dataHoraEfetiva; }
    public void setDataHoraEfetiva(LocalDateTime dataHoraEfetiva) { this.dataHoraEfetiva = dataHoraEfetiva; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public StatusConsulta getStatus() { return status; }
    public void setStatus(StatusConsulta status) { this.status = status; }

    public Paciente getPaciente() { return paciente; }
    public void setPaciente(Paciente paciente) { this.paciente = paciente; }

    public Usuario getCanceladaPor() { return canceladaPor; }
    public void setCanceladaPor(Usuario canceladaPor) { this.canceladaPor = canceladaPor; }

    public ConfiguracaoPerfilProfissionalSaude getFoiRegistradaPor() { return foiRegistradaPor; }
    public void setFoiRegistradaPor(ConfiguracaoPerfilProfissionalSaude foiRegistradaPor) { this.foiRegistradaPor = foiRegistradaPor; }

    public Plano getPlano() { return plano; }
    public void setPlano(Plano plano) { this.plano = plano; }

    public List<ResultadoExame> getResultadosExame() { return new ArrayList<>(resultadosExame); }
    public void setResultadosExame(List<ResultadoExame> resultadosExame) { this.resultadosExame = resultadosExame; }
    public void adicionarResultadoExame(ResultadoExame r) { this.resultadosExame.add(r); }
    public void removerResultadoExame(ResultadoExame r) { this.resultadosExame.remove(r); }

    public List<Reserva> getReservas() { return new ArrayList<>(reservas); }
    public void setReservas(List<Reserva> reservas) { this.reservas = reservas; }
    public void adicionarReserva(Reserva r) { this.reservas.add(r); }
    public void removerReserva(Reserva r) { this.reservas.remove(r); }

    public List<RegistroDoenca> getRegistrosDoenca() { return new ArrayList<>(registrosDoenca); }
    public void setRegistrosDoenca(List<RegistroDoenca> registrosDoenca) { this.registrosDoenca = registrosDoenca; }
    public void adicionarRegistroDoenca(RegistroDoenca r) { this.registrosDoenca.add(r); }
    public void removerRegistroDoenca(RegistroDoenca r) { this.registrosDoenca.remove(r); }

    public List<Posologia> getPosologias() { return new ArrayList<>(posologias); }
    public void setPosologias(List<Posologia> posologias) { this.posologias = posologias; }
    public void adicionarPosologia(Posologia p) { this.posologias.add(p); }
    public void removerPosologia(Posologia p) { this.posologias.remove(p); }
}