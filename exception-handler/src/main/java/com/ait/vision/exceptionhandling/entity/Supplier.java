package com.ait.vision.exceptionhandling.entity;

import com.ait.vision.exceptionhandling.dto.SupplierOutputDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "suppliers")
@Getter
@NoArgsConstructor
@SuperBuilder
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Supplier name is required")
    @Size(min = 4, max = 30, message = "Invalid Name: Must be of 4 - 30 characters")
    private String name;

    @NotNull(message = "Address is required")
    private String address;
    
    
    @Min(1)
    @Max(Integer.MAX_VALUE)
   // @NotNull(message = "registrationNo must be between 0 and Integer.MAX_VALUE")
    private int registrationNo;

    public SupplierOutputDTO viewAsOutputDto(){
        return new SupplierOutputDTO(id, name, address, registrationNo);
    }
}
