package br.com.contatos.contato.forms;

import br.com.contatos.contato.model.Contato;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContatoForm {

    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private String email;
    @NotNull @NotEmpty
    private String telefone;

    public Contato cadastrar(Contato contato) {
        contato.setNome(nome);
        contato.setEmail(email);
        contato.setTelefone(telefone);

        return contato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
