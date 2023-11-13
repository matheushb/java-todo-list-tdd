package org.example.service;

import org.example.domain.Tarefa;
import org.example.repositories.TarefaRepository;

import java.util.List;

public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public boolean create(Tarefa createTarefaDto)throws Exception {
        if(createTarefaDto == null) return false;
        tarefaRepository.create(createTarefaDto);
        return true;
    }

    public List<Tarefa> find() {
        return tarefaRepository.find();
    }

    public Tarefa findOne(Integer id) {
        return tarefaRepository.findOne(id);
    }

    public Tarefa update(Integer id, Tarefa updateTarefaDto) {

        if(updateTarefaDto == null) return null;

        Tarefa tarefaToUpdate = findOne(id);

        if(tarefaToUpdate == null) return null;

        if(updateTarefaDto.getNome() != null) {
            tarefaToUpdate.setNome(updateTarefaDto.getNome());
        }
        if(updateTarefaDto.getStatus() != null) {
            tarefaToUpdate.setStatus(updateTarefaDto.getStatus());
        }

        if(updateTarefaDto.getDescricao() != null) {
            tarefaToUpdate.setDescricao(updateTarefaDto.getDescricao());
        }

        return tarefaRepository.update(id, tarefaToUpdate);
    }

    public boolean delete(Integer id) {
        return tarefaRepository.delete(id);
    }
}
