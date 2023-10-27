package io.bvalentino.app.repository;

import io.bvalentino.app.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {}
