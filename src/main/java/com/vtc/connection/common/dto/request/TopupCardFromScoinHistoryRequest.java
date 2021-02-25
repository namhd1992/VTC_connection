/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Jul 16, 2019
 */
@Setter
@Getter
@NoArgsConstructor
public class TopupCardFromScoinHistoryRequest {
    
    private long   accountid;

    private String paymenttype;

    private long   paymenttime;

    private long   totalpayment;

    private long   billingtransid;

    private int    serviceid;

    private String sign;

}
