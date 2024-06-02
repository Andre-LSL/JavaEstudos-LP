import javax.swing.JOptionPane;
import java.io.*;
    public class principal {
        public static void main (String [] args) throws IOException {
            int codigo = 0;
            boolean Otimizacao = false; 
            int resultadoEleitores[] = new int [11];
            int QuantVotos[][] = new int[2][201]; // matriz que armazena na linha 0 os votos e, na linha 1 os candidatos.
            /* Uma variavel de true/false, ela decide se os calculos das estatisticas já foram realizados.
             * Otimizando o código, economizando a chamada de funções.         
            */
            metodos m = new metodos();
            votacao vt[] = new votacao[201];

        // inicializando o objeto.
        for (int i = 0; i < vt.length; i++) {
            vt[i] = new votacao();
        }
        // Menu de escolha para o usuário.
        while(codigo != 9) {
            codigo = Integer.parseInt(JOptionPane.showInputDialog( 
                    "Votação \n"
                    + "1 - Carregar Seção/Numero Eleitor \n" 
                    + "2 - Classificar por seção\n"
                    + "3 - Gravar Registro\n"
                    + "4 - Mostrar indicadores\n"
                    + "9 - Sair "));

            switch(codigo) {
                case 1:
                vt = m.carregarVotacao(vt);
                    Otimizacao = true; // Como gerou novos valores, é necessário recalcular as estatisticas dos votos.
                    break;
                case 2:
                vt = m.ordenarVotacao(vt);
                    break;
                case 3:
                    m.gravacao(vt);
                    break;
                case 4:
                    if (Otimizacao == true) { 
                        resultadoEleitores = m.calcEleitores(vt); // Função que calcula votos por seção
                        QuantVotos = m.qtndVotos(vt); // Função que calcula quantidade de votos por candidato
                        }
                        menuConsulta(vt, resultadoEleitores, QuantVotos);
                        Otimizacao = false;
                    break;
                case 9:
                JOptionPane.showMessageDialog(null, "Encerrando programa.");
                    break;
                default:
                JOptionPane.showMessageDialog(null, "Valor digitado inválido");
                break;
                }
            }
        }
        static void menuConsulta(votacao[] votos, int [] resEleitores, int[][] CandVotos) {
            int CodigoConsulta = 0;
            metodos m1 = new metodos();
            while (CodigoConsulta != 9) {
                CodigoConsulta = Integer.parseInt(JOptionPane.showInputDialog(
                    "Consulta \n "
                        + "1 - Quantidade de Eleitores por seção \n"
                        + "2 - Seção com maior e menor quantidade de eleitores \n"
                        + "3 - Quantidade de votos por candidatos \n"
                        + "4 - 10 primeiros colocados (Quantidade de votos) \n"
                        + "9 - Sair"));
                switch (CodigoConsulta) {
                    case 1:
                        m1.eleitores(votos, resEleitores);
                        break;
                    case 2:
                        m1.MaiorMenor(votos, resEleitores);
                        break;
                    case 3:
                        m1.candidatosVoto(votos, CandVotos);
                        break;
                    case 4:
                        m1.maisVotos(votos, CandVotos);
                        break;
                    case 9:
                    JOptionPane.showMessageDialog(null, "Encerrando consulta");
                        break;
                    default:
                            JOptionPane.showMessageDialog(null, "Valor digitado inválido");
                        }
                }
            }
        }
    
