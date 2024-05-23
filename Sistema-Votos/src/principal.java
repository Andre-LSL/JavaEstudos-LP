import javax.swing.JOptionPane;
import java.io.*;
    public class principal {
        public static void main (String [] args) throws IOException {
            int codigo = 0;
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
                    break;
                case 2:
                vt = m.ordenarVotacao(vt);
                    break;
                case 3:
                    m.gravacao(vt);
                    break;
                case 4:
                    menuConsulta(vt);
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
        static void menuConsulta(votacao[] votos) {
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
                        m1.eleitores(votos);
                        break;
                    case 2:
                        m1.MaiorMenor(votos);
                        break;
                    case 3:
                        m1.candidatosVoto(votos);
                        break;
                    case 4:
                        m1.maisVotos(votos);
                        break;
                    case 9:
                    JOptionPane.showMessageDialog(null, "Encerrando consulta");
                        break;
                    default:
                            JOptionPane.showMessageDialog(null, "Valor digitado inválido");
                        }
                        break;
                }
            }
        }
    