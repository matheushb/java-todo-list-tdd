package org.example.service;

import org.example.domain.Tarefa;
import org.example.domain.enums.StatusTarefa;
import org.example.repositories.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TarefaServiceTest {

    List<Tarefa> tarefaList;
    TarefaRepository tarefaRepository = new TarefaRepository(tarefaList);
    TarefaService tarefaService = new TarefaService(tarefaRepository);

    @Test
    public void testeCreateTarefa() throws Exception {
        tarefaService.create(new Tarefa("Tarefa 1", "Descricao 1", StatusTarefa.FAZER));
        tarefaService.create(new Tarefa("Tarefa 2", "Descricao 2", StatusTarefa.FAZER));
    }

    @Test
    public void testeFindTarefa() {
        List<Tarefa> tarefas = tarefaService.find();
        Assertions.assertEquals(tarefas.get(0).getNome(), "Tarefa 1");
        Assertions.assertEquals(tarefas.get(0).getDescricao(), "Descricao 2");
        Assertions.assertEquals(tarefas.get(0).getId(), 1);

        Assertions.assertEquals(tarefas.get(1).getNome(), "Tarefa 2");
        Assertions.assertEquals(tarefas.get(1).getDescricao(), "Descricao 2");
        Assertions.assertEquals(tarefas.get(1).getId(), 2);
    }

    @Test
    public void testeCompleteTarefa() {
        Tarefa tarefaUpdate = new Tarefa("Descricao Update");

        tarefaService.update(1, tarefaUpdate);
        Tarefa tarefa = tarefaService.findOne(1);
        Assertions.assertEquals(tarefa.getStatus(), StatusTarefa.FAZER);
    }

    @Test
    public void testeUpdateTarefa() {
        Tarefa tarefaUpdate1 = new Tarefa(StatusTarefa.FAZER);
        Tarefa tarefaUpdate2 = new Tarefa("nome", "descricao");



        tarefaService.update(1, tarefaUpdate1);
        tarefaService.update(1, tarefaUpdate2);
        Tarefa tarefa = tarefaService.findOne(1);
        Assertions.assertEquals(tarefa.getNome(), "Tarefa Update");
        Assertions.assertEquals(tarefa.getDescricao(), "Descricao Update");
    }

    @Test
    public void testeDeleteTarefa() {
        Assertions.assertTrue(tarefaService.delete(1));
    }
}
