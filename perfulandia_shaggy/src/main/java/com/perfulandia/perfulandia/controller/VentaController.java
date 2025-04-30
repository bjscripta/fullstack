package com.perfulandia.perfulandia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.perfulandia.perfulandia.model.Venta;
import com.perfulandia.perfulandia.repository.VentaRepository;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaRepository ventaRepository;

    // Crear una nueva venta
    @PostMapping
    public ResponseEntity<String> agregarVenta(@RequestBody Venta venta) {
        ventaRepository.agregarVenta(venta);
        return ResponseEntity.ok("Venta agregada exitosamente");
    }

    // Leer todas las ventas
    @GetMapping
    public List<Venta> listarVentas() {
        return ventaRepository.listarVenta();
    }

    // Leer una venta por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venta> obtenerVentaPorId(@PathVariable int id) {
        Optional<Venta> venta = ventaRepository.obtenerVentaPorId(id);
        return venta.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar una venta existente
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarVenta(@PathVariable int id, @RequestBody Venta ventaActualizada) {
        boolean actualizado = ventaRepository.actualizarVenta(id, ventaActualizada);
        if (actualizado) {
            return ResponseEntity.ok("Venta actualizada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una venta por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVenta(@PathVariable int id) {
        boolean eliminado = ventaRepository.eliminarVenta(id);
        if (eliminado) {
            return ResponseEntity.ok("Venta eliminada exitosamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}