package com.calcio.it.springmvcseriea.reposotory;

import com.calcio.it.springmvcseriea.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String url);

    // Параметр ":query" представляет собой переменную, которая будет заменена на конкретное значение при выполнении запроса.
    // Это значение будет использоваться для поиска записей в таблице "Club", где значение поля "title" содержит указанную подстроку.
    // Например, если значение параметра ":query" равно "football",
    // то будут найдены все записи, где в поле "title" содержится подстрока "football".
    // Для поиска в поисковой строке по любому символу или набору символов. На странице главной точно есть строка с поиском
    @Query("SELECT c from Club c WHERE c.title LIKE CONCAT('%', :query, '%')")
    List<Club> searchClubs(String query);
}
