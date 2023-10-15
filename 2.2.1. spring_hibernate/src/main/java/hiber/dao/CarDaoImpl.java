package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> getUserByCar(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User where car.model=:model and car.series=:series");
        return query.setParameter("model", model).setParameter("series", series).getResultList();
    }
}
