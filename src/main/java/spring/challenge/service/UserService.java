package spring.challenge.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.challenge.dto.UserRequest;
import spring.challenge.entity.User;
import spring.challenge.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public String signup(UserRequest request){
        userRepository.save(User.builder()
                .userId(request.getUserId())
                .userPwd(request.getUserPwd())
                .userName(request.getUserName())
                .build());
        return "Success";
    }

    public String login(String userId, String userPwd){
        Optional<User> user = userRepository.findByUserId(userId);
        log.info("db password = {}, input password = {}", user.get().getUserPwd(), userPwd);
        if(user.get().getUserPwd().equals(userPwd)) {
            return "Success";
        }
        return "Failed";
    }

    public Optional<User> getUserFromUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
