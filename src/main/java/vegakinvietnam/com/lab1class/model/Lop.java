package vegakinvietnam.com.lab1class.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;
import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "lop")
public class Lop {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "Tên lớp không được để trống")
    @Size(max = 100, message = "Tên lớp không vượt quá 100 ký tự")
    private String tenLop;


    @NotBlank(message = "Mã lớp không được để trống")
    @Size(max = 20, message = "Mã lớp không vượt quá 20 ký tự")
    private String maLop;

    private String moTa;


    @NotNull(message = "Thời gian bắt đầu không được để trống")
    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime thoiGianBatDau;

    @NotNull(message = "Thời gian kết thúc không được để trống")
    @DateTimeFormat(iso = DATE_TIME)
    private LocalDateTime thoiGianKetThuc;

    @NotBlank(message = "Kỳ học hiện tại không được để trống")
    @Size(max = 50, message = "Kỳ học hiện tại không vượt quá 50 ký tự")
    private String kyHocHienTai;

    @Min(value = 0, message = "Sĩ số phải lớn hơn hoặc bằng 0")
    private int siSo;

    @OneToMany(mappedBy = "lop")
    private Set<HocSinh> hocSinhs = new HashSet<>();

    public Lop(String tenLop, String maLop, String moTa, LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, String kyHocHienTai, int siSo) {
        this.tenLop = tenLop;
        this.maLop = maLop;
        this.moTa = moTa;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.kyHocHienTai = kyHocHienTai;
        this.siSo = siSo;
    }
}
