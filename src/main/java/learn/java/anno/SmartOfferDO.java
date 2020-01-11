package learn.java.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vigo on 2019/5/20.
 */
public class SmartOfferDO {
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SmartOfferColumn {
        String name();
        Class<?> clsType() default Object.class;
    }

    @SmartOfferColumn(name="scene_id")
    private String sceneId;

    @SmartOfferColumn(name="offer_id", clsType = Long.class)
    private Long offerId;

    public static Map<String, SmartOfferColumn> getColumnMap(){
        Map<String, SmartOfferColumn> map = new HashMap<String, SmartOfferColumn>();
        Field[] fs = SmartOfferDO.class.getDeclaredFields();
        for (Field f : fs){
            if (f.isAnnotationPresent(SmartOfferColumn.class)){
                SmartOfferColumn col = f.getAnnotation(SmartOfferColumn.class);
                map.put(col.name(), col);
            }
        }
        return map;
    }
}

// 使用样例
/*
protected SmartOfferDO convertToSmartOffer(Row r) {
    SmartOfferDO offer = new SmartOfferDO();
    Map<String, SmartOfferColumn> colMap = SmartOfferDO.getColumnMap();
    for (Map.Entry<String, SmartOfferColumn> entry : colMap.entrySet()){
        SmartOfferColumn soc = entry.getValue();
        ColumnValue value = r.getColumnValue(soc.name);
        Object valueObj = value.getValueObject();
        if (!soc.clsType().equals(Object.class)){
            if (soc.clsType().equals(Long.class)){
                valueObj = Long.parseLong(String.valueOf(valueObj));
            }else if (soc.clsType().equals(Integer.class)){
                valueObj = Integer.parseInt(String.valueOf(valueObj));
            }
        }
    }
    return offer;
} **/

