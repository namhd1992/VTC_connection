/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.service;

import com.vtc.connection.common.dto.request.CheckLimitCardScoinCrossRequest;
import com.vtc.connection.common.dto.request.TopupCardFromScoinHistoryRequest;
import com.vtc.connection.common.dto.response.CheckLimitCardScoinCrossResponse;
import com.vtc.connection.common.dto.response.TopupCardFromScoinHistoryResponse;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Aug 28, 2019
 */
public interface CardScoinService {
    
    public TopupCardFromScoinHistoryResponse saveTopupCardFromScoinHistory(TopupCardFromScoinHistoryRequest request);

    public CheckLimitCardScoinCrossResponse checkLimitTopupCardScoinCross(CheckLimitCardScoinCrossRequest request);

}
