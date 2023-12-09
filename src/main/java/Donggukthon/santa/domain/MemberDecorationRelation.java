package Donggukthon.santa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_decoration_relation")
public class MemberDecorationRelation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private Long member_id;
        private Long decoration_id;
        private LocalDateTime createdAt;

        @ManyToOne
        @JoinColumn(name = "member_id", insertable = false, updatable = false)
        private Member memberId;

        @ManyToOne
        @JoinColumn(name = "decoration_id", insertable = false, updatable = false)
        private Member memberDecoration;

}
