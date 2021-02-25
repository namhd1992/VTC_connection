/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.exception;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Dec 13, 2019
 */
public class ConnectionScoinInvalidDataRequestException extends ScoinBusinessException {

    private static final long serialVersionUID = 1L;

    public ConnectionScoinInvalidDataRequestException() {
        super(-2, "Invalid data request");
    }

}
