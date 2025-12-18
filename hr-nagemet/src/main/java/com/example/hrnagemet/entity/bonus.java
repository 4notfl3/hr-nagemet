package com.example.hrnagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class bonus {
    private long id;
    private long empno;
    private BigDecimal comm;
    private LocalDate bonus_date;
}