package br.edu.ifsp.biblioteca.domain;


import jakarta.persistence.*;

@Entity
@Table
public class Exemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long            id;

    @Column(nullable = false, unique = true, length = 30)
    private String          codigo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro           livro;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EStatusExemplar status;

    protected Exemplar() {}

    public Exemplar(String codigo, Livro livro) {
        this.codigo = codigo;
        this.livro = livro;
        this.status = EStatusExemplar.DISPONIVEL;
    }

    public Long getId() {
        return (id);
    }

    public String getCodigo() {
        return (codigo);
    }

    public Livro getLivro() {
        return (livro);
    }

    public EStatusExemplar getStatus() {
        return (status);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public void setStatus(EStatusExemplar status) {
        this.status = status;
    }

    public void emprestar() {
        if (this.status == EStatusExemplar.EMPRESTADO) {
            throw new IllegalStateException("Exemplar " + this.codigo + " já está emprestado!");
        }
        this.status = EStatusExemplar.EMPRESTADO;
    }

    public void devolver() {
        if (this.status == EStatusExemplar.EMPRESTADO) {
            this.status = EStatusExemplar.DISPONIVEL;
        }
    }

    public boolean estaDisponivel() {
        return (this.status == EStatusExemplar.DISPONIVEL);
    }

    @Override
    public String toString() {
        return "Exemplar{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", livro=" + livro +
                ", status=" + status +
                '}';
    }
}
