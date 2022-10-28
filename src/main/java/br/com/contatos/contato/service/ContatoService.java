package br.com.contatos.contato.service;

import br.com.contatos.contato.dtos.ContatoDTO;
import br.com.contatos.contato.forms.ContatoForm;
import br.com.contatos.contato.model.Contato;
import br.com.contatos.contato.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    private final ContatoRepository repository;

    @Autowired
    public ContatoService(ContatoRepository repository) {
        this.repository = repository;
    }


    //getAll
    public List<ContatoDTO> todosContatos() {
        return ContatoDTO.converterParaContatoDTO(repository.findAll());
    }
    //getById
    public ResponseEntity<ContatoDTO> contatoPorId(Long id) {
        Optional<Contato> oContato = repository.findById(id);

        if(oContato.isPresent()) {
            return ResponseEntity.ok(new ContatoDTO(oContato.get()));
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    //post
    @Transactional
    public ResponseEntity<Void> cadastrarContato(ContatoForm contatoForm) {
        Contato contato = contatoForm.cadastrar(new Contato());

        repository.save(contato);

        return ResponseEntity.ok().build();
    }

    //delete
    public ResponseEntity<Void> deletarContato(Long id) {
        Optional<Contato> oContato = repository.findById(id);

        if(oContato.isPresent()) {
            repository.delete(oContato.get());
            return ResponseEntity.ok().build();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    //update
    public ResponseEntity<ContatoDTO> atualizarContato(Long id, ContatoForm contatoForm) {
        Optional<Contato> oContato = repository.findById(id);

        if(oContato.isPresent()) {
            Contato contato = oContato.get();

            contato.setNome(contatoForm.getNome());
            contato.setEmail(contatoForm.getEmail());
            contato.setTelefone(contatoForm.getTelefone());

            return ResponseEntity.ok(new ContatoDTO(repository.save(contato)));
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
