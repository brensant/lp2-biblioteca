package br.edu.ifsp.biblioteca.domain;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long           id;

    @Column(nullable = false,
            unique = true,
            length = 20)
    private String         isbn;

    @Column(nullable = false,
            length = 200)
    private String         titulo;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "livro_autor",
               joinColumns = @JoinColumn(name = "livro_id"),
               inverseJoinColumns = @JoinColumn(name = "autor_id"))

    @Column(name = "ano_publicacao")
    private Integer        anoPublicacao;

    @OneToMany(mappedBy = "livro",
               cascade = CascadeType.ALL,
               orphanRemoval = true,
               fetch = FetchType.LAZY)
    private List<Exemplar> listaExemplares;

    private  List<Autor> autores = new ArrayList<>();

    public Livro() {}

    public Livro(String isbn, String titulo, int anoPublicacao) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autores = new ArrayList<>();
        this.anoPublicacao = anoPublicacao;
        this.listaExemplares = new ArrayList<>();
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

    public List<Autor> getAutores() { return (autores); }

    public int getAnoPublicacao() {
        return (anoPublicacao);
    }

    public List<Exemplar> getExemplares() { return (listaExemplares); }

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
