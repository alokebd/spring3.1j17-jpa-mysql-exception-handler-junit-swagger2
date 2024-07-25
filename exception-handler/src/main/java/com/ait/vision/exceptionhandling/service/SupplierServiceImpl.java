package com.ait.vision.exceptionhandling.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ait.vision.exceptionhandling.dto.SupplierInputDTO;
import com.ait.vision.exceptionhandling.dto.SupplierOutputDTO;
import com.ait.vision.exceptionhandling.entity.Supplier;
import com.ait.vision.exceptionhandling.exeption.ResourceNotFoundException;
import com.ait.vision.exceptionhandling.exeption.SupplierAlreadyExistsException;
import com.ait.vision.exceptionhandling.repository.SupplierRepository;
import com.ait.vision.exceptionhandling.utility.ErrorMessages;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public List<SupplierOutputDTO> getAllSuppliers(){
        return supplierRepository.findAll().stream().map(Supplier::viewAsOutputDto).toList();
    }

    public SupplierOutputDTO getSupplierById(Long id){
        return supplierRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(ErrorMessages.ERROR_SUPPLIER_NOT_FOUND + id)).viewAsOutputDto();
    }

    public SupplierOutputDTO createSupplier(SupplierInputDTO supplierDTO){
       if(supplierRepository.findByRegistrationNo(supplierDTO.getRegistrationNo()).isPresent()) {
           throw new SupplierAlreadyExistsException(ErrorMessages.ERROR_SUPPLIER_ALREADY_FOUND + supplierDTO.getRegistrationNo());
       }
        Supplier supplier = Supplier.builder().name(supplierDTO.getName()).address(supplierDTO.getAddress()).registrationNo(supplierDTO.getRegistrationNo()).build();
        return supplierRepository.save(supplier).viewAsOutputDto();
    }

    public SupplierOutputDTO updateSupplier(long id, SupplierInputDTO supplierDTO){
        SupplierOutputDTO existingSupplier = getSupplierById(id);
        Supplier supplier = Supplier.builder().name(supplierDTO.getName()).address(supplierDTO.getAddress()).registrationNo(supplierDTO.getRegistrationNo()).id(existingSupplier.getId()).build();
        return supplierRepository.save(supplier).viewAsOutputDto();
    }

}
