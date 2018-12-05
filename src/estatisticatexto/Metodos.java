package estatisticatexto;

import java.util.stream.Stream;

/**
 *
 * @author Gerson Pereira
 */
public class Metodos {

    private StringBuilder sb = new StringBuilder();
    private Integer qtdPara = 0;
    private Integer qtdDe = 0;

    public String lerTexto(Stream<String> linhas){
        linhas.forEach(linha -> {
            String aux = linha;
            while(linha.contains(".")){
                sb.append(" " + linha.substring(0, linha.indexOf(".") + 1));
                linha = "\r\n " + linha.substring(linha.indexOf(".") + 1, linha.length());
            }
            sb.append(" " + linha);
        });
        return sb.toString();
    }

    public Integer buscarPara(String texto) {
        boolean repetir = true;
        while (repetir) {
            if (texto.toLowerCase().contains("para")) {
                qtdPara++;
                texto = texto.substring(texto.toLowerCase().indexOf("para") + 4, texto.length());
            } else {
                repetir = false;
            }
        }

        return qtdPara;
    }
    
    public Integer buscarDe(String texto){
        boolean repetir = true;
        while (repetir) {
            if (texto.toLowerCase().contains("de")) {
                qtdDe++;
                texto = texto.substring(texto.toLowerCase().indexOf("de") + 2, texto.length());
            } else {
                repetir = false;
            }
        }

        return qtdDe;
    }
    
}
