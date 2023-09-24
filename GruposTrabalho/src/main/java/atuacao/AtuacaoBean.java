/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package atuacao;

import grupo.MembroDto;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author deise
 */
@Stateless
public class AtuacaoBean implements AtuacaoBeanLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(Atuacao atuacao) {
        em.persist(atuacao);
    }

    @Override
    public List<MembroDto> getNomesGruposMembrosData(List<Long> idsGrupos, LocalDate dataInicio) {
        TypedQuery resultado = em.createQuery("SELECT NEW grupo.MembroDto(grupo.nome, pessoa.nome, atuacao.inicio) "
                + "FROM Atuacao atuacao "
                + "JOIN atuacao.grupo grupo "
                + "JOIN atuacao.pessoa pessoa "
                + "WHERE atuacao.inicio >= :dataInicio "
                + "AND grupo.id IN :idsGrupos "
                + "ORDER BY grupo.nome, atuacao.inicio",
                MembroDto.class)
                .setParameter("idsGrupos", idsGrupos)
                .setParameter("dataInicio", dataInicio);

        return resultado.getResultList();
    }
}
