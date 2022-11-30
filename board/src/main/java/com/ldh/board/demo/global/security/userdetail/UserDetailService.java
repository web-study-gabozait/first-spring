package com.ldh.board.demo.global.security.userdetail;
import com.ldh.board.demo.domain.user.domain.User;
import com.ldh.board.demo.domain.user.entity.UserEntity;
import com.ldh.board.demo.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity optional = userRepository.findById(username)
                .orElseThrow(()->new UsernameNotFoundException("해당 아이디를 가진 사용자를 찾을 수 없습니다."));
        User user = User.build(optional);

        return new UserDetail(user);
    }
}
