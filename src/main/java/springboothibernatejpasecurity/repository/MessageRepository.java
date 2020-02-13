package springboothibernatejpasecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboothibernatejpasecurity.models.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
