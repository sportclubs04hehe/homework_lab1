package vegakinvietnam.com.lab1class.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ky_nang")
public class KyNang {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotBlank(message = "Mã kỹ năng không được để trống")
    @Size(max = 20, message = "Mã kỹ năng không vượt quá 20 ký tự")
    private String maKyNang;

    @NotBlank(message = "Tên kỹ năng không được để trống")
    @Size(max = 255, message = "Tên kỹ năng không vượt quá 255 ký tự")
    private String tenKyNang;

    private String moTa;

    @ManyToMany(mappedBy = "kyNangs")
    private Set<HocSinh> hocSinhs = new HashSet<>();

    public KyNang(String maKyNang, String tenKyNang, String moTa) {
        this.maKyNang = maKyNang;
        this.tenKyNang = tenKyNang;
        this.moTa = moTa;
    }
}
