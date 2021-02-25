/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.exception;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * Dec 13, 2019
 */
public class ConnectionScoinUnAuthorizationException extends ScoinBusinessException {

    private static final long serialVersionUID = 1L;
    
    public ConnectionScoinUnAuthorizationException() {
        super(-6, "Only the scoin can call this api");
    }

}
