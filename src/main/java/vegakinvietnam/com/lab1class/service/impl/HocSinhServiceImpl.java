package vegakinvietnam.com.lab1class.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vegakinvietnam.com.lab1class.model.HocSinh;
import vegakinvietnam.com.lab1class.repo.HocSinhRepository;
import vegakinvietnam.com.lab1class.service.HocSinhService;

@Service
@Transactional
@RequiredArgsConstructor
public class HocSinhServiceImpl implements HocSinhService {
    @Autowired
    private final HocSinhRepository hocSinhRepository;
    @Override
    public HocSinh createStudent(HocSinh hocSinh) {
        HocSinh hocSinh1 = hocSinhRepository.save(hocSinh);
        return hocSinh1;
    }
}
