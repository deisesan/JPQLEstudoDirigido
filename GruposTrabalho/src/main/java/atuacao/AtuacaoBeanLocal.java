/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package atuacao;

import grupo.MembroDto;
import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author deise
 */
@Local
public interface AtuacaoBeanLocal {

    void create(Atuacao atuacao);

    List<MembroDto> getNomesGruposMembrosData(List<Long> idsGrupos, LocalDate dataInicio);
}
