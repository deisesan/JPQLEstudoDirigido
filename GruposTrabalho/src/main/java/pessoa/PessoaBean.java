/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package pessoa;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author deise
 */
@Stateless
public class PessoaBean implements PessoaBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Pessoa pessoa) {
        em.persist(pessoa);
    }

    @Override
    public List<Pessoa> getPessoasQuery() {
        Query resultado = em.createQuery("SELECT pessoa "
                + "FROM Pessoa pessoa");
        return (List<Pessoa>) resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasTypedQuery() {
        TypedQuery resultado = em.createQuery("SELECT pessoa "
                + "FROM Pessoa pessoa",
                Pessoa.class);
        return resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasNamedQuery() {
        return em.createNamedQuery("Pessoa.getPessoasNamedQuery",
                Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Object[]> getNomesQuery() {
        Query resultado = em.createQuery("SELECT pessoa.nome "
                + "FROM Pessoa pessoa");
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesTypedQuery() {
        TypedQuery resultado = em.createQuery("SELECT pessoa.nome "
                + "FROM Pessoa pessoa",
                Object[].class);
        return resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesNamedQuery() {
        return em.createNamedQuery("Pessoa.getNomesNamedQuery",
                Object[].class)
                .getResultList();
    }

    @Override
    public List<Object[]> getPessoasEnderecosQuery() {
        Query resultado = em.createQuery("SELECT pessoa.nome, pessoa.endereco "
                + "FROM Pessoa pessoa");
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getPessoasEnderecosTypedQuery() {
        TypedQuery resultado = em.createQuery("SELECT pessoa.nome, pessoa.endereco "
                + "FROM Pessoa pessoa",
                Object[].class);
        return resultado.getResultList();
    }

    @Override
    public List<Object[]> getPessoasEnderecosNamedQuery() {
        return em.createNamedQuery("Pessoa.getPessoasEnderecosNamedQuery",
                Object[].class)
                .getResultList();
    }

    @Override
    public List<Pessoa> getPessoasAvenidasQuery() {
        Query resultado = em.createQuery("SELECT pessoa "
                + "FROM Pessoa pessoa "
                + "WHERE pessoa.endereco.tipoLogradouro = 1");
        return (List<Pessoa>) resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasAvenidasTypedQuery() {
        TypedQuery resultado = em.createQuery("SELECT pessoa "
                + "FROM Pessoa pessoa "
                + "WHERE pessoa.endereco.tipoLogradouro = 1",
                Pessoa.class);
        return resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasAvenidasNamedQuery() {
        return em.createNamedQuery("Pessoa.getPessoasAvenidasNamedQuery",
                Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Pessoa> getPessoasNaoPracasQuery() {
        Query resultado = em.createQuery("SELECT pessoa "
                + "FROM Pessoa pessoa "
                + "WHERE NOT pessoa.endereco.tipoLogradouro = 2");
        return (List<Pessoa>) resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasNaoPracasTypedQuery() {
        TypedQuery resultado = em.createQuery("SELECT pessoa "
                + "FROM Pessoa pessoa "
                + "WHERE NOT pessoa.endereco.tipoLogradouro = 2",
                Pessoa.class);
        return resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasNaoPracasNamedQuery() {
        return em.createNamedQuery("Pessoa.getPessoasNaoPracasNamedQuery",
                Pessoa.class)
                .getResultList();
    }

    @Override
    public List<Object[]> getNomesTelefonesQuery() {
        Query resultado = em
                .createQuery("SELECT pessoa.nome, telefones "
                        + "FROM Pessoa pessoa "
                        + "JOIN pessoa.telefones telefones");
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesTelefonesTypedQuery() {
        TypedQuery resultado = em.createQuery(
                "SELECT pessoa.nome, telefones "
                + "FROM Pessoa pessoa "
                + "JOIN pessoa.telefones telefones",
                Object[].class);
        return resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesTelefonesNamedQuery() {
        return em.createNamedQuery("Pessoa.getNomesTelefonesNamedQuery",
                Object[].class)
                .getResultList();
    }

    @Override
    public List<Pessoa> getPessoasAniversarios(LocalDate dataInicio, LocalDate dataFim) {
        Query resultado = em.createQuery("SELECT p "
                + "FROM Pessoa p "
                + "WHERE p.nascimento "
                + "BETWEEN :dataInicio AND :dataFim")
                .setParameter("dataInicio", dataInicio)
                .setParameter("dataFim", dataFim);
        return (List<Pessoa>) resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasTelefonesEstado(Byte ddd) {
        Query resultado = em.createQuery("SELECT DISTINCT pessoa "
                + "FROM Pessoa pessoa "
                + "JOIN pessoa.telefones telefone "
                + "WHERE telefone.ddd = :ddd")
                .setParameter("ddd", ddd);
        return (List<Pessoa>) resultado.getResultList();
    }

    @Override
    public List<Pessoa> getPessoasNaoTelefones() {
        Query resultado = em.createQuery("SELECT pessoa "
                + "FROM Pessoa pessoa "
                + "WHERE pessoa.telefones IS EMPTY");
        return (List<Pessoa>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomeCountTelefones() {
        Query resultado = em.createQuery("SELECT pessoa.nome, COUNT(telefone.id) "
                + "FROM Pessoa pessoa "
                + "LEFT JOIN pessoa.telefones telefone "
                + "GROUP BY pessoa.nome");
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesGrupoInverso(String nomeGrupo) {
        Query resultado = em.createQuery("SELECT pessoa.nome "
                + "FROM Pessoa pessoa "
                + "JOIN pessoa.atuacoes atuacao "
                + "WHERE atuacao.grupo.nome = :nomeGrupo "
                + "ORDER BY pessoa.nome DESC")
                .setParameter("nomeGrupo", nomeGrupo);
        return (List<Object[]>) resultado.getResultList();
    }

}
