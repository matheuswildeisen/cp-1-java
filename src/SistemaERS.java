import java.util.ArrayList;

public class SistemaERS {
    // Listas para armazenar os dados
    private ArrayList<Colaborador> colaboradores;
    private ArrayList<Recurso> recursos;
    private ArrayList<Alocacao> alocacoes;
    
    // Construtor
    public SistemaERS() {
        colaboradores = new ArrayList<Colaborador>();
        recursos = new ArrayList<Recurso>();
        alocacoes = new ArrayList<Alocacao>();
    }
    
    // === MÉTODOS DE CADASTRO ===
    
    // Cadastrar colaborador
    public void cadastrarColaborador(int id, String nome, String cargo, double salario, String dataAdmissao) {
        Colaborador novoColaborador = new Colaborador(id, nome, cargo, salario, dataAdmissao);
        colaboradores.add(novoColaborador);
        System.out.println("Colaborador cadastrado: " + nome);
    }
    
    // Cadastrar recurso
    public void cadastrarRecurso(int id, String nome, String categoria, double valor) {
        Recurso novoRecurso = new Recurso(id, nome, categoria, valor);
        recursos.add(novoRecurso);
        System.out.println("Recurso cadastrado: " + nome);
    }
    
    // === MÉTODO OBRIGATÓRIO DE ALOCAÇÃO ===
    
    // Método obrigatório - alocar recurso
    public void alocarRecurso(int colaboradorId, int recursoId) {
        // Buscar colaborador
        Colaborador colaborador = buscarColaboradorPorId(colaboradorId);
        if (colaborador == null) {
            System.out.println("ERRO: Colaborador não encontrado!");
            return;
        }
        
        if (!colaborador.isAtivo()) {
            System.out.println("ERRO: Colaborador não está ativo!");
            return;
        }
        
        // Buscar recurso
        Recurso recurso = buscarRecursoPorId(recursoId);
        if (recurso == null) {
            System.out.println("ERRO: Recurso não encontrado!");
            return;
        }
        
        // Verificar se pode ser alocado
        if (!recurso.podeSerAlocado()) {
            if (!recurso.isDisponivel()) {
                System.out.println("ERRO: Recurso já está alocado!");
            } else {
                System.out.println("AVISO: Recurso com valor acima de R$ 5.000 precisa de autorização especial!");
            }
            return;
        }
        
        // Realizar a alocação
        recurso.alocar(colaboradorId); // Agora passamos o colaboradorId para registrar quem pegou o recurso
        String dataAtual = "21/03/2026"; // Data fixa para simplicidade
        Alocacao novaAlocacao = new Alocacao(colaboradorId, recursoId, dataAtual);
        alocacoes.add(novaAlocacao);
        
        System.out.println("Recurso alocado com sucesso!");
        System.out.println("Colaborador: " + colaborador.getNome());
        System.out.println("Recurso: " + recurso.getNomeDoRecurso());
    }
    
    // Devolver recurso
    public void devolverRecurso(int recursoId) {
        Recurso recurso = buscarRecursoPorId(recursoId);
        if (recurso == null) {
            System.out.println("ERRO: Recurso não encontrado!");
            return;
        }
        
        if (recurso.isDisponivel()) {
            System.out.println("ERRO: Recurso já está disponível!");
            return;
        }
        
        recurso.devolver();
        System.out.println("Recurso devolvido: " + recurso.getNomeDoRecurso());
    }
    
    // === MÉTODOS DE BUSCA ===
    
    // Buscar colaborador por ID
    public Colaborador buscarColaboradorPorId(int id) {
        for (int i = 0; i < colaboradores.size(); i++) {
            Colaborador colaborador = colaboradores.get(i);
            if (colaborador.getId() == id) {
                return colaborador;
            }
        }
        return null;
    }
    
    // Buscar recurso por ID
    public Recurso buscarRecursoPorId(int id) {
        for (int i = 0; i < recursos.size(); i++) {
            Recurso recurso = recursos.get(i);
            if (recurso.getId() == id) {
                return recurso;
            }
        }
        return null;
    }
    
    // === MÉTODOS DE EXIBIÇÃO ===
    
    // Exibir todos os colaboradores
    public void exibirColaboradores() {
        System.out.println("\n=== COLABORADORES CADASTRADOS ===");
        if (colaboradores.size() == 0) {
            System.out.println("Nenhum colaborador cadastrado.");
            return;
        }
        
        for (int i = 0; i < colaboradores.size(); i++) {
            System.out.println(colaboradores.get(i).toString());
        }
    }
    
    // Exibir todos os recursos
    public void exibirRecursos() {
        System.out.println("\n=== RECURSOS CADASTRADOS ===");
        if (recursos.size() == 0) {
            System.out.println("Nenhum recurso cadastrado.");
            return;
        }
        
        for (int i = 0; i < recursos.size(); i++) {
            System.out.println(recursos.get(i).toString());
        }
    }
    
    // Exibir alocações
    public void exibirAlocacoes() {
        System.out.println("\n=== ALOCAÇÕES REALIZADAS ===");
        if (alocacoes.size() == 0) {
            System.out.println("Nenhuma alocação realizada.");
            return;
        }
        
        for (int i = 0; i < alocacoes.size(); i++) {
            Alocacao alocacao = alocacoes.get(i);
            Colaborador colaborador = buscarColaboradorPorId(alocacao.getColaboradorId());
            Recurso recurso = buscarRecursoPorId(alocacao.getRecursoId());
            
            System.out.println("Data: " + alocacao.getData());
            System.out.println("Colaborador: " + colaborador.getNome());
            System.out.println("Recurso: " + recurso.getNomeDoRecurso());
            System.out.println("---");
        }
    }
    
    // === INOVAÇÃO: CÁLCULO DE CUSTO POR COLABORADOR ===
    
    // Calcular custo total de equipamentos por colaborador
    public void calcularCustoPorColaborador(int colaboradorId) {
        Colaborador colaborador = buscarColaboradorPorId(colaboradorId);
        if (colaborador == null) {
            System.out.println("ERRO: Colaborador não encontrado!");
            return;
        }
        
        double custoTotal = 0;
        int quantidadeRecursos = 0;
        
        System.out.println("\n=== RECURSOS ALOCADOS PARA: " + colaborador.getNome() + " ===");
        
        for (int i = 0; i < alocacoes.size(); i++) {
            Alocacao alocacao = alocacoes.get(i);
            if (alocacao.getColaboradorId() == colaboradorId) {
                Recurso recurso = buscarRecursoPorId(alocacao.getRecursoId());
                // MUDANÇA: Agora verificamos se o recurso está indisponível E se o colaboradorId registrado no Recurso é o mesmo da alocação.
                // Isso evita cobrar de um colaborador antigo caso o recurso já tenha sido devolvido e reatribuído a outra pessoa.
                if (recurso != null && !recurso.isDisponivel() && recurso.getColaboradorId() == colaboradorId) {
                    System.out.println("- " + recurso.getNomeDoRecurso() + ": R$ " + recurso.getValorEstimado());
                    custoTotal += recurso.getValorEstimado();
                    quantidadeRecursos++;
                }
            }
        }
        
        System.out.println("\nTotal de recursos: " + quantidadeRecursos);
        System.out.println("Custo total: R$ " + custoTotal);
    }
    
    // Relatório geral do sistema
    public void relatorioGeral() {
        System.out.println("\n========== RELATÓRIO GERAL ERS ==========");
        System.out.println("Total de colaboradores: " + colaboradores.size());
        System.out.println("Total de recursos: " + recursos.size());
        System.out.println("Total de alocações: " + alocacoes.size());
        
        // Contar recursos disponíveis
        int recursosDisponiveis = 0;
        for (int i = 0; i < recursos.size(); i++) {
            if (recursos.get(i).isDisponivel()) {
                recursosDisponiveis++;
            }
        }
        System.out.println("Recursos disponíveis: " + recursosDisponiveis);
        System.out.println("Recursos alocados: " + (recursos.size() - recursosDisponiveis));
    }
}