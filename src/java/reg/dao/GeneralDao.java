/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reg.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import reg.domain.User;
import reg.utils.HibernateUtil;

/**
 *
 * @author duncan
 * @param <K>
 */
public class GeneralDao<K> {
     Session session =null;
    private final Class<K> type;

    public GeneralDao(Class<K> type) {
        this.type = type;
    }
    
    public Session createSession(){
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }
    public void closeSession(){
        session.getTransaction().commit();
        session.close();
    }
    
    
    public K save(K obj){
       K res = (K) createSession().save(obj);
        closeSession();
        return res;
    }
    
    public void update(K obj){
        createSession().update(obj);
        closeSession();
    }
    public void delete(K obj){
        createSession().delete(obj);
        closeSession();
    }
    public K  findById(Serializable id){
        K obj = (K) createSession().get(type, id);
        closeSession();
        return obj;
    }
    public K findByName(String name){
        K item = (K) createSession().get(type.getName(), name);
     return item;
    }
    public List<K>  findAll(){
        List<K> obj = createSession().createCriteria(type.getName()).list();
        closeSession();
        return obj;
    }
}
