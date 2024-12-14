package unit

import com.example.EventGather.model.entity.Event
import com.example.EventGather.repository.EventRepository
import com.example.EventGather.service.implement.EventServiceImpl
import spock.lang.Specification

class EventServiceTest extends Specification{
    def eventRepository = Mock(EventRepository)
    def eventService = new EventServiceImpl(eventRepository)

    def"Should create event successfully"(){
        given :
        Event event = Event.builder()
                .id("1")
                .title("football")
                .description("find friend to play football together")
                .location("ladpao")
                .date("20/10/2024")
                .time("14.00 - 20.00")
                .organizerId("1")
                .participantIds(List.of("1","2"))
                .build()
        when:
        def created = eventService.createEvent(event)

        then:
        1 * eventRepository.save(event) >> event
        verifyAll (created){
            it.id == "1"
            it.title == "football"
            it.description == "find friend to play football together"
            it.location == "ladpao"
            it.date == "20/10/2024"
            it.time == "14.00 - 20.00"
            it.organizerId == "1"
        }

    }
}
