/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vtc.connection.common.AbstractController;
import com.vtc.connection.common.dto.request.CheckLimitCardScoinCrossRequest;
import com.vtc.connection.common.dto.request.TopupCardFromScoinHistoryRequest;
import com.vtc.connection.common.utils.JsonMapperUtils;
import com.vtc.connection.service.CardScoinService;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Aug 28, 2019
 */
@RestController
@RequestMapping("/scoin")
public class CardScoinController extends AbstractController<CardScoinService> {
    
    @PostMapping("/topup-card-history")
    public ResponseEntity<?> saveTopupCardHistory(@Valid TopupCardFromScoinHistoryRequest request) {
      LOGGER.info("===============REQUEST============== \n {}",
          JsonMapperUtils.toJson(request));
        return ConnectionScoinResponse(toConnectionScoinResult(service.saveTopupCardFromScoinHistory(request)));
    }
    
    @PostMapping("/limited-cross-card")
    public ResponseEntity<?> checkLimitTopupCardScoinCross(@Valid CheckLimitCardScoinCrossRequest request) {
      LOGGER.info("===============REQUEST============== \n {}",
          JsonMapperUtils.toJson(request));
        return ConnectionScoinResponse(toConnectionScoinResult(service.checkLimitTopupCardScoinCross(request)));
    }

}
