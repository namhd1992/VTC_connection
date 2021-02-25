/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.dto.response;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Dec 13, 2019
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionScoinResponse<T> implements Serializable {
    
    private static final long serialVersionUID = -6669686067446636607L;

    protected int             errorCode;

    protected String          errorDesc;

    protected T               data;

}
