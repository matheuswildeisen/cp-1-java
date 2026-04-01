public class Main {
    public static void main(String[] args) {
        // Criar sistema ERS
        SistemaERS sistema = new SistemaERS();
        
        System.out.println("========================================");
        System.out.println("     SISTEMA ERS - EMPLOYEE RESOURCE    ");
        System.out.println("========================================");
        
        // === CADASTRANDO COLABORADORES ===
        System.out.println("\n1. CADASTRANDO COLABORADORES...");
        sistema.cadastrarColaborador(1, "João Silva", "Desenvolvedor", 5000.0, "15/01/2026");
        sistema.cadastrarColaborador(2, "Maria Santos", "Analista", 4500.0, "20/02/2026");
        sistema.cadastrarColaborador(3, "Pedro Costa", "Gerente", 8000.0, "10/01/2026");
        
        // === CADASTRANDO RECURSOS ===
        System.out.println("\n2. CADASTRANDO RECURSOS...");
        sistema.cadastrarRecurso(101, "Notebook Dell", "Notebook", 3500.0);
        sistema.cadastrarRecurso(102, "Monitor 24 polegadas", "Monitor", 800.0);
        sistema.cadastrarRecurso(103, "iPhone 15", "Celular", 6000.0); // Valor alto para teste
        sistema.cadastrarRecurso(104, "Cadeira Ergonômica", "Móvel", 1200.0);
        sistema.cadastrarRecurso(105, "Notebook Gamer", "Notebook", 4500.0);
        
        // === EXIBINDO DADOS INICIAIS ===
        sistema.exibirColaboradores();
        sistema.exibirRecursos();
        
        // === TESTANDO ALOCAÇÕES ===
        System.out.println("\n3. TESTANDO ALOCAÇÕES...");
        
        // Alocação normal (deve funcionar)
        System.out.println("\n3.1 Alocação normal:");
        sistema.alocarRecurso(1, 101); // João recebe Notebook Dell
        
        // Alocação normal (deve funcionar)
        System.out.println("\n3.2 Segunda alocação:");
        sistema.alocarRecurso(2, 102); // Maria recebe Monitor
        
        // Tentativa de alocação de recurso já alocado (deve dar erro)
        System.out.println("\n3.3 Tentando alocar recurso já alocado:");
        sistema.alocarRecurso(3, 101); // Pedro tenta pegar Notebook Dell (já alocado)
        
        // Tentativa de alocação de recurso caro (deve dar aviso)
        System.out.println("\n3.4 Tentando alocar recurso caro:");
        sistema.alocarRecurso(1, 103); // João tenta pegar iPhone (valor alto)
        
        // Alocação bem-sucedida para Pedro
        System.out.println("\n3.5 Alocação para Pedro:");
        sistema.alocarRecurso(3, 104); // Pedro recebe Cadeira
        
        // === EXIBINDO ALOCAÇÕES ===
        sistema.exibirAlocacoes();
        
        // === TESTANDO PROMOÇÃO ===
        System.out.println("\n4. TESTANDO PROMOÇÃO...");
        Colaborador joao = sistema.buscarColaboradorPorId(1);
        System.out.println("Antes da promoção: " + joao.toString());
        joao.promover("Desenvolvedor Senior", 6500.0);
        System.out.println("Após a promoção: " + joao.toString());
        
        // === TESTANDO INOVAÇÃO: CUSTO POR COLABORADOR ===
        System.out.println("\n5. INOVAÇÃO - CUSTO POR COLABORADOR...");
        sistema.calcularCustoPorColaborador(1); // João
        sistema.calcularCustoPorColaborador(2); // Maria
        sistema.calcularCustoPorColaborador(3); // Pedro
        
        // === TESTANDO DEVOLUÇÃO ===
        System.out.println("\n6. TESTANDO DEVOLUÇÃO...");
        sistema.devolverRecurso(102); // Maria devolve Monitor
        
        // Verificar que o recurso ficou disponível
        System.out.println("\nApós devolução:");
        sistema.exibirRecursos();
        
        // === RELATÓRIO FINAL ===
        sistema.relatorioGeral();
        
        // === TESTE DE ERROS ===
        System.out.println("\n7. TESTANDO CASOS DE ERRO...");
        
        // Tentar alocar para colaborador inexistente
        System.out.println("\n7.1 Colaborador inexistente:");
        sistema.alocarRecurso(999, 105);
        
        // Tentar alocar recurso inexistente
        System.out.println("\n7.2 Recurso inexistente:");
        sistema.alocarRecurso(1, 999);
        
        // Tentar devolver recurso já disponível
        System.out.println("\n7.3 Devolver recurso já disponível:");
        sistema.devolverRecurso(102); // Monitor já foi devolvido
        
        // === DEMONSTRAÇÃO FINAL ===
        System.out.println("\n8. DEMONSTRAÇÃO FINAL...");
        
        // Alocar o monitor que foi devolvido
        sistema.alocarRecurso(1, 102); // João pega o monitor que Maria devolveu
        
        // Mostrar estado final
        System.out.println("\nESTADO FINAL DO SISTEMA:");
        sistema.exibirRecursos();
        sistema.calcularCustoPorColaborador(1); // João agora tem 2 recursos
        
        System.out.println("\n========================================");
        System.out.println("    DEMONSTRAÇÃO CONCLUÍDA COM SUCESSO  ");
        System.out.println("========================================");
    }
}