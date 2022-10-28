package br.com.contatos.contato.dtos;

import br.com.contatos.contato.model.Contato;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ContatoDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public ContatoDTO(){}

    public ContatoDTO(Contato contato) {
        setId(contato.getId());
        setNome(contato.getNome());
        setEmail(contato.getEmail());
        setTelefone(contato.getTelefone());
    }

    public static List<ContatoDTO> converterParaContatoDTO(List<Contato> contatos) {
        return contatos.stream().map(ContatoDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
