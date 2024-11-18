package projeto.listify.service;

import projeto.listify.entity.User;

public interface IUserService {
        User save(User user);
        User findById(Long id);
        void delete(Long id);
}
