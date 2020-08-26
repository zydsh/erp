package hrm.hr.types;


import io.ciera.runtime.summit.exceptions.XtumlException;
import io.ciera.runtime.summit.types.IXtumlType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public enum PayslipItemType implements IXtumlType {

    UNINITIALIZED_ENUM( -1 ),
    DEDUCTION( 1 ),
    EARNING( 0 );

    private final int value;

    PayslipItemType() {
        value = -1;
    }

    PayslipItemType( int value ) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equality( IXtumlType value ) throws XtumlException {
        if (value instanceof PayslipItemType) {
            return null != value && this.value == ((PayslipItemType)value).getValue();
        }
        else return false;
    }

    @Override
    public String serialize() {
        return Integer.toString(value);
    }

    public static PayslipItemType deserialize(Object o) throws XtumlException {
        if (o instanceof PayslipItemType) {
            return (PayslipItemType)o;
        }
        else if (o instanceof Integer) {
            return valueOf((int)o);
        }
        else if (o instanceof String) {
            try {
                return valueOf(Integer.parseInt((String)o));
            }
            catch (NumberFormatException e1) {
                Matcher m = Pattern.compile("([A-Za-z_]+)::([A-Za-z_]+)").matcher((String)o);
                if (m.matches() && "payslipitemtype".equals(m.group(1).toLowerCase())) {
                    try {
                        return Enum.valueOf(PayslipItemType.class, m.group(2).toUpperCase());
                    } catch (IllegalArgumentException e2) {/* do nothing */}
                }
            }
        }
        throw new XtumlException("Cannot deserialize value");
    }

    public static PayslipItemType valueOf(int value) {
        switch( value ) {
        case 1:
            return DEDUCTION;
        case 0:
            return EARNING;
        default:
            return UNINITIALIZED_ENUM;
        }
    }

}
