/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pessoa;

import atuacao.Atuacao;
import grupo.Grupo;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

/**
 *
 * @author deise
 */
@Entity(name = "Pessoa")
@NamedQueries({
    @NamedQuery(name = "Pessoa.getPessoasNamedQuery", query = "SELECT pessoa FROM Pessoa pessoa"),
    @NamedQuery(name = "Pessoa.getNomesNamedQuery", query = "SELECT pessoa.nome FROM Pessoa pessoa"),
    @NamedQuery(name = "Pessoa.getPessoasEnderecosNamedQuery", query = "SELECT pessoa.nome, pessoa.endereco FROM Pessoa pessoa"),
    @NamedQuery(name = "Pessoa.getPessoasAvenidasNamedQuery", query = "SELECT pessoa FROM Pessoa pessoa WHERE pessoa.endereco.tipoLogradouro = 1"),
    @NamedQuery(name = "Pessoa.getPessoasNaoPracasNamedQuery", query = "SELECT pessoa FROM Pessoa pessoa WHERE NOT pessoa.endereco.tipoLogradouro = 2"),
    @NamedQuery(name = "Pessoa.getNomesTelefonesNamedQuery", query = "SELECT pessoa.nome, telefones FROM Pessoa pessoa JOIN pessoa.telefones telefones")
})
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 65, nullable = false)
    private String nome;

    @Column(length = 65, nullable = false, unique = true)
    private String email;

    @Column(columnDefinition = "DATE")
    private LocalDate nascimento;

    @Transient
    private Byte idade;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Telefone> telefones;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "pessoa_id")
    private List<Atuacao> atuacoes;

    @OneToMany(mappedBy = "lider", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grupo> liderancas;

    public Pessoa() {
        this.telefones = new ArrayList<>();
        this.atuacoes = new ArrayList<>();
        this.liderancas = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Byte getIdade() {
        this.idade = (byte) (LocalDate.now().getYear() - this.nascimento.getYear());
        
        return (byte) idade;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Atuacao> getAtuacoes() {
        return atuacoes;
    }

    public void setAtuacoes(List<Atuacao> atuacoes) {
        this.atuacoes = atuacoes;
    }

    public List<Grupo> getLiderancas() {
        return liderancas;
    }

    public void setLiderancas(List<Grupo> liderancas) {
        this.liderancas = liderancas;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "id=" + id + ", nome=" + nome + ", email=" + email + ", nascimento=" + nascimento
                + ", idade=" + idade + ", endereco=" + endereco
                + ", telefones=" + telefones + ", atuacoes=" + atuacoes + ", liderancas=" + liderancas + '}';
    }

}
