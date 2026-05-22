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

    @Column(name = "data_hora_agendamento",nullable = false)
    private LocalDateTime dataHoraAgendamento;

    @Column(name = "data_hora_efetiva", nullable = false)
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
    @JoinColumn(name = "id_usuario_cancelamento")
    private Usuario canceladaPor;
    
    
    
    @ManyToOne
    @JoinColumn(name = "id_usuario_registro")
    private Usuario registrouPor;

    
    
    @ManyToOne
    @JoinColumn(name = "configuracao_perfil_profissional_saude_id")
    private ConfiguracaoPerfilProfissionalSaude foiAtendidoPor;

   
    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL)
    private List<ResultadoExame> listaResultadosExame = new ArrayList<>();

    @OneToMany
    private List<RegistroDoenca> listaRegistrosDoenca = new ArrayList<>();

    @OneToMany
    private List<Posologia> listaPosologias = new ArrayList<>();

    @OneToMany
    private List<TipoExame> listaTiposExame = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "sala_atendimento_id")
    private SalaAtendimento salaAtendimento;

    public Consulta() {}

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long i) throws ModelException {
        if(i == null)
            throw new ModelException("O id não pode ser nulo!");
        this.id = i;
    }

    public LocalDateTime getDataHoraAgendamento() {
        return dataHoraAgendamento;
    }

    public void setDataHoraAgendamento(LocalDateTime d) throws ModelException {
        if(d == null)
            throw new ModelException("A data e hora de agendamento não pode ser nula!");
        this.dataHoraAgendamento = d;
    }

    public LocalDateTime getDataHoraEfetiva() {
        return dataHoraEfetiva;
    }

    public void setDataHoraEfetiva(LocalDateTime d) throws ModelException {
        if(d == null)
            throw new ModelException("A data e hora efetiva não pode ser nula!");
        this.dataHoraEfetiva = d;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String d) throws ModelException {
        if(d == null || d.isBlank())
            throw new ModelException("A descrição não pode ser nula ou vazia!");
        this.descricao = d;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta s) throws ModelException {
        if(s == null)
            throw new ModelException("O status não pode ser nulo!");
        this.status = s;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente p) throws ModelException {
        if(p == null)
            throw new ModelException("O paciente não pode ser nulo!");
        this.paciente = p;
    }

    public Usuario getCanceladaPor() {
        return canceladaPor;
    }

    public void setCanceladaPor(Usuario u) {
        this.canceladaPor = u;
    }

    public Usuario getRegistrouPor() {
        return registrouPor;
    }

    public void setRegistrouPor(Usuario u) throws ModelException {
        if(u == null)
            throw new ModelException("O usuário que registrou não pode ser nulo!");
        this.registrouPor = u;
    }

    public ConfiguracaoPerfilProfissionalSaude getFoiAtendidoPor() {
        return foiAtendidoPor;
    }

    public void setFoiAtendidoPor(ConfiguracaoPerfilProfissionalSaude c) throws ModelException {
        if(c == null)
            throw new ModelException("O profissional de saúde não pode ser nulo!");
        this.foiAtendidoPor = c;
    }

    public SalaAtendimento getSalaAtendimento() {
        return salaAtendimento;
    }

    public void setSalaAtendimento(SalaAtendimento s) throws ModelException {
        if(s == null)
            throw new ModelException("A sala de atendimento não pode ser nula!");
        this.salaAtendimento = s;
    }

    public List<ResultadoExame> getListaResultadosExame() {
        return new ArrayList<ResultadoExame>(this.listaResultadosExame);
    }

    public void setListaResultadosExame(List<ResultadoExame> novaLista) throws ModelException {
        if(novaLista == null)
            throw new ModelException("A lista de resultados de exame não pode ser nula!");
        this.listaResultadosExame = novaLista;
    }

    public boolean adicionarResultadoExame(ResultadoExame r) {
        return this.listaResultadosExame.add(r);
    }

    public boolean removerResultadoExame(ResultadoExame r) {
        return this.listaResultadosExame.remove(r);
    }

    public List<RegistroDoenca> getListaRegistrosDoenca() {
        return new ArrayList<RegistroDoenca>(this.listaRegistrosDoenca);
    }

    public void setListaRegistrosDoenca(List<RegistroDoenca> novaLista) throws ModelException {
        if(novaLista == null)
            throw new ModelException("A lista de registros de doença não pode ser nula!");
        this.listaRegistrosDoenca = novaLista;
    }

    public boolean adicionarRegistroDoenca(RegistroDoenca r) {
        return this.listaRegistrosDoenca.add(r);
    }

    public boolean removerRegistroDoenca(RegistroDoenca r) {
        return this.listaRegistrosDoenca.remove(r);
    }

    public List<Posologia> getListaPosologias() {
        return new ArrayList<Posologia>(this.listaPosologias);
    }

    public void setListaPosologias(List<Posologia> novaLista) throws ModelException {
        if(novaLista == null)
            throw new ModelException("A lista de posologias não pode ser nula!");
        this.listaPosologias = novaLista;
    }

    public boolean adicionarPosologia(Posologia p) {
        return this.listaPosologias.add(p);
    }

    public boolean removerPosologia(Posologia p) {
        return this.listaPosologias.remove(p);
    }

    public List<TipoExame> getListaTiposExame() {
        return new ArrayList<TipoExame>(this.listaTiposExame);
    }

    public void setListaTiposExame(List<TipoExame> novaLista) throws ModelException {
        if(novaLista == null)
            throw new ModelException("A lista de tipos de exame não pode ser nula!");
        this.listaTiposExame = novaLista;
    }

    public boolean adicionarTipoExame(TipoExame t) {
        return this.listaTiposExame.add(t);
    }

    public boolean removerTipoExame(TipoExame t) {
        return this.listaTiposExame.remove(t);
    }
    
}