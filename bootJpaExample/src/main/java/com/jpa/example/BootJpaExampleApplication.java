package com.jpa.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.jpa.example.dao.UserRepo;
import com.jpa.example.mdl.UserModel;

@SpringBootApplication
public class BootJpaExampleApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(BootJpaExampleApplication.class, args);
		UserRepo bean = context.getBean(UserRepo.class);

//----------------------------------------------------------------------//		
		// This is to save single obj

//		UserModel usermdl = new UserModel();
//		usermdl.setName("Ram");
//		usermdl.setCity("Ayodhya");
//		usermdl.setStatus("OK");
//
//		UserModel save = bean.save(usermdl);
//		System.out.println("From save method ==>>> " + save);

//----------------------------------------------------------------------//		

		// This is to save multiple obj

//		UserModel user1 = new UserModel();
//		user1.setName("Sita");
//		user1.setCity("Ayodhya");
//		user1.setStatus("good");
//
//		UserModel user2 = new UserModel();
//		user2.setName("Lakshman");
//		user2.setCity("Ayodhya");
//		user2.setStatus("better");
//
//		UserModel user3 = new UserModel();
//		user3.setName("satyam");
//		user3.setCity("Kanpur");
//		user3.setStatus("ok");
//
//		List<UserModel> allUsers = List.of(user1, user2, user3);
//		Iterable<UserModel> saveAll = bean.saveAll(allUsers);
//		
//		saveAll.forEach(UserModel -> {
//			System.out.println(UserModel);
//		});

//----------------------------------------------------------------------//			

		// This is to update single obj

//		Optional<UserModel> option = bean.findById(154);
//		UserModel userModel = option.get();
//
//		userModel.setName("Satyam Mishra");
//		userModel.setStatus("ok-best");
//
//		UserModel saveUpdate = bean.save(userModel);
//		System.out.println(saveUpdate);

//----------------------------------------------------------------------//

		// This is to fetch single and multiple obj data

		// #1
//		Optional<UserModel> findById = bean.findById(152);
//		UserModel userModel = findById.get();
//		System.out.println("Single obj data---> " + userModel);
//
//		// #2
//		Iterable<UserModel> findAll = bean.findAll();
//		Iterator<UserModel> iterator = findAll.iterator();
//
////		while (iterator.hasNext()) {
////			UserModel userMdl = iterator.next();
////			System.out.println("Multiple obj data---> " + userMdl);
////		}
//
//		findAll.forEach(UserModel -> {
//			System.out.println("Multiple obj data---> " + UserModel);
//		});

//----------------------------------------------------------------------//		

		// This is to delete single obj

//		bean.deleteById(154);
//		System.out.println("Deleted");

//----------------------------------------------------------------------//	

		// This is to find obj by custom methods

		List<UserModel> findByName = bean.findByName("Sita");
		findByName.forEach(e -> System.out.println(e));

		System.out.println("________________________________________________");

		List<UserModel> findByNameAndCity = bean.findByNameAndCity("Ram", "Ayodhya");
		findByNameAndCity.forEach(e -> System.out.println(e));

		System.out.println("________________________________________________");

		List<UserModel> getAllUser = bean.getAllUser();
		getAllUser.forEach(e -> System.out.println(e));

		System.out.println("________________________________________________");

//		List<UserModel> getAllUSerByNameAndCity = bean.getAllUSerByNameAndCity("Ram", "Ayodhya");
//		getAllUSerByNameAndCity.forEach(e -> System.out.println(e));

		System.out.println("________________________________________________");

		List<UserModel> getUsers = bean.getUsers();
		getUsers.forEach(e -> System.out.println(e));

		System.out.println("________________________________________________");

//----------------------------------------------------------------------//			

	}
}
