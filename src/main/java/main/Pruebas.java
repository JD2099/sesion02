package main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.TbUsuario;

public class Pruebas {

	public static void main(String[] args) {
		System.out.println("JPA_CRUD");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_clase01x");
		EntityManager em = fabrica.createEntityManager();
		
		List<TbUsuario> lstUsuarios = em.createQuery("Select a From TbUsuario a", TbUsuario.class).getResultList();
		//Cantidad de Usuarios
		System.out.println("---------------------------------------------------");
		System.out.println("Número de Usuarios: "+lstUsuarios.size());
		
		//Listar cada Usuario
		System.out.println("---------------------------------------------------");
		System.out.println("Lista de Usuarios");
		for(TbUsuario u: lstUsuarios){
			System.out.println("Usuario: "+u.getNomUsua()+ " " + u.getApeUsua()+ " "+ u.getClaUsua());
		}
		
		//Busqueda de Usuario id=2
		System.out.println("---------------------------------------------------");
		System.out.println("Usuario con id=2");
		TbUsuario us = em.find(TbUsuario.class, 2);
		System.out.println(us.getCodUsua());
		System.out.println(us.getNomUsua());
		System.out.println(us.getApeUsua());

	}
}
