package es.nter.spring_cloud.presentation.controllers;

import es.nter.spring_cloud.application.mappers.ClientMapper;
import es.nter.spring_cloud.application.mappers.TripMapper;
import es.nter.spring_cloud.application.services.TripService;
import es.nter.spring_cloud.persistence.entities.Trip;
import es.nter.spring_cloud.presentation.dto.BasicResponseDto;
import es.nter.spring_cloud.presentation.dto.PageResponse;
import es.nter.spring_cloud.presentation.dto.client.ClientInDto;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDto;
import es.nter.spring_cloud.presentation.dto.trip.TripInDto;
import es.nter.spring_cloud.presentation.dto.trip.TripOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService service;
    private final TripMapper mapper;

    private final ClientMapper clientMapper;

    @GetMapping
    private ResponseEntity<PageResponse<TripOutDto>> getAll(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "10", required = false) int pageSize
    ) {
        return ResponseEntity.ok(
                new PageResponse<>(service.getAll(pageNumber, pageSize).map(mapper::toDto)));
    }

    @GetMapping("/{id}")
    private ResponseEntity<TripOutDto> getById(@PathVariable Long id) {
        Trip tripFound= service.getById(id);

        return ResponseEntity.ok(mapper.toDto(tripFound));
    }

    @GetMapping("/{tripId}/passenger-count")
    private ResponseEntity<?> getPassenger(@PathVariable Long tripId) {

        return ResponseEntity.ok(service.getPassenger(tripId).stream().map(clientMapper::toDto).collect(Collectors.toSet()));
    }

    @GetMapping("/{tripId}/available")
    private ResponseEntity<?> getAvailability(@PathVariable Long tripId) {
        return ResponseEntity.ok(null);
    }


    @PostMapping
    private ResponseEntity<TripOutDto> create(@RequestBody TripInDto tripIn) {
        return ResponseEntity.ok(mapper.toDto(service.created(mapper.toModel(tripIn))));
    }

    @PostMapping("/{tripId}/passengers/{clientId}")
    private ResponseEntity<?> addPassenger(@PathVariable Long tripId,
                                           @PathVariable Long clientId) {
        return ResponseEntity.ok(null);
    }

    @PutMapping("/{id}")
    private ResponseEntity<TripOutDto> update(@PathVariable Long id,
                                              @RequestBody TripInDto tripIn) {
        return ResponseEntity.ok(mapper.toDto(service.updated(id, mapper.toModel(tripIn))));
    }

    @PutMapping("/{tripId}/status/{newStatus}")
    private ResponseEntity<TripOutDto> updateStatus(@PathVariable Long tripId,
                                                    @PathVariable String newStatus){
        return ResponseEntity.ok(mapper.toDto(service.updatedStatus(tripId,newStatus)));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<BasicResponseDto> delete(@PathVariable Long id) {
        service.deleted(id);
        return ResponseEntity.ok(new BasicResponseDto(HttpStatus.OK.value(), "Resgistro eliminado"));
    }
}
