package edu.umss.storeservice.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umss.storeservice.model.ModelBase;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.*;

@Repository
public abstract class StoredProcedureRepositoryImpl<T extends ModelBase> {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<T> findAll(){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);

        StoredProcedureQuery querySP = entityManager.createNamedStoredProcedureQuery("GetAll"+typeName);
        querySP.execute();

        return (List<T>) querySP.getResultList();
    }

    @Transactional
    public T findById(Long id){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);

        StoredProcedureQuery  querySP = entityManager.createNamedStoredProcedureQuery("Get"+typeName+"ById");
        querySP.setParameter("id", id);

        querySP.execute();

        return (T) querySP.getSingleResult();
    }

    @Transactional
    public Boolean deleteById(Long id){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);

        StoredProcedureQuery  querySP = entityManager.createNamedStoredProcedureQuery("Delete"+typeName+"ById");
        querySP.setParameter("id", id);

        querySP.execute();

        return (Boolean) querySP.getOutputParameterValue("result");
    }

    @Transactional
    public boolean save(T modelData){
        String typeName = (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
        typeName = typeName.substring(typeName.lastIndexOf('.') + 1);
        StoredProcedureQuery  querySP = entityManager.createNamedStoredProcedureQuery("Save"+typeName);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> objectAsMap = objectMapper.convertValue(modelData, Map.class);

        for (Field field : modelData.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if( !field.getName().equals("id") && !field.getName().equals("updatedAt")) {
                if (field.getType() == Boolean.class){
                    querySP.setParameter(field.getName(), ( objectAsMap.getOrDefault(field.getName(), 0).equals(false) ? 0 : 1) );
                } else {
                    querySP.setParameter(field.getName(), objectAsMap.getOrDefault(field.getName(), 0));
                }
            }
        }
        querySP.setParameter("createdAt", new Date());
        querySP.setParameter("version", 0);

        querySP.execute();

        return true;
    }

}
