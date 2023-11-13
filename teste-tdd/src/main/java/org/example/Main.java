package org.example;

import org.example.domain.Tarefa;
import org.example.domain.enums.StatusTarefa;
import org.example.repositories.TarefaRepository;
import org.example.service.TarefaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Tarefa> tarefaList = new ArrayList<Tarefa>();
        TarefaRepository tarefaRepository = new TarefaRepository(tarefaList);
        TarefaService tarefaService = new TarefaService(tarefaRepository);

        Scanner scanner = new Scanner(System.in);

        int option;

        do{
            System.out.println("Digite a opção: " +
                    "\n1 - Adicionar Tarefa" +
                    "\n2 - Editar Tarefa" +
                    "\n3 - Marcar como concluída" +
                    "\n4 - Listar Tarefas" +
                    "\n5 - Remover Tarefas" +
                    "\n0 - Sair");

            option = validateInputMinMax(scanner, 0, 5);

            switch (option) {
                case 1 -> {
                    System.out.println("Digite o nome da tarefa: ");
                    String tarefaName = scanner.nextLine();

                    System.out.println("Digite a descricao da tarefa: ");
                    String tarefaDescricao = scanner.nextLine();

                    Tarefa tarefa = new Tarefa(tarefaName, tarefaDescricao, StatusTarefa.FAZER);

                    tarefaService.create(tarefa);
                }
                case 2 -> {
                    printTarefas(tarefaService);

                    System.out.println("\nDigite o ID de uma tarefa para editar: ");

                    int tarefaId = validateInput(scanner);

                    Tarefa foundTarefa = tarefaService.findOne(tarefaId);

                    if(foundTarefa != null) {

                        System.out.println("\nO que deseja editar: \n1 - Nome\n2 - Descricao\n3 - Nome e Descricao\n4 - Status");

                        int updateOption = validateInputMinMax(scanner, 1, 4);

                        String tarefaName = null;
                        String tarefaDescricao = null;
                        Tarefa tarefa = null;
                        StatusTarefa statusTarefa = null;

                        switch (updateOption) {
                            case 1 -> {
                                System.out.println("Digite o nome da tarefa: ");
                                tarefaName = scanner.nextLine();
                            }
                            case 2 -> {
                                System.out.println("Digite a descricao da tarefa: ");
                                tarefaDescricao = scanner.nextLine();
                            }
                            case 3 -> {
                                System.out.println("Digite o nome da tarefa: ");
                                tarefaName = scanner.nextLine();
                                System.out.println("Digite a descricao da tarefa: ");
                                tarefaDescricao = scanner.nextLine();
                            }
                            case 4 -> {
                                System.out.println("Digite o status (FAZER | FAZENDO | FEITO): ");
                                String statusTarefaInput = scanner.nextLine().toUpperCase();

                                while (!statusTarefaInput.matches("(FAZER|FEITO|FAZENDO)")) {
                                    System.out.println("Status inválido!");
                                    statusTarefaInput = scanner.nextLine().toUpperCase();
                                }

                                statusTarefa = StatusTarefa.valueOf(statusTarefaInput);
                            }

                        }
                        if (tarefaName != null || tarefaDescricao != null) {
                            tarefa = new Tarefa(tarefaName, tarefaDescricao);
                        } else if (statusTarefa != null) {
                            tarefa = new Tarefa(statusTarefa);
                        }

                        tarefaService.update(tarefaId, tarefa);
                        System.out.println("Tarefa com id " + tarefaId + " atualizada com sucesso!");

                    } else {
                        System.out.println("\nTarefa não encontrada com id " + tarefaId + "\n");
                    }
                }
                case 3 -> {
                    printTarefas(tarefaService);

                    System.out.println("\nDigite o ID de uma tarefa para marcar como concluída: ");

                    int tarefaId = validateInput(scanner);

                    Tarefa foundTarefa = tarefaService.findOne(tarefaId);

                    if(foundTarefa != null) {
                        Tarefa tarefaStatus = new Tarefa(StatusTarefa.FEITO);
                        tarefaService.update(tarefaId, tarefaStatus);
                        System.out.println("Tarefa com id " + tarefaId + " completada com sucesso!");

                    } else {
                        System.out.println("\nTarefa não encontrada com id " + tarefaId + "\n");
                    }
                }
                case 4 -> {
                    printTarefas(tarefaService);

                    System.out.println("\nPressione ENTER para continuar.\n");
                    scanner.nextLine();
                }
                case 5 -> {
                    printTarefas(tarefaService);

                    System.out.println("\nDigite o ID de uma tarefa para remover: \n");

                    int tarefaId = validateInput(scanner);

                    Tarefa foundTarefa = tarefaService.findOne(tarefaId);

                    if(foundTarefa != null) {
                        tarefaService.delete(tarefaId);
                        System.out.println("Tarefa com id " + tarefaId + " deletada com sucesso!");
                    } else {
                        System.out.println("\nTarefa não encontrada com id " + tarefaId + "\n");
                    }
                }
            }

        }while(option != 0);
        System.out.println("Sistema Finalizado.");

    }

    private static int validateInputMinMax(Scanner scanner, int min, int max) {
        int option;

        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Opcão inválida");
                scanner.next();
            }
            option = scanner.nextInt();
            if(option < min || option > max)
                System.out.println("Opcão Inválida");
        } while (option < min || option > max);
        scanner.nextLine();

        return option;
    }
    private static int validateInput(Scanner scanner) {
        int tarefaId = -1;

        do{
            while(!scanner.hasNextInt()){
                System.out.println("Opcão inválida");
                scanner.next();
            }
            tarefaId = scanner.nextInt();
        }while(tarefaId == -1);

        scanner.nextLine();

        return tarefaId;

    }

    private static void printTarefas(TarefaService tarefaService) {
        List<Tarefa> tarefas = tarefaService.find();

        System.out.println("Lista de Tarefas:");
        tarefas.forEach(tarefa -> {
            System.out.println("\nId: " + tarefa.getId() + "\nNome: " + tarefa.getNome() + "\nDescricao: " + tarefa.getDescricao() + "\nStatus: " + tarefa.getStatus());
        });
    }


}