package com.springBajo8.springBajo8.web;


import com.springBajo8.springBajo8.domain.PadecimientoTratamiento;
import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.service.IcitasReactivaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class citasReactivaResource {

    @Autowired
    private IcitasReactivaService icitasReactivaService;

    @PostMapping("/citasReactivas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<citasDTOReactiva> save(@RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.save(citasDTOReactiva);
    }

    @DeleteMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> delete(@PathVariable("id") String id) {
        return this.icitasReactivaService.delete(id)
                .flatMap(citasDTOReactiva -> Mono.just(ResponseEntity.ok(citasDTOReactiva)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/citasReactivas/{id}")
    private Mono<ResponseEntity<citasDTOReactiva>> update(@PathVariable("id") String id, @RequestBody citasDTOReactiva citasDTOReactiva) {
        return this.icitasReactivaService.update(id, citasDTOReactiva)
                .flatMap(citasDTOReactiva1 -> Mono.just(ResponseEntity.ok(citasDTOReactiva1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @GetMapping("/citasReactivas/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> findAllByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.findByIdPaciente(idPaciente);
    }

    @GetMapping(value = "/citasReactivas")
    private Flux<citasDTOReactiva> findAll() {
        return this.icitasReactivaService.findAll();
    }


    @PutMapping("/cancelarCita/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> cancelarCitaByidPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.cancelarCita(idPaciente);
    }

    @GetMapping("/consultarFechaHora/{fecha}/{hora}")
    private Flux<citasDTOReactiva> consultarFechaHora(@PathVariable("fecha") String fecha, @PathVariable("hora") String hora) {
        LocalDate fechaParseada = LocalDate.parse(fecha);
        return this.icitasReactivaService.consultarFechaYHora(fechaParseada, hora);
    }

    @GetMapping("/consultarMedico/{idPaciente}/byidPaciente")
    private Flux<citasDTOReactiva> consultarMedicoByIdPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.consultarMedicoQueLoAtendera(idPaciente);
    }

    @GetMapping("/consultarTratamiento/{idPaciente}/byidPaciente")
    private Flux<List<PadecimientoTratamiento>> consultarTratamientoByIdPaciente(@PathVariable("idPaciente") String idPaciente) {
        return this.icitasReactivaService.consultarTratamientosYPadecimientos(idPaciente);
    }

}
