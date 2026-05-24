package com.project.logitracksv.controller;

import com.project.logitracksv.dto.AlertaRequestDTO;
import com.project.logitracksv.dto.AlertaResponseDTO;
import com.project.logitracksv.service.AlertaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alertas")
@RequiredArgsConstructor
public class AlertaController {

    private final AlertaService alertaService;

    // CREATE
    @PostMapping
    public AlertaResponseDTO crear(@Valid @RequestBody AlertaRequestDTO alerta) {
        return alertaService.crear(alerta);
    }

    // READ ALL (PAGINADO)
    @GetMapping
    public Page<AlertaResponseDTO> obtenerTodos(Pageable pageable) {
        return alertaService.obtenerTodos(pageable);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public AlertaResponseDTO obtenerPorId(@PathVariable String id) {
        return alertaService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public AlertaResponseDTO actualizar(@PathVariable String id,
                                        @Valid @RequestBody AlertaRequestDTO alerta) {
        return alertaService.actualizar(id, alerta);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        alertaService.eliminar(id);
    }

    // FILTRO POR VEHICULO
    @GetMapping("/vehiculo/{vehiculoId}")
    public Page<AlertaResponseDTO> obtenerPorVehiculo(@PathVariable String vehiculoId,
                                                      Pageable pageable) {
        return alertaService.obtenerPorVehiculo(vehiculoId, pageable);
    }

    // FILTRO POR ESTADO
    @GetMapping("/estado/{estado}")
    public Page<AlertaResponseDTO> obtenerPorEstado(@PathVariable String estado,
                                                    Pageable pageable) {
        return alertaService.obtenerPorEstado(estado, pageable);
    }

    // FILTRO POR TIPO
    @GetMapping("/tipo/{tipo}")
    public Page<AlertaResponseDTO> obtenerPorTipo(@PathVariable String tipo,
                                                  Pageable pageable) {
        return alertaService.obtenerPorTipo(tipo, pageable);
    }
}