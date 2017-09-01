package com.loserbird.spring_hibernate_jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.loserbird.spring_hibernate_jpa.entity.Person;

@Repository
public class PersonDao {
		//如何获取到和当前事务关联的 EntityManager 对象呢 ?
		//通过 @PersistenceContext 注解来标记成员变量!
		@PersistenceContext
		private EntityManager entityManager;
		
		public void save(Person person){
			entityManager.persist(person);
		}
}
