package es.daw.springpurchasesapirest.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchases")
@RequiredArgsConstructor
@Validated

public class PurhaseController {

    // ----------------------------------
    // CONFIGURACIÓN PERSONALIZADA
    @Value("${config.daw.code}")
    private String code_conf;
    @Value("${config.daw.message}")
    private String message_conf;
    //-------------------------------------

    private final ProductoService productoService;
    private final ProductoMapper productoMapper;

    @GetMapping("/values-conf")
    public Map<String, String> values() {
        Map<String, String> json = new HashMap<>();
        json.put("code", code_conf);
        json.put("message", message_conf);
        return json;
    }

    @GetMapping("/values-conf2")
    public Map<String, String> values(@Value("${config.daw.code}") String code, @Value("${config.daw.message}") String message) {
        Map<String, String> json = new HashMap<>();
        json.put("code", code);
        json.put("message", message);
        return json;
    }

    @GetMapping
    public ResponseEntity<Optional<List<ProductoDTO>>> findAll() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<ProductoDTO> findByCodigo(@PathVariable String codigo) {
        return ResponseEntity.of(productoService.findByCodigo(codigo));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@Valid @RequestBody ProductoDTO productoDTO) {
        return productoService.save(productoDTO).map(productoDTO1 -> ResponseEntity.status(HttpStatus.CREATED).body(productoDTO1)).orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }

    @GetMapping("/parse-int")
    public String parseInteger(@RequestParam(name = "numero", defaultValue = "666") String number) {
        int parsedNumber = Integer.parseInt(number);
        return "Parsed number: " + parsedNumber;
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> delete(@Pattern(regexp = "^\\d{3}[A-Z]$", message = "The pattern must have 3 digits followed by a letter " + "(CAPS)") @PathVariable String codigo) {
        return productoService.delete(codigo) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();


    }

}
