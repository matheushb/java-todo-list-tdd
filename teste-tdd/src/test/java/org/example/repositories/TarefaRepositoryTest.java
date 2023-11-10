package org.example.repositories;

import org.example.domain.Tarefa;
import org.example.domain.enums.StatusTarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TarefaRepositoryTest {

    List<Tarefa> tarefaList;
    TarefaRepository tarefaRepository = new TarefaRepository(tarefaList);

    @Test
    public void testeCreateTarefa() {
        tarefaRepository.create(new Tarefa(1, "Tarefa 1", "Descricao 1", StatusTarefa.FAZER));
        tarefaRepository.create(new Tarefa(2, "Tarefa 2", "Descricao 2", StatusTarefa.FAZER));
    }

    @Test
    public void testeFindTarefa() {
        List<Tarefa> tarefas = tarefaRepository.find();
        Assertions.assertEquals(tarefas.get(0).getNome(), "Tarefa 1");
        Assertions.assertEquals(tarefas.get(0).getDescricao(), "Descricao 2");
        Assertions.assertEquals(tarefas.get(0).getId(), 1);

        Assertions.assertEquals(tarefas.get(1).getNome(), "Tarefa 2");
        Assertions.assertEquals(tarefas.get(1).getDescricao(), "Descricao 2");
        Assertions.assertEquals(tarefas.get(1).getId(), 2);
    }

    @Test
    public void testeCompleteTarefa() {
        tarefaRepository.update(1L, "Tarefa 1", "", "");
        Tarefa tarefa = tarefaRepository.findOne(1L);
        Assertions.assertEquals(tarefa.getStatus(), StatusTarefa.FAZER);
    }

    @Test
    public void testeUpdateTarefa() {
        tarefaRepository.update(1L, "nome", "Tarefa Update");
        tarefaRepository.update(1L, "descricao", "Descricao Update");
        Tarefa tarefa = tarefaRepository.findOne(1L);
        Assertions.assertEquals(tarefa.getNome(), "Tarefa Update");
        Assertions.assertEquals(tarefa.getDescricao(), "Descricao Update");
    }

    @Test
    public void testeDeleteTarefa() {
        tarefaRepository.delete(1L);
    }
}
