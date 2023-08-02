package vegakinvietnam.com.lab1class.service;

import org.springframework.data.domain.Page;
import vegakinvietnam.com.lab1class.model.Lop;

public interface LopService {
    Page<Lop> getAllClass(int page,int size);

    Page<Lop> searchClass(String tuKhoa, int page, int size);

    Lop createClass(Lop lop);

    Lop updateLopById(Lop lop, Long id);

    void deleteLopByMaLop(String maLop);

}
