package utils.interceptors.validators;

import entities.users.PremiumUser;
import entities.users.User;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import utils.annotations.Interceptor;

import java.io.Serializable;

@Interceptor(interceptedType = PremiumUser.class)
public class PremiumUserInterceptor extends UserInterceptor {

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
        if (super.onSave(entity, id, state, propertyNames, types)) {
            if (entity instanceof PremiumUser) {
                PremiumUser user = (PremiumUser) entity;
                if (user.getCreditCard() == null || user.getCreditCard().isEmpty())
                {
                    throw new IllegalArgumentException("Unexpected values of the user properties");
                }
                return true;
            }
        }
        return false;
    }
}
