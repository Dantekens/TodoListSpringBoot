package com.example.start;
import java.time.LocalDate;

public record Book( Long Id,
                    String ISBN,
                   String Autor,
                   String Title,
                   LocalDate age,
                   BookStatus status) {
}
