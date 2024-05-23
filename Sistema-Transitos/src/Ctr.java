class Estatistiscas {
    // valores a serem coletados
    int CodigoCidade, QtdAcidentes;
    String NomeCidade;
    // construtor

    // esse construtor serve para quando criar o objeto sem passagem de parametrô 
    Estatistiscas() { 
    this (0,0, "");
    }

    // construtror para ser possível definir os valores do objeto
    Estatistiscas(int CodigoCidade, int QtdAcidentes, String  NomeCidade) {
        this.CodigoCidade = CodigoCidade;
        this.QtdAcidentes = QtdAcidentes;
        this.NomeCidade = NomeCidade;
    }
}
