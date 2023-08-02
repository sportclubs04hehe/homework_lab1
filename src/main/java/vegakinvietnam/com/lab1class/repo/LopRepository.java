package vegakinvietnam.com.lab1class.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vegakinvietnam.com.lab1class.model.Lop;

import java.util.Optional;

public interface LopRepository extends JpaRepository<Lop, Long> {
    Page<Lop> findByTenLopOrMaLop(String tenLop, String maLop, Pageable pageable);
    void deleteLopByMaLop(String maLop);
    boolean existsByMaLop(String maLop);
    boolean existsByTenLop(String tenLop);
    Optional<Lop> findLopById(Long id);
}
