/***************************************************************************
 * Product made by Quang Dat *
 **************************************************************************/
package com.vtc.connection.common.exception;

import com.vtc.connection.common.constant.ExceptionConstant;

/**
 * Author : Dat Le Quang
 * Email: Quangdat0993@gmail.com
 * May 16, 2019
 */
public class ScoinNotEnoughtException extends ScoinBusinessException {
    
    private static final long serialVersionUID = -6502596312985405760L;

    public ScoinNotEnoughtException() {
        super(ExceptionConstant.NOT_ENOUGHT, ExceptionConstant.NOT_ENOUGHT_DESCRIPTION);
    }
    
    public ScoinNotEnoughtException(String message) {
        super(ExceptionConstant.NOT_ENOUGHT, message);
    }
    
    public ScoinNotEnoughtException(Object data, String message) {
        super(ExceptionConstant.NOT_ENOUGHT, data, message);
    }

}
