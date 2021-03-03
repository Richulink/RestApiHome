package com.example.apiHome.Controllers;

import com.example.apiHome.domain.Producto;
import com.example.apiHome.services.OperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {

    private OperaService operaService;
    private String id;

    public UserController(@Autowired OperaService operaService) {
        this.operaService = operaService;
    }

    @RequestMapping ( value =("/"))
    public List<Producto> findAllProducts() {
        return operaService.getUser();
    }

    @GetMapping (value = "/producto/{nombre}")
    public Producto getProductoByNombre(@PathVariable ("nombre") String nombre) {
        return operaService.getProductoByNonmbre(nombre);
    }
    @GetMapping (value = "/NumeroDeProducto/{id}")
    public Optional<Producto> getProductoByID(@PathVariable Long id) {
        return operaService.getProductoById(id);
    }
    @PostMapping("/guardar")
    public ResponseEntity<Producto> createTutorial(@RequestBody Producto producto) {
        try {
             operaService.addProducto(producto);
            return new ResponseEntity<>(producto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public String deleteForId(@PathVariable Long id) {
        return operaService.deleteById(id);
    }
    @DeleteMapping("/deleteall")
    public String deleteAll() {
        return operaService.deleteAll(Producto.builder().build());
    }
}

