package kr.hyeongmeme.gaegulbot.controllers;

import kr.hyeongmeme.gaegulbot.entities.SimpleResponse;
import kr.hyeongmeme.gaegulbot.utils.ServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apis")
@Slf4j
public class GaegulEController {
    @Value("${spring.server.profiles}")
    private String profile;
    @Value("${env.frog.bleat}")
    private String bleat;
    @Value("${env.appVersion}")
    private String ext;
    @Value("${env.projectName}")
    private String projectName;

    private final ServiceUtil serviceUtil;

    public GaegulEController(ServiceUtil serviceUtil) {
        this.serviceUtil = serviceUtil;
    }

    @GetMapping("/gaeguls")
    public ResponseEntity<?> gaeguls () {
        SimpleResponse response =
                SimpleResponse.builder().version(String.format(String.format("%s:%s", projectName, ext ))).profile(profile).bleat(bleat).address(serviceUtil.getServiceAddress()).build();

        log.info(response.toString());
        return ResponseEntity.ok(response);
    }
}
