public class Recurso {
    // Atributos básicos do recurso
    private int id;
    private String nomeDoRecurso;
    private String categoria;
    private boolean disponivel;
    private double valorEstimado;
    private int colaboradorId; // ID do colaborador que está com o recurso atualmente (-1 se disponível)
    
    // Construtor
    public Recurso(int id, String nomeDoRecurso, String categoria, double valorEstimado) {
        this.id = id;
        this.nomeDoRecurso = nomeDoRecurso;
        this.categoria = categoria;
        this.valorEstimado = valorEstimado;
        this.disponivel = true; // Recurso sempre começa disponível
        this.colaboradorId = -1; // Inicializa sem nenhum colaborador alocado
    }
    
    // Método obrigatório de negócio - verificar se pode ser alocado
    public boolean podeSerAlocado() {
        return disponivel && valorEstimado <= 5000;
    }
    
    // Método para alocar o recurso
    public void alocar(int colaboradorId) { // Recebe o ID do colaborador para registrar a posse atual
        this.disponivel = false;
        this.colaboradorId = colaboradorId; // Registra quem pegou o recurso
    }
    
    // Método para devolver o recurso
    public void devolver() {
        this.disponivel = true;
        this.colaboradorId = -1; // Limpa o ID do colaborador ao devolver
    }
    
    // Métodos getter
    public int getId() {
        return id;
    }
    
    public String getNomeDoRecurso() {
        return nomeDoRecurso;
    }
    
    public String getCategoria() {
        return categoria;
    }
    
    public boolean isDisponivel() {
        return disponivel;
    }
    
    public double getValorEstimado() {
        return valorEstimado;
    }

    public int getColaboradorId() { // Getter para verificar quem é o dono atual do recurso
        return colaboradorId;
    }
    
    // Métodos setter básicos
    public void setNomeDoRecurso(String nomeDoRecurso) {
        this.nomeDoRecurso = nomeDoRecurso;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public void setValorEstimado(double valorEstimado) {
        this.valorEstimado = valorEstimado;
    }
    
    // Método para exibir informações do recurso
    public String toString() {
        String status = disponivel ? "Disponível" : "Alocado";
        return "ID: " + id + " | Recurso: " + nomeDoRecurso + " | Categoria: " + categoria + 
               " | Valor: R$ " + valorEstimado + " | Status: " + status;
    }
}