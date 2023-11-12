package org.example.repositories;

import org.example.domain.Tarefa;
import org.example.domain.enums.StatusTarefa;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TarefaRepositoryTest {

    TarefaRepository tarefaRepository;

    @BeforeEach
    public void setUp() {
        List<Tarefa> tarefaList = new ArrayList<>(Arrays.asList(new Tarefa(0, "Tarefa ja na lista", "Descricao ja na lista", StatusTarefa.FAZENDO)));
        tarefaRepository = new TarefaRepository(tarefaList);

    }

    @Test
    public void testeFindAndCreateTarefa() throws Exception {
        boolean isAdded = tarefaRepository.create(new Tarefa(1, "Tarefa 1", "Descricao 1", StatusTarefa.FAZER));
        boolean isAdded2 = tarefaRepository.create(new Tarefa(2, "Tarefa 2", "Descricao 2", StatusTarefa.FAZER));
        List<Tarefa> tarefas = tarefaRepository.find();

        Assertions.assertTrue(isAdded);
        Assertions.assertEquals(tarefas.get(1).getNome(), "Tarefa 1");
        Assertions.assertEquals(tarefas.get(1).getDescricao(), "Descricao 1");
        Assertions.assertEquals(1, tarefas.get(1).getId());

        Assertions.assertTrue(isAdded2);
        Assertions.assertEquals(tarefas.get(2).getNome(), "Tarefa 2");
        Assertions.assertEquals(tarefas.get(2).getDescricao(), "Descricao 2");
        Assertions.assertEquals(2, tarefas.get(2).getId());
    }

    @Test
    public void testeCompleteTarefa() {
        Tarefa tarefaUpdate = new Tarefa(StatusTarefa.FEITO);

        tarefaRepository.update(0, tarefaUpdate);

        Tarefa tarefa = tarefaRepository.findOne(0);

        Assertions.assertEquals(tarefa.getStatus(), StatusTarefa.FEITO);
    }

    @Test
    public void testeUpdateTarefa() {

        Tarefa tarefaUpdate = new Tarefa("Tarefa Update");
        Tarefa tarefaUpdate2 = new Tarefa(StatusTarefa.FAZER);
        List<Tarefa> tarefas = tarefaRepository.find();
        tarefaRepository.update(tarefas.get(0).getId(), tarefaUpdate);
        tarefaRepository.update(tarefas.get(0).getId(), tarefaUpdate2 );

        Tarefa tarefa = tarefaRepository.findOne(tarefas.get(0).getId());

        Assertions.assertEquals( "Tarefa Update", tarefa.getDescricao());
        Assertions.assertEquals(StatusTarefa.FAZER, tarefa.getStatus());
    }

    @Test
    public void testeDeleteTarefa() {
        Tarefa tarefaAntes = tarefaRepository.findOne(0);
        Assertions.assertNotNull(tarefaAntes);

        boolean isTarefaDeleted = tarefaRepository.delete(0);

        Assertions.assertTrue(isTarefaDeleted);
        Tarefa tarefaDepois = tarefaRepository.findOne(0);
        Assertions.assertNull(tarefaDepois);

    }

    @AfterEach
    public void cleanUp() {
        tarefaRepository = null;
    }

}
