package vegakinvietnam.com.lab1class.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "hoc_sinh")
public class HocSinh {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "Mã học sinh không được để trống")
    @Size(max = 20, message = "Mã học sinh không vượt quá 20 ký tự")
    private String maHocSinh;
    @NotBlank(message = "Tên học sinh không được để trống")
    @Size(max = 100, message = "Tên học sinh không vượt quá 100 ký tự")
    private String ten;

    @NotNull(message = "Ngày sinh không được để trống")
    private LocalDate ngaySinh;
    @NotBlank(message = "Giới tính không được để trống")
    @Size(max = 10, message = "Giới tính không vượt quá 10 ký tự")
    private String gioiTinh;
    private String diaChi;
    private String soDienThoai;

    @ManyToMany
    @JoinTable(
            name = "hoc_sinh_ky_nang",
            joinColumns = @JoinColumn(name = "hoc_sinh_id"),
            inverseJoinColumns = @JoinColumn(name = "ky_nang_id")
    )
    private Set<KyNang> kyNangs = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "lop_id")
    private Lop lop;

    public HocSinh(String maHocSinh, String ten, LocalDate ngaySinh, String gioiTinh, String diaChi, String soDienThoai) {
        this.maHocSinh = maHocSinh;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

}
