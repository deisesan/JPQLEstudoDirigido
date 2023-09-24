/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package singleton;

import atuacao.Atuacao;
import atuacao.AtuacaoBeanLocal;
import grupo.Grupo;
import grupo.GrupoBeanLocal;
import pessoa.Endereco;
import pessoa.Pessoa;
import pessoa.PessoaBeanLocal;
import pessoa.Telefone;
import java.time.LocalDate;
import java.time.Month;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author deise
 */
@Singleton
@Startup
public class SingletonBean implements SingletonBeanLocal {

    @Inject
    private PessoaBeanLocal pessoaBean;

    @Inject
    private GrupoBeanLocal grupoBean;

    @Inject
    private AtuacaoBeanLocal atuacaoBean;

    @PostConstruct
    @Override
    public void SingletonBean() {

        Telefone telefone1 = new Telefone();
        Telefone telefone2 = new Telefone();
        Telefone telefone3 = new Telefone();
        Telefone telefone4 = new Telefone();
        Telefone telefone5 = new Telefone();
        Telefone telefone6 = new Telefone();

        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();
        Endereco endereco3 = new Endereco();
        Endereco endereco4 = new Endereco();

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        Pessoa pessoa3 = new Pessoa();
        Pessoa pessoa4 = new Pessoa();

        Grupo grupo1 = new Grupo();
        Grupo grupo2 = new Grupo();
        Grupo grupo3 = new Grupo();
        Grupo grupo4 = new Grupo();

        Atuacao atuacao1 = new Atuacao();
        Atuacao atuacao2 = new Atuacao();
        Atuacao atuacao3 = new Atuacao();
        Atuacao atuacao4 = new Atuacao();
        Atuacao atuacao5 = new Atuacao();
        Atuacao atuacao6 = new Atuacao();
        Atuacao atuacao7 = new Atuacao();
        Atuacao atuacao8 = new Atuacao();
        Atuacao atuacao9 = new Atuacao();
        Atuacao atuacao10 = new Atuacao();
        Atuacao atuacao11 = new Atuacao();
        Atuacao atuacao12 = new Atuacao();

        /* Telefones */
        telefone1.setDdd((byte) 11);
        telefone1.setNumero(11111111);

        telefone2.setDdd((byte) 12);
        telefone2.setNumero(12121212);

        telefone3.setDdd((byte) 13);
        telefone3.setNumero(13131313);

        telefone4.setDdd((byte) 22);
        telefone4.setNumero(22222222);

        telefone5.setDdd((byte) 44);
        telefone5.setNumero(44444444);

        telefone6.setDdd((byte) 45);
        telefone6.setNumero(45454545);

        /* Enderecos */
        endereco1.setTipoLogradouro(Endereco.TipoLogradouro.RUA);
        endereco1.setLogradouro("1");
        endereco1.setNumero(1111);
        endereco1.setBairro("Humberto");

        endereco2.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);
        endereco2.setLogradouro("2");
        endereco2.setNumero(2222);
        endereco2.setBairro("Doisberto");

        endereco3.setTipoLogradouro(Endereco.TipoLogradouro.AVENIDA);
        endereco3.setLogradouro("3");
        endereco3.setNumero(3333);
        endereco3.setBairro("Tresberto");

        endereco4.setTipoLogradouro(Endereco.TipoLogradouro.PRACA);
        endereco4.setLogradouro("4");
        endereco4.setNumero(4444);
        endereco4.setBairro("Quatroberto");

        /* Pessoas */
        pessoa1.setNome("Ana Zaira");
        pessoa1.setEmail("ana@mail.com");
        pessoa1.setNascimento(LocalDate.of(2001, Month.JANUARY, 1));
        pessoa1.setEndereco(endereco1);
        pessoa1.getTelefones().add(telefone1);
        pessoa1.getTelefones().add(telefone2);
        pessoa1.getTelefones().add(telefone3);

        pessoa2.setNome("Beatriz Yana");
        pessoa2.setEmail("beatriz@mail.com");
        pessoa2.setNascimento(LocalDate.of(2002, Month.FEBRUARY, 2));
        pessoa2.setEndereco(endereco2);
        pessoa2.getTelefones().add(telefone4);

        pessoa3.setNome("Cecília Xerxes");
        pessoa3.setEmail("cecilia@mail.com");
        pessoa3.setNascimento(LocalDate.of(2003, Month.MARCH, 3));
        pessoa3.setEndereco(endereco3);

        pessoa4.setNome("Debora Wendel");
        pessoa4.setEmail("debora@mail.com");
        pessoa4.setNascimento(LocalDate.of(2004, Month.APRIL, 4));
        pessoa4.setEndereco(endereco4);
        pessoa4.getTelefones().add(telefone5);
        pessoa4.getTelefones().add(telefone6);

        /* Grupos */
        grupo1.setNome("Estudo I");
        grupo1.setAtivo(false);
        grupo1.setLider(pessoa1);

        grupo2.setNome("Estudo II");
        grupo2.setAtivo(true);
        grupo2.setLider(pessoa2);

        grupo3.setNome("Estudo III");
        grupo3.setAtivo(false);
        grupo3.setLider(pessoa3);

        grupo4.setNome("Estudo IV");
        grupo4.setAtivo(true);
        grupo4.setLider(pessoa2);

        /* Atuações - Grupo I */
        atuacao1.setInicio(LocalDate.of(2011, Month.JANUARY, 1));
        atuacao1.setTermino(LocalDate.of(2021, Month.NOVEMBER, 11));
        atuacao1.setGrupo(grupo1);
        atuacao1.setPessoa(pessoa1);
        pessoa1.getAtuacoes().add(atuacao1);
        grupo1.getAtuacoes().add(atuacao1);

        atuacao2.setInicio(LocalDate.of(2012, Month.JANUARY, 1));
        atuacao2.setTermino(LocalDate.of(2022, Month.NOVEMBER, 11));
        atuacao2.setGrupo(grupo1);
        atuacao2.setPessoa(pessoa1);
        pessoa1.getAtuacoes().add(atuacao2);
        grupo1.getAtuacoes().add(atuacao2);

        atuacao3.setInicio(LocalDate.of(2012, Month.JANUARY, 2));
        atuacao3.setTermino(LocalDate.of(2021, Month.JANUARY, 12));
        atuacao3.setGrupo(grupo1);
        atuacao3.setPessoa(pessoa2);
        pessoa2.getAtuacoes().add(atuacao3);
        grupo1.getAtuacoes().add(atuacao3);

        atuacao4.setInicio(LocalDate.of(2013, Month.JANUARY, 3));
        atuacao4.setTermino(LocalDate.of(2021, Month.JANUARY, 13));
        atuacao4.setGrupo(grupo1);
        atuacao4.setPessoa(pessoa3);
        pessoa3.getAtuacoes().add(atuacao4);
        grupo1.getAtuacoes().add(atuacao4);

        atuacao5.setInicio(LocalDate.of(2014, Month.JANUARY, 4));
        atuacao5.setTermino(LocalDate.of(2021, Month.JANUARY, 14));
        atuacao5.setGrupo(grupo1);
        atuacao5.setPessoa(pessoa4);
        pessoa4.getAtuacoes().add(atuacao5);
        grupo1.getAtuacoes().add(atuacao5);

        /* Atuações - Grupo II */
        atuacao6.setInicio(LocalDate.of(2012, Month.JANUARY, 2));
        atuacao6.setGrupo(grupo2);
        atuacao6.setPessoa(pessoa2);
        pessoa2.getAtuacoes().add(atuacao6);
        grupo2.getAtuacoes().add(atuacao6);

        atuacao7.setInicio(LocalDate.of(2012, Month.JANUARY, 2));
        atuacao7.setGrupo(grupo2);
        atuacao7.setPessoa(pessoa4);
        pessoa4.getAtuacoes().add(atuacao7);
        grupo2.getAtuacoes().add(atuacao7);

        /* Atuações - Grupo III */
        atuacao8.setInicio(LocalDate.of(2012, Month.JANUARY, 3));
        atuacao8.setTermino(LocalDate.of(2023, Month.NOVEMBER, 13));
        atuacao8.setGrupo(grupo3);
        atuacao8.setPessoa(pessoa3);
        pessoa3.getAtuacoes().add(atuacao8);
        grupo3.getAtuacoes().add(atuacao8);

        atuacao9.setInicio(LocalDate.of(2012, Month.JANUARY, 3));
        atuacao9.setTermino(LocalDate.of(2023, Month.JANUARY, 13));
        atuacao9.setGrupo(grupo3);
        atuacao9.setPessoa(pessoa4);
        pessoa4.getAtuacoes().add(atuacao9);
        grupo3.getAtuacoes().add(atuacao9);

        /* Atuações - Grupo IV */
        atuacao10.setInicio(LocalDate.of(2012, Month.JANUARY, 4));
        atuacao10.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
        atuacao10.setGrupo(grupo4);
        atuacao10.setPessoa(pessoa2);
        pessoa2.getAtuacoes().add(atuacao10);
        grupo4.getAtuacoes().add(atuacao10);

        atuacao11.setInicio(LocalDate.of(2012, Month.JANUARY, 4));
        atuacao11.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
        atuacao11.setGrupo(grupo4);
        atuacao11.setPessoa(pessoa3);
        pessoa3.getAtuacoes().add(atuacao11);
        grupo4.getAtuacoes().add(atuacao11);

        atuacao12.setInicio(LocalDate.of(2012, Month.JANUARY, 4));
        atuacao12.setTermino(LocalDate.of(2024, Month.JANUARY, 14));
        atuacao12.setGrupo(grupo4);
        atuacao12.setPessoa(pessoa4);
        pessoa4.getAtuacoes().add(atuacao12);
        grupo4.getAtuacoes().add(atuacao12);

        /* Lideranças */
        pessoa1.getLiderancas().add(grupo1);
        pessoa2.getLiderancas().add(grupo2);
        pessoa2.getLiderancas().add(grupo4);
        pessoa3.getLiderancas().add(grupo3);

        /* Persistência dos dados */
        atuacaoBean.create(atuacao1);
        atuacaoBean.create(atuacao2);
        atuacaoBean.create(atuacao3);
        atuacaoBean.create(atuacao4);
        atuacaoBean.create(atuacao5);
        atuacaoBean.create(atuacao6);
        atuacaoBean.create(atuacao7);
        atuacaoBean.create(atuacao8);
        atuacaoBean.create(atuacao9);
        atuacaoBean.create(atuacao10);
        atuacaoBean.create(atuacao11);
        atuacaoBean.create(atuacao12);

        pessoaBean.create(pessoa1);
        pessoaBean.create(pessoa2);
        pessoaBean.create(pessoa3);
        pessoaBean.create(pessoa4);

        grupoBean.create(grupo1);
        grupoBean.create(grupo2);
        grupoBean.create(grupo3);
        grupoBean.create(grupo4);

    }

}
