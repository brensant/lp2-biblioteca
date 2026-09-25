package br.edu.ifsp.biblioteca.domain;

public class Exemplar {
    private Long            id;
    private String          codigo;
    private Livro           livro;
    private EStatusExemplar status;

    public Exemplar(String codigo, Livro livro) {
        this.codigo = codigo;
        this.livro = livro;
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
