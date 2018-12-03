package utils.interceptors.validators;

import entities.users.User;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import utils.annotations.Interceptor;

import java.io.Serializable;

@Interceptor(interceptedType = User.class)
public class UserInterceptor extends EmptyInterceptor {

    @Override
    public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("*** Loading the user ***");
        return super.onLoad(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("*** Saving the user ***");
        if (entity instanceof User) {
            User user = (User) entity;
            if (user.getAge() == null) {
                for (int i = 0; i < propertyNames.length; i++) {
                    if (propertyNames[i].equals("age")) {
                        state[i] = "6";
                    }
                }
            }
            if
               (       user.getName() == null
                    || user.getPassportKey() == null
                    || user.getName().isEmpty()
                    || user.getPassportKey().isEmpty()
               )
            {
                throw new IllegalArgumentException("Unexpected values of the user properties");
            }
            return true;
        }
        return super.onSave(entity, id, state, propertyNames, types);
    }

    @Override
    public void onDelete(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        System.out.println("*** Deleting the user ***");
        super.onDelete(entity, id, state, propertyNames, types);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }
}