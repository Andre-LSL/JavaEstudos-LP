import java.util.Random;
import javax.swing.JOptionPane;
import java.io.*;
public class metodos {

    // variavel global para calculo de quantidade de voto por seção
    int resultadoEleitores[] = new int [11]; 
    int QuantVotos[][] = new int[2][301]; // matriz que armazena na linha 0 os votos e, na linha 1 os candidatos.
    // Carregando os votos utilizando a função Random.
    public votacao[] carregarVotacao (votacao[] votosReceber) {
        Random aleatorio = new Random();
        for (int contador = 0; contador < votosReceber.length; contador ++) {
            votosReceber[contador].votoCandidato = aleatorio.nextInt(301);
            votosReceber[contador].numeroSecao = aleatorio.nextInt(11);
        }
        return votosReceber;
    }

    // Ordenando os Numeros de Seção e por consequência, os votos.
    public votacao[] ordenarVotacao (votacao[] votosOrdenar) {
        int nxt, ant;
        for (ant = 0; ant < votosOrdenar.length; ant ++){
            for (nxt = ant + 1; nxt < votosOrdenar.length; nxt++)
                if (votosOrdenar[ant].numeroSecao > votosOrdenar[nxt].numeroSecao) {
                    
                    votosOrdenar[200].numeroSecao = votosOrdenar[ant].numeroSecao; // auxiliar
                    votosOrdenar[ant].numeroSecao = votosOrdenar[nxt].numeroSecao;
                    votosOrdenar[nxt].numeroSecao = votosOrdenar[200].numeroSecao;

                    //Ordenando os votos junto com a seção.
                    votosOrdenar[200].votoCandidato = votosOrdenar[ant].votoCandidato;
                    votosOrdenar[ant].votoCandidato = votosOrdenar[nxt].votoCandidato;
                    votosOrdenar[nxt].votoCandidato = votosOrdenar[200].votoCandidato;
                }
        }
        return votosOrdenar;
    }

    // Método para gravação do Arquivo em txt.
    public votacao[] gravacao(votacao[] votosGravacao) throws IOException {
        String nomeArquivo = "VotosRegistro";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(nomeArquivo));
        for(int contador = 0; contador < votosGravacao.length; contador ++) {
            gravar.write(Integer.toString(votosGravacao[contador].numeroSecao));
                gravar.newLine();
            gravar.write(Integer.toString(votosGravacao[contador].votoCandidato));
                gravar.newLine();

        }
        gravar.close();
        JOptionPane.showMessageDialog(null, "Arquivo gerado.");
        return votosGravacao;
    }

    // Cálculo de quantidade de votos por seção
    public void eleitores(votacao[] votosIndice) {
        int contadorEleitor, contadorRegistro;
        // Um vetor com 10 casas(porque há 10 seções) e em cada casa guardando a quantidade de votos respectivamente. Vetor[1] = votos seção 1.
   for (contadorRegistro = 0; contadorRegistro < resultadoEleitores.length; contadorRegistro++) { // Loop que decidi qual seção os votos seráo recolhidos
        for (contadorEleitor = 0; contadorEleitor < votosIndice.length; contadorEleitor++) {
            if (contadorRegistro == votosIndice[contadorEleitor].numeroSecao) {
                resultadoEleitores[contadorRegistro] ++;
            }
        }
    }

        for(contadorEleitor = 0; contadorEleitor < resultadoEleitores.length; contadorEleitor++) {
            JOptionPane.showMessageDialog(null, "Quantidade de votos da Seção:" + contadorEleitor + "\n"
            + "Numeros Eleitores: " + resultadoEleitores[contadorEleitor]);
        }
      }

    public void MaiorMenor(votacao[] votosMn) {
        int MaiorSecao, MenorSecao, MaiorVoto, MenorVoto, contadorMn;
        MaiorSecao = Integer.MIN_VALUE;
        MaiorVoto = Integer.MIN_VALUE;
        MenorSecao = Integer.MAX_VALUE;
        MenorVoto = Integer.MAX_VALUE;

        for(contadorMn = 0; contadorMn < 10; contadorMn++) {
            if(resultadoEleitores[contadorMn] > MaiorVoto) { // condição para decidir se é maior ou não.
                MaiorSecao = contadorMn;
                MaiorVoto = resultadoEleitores[contadorMn]; // vetor carregado com a quantidade de votos por seção
            } else if (resultadoEleitores[contadorMn] < MenorVoto) { // condição para decidir se é menor ou não.
                MenorSecao = contadorMn;
                MenorVoto = resultadoEleitores[contadorMn];
            }

        }
            JOptionPane.showMessageDialog(null, "Maior votos foram na seção" + MaiorSecao + "\n" // Mensagem para exibir os valores
                                         + "Quantidade de votos: " + MaiorVoto + "\n" 
                                         + "Menor quantidade de votos na seção:" + MenorSecao + "\n" 
                                         + "Quantidade de votos: " + MenorVoto);
    }

    public void candidatosVoto(votacao[] calcVotos) {
        int ctdr, auxiliar = 0;

        // Zerando a contagem de votos antes de contar novamente
        for (int i = 0; i < QuantVotos[0].length; i++) {
            QuantVotos[0][i] = 0;
        }
        for(ctdr = 0; ctdr < calcVotos.length; ctdr++) {
            auxiliar = calcVotos[ctdr].votoCandidato;
            QuantVotos[0][auxiliar]++;
            QuantVotos[1][auxiliar] = auxiliar;
        }
        for(ctdr = 0; ctdr < calcVotos.length; ctdr ++) {
            JOptionPane.showMessageDialog(null, 
                                        "Candidato:" +  QuantVotos[1][ctdr] + "\n"
                                        + "Quantidade votos: " + QuantVotos[0][ctdr]);
        }
    }

    public void maisVotos(votacao[] resultado) {
        // Zerando a contagem de votos antes de contar novamente
        for (int i = 0; i < QuantVotos[0].length; i++) {
            QuantVotos[0][i] = 0;
        }
    
        // Contando os votos de cada candidato
        for (int ctdr2 = 0; ctdr2 < resultado.length; ctdr2++) {
            int auxiliar1 = resultado[ctdr2].votoCandidato;
            QuantVotos[0][auxiliar1]++;
            QuantVotos[1][auxiliar1] = auxiliar1;
        }
    
        // Ordenando os candidatos com base no número de votos
        for (int anterior = 0; anterior < QuantVotos[0].length - 1; anterior++) {
            for (int proximo = anterior + 1; proximo < QuantVotos[0].length; proximo++) {
                if (QuantVotos[0][anterior] < QuantVotos[0][proximo]) {
                    // Troca de posições se o candidato proximo tiver mais votos que o candidato anterior
                    int auxVotos = QuantVotos[0][anterior];
                    QuantVotos[0][anterior] = QuantVotos[0][proximo];
                    QuantVotos[0][proximo] = auxVotos;
    
                    int auxCandidato = QuantVotos[1][anterior];
                    QuantVotos[1][anterior] = QuantVotos[1][proximo];
                    QuantVotos[1][proximo] = auxCandidato;
                }
            }
        }
    
        // Exibição do ranking dos top 10 mais votados
        for (int auxiliar2 = 0; auxiliar2 < 10; auxiliar2++) {
            JOptionPane.showMessageDialog(null, 
                    "Posição no ranking: " + (auxiliar2 + 1) + "\n"
                    + "Candidato: " + QuantVotos[1][auxiliar2] + "\n"
                    + "Votos: " + QuantVotos[0][auxiliar2]);
        }
    }
  }


  