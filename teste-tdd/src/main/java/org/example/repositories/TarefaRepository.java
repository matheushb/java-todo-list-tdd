package org.example.repositories;

import org.example.domain.Tarefa;

import java.util.List;
import java.util.Optional;

public class TarefaRepository {

    private List<Tarefa> tarefaList;
    public TarefaRepository(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList;
    }

    public boolean create(Tarefa createTarefaDto) throws Exception {
        try{
            tarefaList.add(createTarefaDto);
        }catch(Exception err) {
            return false;
        }
        return true;
    }

    public Tarefa update(Integer id, Tarefa tarefaToUpdate) {

        Tarefa tarefa = findOne(id);

        Integer tarefaIndex = tarefaList.indexOf(tarefa);

        if(tarefaIndex.equals(-1)) return null;

        tarefaList.set(tarefaIndex, tarefaToUpdate);

        return tarefaToUpdate;
    }


    public boolean delete(Integer id) {
        Tarefa tarefa = findOne(id);
        if(tarefa == null) return false;
        tarefaList.remove(tarefa);
        return true;
    }

    public List<Tarefa> find() {
        return tarefaList;
    }

    public Tarefa findOne(Integer id) {
        Optional<Tarefa> foundTarefa = tarefaList.stream().filter(tarefa -> tarefa.getId().equals(id)).findFirst();
        return foundTarefa.orElse(null);
    }
}
