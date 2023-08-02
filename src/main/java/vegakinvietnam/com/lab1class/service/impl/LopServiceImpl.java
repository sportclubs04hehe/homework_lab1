package vegakinvietnam.com.lab1class.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import vegakinvietnam.com.lab1class.exception.ClassNotFoundAndException;
import vegakinvietnam.com.lab1class.model.Lop;
import vegakinvietnam.com.lab1class.repo.LopRepository;
import vegakinvietnam.com.lab1class.service.LopService;

import java.time.LocalDateTime;

import static org.springframework.data.domain.Sort.Direction.DESC;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class LopServiceImpl implements LopService {
    @Autowired
    private final LopRepository lopRepository;
    @Override
    public Page<Lop> getAllClass(int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        return lopRepository.findAll(pageable);
    }

    @Override
    public Page<Lop> searchClass(String tuKhoa, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(DESC,"id"));
        return lopRepository.findByTenLopOrMaLop(tuKhoa, tuKhoa, pageable);
    }

    @Override
    public Lop createClass(Lop lop) {
        if(lopRepository.existsByTenLop(lop.getTenLop())){
            throw new ClassNotFoundAndException("Ten lop da ton tai");
        }
        else if(lopRepository.existsByMaLop(lop.getMaLop())){
            log.error("Ma lop da ton tai");
            throw new ClassNotFoundAndException("Ma lop da ton tai");
        }

        LocalDateTime currentTime = LocalDateTime.now(); // lấy thời gian hiện tại
        if (lop.getThoiGianBatDau().isBefore(currentTime) || lop.getThoiGianKetThuc().isBefore(currentTime)){
            log.error("Thoi gian truyen vao khong hop le.");
            throw new ClassNotFoundAndException("Thời gian bắt đầu phải ở tương lai và thời gian kết thúc phải ở hiện tại hoặc tương lai.");
        }
        return lopRepository.save(lop);
    }

    @Override
    public Lop updateLopById(Lop lop, Long id) {
        Lop lop1 = lopRepository.findLopById(id).orElseThrow(() -> new ClassNotFoundAndException("Lop co id = "+ id + " khong ton tai"));
        lop1.setTenLop(lop.getTenLop());
        lop1.setMaLop(lop.getMaLop());
        lop1.setMoTa(lop.getMoTa());
        lop1.setThoiGianBatDau(lop.getThoiGianBatDau());
        lop1.setThoiGianKetThuc(lop.getThoiGianKetThuc());
        lop1.setKyHocHienTai(lop.getKyHocHienTai());
        lop1.setSiSo(lop.getSiSo());

        return lopRepository.save(lop1);
    }


    @Override
    public void deleteLopByMaLop(String maLop) {
        if (maLop.equals("")|| maLop == null){
            throw new ClassNotFoundAndException("Ma lop khong ton tai");
        }
        lopRepository.deleteLopByMaLop(maLop);
    }


}
