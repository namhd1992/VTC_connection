/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.exception;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Dec 13, 2019
 */
public class ConnectionScoinNotEnoughtException extends ScoinBusinessException{

    private static final long serialVersionUID = 1L;
    
    public ConnectionScoinNotEnoughtException(String errorDesc) {
        super(-5,errorDesc);
    }

}
