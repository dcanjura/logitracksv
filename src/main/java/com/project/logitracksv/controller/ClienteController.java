package com.project.logitracksv.controller;

import com.project.logitracksv.dto.ClienteRequestDTO;
import com.project.logitracksv.dto.ClienteResponseDTO;
import com.project.logitracksv.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    // CREATE
    @PostMapping
    public ClienteResponseDTO crear(@Valid @RequestBody ClienteRequestDTO cliente) {
        return clienteService.crear(cliente);
    }

    // READ ALL (PAGINADO)
    @GetMapping
    public Page<ClienteResponseDTO> obtenerTodos(Pageable pageable) {
        return clienteService.obtenerTodos(pageable);
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ClienteResponseDTO obtenerPorId(@PathVariable String id) {
        return clienteService.obtenerPorId(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ClienteResponseDTO actualizar(@PathVariable String id,
                                         @Valid @RequestBody ClienteRequestDTO cliente) {
        return clienteService.actualizar(id, cliente);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable String id) {
        clienteService.eliminar(id);
    }

    // FILTRO POR ESTADO
    @GetMapping("/estado/{estado}")
    public Page<ClienteResponseDTO> obtenerPorEstado(@PathVariable String estado,
                                                     Pageable pageable) {
        return clienteService.obtenerPorEstado(estado, pageable);
    }

    // BÚSQUEDA POR NOMBRE
    @GetMapping("/buscar")
    public Page<ClienteResponseDTO> buscarPorNombre(@RequestParam String nombre,
                                                    Pageable pageable) {
        return clienteService.buscarPorNombre(nombre, pageable);
    }
}