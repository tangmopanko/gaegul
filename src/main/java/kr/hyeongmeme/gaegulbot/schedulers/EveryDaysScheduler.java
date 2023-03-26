package kr.hyeongmeme.gaegulbot.schedulers;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
public class EveryDaysScheduler {

    @Async
    @Scheduled(cron="0/60 * * * * ?")
    public void echo() {
        
    }

}
