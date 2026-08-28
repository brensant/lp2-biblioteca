package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;

import java.util.*;

public class LivroRepositoryEmMemoria implements ILivroRepository {
    private final Map<Long, Livro> livros = new HashMap<>();
    private Long                   sequenciaId = 0L;

    @Override
    public Livro salvar(Livro livro) {
        if (livro.getId() == null) {
            this.sequenciaId += 1;
            livro.setId(this.sequenciaId);
        }

        this.livros.put(sequenciaId, livro);

        return (livro);
    }

    @Override
    public List<Livro> listarTodos() {
        return (new ArrayList<>(livros.values()));
    }

    @Override
    public Optional<Livro> buscarPorId(Long id) {
        return (Optional.ofNullable(this.livros.get(id)));

//        Livro l = this.livros.get(id);
//
//        if (l == null) {
//            return (Optional.empty());
//        }
//        return (Optional.of(l));
    }

    @Override
    public Optional<Livro> buscarPorIsbn(String isbn) {
        List<Livro> listaLivros = new ArrayList<>(this.livros.values());

        for (Livro livro : listaLivros) {
            if (livro.getIsbn().equalsIgnoreCase(isbn))
                return (Optional.of(livro));
        }

        return (Optional.empty());
    }

    @Override
    public List<Livro> buscarPorTitulo(String titulo) {
        List<Livro> listaLivros = new ArrayList<>(this.livros.values());
        List<Livro> listaResultado = new ArrayList<>();

        String tituloBusca = titulo.toLowerCase();
        for (Livro livro : listaLivros) {
            if (livro.getTitulo().toLowerCase().contains(tituloBusca))
                listaResultado.add(livro);
        }

        return (listaResultado);
    }
}
