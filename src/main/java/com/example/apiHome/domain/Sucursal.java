package com.example.apiHome.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sucursales")
public class Sucursal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "cuit",length = 22)
    int clientNumberCuit;
    @Column(name = "location",length = 17)
    String clientlocation;
    @Column(length = 17)
    String businessName;
    @Column(length = 17)
    String managerName;
    @Column(length = 17)
    String subManagerName;
    @Column(length = 17)
    String city;
    @Column(length = 17)
    String Province;
    @Column(length = 17)
    String country;

    boolean onHold;

}
