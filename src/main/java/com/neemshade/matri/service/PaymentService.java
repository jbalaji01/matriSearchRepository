package com.neemshade.matri.service;

import com.neemshade.matri.service.dto.PaymentDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.neemshade.matri.domain.Payment}.
 */
public interface PaymentService {

    /**
     * Save a payment.
     *
     * @param paymentDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentDTO save(PaymentDTO paymentDTO);

    /**
     * Get all the payments.
     *
     * @return the list of entities.
     */
    List<PaymentDTO> findAll();


    /**
     * Get the "id" payment.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentDTO> findOne(Long id);

    /**
     * Delete the "id" payment.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
