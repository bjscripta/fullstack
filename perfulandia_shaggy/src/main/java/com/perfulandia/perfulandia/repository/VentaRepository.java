package com.perfulandia.perfulandia.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.perfulandia.perfulandia.model.Venta;

@Repository
public class VentaRepository {

    private List<Venta> listaVentas = new ArrayList<>();

    // Crear una nueva venta
    public void agregarVenta(Venta venta) {
        listaVentas.add(venta);
    }

    // Leer todas las ventas
    public List<Venta> listarVenta() {
        return listaVentas;
    }

    // Leer una venta por ID
    public Optional<Venta> obtenerVentaPorId(int idVenta) {
        return listaVentas.stream()
                .filter(venta -> venta.getIdVenta() == idVenta)
                .findFirst();
    }

    // Actualizar una venta existente
    public boolean actualizarVenta(int idVenta, Venta ventaActualizada) {
        Optional<Venta> ventaExistente = obtenerVentaPorId(idVenta);
        if (ventaExistente.isPresent()) {
            Venta venta = ventaExistente.get();
            venta.setIdCliente(ventaActualizada.getIdCliente());
            venta.setFechaVenta(ventaActualizada.getFechaVenta());
            venta.setCantidad(ventaActualizada.getCantidad());
            venta.setPrecioUnitario(ventaActualizada.getPrecioUnitario());
            return true;
        }
        return false;
    }

    // Eliminar una venta por ID
    public boolean eliminarVenta(int idVenta) {
        return listaVentas.removeIf(venta -> venta.getIdVenta() == idVenta);
    }
}