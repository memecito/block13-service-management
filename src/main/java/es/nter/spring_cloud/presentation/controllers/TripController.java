package es.nter.spring_cloud.presentation.controllers;

import es.nter.spring_cloud.presentation.dto.BasicResponseDto;
import es.nter.spring_cloud.presentation.dto.PageResponse;
import es.nter.spring_cloud.presentation.dto.client.ClientInDto;
import es.nter.spring_cloud.presentation.dto.client.ClientOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {
    @GetMapping
    private ResponseEntity<PageResponse<ClientOutDto>> getAll(
            @RequestParam(defaultValue = "0", required = false) int pageNumber,
            @RequestParam(defaultValue = "10", required = false) int pageSize
    ){
        return null;
    }

    @GetMapping("/{id}")
    private ResponseEntity<ClientOutDto> getById(@PathVariable Long id){
        return null;
    }

    @PostMapping
    private ResponseEntity<ClientOutDto> create(@RequestBody ClientInDto clientIn){
        return null;
    }

    @PutMapping("/{id}")
    private ResponseEntity<ClientOutDto> update(@PathVariable Long id,
                                                @RequestBody ClientInDto clientIn){
        return null;
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<BasicResponseDto> delete(@PathVariable Long id){
        return null;
    }
}
