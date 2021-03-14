package com.mramirez.avatarproject.repository;


import com.mramirez.avatarproject.domain.Producto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    @Override
    Optional<Producto> findById(Integer id);

    Optional<Producto> findByPartNumber(String partNumber);

    boolean existsByPartNumber(String partNumber);

}
