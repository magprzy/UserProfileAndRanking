import java.util.List;

import com.capgemini.userProfileAndRanking.dao.impl.UserProfileDaoImpl;
import com.capgemini.userProfileAndRanking.entities.User;

public class Main {

	public static void main(String[] args) {
		UserProfileDaoImpl userProfileDaoImpl = new UserProfileDaoImpl();
		userProfileDaoImpl.exampleUsers();

		List<User> users = userProfileDaoImpl.getByParameters(null, "Kowalski", null);
		
		System.out.println("Rozmiar listy: " + users.size());
		users.stream().forEach(i -> System.out.println(i.getFirstName() + " "+ i.getLastName() +" "
								+i.getPassword()  +" "+ i.getMotto()  +" "+ i.getEmail()));
		
	}

}
