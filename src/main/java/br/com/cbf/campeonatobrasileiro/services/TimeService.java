package br.com.cbf.campeonatobrasileiro.services;

import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository timeRepository;

    public void cadastrarTime(Time time) {

        this.timeRepository.save(time);
    }

    public List<Time> listarTimes() {
        return this.timeRepository.findAll();
    }

    public Time obterTime(Integer id) {
        Optional<Time> time = this.timeRepository
                .findById(id);

        if (time.isEmpty()) {
            throw new RuntimeException("Time não encontrado com o id " + id + "informado");
        }

        return time.get();
    }
}
