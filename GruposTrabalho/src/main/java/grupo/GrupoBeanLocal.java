/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package grupo;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author deise
 */
@Local
public interface GrupoBeanLocal {

    void create(Grupo grupo);

    List<Grupo> getGruposNaoAtivos();

    List<Object[]> getNomesLideresGruposNomes();

    List<Grupo> getGruposLiderados(String nomeLider);

    List<Object[]> getDatasNomeGrupo(String nomeIntegrante);

    List<Grupo> getGruposString(String string);

    List<Object[]> getNomesGruposTotaisMembros();

    List<Object[]> getNomesGruposTotaisMembrosFiltro(Long quantidade);

    List<Object[]> getNomesDataFiltroAno(Long id, LocalDate data);

    List<Object[]> getNomesGruposMembrosNaoDataTermino();

    List<Object[]> getNomesGruposLideresMembros();

}
