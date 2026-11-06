package br.edu.ifsp.biblioteca.repository;

import br.edu.ifsp.biblioteca.domain.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

/**
 * JpaRepository fornece os seguintes métodos (dentre outros):
 *
 * - save, findById, findAll, count, ...
 */
public interface ILivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByIsbn(String isbn);
    boolean         existsByIsbn(String isbn);
    List<Livro>     findByTituloContainingIgnoreCase(String trechoTitulo); // "Containing" vira LIKE %..%, "IgnoreCase" vira LOWER(...)
    Page<Livro>     findByTituloContainingIgnoreCase(String trechoTitulo, Pageable pagina);
}