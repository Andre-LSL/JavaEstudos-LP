import javax.swing.JOptionPane;
public class Metodos {

    public Estatistiscas[] registro(Estatistiscas[] coletaValores) {
        for (int contador = 0; contador < 10; contador++) {
            coletaValores[contador].CodigoCidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código da cidade:"));
            coletaValores[contador].QtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de acidentes na cidade:"));
            coletaValores[contador].NomeCidade = JOptionPane.showInputDialog(null, "Digite o nome da cidade");
        }
        return coletaValores;
    }


    public void consQAcidentes (Estatistiscas[] valores) {
        for (int contador = 0; contador < 10; contador ++) {
            if (valores[contador].QtdAcidentes > 100 && valores[contador].QtdAcidentes < 500) {
                System.out.println("Cidade: " + contador);
                System.out.println("Codigo da cidade: " + valores[contador].CodigoCidade);
                System.out.println("Nome da cidade: " + valores[contador].NomeCidade);
                System.out.println("Quantidade de acidentes:" + valores[contador].QtdAcidentes);
                System.out.println("--");
            }
        }
    }
    public void consMaiorMenor(Estatistiscas[] coletaValores2) {
        int min, max, contador, contadorCidadeMax = 0;
        int contadorCidadeMin = 0;
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        for (contador = 0; contador < 10; contador ++) {
            if (coletaValores2[contador].QtdAcidentes > max) {
                max = coletaValores2[contador].QtdAcidentes;
                contadorCidadeMax = contador;
            } else if (coletaValores2[contador].QtdAcidentes < min) {
                min = coletaValores2[contador].QtdAcidentes;
                contadorCidadeMin = contador;
            }
        }
        JOptionPane.showMessageDialog(null, "A quantidade maior quantidade de acidentes foi: " + max +"\n Na cidade: " + coletaValores2[contadorCidadeMax].NomeCidade );
        JOptionPane.showMessageDialog(null, "A menor quantidade de acidentes foi: " + min + "\n Na cidade: " + coletaValores2[contadorCidadeMin].NomeCidade );
    }
    public void mediaAcidentes (Estatistiscas[] coletaValores3) {
        int media = 0;
        int contador = 0;
        for (contador = 0; contador < 10; contador ++) {
            media += coletaValores3[contador].QtdAcidentes;
        }
        media = media/10;
        System.out.println("Média das cidades:" + media);
        for (contador = 0; contador < 10; contador++) {
            if (coletaValores3[contador].QtdAcidentes > media) {
                System.out.println("Cidade: " + contador);
                System.out.println("Codigo da cidade: " + coletaValores3[contador].CodigoCidade);
                System.out.println("Nome da cidade: " + coletaValores3[contador].NomeCidade);
                System.out.println("Quantidade de acidentes:" + coletaValores3[contador].QtdAcidentes);
                System.out.println("--");
            }
        }
    }
}