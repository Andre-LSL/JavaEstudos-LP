class votacao {
    int numeroSecao, votoCandidato;
    
    // Os dois atributos principais são os votos e numero da Seção.
    votacao () {
        this(0,0);
    }
    votacao(int numeroSecao, int votoCandidato) {
        this.numeroSecao = numeroSecao;
        this.votoCandidato = votoCandidato;
    }
}
