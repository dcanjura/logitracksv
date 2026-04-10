package com.project.logitracksv.service;

import com.project.logitracksv.dto.ClienteRequestDTO;
import com.project.logitracksv.dto.ClienteResponseDTO;
import com.project.logitracksv.entity.ClienteEntity;
import com.project.logitracksv.mapper.ClienteMapper;
import com.project.logitracksv.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // CREATE
    public ClienteResponseDTO crear(ClienteRequestDTO dto) {
        ClienteEntity entity = ClienteMapper.toEntity(dto);
        return ClienteMapper.toDTO(clienteRepository.save(entity));
    }

    // READ ALL (PAGINADO)
    public Page<ClienteResponseDTO> obtenerTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable)
                .map(ClienteMapper::toDTO);
    }

    // READ BY ID
    public ClienteResponseDTO obtenerPorId(String id) {
        ClienteEntity entity = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        return ClienteMapper.toDTO(entity);
    }

    // UPDATE
    public ClienteResponseDTO actualizar(String id, ClienteRequestDTO dto) {
        ClienteEntity existente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        existente.setNombre(dto.nombre());
        existente.setDireccion(dto.direccion());
        existente.setTelefono(dto.telefono());
        existente.setEmail(dto.email());
        existente.setEstado(dto.estado());

        return ClienteMapper.toDTO(clienteRepository.save(existente));
    }

    // DELETE
    public void eliminar(String id) {
        clienteRepository.deleteById(id);
    }

    // FILTRO POR ESTADO
    public Page<ClienteResponseDTO> obtenerPorEstado(String estado, Pageable pageable) {
        return clienteRepository.findByEstado(estado, pageable)
                .map(ClienteMapper::toDTO);
    }

    // BÚSQUEDA POR NOMBRE
    public Page<ClienteResponseDTO> buscarPorNombre(String nombre, Pageable pageable) {
        return clienteRepository.findByNombreContainingIgnoreCase(nombre, pageable)
                .map(ClienteMapper::toDTO);
    }
}