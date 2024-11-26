package projeto.listify.service;

import projeto.listify.entity.User;

public interface IUserService {
        User save(User user);
        User findById(Long id);
        User findByEmail(String email);
        void deleteUserByEmail(String email);
}
