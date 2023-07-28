package scheduled;

import java.time.LocalTime;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledWork {
    
    @Scheduled(fixedRate = 5000)
    public void work() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        System.out.println("현재시간: " + hour + "시 " + minute + "분 " + second + "초");
    }
}
