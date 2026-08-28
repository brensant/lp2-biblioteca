package br.edu.ifsp.biblioteca.domain;

public class Livro {
    private Long   id;
    private String isbn;
    private String titulo;
    private int    anoPublicacao;

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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
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
