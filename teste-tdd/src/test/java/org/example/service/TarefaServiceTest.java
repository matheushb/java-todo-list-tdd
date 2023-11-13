package org.example.service;

import org.example.domain.Tarefa;
import org.example.domain.enums.StatusTarefa;
import org.example.repositories.TarefaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarefaServiceTest {

    List<Tarefa> tarefaList;
    TarefaRepository tarefaRepository;
    TarefaService tarefaService;

    @BeforeEach
    public void setUp() {
        tarefaList = new ArrayList<>(Arrays.asList(new Tarefa(0,"Tarefa 1", "Descricao 1", StatusTarefa.FAZER)));
        tarefaRepository = new TarefaRepository(tarefaList);
        tarefaService = new TarefaService(tarefaRepository);
    }

    @Test
    public void testeCreateTarefa() throws Exception {
        boolean isCreated = tarefaService.create(new Tarefa("Tarefa 1", "Descricao 1", StatusTarefa.FAZER));
        boolean isCreated2 = tarefaService.create(new Tarefa("Tarefa 2", "Descricao 2", StatusTarefa.FAZER));

        Assertions.assertTrue(isCreated);
        Assertions.assertTrue(isCreated2);
    }

    @Test
    public void testeFindTarefa() {
        List<Tarefa> tarefas = tarefaService.find();
        Assertions.assertEquals(tarefas.get(0).getNome(), "Tarefa 1");
        Assertions.assertEquals(tarefas.get(0).getDescricao(), "Descricao 1");
        Assertions.assertEquals(0, tarefas.get(0).getId());

    }

    @Test
    public void testeCompleteTarefa() {
        Tarefa tarefaUpdate = new Tarefa(StatusTarefa.FEITO);

        tarefaService.update(0, tarefaUpdate);
        Tarefa tarefa = tarefaService.findOne(0);
        Assertions.assertEquals(StatusTarefa.FEITO, tarefa.getStatus());
    }

    @Test
    public void testeUpdateTarefa() {
        Tarefa tarefaUpdate = new Tarefa("novo nome", "nova descricao");

        tarefaService.update(0, tarefaUpdate);
        Tarefa tarefa = tarefaService.findOne(0);

        Assertions.assertNull(tarefaService.update(-1, new Tarefa("LOL")));
        Assertions.assertNull(tarefaService.update(0, null));

        Assertions.assertEquals("novo nome", tarefa.getNome());
        Assertions.assertEquals("nova descricao", tarefa.getDescricao());
    }

    @Test
    public void testeDeleteTarefa() {
        boolean isDeleted = tarefaService.delete(0);
        boolean isDeletedFalse = tarefaService.delete(-1);

        Assertions.assertFalse(isDeletedFalse);
        Assertions.assertTrue(isDeleted);
    }

}
