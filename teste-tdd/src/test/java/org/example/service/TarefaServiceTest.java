package org.example.service;

import org.example.domain.Tarefa;
import org.example.repositories.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaServiceTest {
    TarefaRepository tarefaRepository = new TarefaRepository();
    TarefaService tarefaService = new TarefaService(tarefaRepository);

    @Test
    public void testeCreateTarefa() {
        tarefaService.create(new Tarefa("Tarefa 1", "Descricao 1"));
        tarefaService.create(new Tarefa("Tarefa 2", "Descricao 2"));
    }

    @Test
    public void testeFindTarefa() {
        Tarefa[] tarefas = tarefaService.find();
        Assertions.assertEquals(tarefas[0].nome, "Tarefa 1");
        Assertions.assertEquals(tarefas[1].nome, "Tarefa 2");
        Assertions.assertEquals(tarefas[1].descricao, "Descricao 2");
        Assertions.assertEquals(tarefas[1].descricao, "Descricao 2");
    }

    @Test
    public void testeCompleteTarefa() {
        tarefaService.update("Tarefa 1", status, true);
        Tarefa tarefa = tarefaService.findOne("Tarefa 1");
        Assertions.assertTrue(tarefa.status);
    }

    @Test
    public void testeUpdateTarefa() {

    }

    @Test
    public void testeDeleteTarefa() {

    }
}
