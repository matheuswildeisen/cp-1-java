# CP - 01 Java

## Descrição do Projeto

O CP - 01 Java é uma aplicação Java simples projetada para gerenciar colaboradores e recursos dentro de uma organização, bem como o processo de alocação e devolução desses recursos. Ele permite o cadastro de funcionários, o registro de diversos tipos de recursos (como notebooks, monitores, celulares, etc.) e a associação desses recursos aos colaboradores. O sistema também inclui funcionalidades para promover colaboradores, calcular o custo total de recursos alocados por colaborador e gerar relatórios gerais sobre o estado do sistema.

## Funcionalidades

As principais funcionalidades implementadas neste sistema incluem:

*   **Cadastro de Colaboradores**: Adiciona novos colaboradores com ID, nome, cargo, salário e data de admissão.
*   **Cadastro de Recursos**: Registra recursos com ID, nome, categoria e valor estimado.
*   **Alocação de Recursos**: Atribui recursos a colaboradores, com validações para recursos já alocados ou recursos de alto valor (acima de R$ 5.000,00) que requerem atenção especial.
*   **Devolução de Recursos**: Libera recursos de colaboradores, tornando-os novamente disponíveis.
*   **Promoção de Colaboradores**: Atualiza o cargo e o salário de um colaborador existente.
*   **Cálculo de Custo por Colaborador**: Calcula o valor total dos recursos atualmente alocados a um colaborador específico.
*   **Exibição de Dados**: Mostra listas de colaboradores, recursos e alocações.
*   **Relatório Geral**: Apresenta um resumo estatístico do sistema, incluindo o número total de colaboradores, recursos e alocações, bem como a contagem de recursos disponíveis e alocados.

## Estrutura do Projeto

O projeto é composto pelas seguintes classes Java:

*   `Main.java`: Contém o método `main` e serve como ponto de entrada da aplicação. Demonstra o uso das funcionalidades do `SistemaERS` através de uma sequência de operações de cadastro, alocação, devolução e relatórios.
*   `cpjava.iml`: A classe principal que orquestra as operações do sistema. Gerencia as listas de `Colaborador`, `Recurso` e `Alocacao`, e implementa os métodos para cadastrar, buscar, alocar, devolver e exibir informações, além das funcionalidades de promoção e cálculo de custo.
*   `Colaborador.java`: Representa a entidade Colaborador. Contém atributos como ID, nome, cargo, salário, status de atividade e data de admissão. Inclui métodos para promover, ativar/desativar e exibir informações do colaborador.
*   `Recurso.java`: Representa a entidade Recurso. Possui atributos como ID, nome, categoria, status de disponibilidade, valor estimado e o ID do colaborador que o possui (se alocado). Implementa métodos para alocar, devolver e verificar se o recurso pode ser alocado.
*   `Alocacao.java`: Representa um registro de alocação, associando um `colaboradorId` a um `recursoId` em uma determinada `data`, com uma `observacao` opcional.

## Como Compilar e Executar

Para compilar e executar este projeto, siga os passos abaixo:

1.  **Pré-requisitos**: Certifique-se de ter o Java Development Kit (JDK) instalado em sua máquina. Você pode baixá-lo em [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) ou [OpenJDK](https://openjdk.java.net/).

2.  **Navegar até o diretório**: Abra um terminal ou prompt de comando e navegue até o diretório `CP-01-Java` onde os arquivos `.java` estão localizados.

    ```bash
    cd /caminho/para/o/seu/projeto/CP-01-Java
    ```

3.  **Compilar os arquivos Java**: Utilize o compilador `javac` para compilar todas as classes.

    ```bash
    javac *.java
    ```

4.  **Executar a aplicação**: Após a compilação bem-sucedida, execute a classe `Main`.

    ```bash
    java Main
    ```

O programa irá então executar a sequência de demonstração definida na classe `Main`, exibindo as operações e seus resultados no console.


LINK DO REPOSITORIO: https://github.com/matheuswildeisen/CP-01-Java
