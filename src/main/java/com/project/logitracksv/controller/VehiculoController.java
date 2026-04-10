package com.project.logitracksv.controller;

import com.project.logitracksv.dto.VehiculoRequestDTO;
import com.project.logitracksv.dto.VehiculoResponseDTO;
import com.project.logitracksv.service.VehiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehiculos")
@RequiredArgsConstructor
public class VehiculoController {

    private final VehiculoService vehiculoService;

    // CREATE
    @PostMapping
    public VehiculoResponseDTO crear(@RequestBody VehiculoRequestDTO vehiculo) {
        return vehiculoService.crear(vehiculo);
    }

    // READ ALL (PAGINADO)
    @GetMapping
    public Page<VehiculoResponseDTO> obtenerTodos(Pageable pageable) {
        return vehiculoService.obtenerTodos(pageable);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public VehiculoResponseDTO obtenerPorId(@PathVariable String id) {
        return vehiculoService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public VehiculoResponseDTO actualizar(@PathVariable String id,
                                          @RequestBody VehiculoRequestDTO vehiculo) {
        return vehiculoService.actualizar(id, vehiculo);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        vehiculoService.eliminar(id);
    }
}