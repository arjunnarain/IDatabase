package enums;

import constants.Constants;
import model.dataType.CustomInteger;
import model.dataType.CustomString;

public enum CustomType {
    CUSTOM_INTEGER(Constants.CUSTOM_INTEGER, new CustomInteger()),
    CUSTOM_STRING(Constants.CUSTOM_STRING, new CustomString());

    private final String typeName;
    private final Object dataType;

    CustomType(String typeName, Object dataType) {
        this.typeName = typeName;
        this.dataType = dataType;
    }

    public String getTypeName() {
        return typeName;
    }

    public Object getDataType() {
        return dataType;
    }
}
