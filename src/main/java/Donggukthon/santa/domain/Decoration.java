package Donggukthon.santa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "decoration")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Decoration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String file;  // BLOB 타입은 byte 배열로 처리
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "decoration")
    private List<Submission> submissions;
}
