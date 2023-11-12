package org.example.domain;

import org.example.domain.enums.StatusTarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaTest {
    Tarefa tarefa = new Tarefa("Tarefa 1", "Descricao 1", StatusTarefa.FAZER);
    Tarefa newTarefa = new Tarefa("Tarefa 2", "Descricao", StatusTarefa.FAZENDO);
    Tarefa tarefa2 = new Tarefa("SÓ DESCRICAO");
    Tarefa tarefa3 = new Tarefa(StatusTarefa.FAZENDO);
    Tarefa tarefa4 = new Tarefa("Descricao", StatusTarefa.FAZER);
    Tarefa tarefa5 = new Tarefa("nome", "Descricao");

    @Test
    public void testeConstructorTarefa() {
        Assertions.assertNotNull(tarefa);
        Assertions.assertNotNull(tarefa2);
        Assertions.assertNotNull(tarefa3);
        Assertions.assertNotNull(tarefa4);
        Assertions.assertNotNull(tarefa5);

    }

    @Test
    public void testeAutoIncrement() {
        Assertions.assertEquals(0, tarefa.getId());
        Assertions.assertEquals(1, newTarefa.getId());

    }

    @Test
    public void testeGettersTarefa() {
        Assertions.assertEquals(tarefa.getNome(), "Tarefa 1");
        Assertions.assertEquals(tarefa.getDescricao(), "Descricao 1");
        Assertions.assertEquals(0, tarefa.getId());
        Assertions.assertEquals(tarefa.getStatus(), StatusTarefa.FAZER);
    }

    @Test
    public void testeSettersTarefa() {
        tarefa.setNome("Tarefa Nova");
        Assertions.assertEquals(tarefa.getNome(), "Tarefa Nova");
        tarefa.setDescricao("Descricao Nova");
        Assertions.assertEquals(tarefa.getDescricao(), "Descricao Nova");
        tarefa.setStatus(StatusTarefa.FAZER);
        Assertions.assertEquals(tarefa.getStatus(), StatusTarefa.FAZER);
    }


}
