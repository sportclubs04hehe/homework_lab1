package vegakinvietnam.com.lab1class.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vegakinvietnam.com.lab1class.model.HocSinh;
import vegakinvietnam.com.lab1class.service.HocSinhService;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class HocSinhController {
    @Autowired
    private final HocSinhService hocSinhService;

    @PostMapping("/add")
    public ResponseEntity<HocSinh> add(@Valid @RequestBody HocSinh hocSinh){
        HocSinh hocSinh1 = hocSinhService.createStudent(hocSinh);
        return new ResponseEntity<>(hocSinh1, CREATED);
    }

}
