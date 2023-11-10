package org.example.domain;

import org.example.domain.enums.StatusTarefa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaTest {
    Tarefa tarefa = new Tarefa(1, "Tarefa 1", "Descricao 1", StatusTarefa.FAZER);

    @Test
    public void testeConstructorTarefa() {
        Assertions.assertNotNull(tarefa);
    }

    @Test
    public void testeGettersTarefa() {
        Assertions.assertEquals(tarefa.getNome(), "Tarefa 1");
        Assertions.assertEquals(tarefa.getDescricao(), "Descricao 1");
        Assertions.assertEquals(tarefa.getId(), 1);
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
