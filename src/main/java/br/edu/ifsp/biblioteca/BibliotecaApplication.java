package br.edu.ifsp.biblioteca;

import br.edu.ifsp.biblioteca.domain.Livro;

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
                1L,
                "8501115827",
                "O Nome da Rosa",
                1980
        );

        System.out.println(livro1);

        Livro livro2 = new Livro(
                2L,
                "8594318839",
                "O Cortiço",
                1890
        );

        System.out.println(livro2);

        Livro livro3 = new Livro(
                3L,
                "8571648565",
                "A Trilogia de Nova York",
                1987
        );

        System.out.println(livro3);

    }
}
