package com.mvp.finances.infra.database.repository;

import com.mvp.finances.domain.dto.TransactionReportByCategory;
import com.mvp.finances.domain.dto.TransactionReportByDate;
import com.mvp.finances.domain.models.ReleaseType;
import com.mvp.finances.domain.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query(value =
            "SELECT "
                + "NEW com.mvp.finances.domain.dto.TransactionReportByCategory(sum(t.amount), c.title) "
                + "FROM Transaction t "
                + "JOIN t.category c "
                + "WHERE "
                + "t.releaseType = :releaseType "
                + "AND "
                + "YEAR(t.transactionDate) = :year "
                + "GROUP BY c.title")
    List<TransactionReportByCategory> reportByCategory(@Param("releaseType") ReleaseType releaseType, @Param("year") Integer year);

    @Query( value =
            "SELECT "
                    + "NEW com.mvp.finances.domain.dto.TransactionReportByDate(sum(t.amount), t.transactionDate) "
                    + "FROM Transaction t "
                    + "WHERE "
                    + "t.releaseType = :releaseType "
                    + "AND "
                    + "YEAR(t.transactionDate) = :year "
                    + "GROUP BY MONTH(t.transactionDate)")
    List<TransactionReportByDate> reportByYear(@Param("releaseType") ReleaseType releaseType, @Param("year") Integer year);
}
