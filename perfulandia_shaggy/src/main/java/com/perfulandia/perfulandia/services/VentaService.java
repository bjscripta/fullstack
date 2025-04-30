package com.perfulandia.perfulandia.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.perfulandia.perfulandia.model.Venta;
import com.perfulandia.perfulandia.repository.VentaRepository;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Crear una nueva venta
    public void agregarVenta(Venta venta) {
        ventaRepository.agregarVenta(venta);
    }

    // Leer todas las ventas
    public List<Venta> listarVentas() {
        return ventaRepository.listarVenta();
    }

    // Leer una venta por ID
    public Optional<Venta> obtenerVentaPorId(int idVenta) {
        return ventaRepository.obtenerVentaPorId(idVenta);
    }

    // Actualizar una venta existente
    public boolean actualizarVenta(int idVenta, Venta ventaActualizada) {
        return ventaRepository.actualizarVenta(idVenta, ventaActualizada);
    }

    // Eliminar una venta por ID
    public boolean eliminarVenta(int idVenta) {
        return ventaRepository.eliminarVenta(idVenta);
    }
}
