package ru.sharova.TaskManager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sharova.TaskManager.models.Comment;
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
