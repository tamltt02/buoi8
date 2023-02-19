package com.example.buoi8.repository;

import com.example.buoi8.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

//    //QueryCeation : truy van tren thuc the
//    Category findCategoriesByCategoryCodeAndAndCategoryName(String categoryCode, String categoryName);

    // Anotation Query: JPQL and raw SQL
    // JPQL
    @Query("select c from Category c where c.categoryCode = ?1 and c.categoryName = ?2")
    Category searchCategoryType1(String code, String name);
//
//    @Query("select c from Category c where c.categoryCode = :code  and c.categoryName = :name")
//    Category searchCategoryType2(@Param("code") String code, @Param("name") String name);
//
//    //SQL
//    @Query(value = "SELECT * FROM category WHERE category_code= :code AND category_name=:name ", nativeQuery = true)
//    Category searchCategoryType3(@Param("code") String code, @Param("name") String name);
}
