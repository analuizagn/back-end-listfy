package projeto.listify.service.impl;

import org.springframework.stereotype.Service;
import projeto.listify.entity.User;
import projeto.listify.exception.BusinessException;
import projeto.listify.repository.UserRepository;
import projeto.listify.service.IUserService;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Id " + id + " não encontrado"));
    }

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException("E-mail " + email + " não encontrado"));
    }

    @Override
    public void deleteUserByEmail(String email) {
        User user = this.findByEmail(email);
        this.userRepository.delete(user);
    }

}
