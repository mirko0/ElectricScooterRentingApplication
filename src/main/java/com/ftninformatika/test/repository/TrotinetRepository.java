package com.ftninformatika.test.repository;

import com.ftninformatika.test.model.Trotinet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TrotinetRepository extends JpaRepository<Trotinet, Long> {

    @Query("SELECT t FROM Trotinet t WHERE " +
            "(:nivoBaterijeOd = NULL OR t.nivoBaterije >= :nivoBaterijeOd) AND " +
            "(:nivoBaterijeDo = NULL OR t.nivoBaterije <= :nivoBaterijeDo) AND " +
            "(:adresaId = NULL OR t.adresa.id = :adresaId)")
    Page<Trotinet> search(@Param("adresaId")Long adresaId,
                          @Param("nivoBaterijeOd") Integer nivoBaterijeOd,
                          @Param("nivoBaterijeDo") Integer nivoBaterijeDo,
                          Pageable of);

}
