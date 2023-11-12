package org.example.service;

import org.example.domain.Tarefa;
import org.example.repositories.TarefaRepository;

import java.util.List;

public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public boolean create(Tarefa tarefa)throws Exception {
        if(tarefa == null) return false;
        tarefaRepository.create(tarefa);
    }

    public List<Tarefa> find() {
        return tarefaRepository.find();
    }

    public Tarefa findOne(Integer id) {
        return tarefaRepository.findOne(id);
    }

    public void update(Integer id, Tarefa tarefa) {
        tarefaRepository.update(id, tarefa);
    }

    public boolean delete(Integer id) {
        return tarefaRepository.delete(id);
    }
}
