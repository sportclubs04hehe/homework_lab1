package vegakinvietnam.com.lab1class.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vegakinvietnam.com.lab1class.model.KyNang;
import vegakinvietnam.com.lab1class.repo.KyNangRepository;
import vegakinvietnam.com.lab1class.service.KyNangService;

@Service
@Transactional
@RequiredArgsConstructor
public class KyNangServiceImpl implements KyNangService {
    @Autowired
    private final KyNangRepository kyNangRepository;
    @Override
    public KyNang createSkill(KyNang kyNang) {
        return kyNangRepository.save(kyNang);
    }
}
