/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.exception;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Dec 13, 2019
 */
public class ConnectionScoinDuplicateEntityException extends ScoinBusinessException {

    private static final long serialVersionUID = 1L;
    
    public ConnectionScoinDuplicateEntityException(String errorDesc) {
        super(-4, errorDesc);
    }

}
