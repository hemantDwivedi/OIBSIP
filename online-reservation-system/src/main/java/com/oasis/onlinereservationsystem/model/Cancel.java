package com.oasis.onlinereservationsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cancel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cancel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String pnrNumber;
}
