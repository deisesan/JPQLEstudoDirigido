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

    private String grupo;

    private String nome;

    private LocalDate inicio;

    public MembroDto(String grupo, String nome, LocalDate inicio) {
        this.grupo = grupo;
        this.nome = nome;
        this.inicio = inicio;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

}
