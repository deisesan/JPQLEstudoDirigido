/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package atuacao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
