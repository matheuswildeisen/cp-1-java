public class Alocacao {
    // Atributos da alocação
    private int colaboradorId;
    private int recursoId;
    private String data;
    private String observacao;
    
    // Construtor básico
    public Alocacao(int colaboradorId, int recursoId, String data) {
        this.colaboradorId = colaboradorId;
        this.recursoId = recursoId;
        this.data = data;
        this.observacao = "";
    }
    
    // Construtor com observação
    public Alocacao(int colaboradorId, int recursoId, String data, String observacao) {
        this.colaboradorId = colaboradorId;
        this.recursoId = recursoId;
        this.data = data;
        this.observacao = observacao;
    }
    
    // Métodos getter
    public int getColaboradorId() {
        return colaboradorId;
    }
    
    public int getRecursoId() {
        return recursoId;
    }
    
    public String getData() {
        return data;
    }
    
    public String getObservacao() {
        return observacao;
    }
    
    // Métodos setter
    public void setData(String data) {
        this.data = data;
    }
    
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    // Método para exibir informações da alocação
    public String toString() {
        String obs = observacao.isEmpty() ? "Sem observações" : observacao;
        return "Colaborador ID: " + colaboradorId + " | Recurso ID: " + recursoId + 
               " | Data: " + data + " | Obs: " + obs;
    }
}