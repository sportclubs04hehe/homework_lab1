package vegakinvietnam.com.lab1class.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vegakinvietnam.com.lab1class.model.Lop;
import vegakinvietnam.com.lab1class.service.LopService;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping(path = "/api/v1")
@RequiredArgsConstructor
public class LopController {
    @Autowired
    private final LopService lopService;

    @GetMapping("/getAllClass")
    public ResponseEntity<Page<Lop>> getAllClass(@RequestParam(defaultValue = "0") int page,
                                                 @RequestParam(defaultValue = "10") int size){
        Page<Lop> lops = lopService.getAllClass(page, size);
        return new ResponseEntity<>(lops, OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Lop>> searchLops(@RequestParam(required = false) String keyword,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        Page<Lop> lops = lopService.searchClass(keyword, page, size);
        return ResponseEntity.ok(lops);
    }
    @PostMapping("/addClass")
    public ResponseEntity<Lop> addLop(@Valid @RequestBody Lop lop) {
        try {
            Lop addedLop = lopService.createClass(lop);
            return new ResponseEntity<>(addedLop, CREATED);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/delete/{maLop}")
    public ResponseEntity<Void> deleteLop(@PathVariable String maLop) {
        lopService.deleteLopByMaLop(maLop);
        return new ResponseEntity<>(OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Lop> update(@RequestBody Lop lop, @PathVariable("id") Long id){
        Lop lop1 = lopService.updateLopById(lop,id);
        return new ResponseEntity<>(lop1, OK);
    }


}
