package view;

// Importação das camadas de modelo e serviço para separar as responsabilidades (Arquitetura em Camadas)
import model.*;
import service.*;
import java.util.Scanner;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        // Objeto Scanner configurado com UTF-8 para leitura de caracteres especiais
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);

        /* * INSTANCIAÇÃO DOS SERVIÇOS
         * Aqui aplicamos o conceito de Gerenciamento de Dados em Memória.
         * Cada 'Service' possui uma lista (ArrayList) para armazenar os objetos.
         */
        RotaService rotaService = new RotaService();
        PontoApoioService pontoService = new PontoApoioService();
        PerigoService perigoService = new PerigoService();
        AvaliacaoService avaliacaoService = new AvaliacaoService();

        // CARGA INICIAL: Criamos um objeto Rota para o sistema não iniciar vazio
        rotaService.cadastrarRota(new Rota(1, "Ciclovia Rio Pinheiros", "Ciclovia", 22.0, "Jaguaré", "Interlagos", 1));
        
        int opcao = 0;

        // ESTRUTURA DE REPETIÇÃO: Mantém o programa rodando até o usuário escolher Sair (Opção 8)
        do {
            System.out.println("\n========= BIKE SEGURA =========");
            System.out.println("1 - Buscar e Listar Rotas");
            System.out.println("2 - Cadastrar Nova Rota");
            System.out.println("3 - Cadastrar Ponto de Apoio");
            System.out.println("4 - Reportar Perigo no Trajeto");
            System.out.println("5 - Listar Pontos de Apoio");
            System.out.println("6 - Avaliar uma Rota");
            System.out.println("7 - Ver Alertas de Perigos");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");

            // TRATAMENTO DE EXCEÇÃO: Evita que o programa quebre se o usuário digitar uma letra em vez de número
            try {
                opcao = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Erro: Entrada inválida. Digite apenas números.");
                continue;
            }

            // ESTRUTURA DE DECISÃO: Direciona o fluxo para a funcionalidade escolhida
            switch (opcao) {
                case 1:
                    System.out.println("\n--- BUSCA DE ROTA ---");
                    System.out.print("Ponto de Partida: ");
                    String inicio = sc.nextLine();
                    System.out.print("Ponto de Destino: ");
                    String fim = sc.nextLine();
                    
                    // Chamada do método de busca no Service
                    List<Rota> rotasEncontradas = rotaService.buscarRota(inicio, fim);
                    if (rotasEncontradas.isEmpty()) {
                        System.out.println("Nenhuma rota cadastrada para este trecho.");
                    } else {
                        for (Rota r : rotasEncontradas) {
                            System.out.println(r); // Chama o toString() sobrescrito na classe Rota
                            // Demonstração de cálculo dinâmico baseado nos atributos do objeto
                            System.out.println("Nível de Segurança Sugerido: " + r.calcularNivelSeguranca());
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- CADASTRO DE ROTA ---");
                    System.out.print("Nome da via: ");
                    String nome = sc.nextLine();
                    System.out.print("Tipo (Ciclovia/Ciclofaixa/Compartilhada): ");
                    String tipo = sc.nextLine();
                    System.out.print("Extensão (km): ");
                    double ext = Double.parseDouble(sc.nextLine());
                    System.out.print("Início: ");
                    String ini = sc.nextLine();
                    System.out.print("Fim: ");
                    String f = sc.nextLine();
                    System.out.print("Dificuldade (1-5): ");
                    int dif = Integer.parseInt(sc.nextLine());
                    
                    // INSTANCIAÇÃO: Criação de um novo objeto Rota e armazenamento na lista do Service
                    rotaService.cadastrarRota(new Rota(rotaService.getListaRotas().size() + 1, nome, tipo, ext, ini, f, dif));
                    System.out.println("Rota cadastrada com sucesso!");
                    break;

                case 3:
                    System.out.println("\n--- CADASTRO PONTO DE APOIO ---");
                    System.out.println("1-Bicicletário / 2-Oficina / 3-Bomba de Ar / 4-Bebedouro");
                    int tipoPonto = Integer.parseInt(sc.nextLine());
                    System.out.print("Nome: ");
                    String nPonto = sc.nextLine();
                    System.out.print("Endereço: ");
                    String end = sc.nextLine();
                    
                    /*
                     * APLICAÇÃO DE POLIMORFISMO:
                     * Criamos diferentes tipos de objetos (Bicicletario, Oficina, etc) 
                     * mas todos são tratados como 'PontoApoio' pelo Service.
                     */
                    if (tipoPonto == 1) pontoService.cadastrarPonto(new Bicicletario(pontoService.getListaPontos().size()+1, nPonto, end, "24h", 10));
                    else if (tipoPonto == 2) pontoService.cadastrarPonto(new Oficina(pontoService.getListaPontos().size()+1, nPonto, end, "Comercial"));
                    else if (tipoPonto == 3) pontoService.cadastrarPonto(new BombaAr(pontoService.getListaPontos().size()+1, nPonto, end, "24h"));
                    else pontoService.cadastrarPonto(new Bebedouro(pontoService.getListaPontos().size()+1, nPonto, end, "24h"));
                    System.out.println("Ponto de apoio registrado.");
                    break;

                case 4:
                    System.out.println("\n--- REPORTAR PERIGO ---");
                    System.out.print("Localização: ");
                    String local = sc.nextLine();
                    System.out.print("Descrição: ");
                    String desc = sc.nextLine();
                    System.out.println("Tipo: 1-Trânsito / 2-Iluminação / 3-Acidente / 4-Obra");
                    int tPerigo = Integer.parseInt(sc.nextLine());

                    /* * USO DE CLASSES ABSTRATAS:
                     * A variável 'novoPerigo' é do tipo pai (Perigo), mas recebe instâncias dos filhos.
                     */
                    Perigo novoPerigo;
                    if (tPerigo == 1) novoPerigo = new PerigoTransito(local, desc);
                    else if (tPerigo == 2) novoPerigo = new PerigoIluminacao(local, desc);
                    else if (tPerigo == 3) novoPerigo = new PerigoAcidente(local, desc);
                    else novoPerigo = new PerigoObra(local, desc);

                    perigoService.cadastrarPerigo(novoPerigo);
                    System.out.println("Alerta enviado à comunidade.");
                    break;

                case 5:
                    System.out.println("\n--- PONTOS DE APOIO CADASTRADOS ---");
                    if (pontoService.getListaPontos().isEmpty()) System.out.println("Nenhum ponto registrado.");
                    // FOREACH: Percorre a lista de pontos chamando o método polimórfico exibirServicos()
                    for (PontoApoio pa : pontoService.getListaPontos()) {
                        System.out.println(pa + " | " + pa.exibirServicos());
                    }
                    break;

                case 6:
                    System.out.println("\n--- AVALIAR ROTA ---");
                    List<Rota> todas = rotaService.getListaRotas();
                    if (todas.isEmpty()) {
                        System.out.println("Não há rotas para avaliar.");
                        break;
                    }
                    // Listagem numerada para o usuário escolher pelo índice da lista
                    for (int i = 0; i < todas.size(); i++) {
                        System.out.println(i + " - " + todas.get(i).getNome());
                    }
                    System.out.print("Escolha o número da rota: ");
                    int idx = Integer.parseInt(sc.nextLine());
                    
                    // Validação de segurança para evitar erro de índice fora da lista
                    if (idx >= 0 && idx < todas.size()) {
                        System.out.print("Nota (1-5): ");
                        int nota = Integer.parseInt(sc.nextLine());
                        System.out.print("Comentário: ");
                        String com = sc.nextLine();
                        // ASSOCIAÇÃO: Vincula o comentário ao objeto Rota escolhido
                        avaliacaoService.adicionarAvaliacao(todas.get(idx), nota, com);
                        System.out.println("Avaliação registrada!");
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;

                case 7:
                    System.out.println("\n--- ALERTAS ATIVOS NO MAPA ---");
                    if (perigoService.getListaPerigos().isEmpty()) System.out.println("Nenhum alerta no momento.");
                    for (Perigo p : perigoService.getListaPerigos()) {
                        /* * POLIMORFISMO EM AÇÃO:
                         * Cada objeto p chama sua própria versão do método exibirAlerta()
                         */
                        System.out.println(p.exibirAlerta());
                    }
                    break;

                case 8:
                    System.out.println("Encerrando sistema... Pedale com segurança!");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 8);

        sc.close(); // Fecha o Scanner para liberar recursos de memória
    }
}