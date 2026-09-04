package br.edu.ifsp.biblioteca.domain;

import java.util.List;

public class Livro {
    private Long           id;
    private String         isbn;
    private String         titulo;
    private List<Autor>    autores;
    private int            anoPublicacao;
    private List<Exemplar> listaExemplares;

    public Livro(String isbn, String titulo, int anoPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
    }

    public Long getId() {
        return (id);
    }

    public String getIsbn() {
        return (isbn);
    }

    public String getTitulo() {
        return (titulo);
    }

    public int getAnoPublicacao() {
        return (anoPublicacao);
    }

    public void setId(Long id) { this.id = id; }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public void adicionarExemplar(Exemplar item) {
        this.listaExemplares.add(item);
    }

    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                '}';
    }
}
