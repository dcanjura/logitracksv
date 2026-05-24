package com.project.logitracksv.cassandra.controller;

import com.project.logitracksv.cassandra.dto.TelemetriaRequestDTO;
import com.project.logitracksv.cassandra.dto.TelemetriaResponseDTO;
import com.project.logitracksv.cassandra.service.TelemetriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/telemetria")
@RequiredArgsConstructor
public class TelemetriaController {

    private final TelemetriaService telemetriaService;

    @PostMapping
    public TelemetriaResponseDTO crear(@Valid @RequestBody TelemetriaRequestDTO telemetria) {
        return telemetriaService.crear(telemetria);
    }

    @GetMapping("/vehiculo/{idVehiculo}")
    public List<TelemetriaResponseDTO> obtenerPorVehiculo(@PathVariable String idVehiculo) {
        return telemetriaService.obtenerPorVehiculo(idVehiculo);
    }

    @GetMapping("/vehiculo/{idVehiculo}/rango")
    public List<TelemetriaResponseDTO> obtenerPorVehiculoYRango(
            @PathVariable String idVehiculo,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant desde,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Instant hasta
    ) {
        return telemetriaService.obtenerPorVehiculoYRango(idVehiculo, desde, hasta);
    }
}
