package com.example.apiHome.domain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="productos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Producto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idProducto;
    @Column(nullable = true)
    private int codigoProducto;

    @Column(nullable = false)
    private Double precio;

    @Column(unique = true)
    private String nombre;

    private String producto;
    private String catalogo;
    private Boolean stock;
    @Column(name="fecha_alta")
    private Date fechaAlta;


}
