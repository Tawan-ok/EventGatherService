package unit

import com.example.EventGather.model.entity.User
import com.example.EventGather.repository.UserRepository
import com.example.EventGather.service.implement.UserServiceImpl
import spock.lang.Specification

class UserServiceTest extends Specification {

    def userRepository = Mock(UserRepository)
    def userService = new UserServiceImpl(
            userRepository
    )

    def "Should save user successfully"() {
        given:

        User user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("securepassword")
                .build()

        when: "saving the user"
        def created =  userService.createUser(user)

        then: "the user is saved successfully"
        1 * userRepository.save(user) >> user
        created == user

    }
    def "Should get a user successfully id = #id and name = #name"(){
        given :
        User user = User.builder()
                 .id(id)
                .name(name)
                .email("john.doe@example.com")
                .password("securepassword")
                .build()

        when:
        def created = userService.getUserById(id)

        then:
        1 * userRepository.findById(id) >> Optional.of(user)
        verifyAll(created) {
            it.id == id
            it.name == name
        }

        where:
        id | name
        "1" | "John"
        "2" | "Doe"
        "3" | "Jack"
    }

//    def"Should get all users successfully"(){
//        given:
//        List<User> users = new ArrayList();
//        User user1 = User.builder()
//                     .id(id)
//                     .name(name)
//                     .email(email)
//                     .password(password)
//                     .build()
//         User user2 = User.builder()
//                     .id(id)
//                     .name(name)
//                     .email(email)
//                     .password(password)
//                     .build()
//
//        users.add(user1)
//        users.add(user2)
//
//        when:
//
//        def getAllUsers = userService.getAllUsers();
//
//        then:
//
//        verifyAll {} (getAllUsers){
//            it.id in ["1","2"]
//        }
//
//
//
//        where:
//        id | name | email | password
//        "1" | "John" | "test01@hotmail.com" | "12345"
//        "2" | "Doe" | "test02@hotmail.com" | "12345"
//
//    }



}
