package br.edu.unisep.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static SessionFactory sessionFactory;

	/*
	 * Código definido no bloco de inicialização estatico será executado apenas
	 * uma única vez, na primeira utilização da classe DespesaDAO
	 */
	static {

		Configuration config = new Configuration();
		/*
		 * Carrega as configurações definidade no arquivo hibernate.cfg.xml,
		 * aplicando-as ao objeto configuration
		 */
		config.configure();

		StandardServiceRegistryBuilder srb = new StandardServiceRegistryBuilder();
		srb.applySettings(config.getProperties());

		StandardServiceRegistry reg = srb.build();

		/*
		 * Cria o objeto SessionFActory, que será responsavel por gerar objetos
		 * Session, que serão utilizados para comunicação com o banco de dados.
		 */
		sessionFactory = config.buildSessionFactory(reg);
	}

	/*
	 * Método responsável por retornar uma sessão de comunicação com o bd
	 */
	public static Session getSession() {
		return sessionFactory.openSession();
	}

}
