package enums;

import constants.Constants;
import model.dataType.CustomInteger;
import model.dataType.CustomString;

public enum CustomType {
    CUSTOM_INTEGER(Constants.CUSTOM_INTEGER, new CustomInteger(), Integer.class.getCanonicalName()),
    CUSTOM_STRING(Constants.CUSTOM_STRING, new CustomString(), String.class.getCanonicalName());

    private final String typeName;
    private final Object dataType;
    private final String rawClassName;

    CustomType(String typeName, Object dataType, String rawClassName) {
        this.typeName = typeName;
        this.dataType = dataType;
        this.rawClassName = rawClassName;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getRawClassName() {
        return rawClassName;
    }

    public Object getDataType() {
        return dataType;
    }
}
