package br.edu.ifsp.biblioteca.cli;

import br.edu.ifsp.biblioteca.domain.Livro;
import br.edu.ifsp.biblioteca.domain.Usuario;
import br.edu.ifsp.biblioteca.exception.RegradeNegocioException;
import br.edu.ifsp.biblioteca.service.LivroService;
import br.edu.ifsp.biblioteca.service.UsuarioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CatalogoRunner implements CommandLineRunner {
    private final LivroService   livroService;
    private final UsuarioService usuarioService;

    public CatalogoRunner(LivroService livroService, UsuarioService usuarioService) {
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    public void run(String... args) {
        System.out.println();
        System.out.println("=== Biblioteca IFSP - v0 (tudo em memória) ===");

        Livro oNomeDaRosa = new Livro(
                "8501115827",
                "O Nome da Rosa",
                1980
        );

        this.livroService.cadastrar(oNomeDaRosa);

        this.livroService.adicionarAutor(oNomeDaRosa.getId(), "Umberto Eco");
        this.livroService.adicionarExemplar(oNomeDaRosa.getId(), "NR-001");
        this.livroService.adicionarExemplar(oNomeDaRosa.getId(), "NR-002");

        Livro oCortico = new Livro(
                "8594318839",
                "O Cortiço",
                1890
        );

        this.livroService.cadastrar(oCortico);

        this.livroService.adicionarAutor(oCortico.getId(), "Aluísio Azevedo");
        this.livroService.adicionarExemplar(oCortico.getId(), "C-001");
        this.livroService.adicionarExemplar(oCortico.getId(), "C-002");

        this.usuarioService.cadastrar(new Usuario("Alice", "alice@example.com"));
        this.usuarioService.cadastrar(new Usuario("Bob", "bob@example.com"));

        System.out.println();

        System.out.println("-- Catálogo --");

        for (Livro livro : this.livroService.listarTodos()) {
            System.out.println(" " + livro);
        }

        System.out.println("-- Usuários --");

        for (Usuario usuario : this.usuarioService.listarTodos()) {
            System.out.println(" " + usuario);
        }

        System.out.println();

        System.out.println("-- Buscar por título contendo 'Rosa' --");

        List<Livro> encontrados = this.livroService.buscarPorTitulo("Rosa");

        for (Livro item : encontrados) {
            System.out.println(" " + item);
        }

        System.out.println("-- Testando cadastrar o mesmo ISBN de novo -- ");

        try {
            this.livroService.cadastrar(
                new Livro(
                    "8594318839",
                    "O Cortiço",
                    1890
            ));
        } catch (RegradeNegocioException erro) {
            System.out.println(" Regra de negócio impediu: " + erro.getMessage());
        }
    }




















}
