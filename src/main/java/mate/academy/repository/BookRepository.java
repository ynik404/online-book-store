package mate.academy.repository;

import mate.academy.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {
    @Modifying
    @Query("update Book b set b.description = :description where b.id = :id")
    void updateDescription(@Param(value = "id") long id,
                           @Param(value = "description") String description);
}
