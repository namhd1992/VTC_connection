/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vtc.connection.common.dao.entity.TopupCardHistory;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 16, 2019
 */
@Repository
public interface TopupCardHistoryRepository extends JpaRepository<TopupCardHistory, Long> {
    
    List<TopupCardHistory> findByCreateOnAfter(Date date);
    
    @Query(value = "SELECT sum(totalPayment) FROM TopupCardHistory WHERE scoinId = ?1")
    Long sumCardValueByScoinId(Long scoinId);
    
    List<TopupCardHistory> findByLuckyWheelUsedIsFalseAndScoinIdAndPaymentTypeAndPaymentTimeBetween(Long scoinId,
                                                                                                   String paymentType,
                                                                                                   Date startDate,
                                                                                                   Date endDate);
    
    List<TopupCardHistory> findByLuckyWheelUsedIsFalseAndScoinIdAndPaymentTimeBetween(Long scoinId,
                                                                                     Date startDate,
                                                                                     Date endDate);

    TopupCardHistory findByBillingTransId(long scoinTransId);
    
    List<TopupCardHistory> findByScoinIdAndPaymentTypeAndPaymentTimeBetween(Long scoinId,
                                                                                     String cardType,
                                                                                     Date startDate,
                                                                                     Date endDate);
    
    List<TopupCardHistory> findByScoinIdAndPaymentType(Long scoinId, String cardType);
    
}
