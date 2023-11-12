package org.example.repositories;

import org.example.domain.Tarefa;

import java.util.List;
import java.util.Optional;

public class TarefaRepository {

    private List<Tarefa> tarefaList;
    public TarefaRepository(List<Tarefa> tarefaList) {
        this.tarefaList = tarefaList;
    }

    public boolean create(Tarefa tarefa) throws Exception {
        try{
            tarefaList.add(tarefa);
        }catch(Exception err) {
            return false;
        }
        return true;
    }

    public Tarefa update(Integer id, Tarefa tarefa) {

        Tarefa tarefaToUpdate = findOne(id);

        if(tarefaToUpdate == null) return null;

        int tarefaIndex = tarefaList.indexOf(tarefaToUpdate);

        if(tarefa.getNome() != null) {
            tarefaToUpdate.setNome(tarefa.getNome());
        }
        if(tarefa.getStatus() != null) {
            tarefaToUpdate.setStatus(tarefa.getStatus());
        }

        if(tarefa.getDescricao() != null) {
            tarefaToUpdate.setDescricao(tarefa.getDescricao());
        }

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
