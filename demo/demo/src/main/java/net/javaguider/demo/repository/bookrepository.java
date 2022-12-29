package net.javaguider.demo.repository;
import net.javaguider.demo.model.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface bookrepository extends JpaRepository<book,Long>
{

}
