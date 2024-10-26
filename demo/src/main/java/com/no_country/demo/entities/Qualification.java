package com.no_country.demo.entities;

import com.no_country.demo.entities.enums.QualificationNote;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_student", nullable = false)
    private Student student; // Relación con el estudiante

    @ManyToOne
    @JoinColumn(name = "id_evaluation", nullable = false)
    private Evaluation evaluation; // Relación con la evaluación

    @Enumerated(EnumType.STRING)
    private QualificationNote note; // Nota del estudiante

    private String comentario; // Comentario adicional
}
