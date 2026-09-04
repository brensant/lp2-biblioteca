package br.edu.ifsp.biblioteca;

import br.edu.ifsp.biblioteca.domain.Livro;
import br.edu.ifsp.biblioteca.repository.ILivroRepository;
import br.edu.ifsp.biblioteca.repository.LivroRepositoryEmMemoria;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * Ponto de entrada da aplicacao.
 *
 * @SpringBootApplication liga tres coisas de uma vez:
 *   - @Configuration      (esta classe pode declarar beans)
 *   - @EnableAutoConfiguration (o Boot configura o que achar no classpath)
 *   - @ComponentScan      (procura @Service/@Repository/@Component DESTE
 *                          pacote para baixo — por isso todo o codigo
 *                          fica sob br.edu.ifsp.biblioteca)
 */
//@SpringBootApplication
public class BibliotecaApplication {
    public static void main(String[] args) {
        Livro livro1 = new Livro(
                "8501115827",
                "O Nome da Rosa",
                1980
        );

        Livro livro2 = new Livro(
                "8594318839",
                "O Cortiço",
                1890
        );

        Livro livro3 = new Livro(
                "8571648565",
                "A Trilogia de Nova York",
                1987
        );

        ILivroRepository livroRepository = new LivroRepositoryEmMemoria();

        livroRepository.salvar(livro1);
        livroRepository.salvar(livro2);
        livroRepository.salvar(livro3);

        Optional<Livro> busca1 = livroRepository.buscarPorId(1L);

        if (busca1.isPresent()) {
            Livro l = busca1.get();

            System.out.println("Livro com ID 1 encontrado: " + l);
        } else {
            System.out.println("Livro com ID 1 não encontrado!");
        }

        Optional<Livro> busca2 =livroRepository.buscarPorId(2L);

        if (busca2.isPresent()) {
            Livro l = busca2.get();

            System.out.println("Livro com ID 2 encontrado: " + l);
        } else {
            System.out.println("Livro com ID 2 não encontrado!");
        }

        List<Livro> encontrados = livroRepository.buscarPorTitulo("Nova York");

        System.out.println(encontrados);
    }
}
