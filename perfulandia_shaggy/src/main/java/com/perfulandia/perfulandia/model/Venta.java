package com.perfulandia.perfulandia.model;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    private int idCliente;
    private int idVenta;
    private Date fechaVenta;
    private int cantidad;
    private int precioUnitario;

}
