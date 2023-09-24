/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package pessoa;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author deise
 */
@Local
public interface PessoaBeanLocal {

    void create(Pessoa pessoa);

    List<Pessoa> getPessoasQuery();

    List<Pessoa> getPessoasTypedQuery();

    List<Pessoa> getPessoasNamedQuery();

    List<Object[]> getNomesQuery();

    List<Object[]> getNomesTypedQuery();

    List<Object[]> getNomesNamedQuery();

    List<Object[]> getPessoasEnderecosQuery();

    List<Object[]> getPessoasEnderecosTypedQuery();

    List<Object[]> getPessoasEnderecosNamedQuery();

    List<Pessoa> getPessoasAvenidasQuery();

    List<Pessoa> getPessoasAvenidasTypedQuery();

    List<Pessoa> getPessoasAvenidasNamedQuery();

    List<Pessoa> getPessoasNaoPracasQuery();

    List<Pessoa> getPessoasNaoPracasTypedQuery();

    List<Pessoa> getPessoasNaoPracasNamedQuery();

    List<Object[]> getNomesTelefonesQuery();

    List<Object[]> getNomesTelefonesTypedQuery();

    List<Object[]> getNomesTelefonesNamedQuery();

    List<Pessoa> getPessoasAniversarios(LocalDate dataInicio, LocalDate dataFim);

    List<Pessoa> getPessoasTelefonesEstado(Byte ddd);

    List<Pessoa> getPessoasNaoTelefones();

    List<Object[]> getNomeCountTelefones();

    List<Object[]> getNomesGrupoInverso(String nomeGrupo);
}
