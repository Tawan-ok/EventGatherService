package integration

import org.testcontainers.containers.MongoDBContainer
import spock.lang.Specification
import com.example.EventGather.repository.UserRepository
import com.example.EventGather.service.implement.UserServiceImpl
import com.example.EventGather.model.entity.User

class UserServiceIT extends Specification {

    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0.6")

    UserRepository userRepository
    UserServiceImpl userService

    def setupSpec() {
        mongoDBContainer.start()
        System.setProperty("spring.data.mongodb.uri", mongoDBContainer.getReplicaSetUrl())
    }

    def setup() {
        userRepository = Mock(UserRepository)
        userService = new UserServiceImpl(userRepository)
    }

    def cleanupSpec() {
        mongoDBContainer.stop()
    }

    def "Should save user to MongoDB"() {
        given:
        User user = User.builder()
                .name("Spock User")
                .email("spock@example.com")
                .password("password123")
                .build()

        when:
        userService.createUser(user)

        then:
        1 * userRepository.save(user) >> user
    }
}
