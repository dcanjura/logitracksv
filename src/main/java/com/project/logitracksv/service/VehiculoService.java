package com.project.logitracksv.service;

import com.project.logitracksv.dto.VehiculoRequestDTO;
import com.project.logitracksv.dto.VehiculoResponseDTO;
import com.project.logitracksv.entity.VehiculoEntity;
import com.project.logitracksv.exception.ResourceNotFoundException;
import com.project.logitracksv.mapper.VehiculoMapper;
import com.project.logitracksv.repository.VehiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    // CREATE
    public VehiculoResponseDTO crear(VehiculoRequestDTO dto) {
        VehiculoEntity entity = VehiculoMapper.toEntity(dto);
        return VehiculoMapper.toDTO(vehiculoRepository.save(entity));
    }

    // READ ALL (PAGINADO)
    public Page<VehiculoResponseDTO> obtenerTodos(Pageable pageable) {
        return vehiculoRepository.findAll(pageable)
                .map(VehiculoMapper::toDTO);
    }

    // READ BY ID
    public VehiculoResponseDTO obtenerPorId(String id) {
        VehiculoEntity entity = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado"));

        return VehiculoMapper.toDTO(entity);
    }

    // UPDATE
    public VehiculoResponseDTO actualizar(String id, VehiculoRequestDTO dto) {
        VehiculoEntity existente = vehiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vehículo no encontrado"));

        existente.setPlaca(dto.placa());
        existente.setModelo(dto.modelo());
        existente.setAnio(dto.anio());
        existente.setEstado(dto.estado());
        existente.setConductorAsignado(
                VehiculoMapper.toEntity(dto).getConductorAsignado()
        );
        existente.setSensoresInstalados(
                VehiculoMapper.toEntity(dto).getSensoresInstalados()
        );
        existente.setUltimaMantenimiento(dto.ultimaMantenimiento());

        return VehiculoMapper.toDTO(vehiculoRepository.save(existente));
    }

    // DELETE
    public void eliminar(String id) {
        if (!vehiculoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Vehículo no encontrado");
        }

        vehiculoRepository.deleteById(id);
    }
}
