package com.project.logitracksv.service;

import com.project.logitracksv.dto.AlertaRequestDTO;
import com.project.logitracksv.dto.AlertaResponseDTO;
import com.project.logitracksv.entity.AlertaEntity;
import com.project.logitracksv.mapper.AlertaMapper;
import com.project.logitracksv.repository.AlertaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertaService {

    private final AlertaRepository alertaRepository;

    // CREATE
    public AlertaResponseDTO crear(AlertaRequestDTO dto) {
        AlertaEntity entity = AlertaMapper.toEntity(dto);
        return AlertaMapper.toDTO(alertaRepository.save(entity));
    }

    // READ ALL (PAGINADO)
    public Page<AlertaResponseDTO> obtenerTodos(Pageable pageable) {
        return alertaRepository.findAll(pageable)
                .map(AlertaMapper::toDTO);
    }

    // READ BY ID
    public AlertaResponseDTO obtenerPorId(String id) {
        AlertaEntity entity = alertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));

        return AlertaMapper.toDTO(entity);
    }

    // UPDATE
    public AlertaResponseDTO actualizar(String id, AlertaRequestDTO dto) {
        AlertaEntity existente = alertaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Alerta no encontrada"));

        existente.setVehiculoId(dto.vehiculoId());
        existente.setTipoAlerta(dto.tipoAlerta());
        existente.setValor(dto.valor());
        existente.setLimite(dto.limite());
        existente.setFecha(dto.fecha());
        existente.setEstado(dto.estado());

        return AlertaMapper.toDTO(alertaRepository.save(existente));
    }

    // DELETE
    public void eliminar(String id) {
        alertaRepository.deleteById(id);
    }

    // FILTRO POR VEHICULO
    public Page<AlertaResponseDTO> obtenerPorVehiculo(String vehiculoId, Pageable pageable) {
        return alertaRepository.findByVehiculoId(vehiculoId, pageable)
                .map(AlertaMapper::toDTO);
    }

    // FILTRO POR ESTADO
    public Page<AlertaResponseDTO> obtenerPorEstado(String estado, Pageable pageable) {
        return alertaRepository.findByEstado(estado, pageable)
                .map(AlertaMapper::toDTO);
    }

    // FILTRO POR TIPO
    public Page<AlertaResponseDTO> obtenerPorTipo(String tipo, Pageable pageable) {
        return alertaRepository.findByTipoAlerta(tipo, pageable)
                .map(AlertaMapper::toDTO);
    }
}