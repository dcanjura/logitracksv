package com.project.logitracksv.controller;

import com.project.logitracksv.dto.RutaRequestDTO;
import com.project.logitracksv.dto.RutaResponseDTO;
import com.project.logitracksv.service.RutaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rutas")
@RequiredArgsConstructor
public class RutaController {

    private final RutaService rutaService;

    // CREATE
    @PostMapping
    public RutaResponseDTO crear(@RequestBody RutaRequestDTO ruta) {
        return rutaService.crear(ruta);
    }

    // READ ALL (PAGINADO)
    @GetMapping
    public Page<RutaResponseDTO> obtenerTodos(Pageable pageable) {
        return rutaService.obtenerTodos(pageable);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public RutaResponseDTO obtenerPorId(@PathVariable String id) {
        return rutaService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public RutaResponseDTO actualizar(@PathVariable String id,
                                      @RequestBody RutaRequestDTO ruta) {
        return rutaService.actualizar(id, ruta);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        rutaService.eliminar(id);
    }

    // FILTRO POR ESTADO
    @GetMapping("/estado/{estado}")
    public Page<RutaResponseDTO> obtenerPorEstado(@PathVariable String estado,
                                                  Pageable pageable) {
        return rutaService.obtenerPorEstado(estado, pageable);
    }

    // FILTRO POR CLIENTE
    @GetMapping("/cliente/{clienteId}")
    public Page<RutaResponseDTO> obtenerPorCliente(@PathVariable String clienteId,
                                                   Pageable pageable) {
        return rutaService.obtenerPorCliente(clienteId, pageable);
    }

    // FILTRO POR VEHICULO
    @GetMapping("/vehiculo/{vehiculoId}")
    public Page<RutaResponseDTO> obtenerPorVehiculo(@PathVariable String vehiculoId,
                                                    Pageable pageable) {
        return rutaService.obtenerPorVehiculo(vehiculoId, pageable);
    }

    // FILTRO POR CONDUCTOR
    @GetMapping("/conductor/{conductorId}")
    public Page<RutaResponseDTO> obtenerPorConductor(@PathVariable String conductorId,
                                                     Pageable pageable) {
        return rutaService.obtenerPorConductor(conductorId, pageable);
    }
}