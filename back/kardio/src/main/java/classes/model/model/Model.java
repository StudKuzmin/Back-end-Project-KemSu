package classes.model.model;

import classes.database.entity.EPatient;
import classes.database.entity.EUser;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {
    public List<String> toStringArray(Object entity) throws IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        int fieldCount = fields.length;
        Object[] objArr = new Object[fieldCount];

        for (int i = 0; i < objArr.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            objArr[i] = field.get(entity);
        }

        List<String> stringArray = new ArrayList<>();
        Arrays.stream(objArr).toList().forEach((Object i) -> {
            stringArray.add(String.valueOf(i));
        });

        return stringArray;
    }
}
