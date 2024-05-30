// Sistema de trânsito.
// Programador: André Luiz 
// 06/05/2024

import javax.swing.JOptionPane;
public class principal {
    public static void main (String [] args) {
        int codigo = 0;
        Estatistiscas vt[] = new Estatistiscas[10];
        Metodos m = new Metodos();
        
        for (int i = 0; i < 10; i++) {
            vt[i] = new Estatistiscas();
        }
        
        while(codigo != 9) {
            codigo = Integer.parseInt(JOptionPane.showInputDialog(null, 
                                                "1 - Registrar valores\n"
                                                + "2 - Consulta de Acidentes\n"
                                                + "3 - Menor e maior quantidade de acidentes\n"
                                                + "4 - Cidade com quantidade de acidentes acima da média\n"
                                                + "9 - Sair"));
            switch (codigo) {
                case 1:
                    vt = m.registro(vt);
                    break;
                case 2:
                    m.consQAcidentes(vt);
                    break;
                case 3:
                    m.consMaiorMenor(vt);
                     break;
                case 4:
                    m.mediaAcidentes(vt);
                    break;
                case 9:
                    break;
            }

        }
    }
}

