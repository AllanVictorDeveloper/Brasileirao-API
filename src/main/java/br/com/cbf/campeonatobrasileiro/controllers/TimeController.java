package br.com.cbf.campeonatobrasileiro.controllers;


import br.com.cbf.campeonatobrasileiro.entity.Time;
import br.com.cbf.campeonatobrasileiro.services.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

    @GetMapping
    public ResponseEntity<List<Time>> getTimes() {
        List<Time> timesList = this.timeService.listarTimes();

        return ResponseEntity.ok().body(timesList);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Time> getTimeById(@PathVariable Integer id) {
        Time time = this.timeService.obterTime(id);

        return ResponseEntity.ok().body(time);
    }

    @PostMapping
    public ResponseEntity<Void> cadastrarTime(@RequestBody Time time) {
        this.timeService.cadastrarTime(time);
        return ResponseEntity.ok().build();
    }

}
