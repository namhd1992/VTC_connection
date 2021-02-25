/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import com.vtc.connection.common.constant.Constant;
import com.vtc.connection.common.dao.entity.TopupCardHistory;
import com.vtc.connection.common.dao.repository.LuckySpinRepository;
import com.vtc.connection.common.dao.repository.LuckySpinSettingRepository;
import com.vtc.connection.common.dao.repository.TopupCardHistoryRepository;
import com.vtc.connection.common.dto.request.CheckLimitCardScoinCrossRequest;
import com.vtc.connection.common.dto.request.TopupCardFromScoinHistoryRequest;
import com.vtc.connection.common.dto.response.CheckLimitCardScoinCrossResponse;
import com.vtc.connection.common.dto.response.TopupCardFromScoinHistoryResponse;
import com.vtc.connection.common.exception.ConnectionScoinDuplicateEntityException;
import com.vtc.connection.common.exception.ConnectionScoinInvalidDataRequestException;
import com.vtc.connection.common.exception.ConnectionScoinUnAuthorizationException;
import com.vtc.connection.common.utils.DateUtils;
import com.vtc.connection.common.utils.StringUtils;
import com.vtc.connection.service.CardScoinService;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Aug 28, 2019
 */
@Service("cardScoinService")
public class CardScoinServiceImpl implements CardScoinService{
  
    protected Logger             LOGGER = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    TopupCardHistoryRepository topupCardHistoryRepo;
    
//    @Autowired
//    CommonUserInfoService userInfoService;
    
    @Autowired
    LuckySpinSettingRepository luckySpinSettingRepo;
    
    @Autowired
    LuckySpinRepository luckySpinRepo;

    @Override
    public TopupCardFromScoinHistoryResponse saveTopupCardFromScoinHistory(TopupCardFromScoinHistoryRequest request) {
        if (ObjectUtils.isEmpty(request)
                || request.getAccountid() < 1
                || request.getBillingtransid() < 1
                || request.getServiceid() < 1
                || StringUtils.isEmpty(request.getSign())) {
            throw new ConnectionScoinInvalidDataRequestException();
        }
        
        String dataSign = StringUtils.toMD5(Constant.SCOIN_PAYMENT_LIVE_PAYMENT_HISTORY_SECURE_SECRET
                    + String.valueOf(request.getAccountid())
                    + String.valueOf(request.getBillingtransid())
                    + String.valueOf(request.getTotalpayment()));
        if (!request.getSign().equals(dataSign.toUpperCase())) {
            throw new ConnectionScoinUnAuthorizationException();
        } 
        
        TopupCardHistory historyByTransId = topupCardHistoryRepo.findByBillingTransId(request.getBillingtransid());
        if (!ObjectUtils.isEmpty(historyByTransId)) 
            throw new ConnectionScoinDuplicateEntityException("Duplicate Payment!!");
        
//        UserInfo userInfo = userInfoService.getByScoinId(request.getAccountid());
        
        TopupCardHistory topupCardHistory = new TopupCardHistory();
        topupCardHistory.setScoinId(request.getAccountid());
        topupCardHistory.setPaymentTime(new Date(request.getPaymenttime() * 1000));
        topupCardHistory.setTotalPayment(request.getTotalpayment());
        topupCardHistory.setBillingTransId(request.getBillingtransid());
        topupCardHistory.setPaymentType(request.getPaymenttype());
        topupCardHistory.setServiceId(request.getServiceid());
        
//        if (!ObjectUtils.isEmpty(userInfo)) topupCardHistory.setUserInfo(userInfo);
        
        topupCardHistory.setLuckyWheelUsed(false);
        topupCardHistory = topupCardHistoryRepo.save(topupCardHistory);
        
        // Set response
        TopupCardFromScoinHistoryResponse response = new TopupCardFromScoinHistoryResponse();
        response.setScoinId(topupCardHistory.getScoinId());
        response.setBillingTransid(topupCardHistory.getBillingTransId());
        response.setPaymentTime(topupCardHistory.getPaymentTime().getTime());
        response.setTotalPayment(topupCardHistory.getTotalPayment());
        
        //get luckyspin
//        Pageable pageable = PageRequest.of(0, 1);
//        List<LuckySpin> luckySpins = luckySpinRepo.findByType(Constant.LUCKYSPIN_TYPE_VONG_QUAY, pageable);
//        if (CollectionUtils.isEmpty(luckySpins)) throw new ScoinNotFoundEntityException();
//        LuckySpin luckySpin = luckySpins.get(0);
        
        //update total turnover of luckySpin
//        Date startDate = DateUtils.startDate(luckySpin.getStartDate());
//        Date endDate = DateUtils.endDate(luckySpin.getEndDate());
//        
//        LuckySpinSetting luckySpinSetting = new LuckySpinSetting();
//        luckySpinSetting = luckySpinSettingRepo.
//                findByLuckySpinAndKeyNameAndStatus(luckySpin, Constant.LUCKYSPIN_TURNOVER_KEYNAME_TOTAL, Constant.STATUS_ACTIVE);
//        if (ObjectUtils.isEmpty(luckySpinSetting)) {
//            luckySpinSetting = new LuckySpinSetting();
//            luckySpinSetting.setName("Total Turnover");
//            luckySpinSetting.setKeyName(Constant.LUCKYSPIN_TURNOVER_KEYNAME_TOTAL);
//            luckySpinSetting.setLuckySpin(luckySpin);
//            luckySpinSetting.setStatus(Constant.STATUS_ACTIVE);
//            luckySpinSetting.setType("luckyspin_turnover");
//        }
//        
//        long totalTurnover = topupCardHistoryRepo.
//                sumTotalPaymentByDateLuckySpin(startDate, endDate);
//        
//        luckySpinSetting.setIntValue(totalTurnover);
//        luckySpinSettingRepo.save(luckySpinSetting);
        
        return response;
    }

    @Override
    public CheckLimitCardScoinCrossResponse checkLimitTopupCardScoinCross(CheckLimitCardScoinCrossRequest request) {
      
        if (ObjectUtils.isEmpty(request)
                || request.getAccountid() < 1
                ) {
            throw new ConnectionScoinInvalidDataRequestException();
        }
        
        Date startDay = DateUtils.startDate(new Date(request.getPaymenttime() * 1000));
        Date endDay = DateUtils.endDate(new Date(request.getPaymenttime() * 1000));
        long totalTopupCardScoinScross = 0;
        
        List<TopupCardHistory> topupCardHistories = topupCardHistoryRepo.
                findByScoinIdAndPaymentTypeAndPaymentTimeBetween(request.getAccountid(), 
                        Constant.SCOIN_PAYMENT_TYPE_CARD_SCOIN_CROSS, startDay, endDay);
        if (CollectionUtils.isEmpty(topupCardHistories)) {
            return new CheckLimitCardScoinCrossResponse(request.getAccountid(), 100000);
        }
        
        for (TopupCardHistory topupCardHistory : topupCardHistories) {
            totalTopupCardScoinScross += topupCardHistory.getTotalPayment();
        }
        
        long limitedPayment = 100000 - totalTopupCardScoinScross;
        if (limitedPayment < 0)
            limitedPayment = 0;
        
        return new CheckLimitCardScoinCrossResponse(request.getAccountid(), limitedPayment);
    }

}
