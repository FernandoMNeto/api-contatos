package br.com.contatos.contato.controller;

import br.com.contatos.contato.dtos.ContatoDTO;
import br.com.contatos.contato.forms.ContatoForm;
import br.com.contatos.contato.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contato")
public class ContatoController {
    private final ContatoService service;

    @Autowired
    public ContatoController(ContatoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ContatoDTO> todosContatos() {
        return service.todosContatos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoDTO> contatoPorId(@PathVariable Long id) {
        return service.contatoPorId(id);
    }

    @PostMapping("/cadastrar")
    @Transactional
    public ResponseEntity<Void> cadastrarContato(@RequestBody @Valid ContatoForm contatoForm) {
        return service.cadastrarContato(contatoForm);
    }

    @PutMapping("/atualizar/{id}")
    @Transactional
    public ResponseEntity<ContatoDTO> atualizarContato(@PathVariable Long id, @RequestBody @Valid ContatoForm contatoForm) {
      return service.atualizarContato(id, contatoForm);
    }

    @DeleteMapping("/deletar/{id}")
    @Transactional
    public ResponseEntity<Void> deletarContato(@PathVariable Long id) {
        return service.deletarContato(id);
    }

}
