import java.util.Random;
import javax.swing.JOptionPane;
import java.io.*;
public class metodos {

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

        // Calculo feito automaticamente 
        // Quantidade de votos por seção
    public int[] calcEleitores (votacao[] VotosCalc) {
        int contadorVotos, auxiliarCalc;
        int vtEleitores[] = new int[10];
            for (contadorVotos = 0; contadorVotos < VotosCalc.length; contadorVotos++) {
                auxiliarCalc = VotosCalc[contadorVotos].numeroSecao;
                vtEleitores[auxiliarCalc]++;
            }
            return vtEleitores;
    }

        // Votos por candidatos
    public int[][] qtndVotos (votacao[] VotosCalc2) {
        int ContadorCandidatos,AuxCandidatos;
        int CanditatosVtCalc[][] = new int[2][201];
        for (ContadorCandidatos = 0; ContadorCandidatos < VotosCalc2.length; ContadorCandidatos++) {
            CanditatosVtCalc[1][ContadorCandidatos] = ContadorCandidatos; // Loop que preenche a linha 1 da matriz com os numeros dos candidatos.
        }
        for (ContadorCandidatos = 0; ContadorCandidatos < VotosCalc2.length; ContadorCandidatos++) {
            AuxCandidatos = VotosCalc2[ContadorCandidatos].numeroSecao; // Loop usa o valor do voto como indice da matriz para adicionar 1. 
            CanditatosVtCalc[0][AuxCandidatos]++;
        }
        return CanditatosVtCalc;
    }

        // Exibir valores
    public void eleitores (votacao[] VotosExibir, int[] QntdVotosSecao) {
        int contadorSecao;
        for(contadorSecao = 0; contadorSecao < QntdVotosSecao.length; contadorSecao++) {
            JOptionPane.showMessageDialog(null, "Seção: " + contadorSecao + "\n"
                                                                + "Votos: " + QntdVotosSecao[contadorSecao]);
        }
    }
        // Calcula e exibe a seção com maior e menor quantidade de votos.
    public void MaiorMenor (votacao[] VotosExibir2, int[] QntdVotosMaiorMenor) {
        int contadorMaior, maxSecao, minSecao, maxVotos, minVotos;
        maxSecao = Integer.MIN_VALUE; maxVotos = Integer.MIN_VALUE;
        minSecao = Integer.MAX_VALUE; minVotos = Integer.MAX_VALUE; 
            for(contadorMaior = 0; contadorMaior < QntdVotosMaiorMenor.length; contadorMaior++) {
                if (QntdVotosMaiorMenor[contadorMaior] > maxVotos) {
                    maxSecao = contadorMaior;
                    maxVotos = QntdVotosMaiorMenor[contadorMaior];
                } else if(QntdVotosMaiorMenor[contadorMaior] < minVotos) {
                    minSecao = contadorMaior;
                    minVotos = QntdVotosMaiorMenor[contadorMaior];
                }
        }
        JOptionPane.showMessageDialog(null, 
                                        "Seção com maior quantidade de votos: " + maxSecao + "\n"
                                        + "Votos: " + maxVotos + "\n"
                                        + "Seção com menor quantidade de votos: " + minSecao + "\n"
                                        + "Votos: " + minVotos);
    }

    // Procedimento que apenas mostra os valores. Desconsidera os candidatos com 0 votos.
    public void candidatosVoto (votacao[] VotosExibir3, int[][] QntdVotosExibir) {
        int contadorVotos;
        for(contadorVotos = 0; contadorVotos < QntdVotosExibir[0].length; contadorVotos++) {
            if (QntdVotosExibir[0][contadorVotos] != 0) {
                JOptionPane.showMessageDialog(null, 
                                            "Candidato:" + QntdVotosExibir[1][contadorVotos] + "\n"
                                             + "Quantidade de votos:" + QntdVotosExibir[0][contadorVotos]);
            }
        }
    }
    public void maisVotos(votacao[] VotosExibir4, int[][] QntdVotosMaiores) {
        int nxt, ant, aux;
        for (ant = 0; ant < QntdVotosMaiores[0].length; ant++) {
            for (nxt = ant + 1; nxt < QntdVotosMaiores[0].length; nxt++) {
                if (QntdVotosMaiores[0][ant] < QntdVotosMaiores[0][nxt]) {
                    // Ordenando do maior para o menor
                    aux = QntdVotosMaiores[0][ant];
                    QntdVotosMaiores[0][ant] = QntdVotosMaiores[0][nxt];
                    QntdVotosMaiores[0][nxt] = aux;
    
                    // Mudando junto o número do candidato
                    aux = QntdVotosMaiores[1][ant];
                    QntdVotosMaiores[1][ant] = QntdVotosMaiores[1][nxt];
                    QntdVotosMaiores[1][nxt] = aux;
                }
            }
        }
        for (int contador = 0; contador < 10; contador++) {
            JOptionPane.showMessageDialog(null, 
                "Ranking: " + (contador + 1) + "\n" +
                "Candidato: " + QntdVotosMaiores[1][contador] + "\n" +
                "Votos: " + QntdVotosMaiores[0][contador]);
        }
    }
}

