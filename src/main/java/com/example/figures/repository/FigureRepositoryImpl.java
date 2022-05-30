package com.example.figures.repository;

import com.example.figures.entity.Circle;
import com.example.figures.entity.Rectangle;
import com.example.figures.model.Color;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;

@Repository
@Transactional
public class FigureRepositoryImpl implements FigureRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void init() {
        BigInteger u = (BigInteger) entityManager.createNativeQuery("SELECT count(*) FROM information_schema.tables\n" +
                "WHERE table_name = 'circle' Limit 1"
        ).getSingleResult();

        if (u.intValue() == 0) {
            entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS figure.circle ( id serial , color varchar(255) not null,  radius integer, primary key (id))")
                    .executeUpdate();
            entityManager.createNativeQuery("CREATE TABLE IF NOT EXISTS figure.rectangle ( id serial , color varchar(255) not null,  first_side integer, second_side integer, primary key (id))")
                    .executeUpdate();
            entityManager.createNativeQuery("INSERT INTO figure.circle(\n" +
                    "\t color, radius)\n" +
                    "\tVALUES ('red', 2),('white', 1),('blue', 3);").executeUpdate();
            entityManager.createNativeQuery("INSERT INTO figure.rectangle(\n" +
                    "\tcolor, first_side, second_side)\n" +
                    "\tVALUES ('white', 1, 2),('black', 2, 2),('red', 3, 2),('yellow', 1, 3);").executeUpdate();
        }
    }

    @Override
    public List<Circle> getAllCircles() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Circle> criteriaQuery = criteriaBuilder.createQuery(Circle.class);
        Root<Circle> circleRoot = criteriaQuery.from(Circle.class);
        criteriaQuery.select(circleRoot);
        TypedQuery<Circle> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Rectangle> getAllRectangles() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rectangle> criteriaQuery = criteriaBuilder.createQuery(Rectangle.class);
        Root<Rectangle> rectangleRoot = criteriaQuery.from(Rectangle.class);
        criteriaQuery.select(rectangleRoot);
        TypedQuery<Rectangle> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Circle> getAllCirclesByColor(Color color) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Circle> criteriaQuery = criteriaBuilder.createQuery(Circle.class);
        Root<Circle> circleRoot = criteriaQuery.from(Circle.class);
        Predicate predicateForUnused = criteriaBuilder.equal(circleRoot.get("color"), color.toString());
        criteriaQuery.where(predicateForUnused).select(circleRoot);
        TypedQuery<Circle> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public List<Rectangle> getAllRectanglesByColor(Color color) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Rectangle> criteriaQuery = criteriaBuilder.createQuery(Rectangle.class);
        Root<Rectangle> rectangleRoot = criteriaQuery.from(Rectangle.class);
        Predicate predicateForUnused = criteriaBuilder.equal(rectangleRoot.get("color"), color.toString());
        criteriaQuery.where(predicateForUnused).select(rectangleRoot);
        TypedQuery<Rectangle> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    @Override
    public void setCircles(List<Circle> circles) {
        for (Circle circle : circles) {
            entityManager.persist(circle);
        }
    }

    @Override
    public void setRectangles(List<Rectangle> rectangles) {
        for (Rectangle rectangle : rectangles) {
            entityManager.persist(rectangle);
        }
    }
}
