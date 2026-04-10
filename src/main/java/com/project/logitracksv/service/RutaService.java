package com.project.logitracksv.service;

import com.project.logitracksv.dto.RutaRequestDTO;
import com.project.logitracksv.dto.RutaResponseDTO;
import com.project.logitracksv.entity.RutaEntity;
import com.project.logitracksv.mapper.RutaMapper;
import com.project.logitracksv.repository.RutaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RutaService {

    private final RutaRepository rutaRepository;

    // CREATE
    public RutaResponseDTO crear(RutaRequestDTO dto) {
        RutaEntity entity = RutaMapper.toEntity(dto);
        return RutaMapper.toDTO(rutaRepository.save(entity));
    }

    // READ ALL (PAGINADO)
    public Page<RutaResponseDTO> obtenerTodos(Pageable pageable) {
        return rutaRepository.findAll(pageable)
                .map(RutaMapper::toDTO);
    }

    // READ BY ID
    public RutaResponseDTO obtenerPorId(String id) {
        RutaEntity entity = rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

        return RutaMapper.toDTO(entity);
    }

    // UPDATE
    public RutaResponseDTO actualizar(String id, RutaRequestDTO dto) {
        RutaEntity existente = rutaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ruta no encontrada"));

        existente.setCliente(RutaMapper.toEntity(dto).getCliente());
        existente.setVehiculo(RutaMapper.toEntity(dto).getVehiculo());
        existente.setConductor(RutaMapper.toEntity(dto).getConductor());
        existente.setOrigen(dto.origen());
        existente.setDestino(dto.destino());
        existente.setFechaSalida(dto.fechaSalida());
        existente.setFechaLlegadaEstimada(dto.fechaLlegadaEstimada());
        existente.setEstado(dto.estado());

        return RutaMapper.toDTO(rutaRepository.save(existente));
    }

    // DELETE
    public void eliminar(String id) {
        rutaRepository.deleteById(id);
    }

    // FILTRO POR ESTADO
    public Page<RutaResponseDTO> obtenerPorEstado(String estado, Pageable pageable) {
        return rutaRepository.findByEstado(estado, pageable)
                .map(RutaMapper::toDTO);
    }

    // FILTRO POR CLIENTE
    public Page<RutaResponseDTO> obtenerPorCliente(String clienteId, Pageable pageable) {
        return rutaRepository.findByCliente_ClienteId(clienteId, pageable)
                .map(RutaMapper::toDTO);
    }

    // FILTRO POR VEHICULO
    public Page<RutaResponseDTO> obtenerPorVehiculo(String vehiculoId, Pageable pageable) {
        return rutaRepository.findByVehiculo_VehiculoId(vehiculoId, pageable)
                .map(RutaMapper::toDTO);
    }

    // FILTRO POR CONDUCTOR
    public Page<RutaResponseDTO> obtenerPorConductor(String conductorId, Pageable pageable) {
        return rutaRepository.findByConductor_ConductorId(conductorId, pageable)
                .map(RutaMapper::toDTO);
    }
}