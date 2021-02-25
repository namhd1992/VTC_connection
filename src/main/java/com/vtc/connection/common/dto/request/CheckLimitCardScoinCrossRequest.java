/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Nov 28, 2019
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CheckLimitCardScoinCrossRequest {
    
    private long   accountid;

    private long   paymenttime;

}
