/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo;

import java.time.LocalDate;

/**
 *
 * @author deise
 */
public class MembroDto {

    private String nomeGrupo;

    private String nomePessoa;

    private LocalDate dataInicio;

    public MembroDto(String nomeGrupo, String nomePessoa, LocalDate dataInicio) {
        this.nomeGrupo = nomeGrupo;
        this.nomePessoa = nomePessoa;
        this.dataInicio = dataInicio;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

}
