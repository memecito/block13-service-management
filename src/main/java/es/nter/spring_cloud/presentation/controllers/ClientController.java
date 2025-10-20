package es.nter.spring_cloud.presentation.controllers;

import es.nter.spring_cloud.application.mappers.ClientMapper;
import es.nter.spring_cloud.application.services.ClientService;
import es.nter.spring_cloud.persistence.entities.Client;
import es.nter.spring_cloud.presentation.dto.BasicResponseDto;
import es.nter.spring_cloud.presentation.dto.PageResponse;
import es.nter.spring_cloud.presentation.dto.client.ClientInDto;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDto;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDtoMini;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;
    private final ClientMapper mapper;

    @GetMapping
    private ResponseEntity<PageResponse<ClientOutDtoMini>> getAll(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "10", required = false) int pageSize
    ){
        return ResponseEntity.ok(
                new PageResponse<>(service.getAll(pageNumber, pageSize).map(mapper::toDtoMini)));
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClientOutDto> getById(@PathVariable Long id){

        return ResponseEntity.ok(mapper.toDto(service.getById(id)));
    }

    @PostMapping
    private ResponseEntity<ClientOutDto> create(@RequestBody ClientInDto clientIn){

        return ResponseEntity.ok(mapper.toDto(service.created(mapper.toModel(clientIn))));
    }

    @PutMapping("/{id}")
    private ResponseEntity<ClientOutDto> update(@PathVariable Long id,
                                                @RequestBody ClientInDto clientIn){
        return ResponseEntity.ok(mapper.toDto(service.updated(id,mapper.toModel(clientIn))));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<BasicResponseDto> delete(@PathVariable Long id){
        service.deleted(id);
        return ResponseEntity.ok(new BasicResponseDto(HttpStatus.OK.value(), "Resgistro eliminado"));
    }

}
