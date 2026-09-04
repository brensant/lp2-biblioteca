package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Usuario;

import java.util.*;

public class UsuarioRepositoryEmMemoria implements IUsuarioRepository {
    private final Map<Long, Usuario> usuarios = new HashMap<>();
    private Long                     sequenciaId = 0L;

    @Override
    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(++this.sequenciaId);
        }

        this.usuarios.put(usuario.getId(), usuario);
        return (usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        if (this.usuarios.containsKey(id))
            return (Optional.of(this.usuarios.get(id)));

        return (Optional.empty());
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        List<Usuario> listaUsuarios = new ArrayList<>(this.usuarios.values());

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEmail().equals(email))
                return (Optional.of(usuario));
        }
        return Optional.empty();
    }

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> listaUsuarios = new ArrayList<>(this.usuarios.values());

        return (listaUsuarios);
    }
}
