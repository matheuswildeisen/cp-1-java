public class Colaborador {
    // Atributos básicos do colaborador
    private int id;
    private String nome;
    private String cargo;
    private double salario;
    private boolean ativo;
    private String dataDeAdmissao;
    
    // Construtor - colaborador sempre começa ativo
    public Colaborador(int id, String nome, String cargo, double salario, String dataDeAdmissao) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
        this.ativo = true; // Regra de negócio: sempre começa ativo
        this.dataDeAdmissao = dataDeAdmissao;
    }
    
    // Método obrigatório de negócio - promover colaborador
    public void promover(String novoCargo, double novoSalario) {
        this.cargo = novoCargo;
        this.salario = novoSalario;
    }
    
    // Método para desativar colaborador
    public void desativar() {
        this.ativo = false;
    }
    
    // Método para reativar colaborador
    public void reativar() {
        this.ativo = true;
    }
    
    // Métodos getter (para acessar os atributos)
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public boolean isAtivo() {
        return ativo;
    }
    
    public String getDataDeAdmissao() {
        return dataDeAdmissao;
    }
    
    // Métodos setter básicos
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    // Método para exibir informações do colaborador
    public String toString() {
        return "ID: " + id + " | Nome: " + nome + " | Cargo: " + cargo + 
               " | Salário: R$ " + salario + " | Ativo: " + ativo + 
               " | Admissão: " + dataDeAdmissao;
    }
}