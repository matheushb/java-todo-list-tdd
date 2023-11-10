package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaTest {
    Tarefa tarefa = new Tarefa("Tarefa 1", "Descricao 1");

    @Test
    public void testeConstructorTarefa() {
        Assertions.assertNotNull(tarefa);
    }

    @Test
    public void testeGettersTarefa() {
        Assertions.assertEquals(tarefa.getNome(), "Tarefa 1");
        Assertions.assertEquals(tarefa.getDescricao(), "Descricao 1");
        Assertions.assertFalse(tarefa.getStatus());
    }

    @Test
    public void testeSettersTarefa() {
        tarefa.setNome("Tarefa Nova");
        Assertions.assertEquals(tarefa.getNome(), "Tarefa Nova");
        tarefa.setDescricao("Descricao Nova");
        Assertions.assertEquals(tarefa.getDescricao(), "Descricao Nova");
        tarefa.setStatus(true);
        Assertions.assertTrue(tarefa.getStatus());
    }


}
