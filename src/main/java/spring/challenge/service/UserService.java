package spring.challenge.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.challenge.dto.UserRequest;
import spring.challenge.entity.User;
import spring.challenge.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
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
}
