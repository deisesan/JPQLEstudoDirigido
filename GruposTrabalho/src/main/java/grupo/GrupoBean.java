/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package grupo;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author deise
 */
@Stateless
public class GrupoBean implements GrupoBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Grupo grupo) {
        em.persist(grupo);
    }

    @Override
    public List<Grupo> getGruposNaoAtivos() {
        Query resultado = em.createQuery("SELECT grupo "
                + "FROM Grupo grupo "
                + "WHERE grupo.ativo = false");
        return (List<Grupo>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesLideresGruposNomes() {
        Query resultado = em.createQuery("SELECT grupo.nome, lideres.nome "
                + "FROM Grupo grupo "
                + "JOIN grupo.lider lideres");
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Grupo> getGruposLiderados(String nomeLider) {
        Query resultado = em
                .createQuery("SELECT grupo "
                        + "FROM Grupo grupo JOIN grupo.lider lider "
                        + "WHERE lider.nome = :nomeLider")
                .setParameter("nomeLider", nomeLider);
        return (List<Grupo>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getDatasNomeGrupo(String nomeIntegrante) {
        Query resultado = em.createQuery(
                "SELECT grupo.nome, atuacao.inicio, atuacao.termino "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "WHERE atuacao.pessoa.nome = :nomeIntegrante")
                .setParameter("nomeIntegrante", nomeIntegrante);
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Grupo> getGruposString(String string) {
        Query resultado = em.createQuery("SELECT grupo "
                + "FROM Grupo grupo "
                + "WHERE grupo.nome LIKE :string")
                .setParameter("string", '%' + string + '%');
        return (List<Grupo>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesGruposTotaisMembros() {
        Query resultado = em.createQuery("SELECT grupo.nome, "
                + "COUNT(DISTINCT atuacao.pessoa) "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "GROUP BY grupo");
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesGruposTotaisMembrosFiltro(Long quantidade) {
        Query resultado = em.createQuery("SELECT grupo.nome, "
                + "COUNT(atuacao.id) "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "GROUP BY grupo "
                + "HAVING COUNT(atuacao.id) >= :quantidade")
                .setParameter("quantidade", quantidade);
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesDataFiltroAno(Long id, LocalDate data) {
        Query resultado = em.createQuery("SELECT DISTINCT atuacao.pessoa.nome "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "WHERE grupo.id = :id "
                + "AND atuacao.inicio >= :data")
                .setParameter("id", id)
                .setParameter("data", data);
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesGruposMembrosData(LocalDate data) {
        Query resultado = em.createQuery("SELECT grupo.nome, atuacao.pessoa.nome, atuacao.inicio "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "WHERE atuacao.inicio >= :data "
                + "ORDER BY grupo.nome")
                .setParameter("data", data);
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesGruposMembrosNaoDataTermino() {
        Query resultado = em.createQuery("SELECT grupo.nome, atuacao.pessoa.nome "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "WHERE atuacao.termino IS NULL");
        return (List<Object[]>) resultado.getResultList();
    }

    @Override
    public List<Object[]> getNomesGruposLideresMembros() {
        Query resultado = em.createQuery("SELECT grupo.nome, grupo.lider.nome, atuacao.pessoa.nome "
                + "FROM Grupo grupo "
                + "JOIN grupo.atuacoes atuacao "
                + "ORDER BY grupo.nome, grupo.lider.nome, atuacao.pessoa.nome");
        return (List<Object[]>) resultado.getResultList();
    }
    
}
