package com.ait.vision.exceptionhandling.service;

import java.util.List;

import com.ait.vision.exceptionhandling.dto.SupplierInputDTO;
import com.ait.vision.exceptionhandling.dto.SupplierOutputDTO;

public interface SupplierService {

    public List<SupplierOutputDTO> getAllSuppliers();
    public SupplierOutputDTO getSupplierById(Long id);
    public SupplierOutputDTO createSupplier(SupplierInputDTO supplierDTO);
    public SupplierOutputDTO updateSupplier(long id, SupplierInputDTO supplierDTO);



}
