package com.example.hrnagemet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class salgrade {
    private long grade;
    private BigDecimal losal;
    private BigDecimal hisal;

}

