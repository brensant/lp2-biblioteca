package br.edu.ifsp.biblioteca.service;

import br.edu.ifsp.biblioteca.domain.Usuario;
import br.edu.ifsp.biblioteca.dto.NovoUsuario;
import br.edu.ifsp.biblioteca.dto.UsuarioDetalhe;
import br.edu.ifsp.biblioteca.exception.RegradeNegocioException;
import br.edu.ifsp.biblioteca.repository.IUsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final IUsuarioRepository usuarioRepository;

    public UsuarioService(IUsuarioRepository repository) {
        this.usuarioRepository = repository;
    }

    public UsuarioDetalhe cadastrar(NovoUsuario novoUsuario) {
        Usuario usuario = novoUsuario.toEntity();

        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new RegradeNegocioException("Nome é obrigatório!");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new RegradeNegocioException("E-mail é obrigatório!");
        }

        this.validarEmail(usuario.getEmail());

        return (UsuarioDetalhe.of(this.usuarioRepository.save(usuario)));
    }

    @Transactional(readOnly = true)
    public UsuarioDetalhe buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);

        if (usuarioOptional.isPresent()) {
            return (UsuarioDetalhe.of(usuarioOptional.get()));
        }

        throw new RegradeNegocioException("Usuário não encontrado: " + id);
    }

    private void validarEmail(String email) {
        Optional<Usuario> usuarioOptional = this.usuarioRepository.findByEmailIgnoreCase(email);

        if (usuarioOptional.isPresent()) {
            throw new RegradeNegocioException("Já existe um usuário cadastrado com o e-mail: " + email);
        }
    }

    @Transactional(readOnly = true)
    public List<UsuarioDetalhe> listarTodos() {
        return (this.usuarioRepository.findAll()
                .stream()
                .map(UsuarioDetalhe::of)
                .toList());
    }
}
