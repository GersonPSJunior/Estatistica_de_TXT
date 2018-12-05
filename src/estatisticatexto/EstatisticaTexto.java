package estatisticatexto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 *
 * @author Gerson Pereira
 */
public class EstatisticaTexto {

    public static void main(String[] args) {

        int qtdLinhas = 0, qtdPalavras = 0, qtdCaracter = 0;
        Path caminho = Paths.get("C:/estagio/texto.txt");
        Path novoArquivo = Paths.get("C:/estagio/texto_sentença.txt");
        Metodos m = new Metodos();
        try {

            Stream<String> lines = Files.lines(caminho, StandardCharsets.ISO_8859_1);
            System.out.println(lines);
            String texto = m.lerTexto(lines);
            Integer para = m.buscarPara(texto);
            Integer de = m.buscarDe(texto);
            qtdLinhas = (int) Files.lines(caminho, StandardCharsets.ISO_8859_1).count();
            qtdPalavras = texto.split(" \\w").length;
            qtdCaracter = texto.replaceAll(" ", "").length();
            System.out.println("Quantidade de Linhas no texto é: "+ qtdLinhas);
            System.out.println("Quantidade de Palavras no texto é: "+ qtdPalavras);
            System.out.println("Quantidade de Caracteres no texto é: "+ qtdCaracter);
            System.out.println("A palavra \"para\" aparece: "+ para +" vezes no texto.");
            System.out.println("A palavra \"de\" aparece: "+ de +" vezes no texto.");
            if(!Files.exists(novoArquivo)){
                Files.createFile(novoArquivo);
                byte[] textoByte = texto.getBytes(StandardCharsets.ISO_8859_1);
                Files.write(novoArquivo, textoByte);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
