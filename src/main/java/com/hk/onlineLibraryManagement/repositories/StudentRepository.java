package com.hk.onlineLibraryManagement.repositories;

import com.hk.onlineLibraryManagement.models.Student;
import com.hk.onlineLibraryManagement.models.StudentStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
//no need to write @Repository as one of the classes extending JpaRepository has the annotation @Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    // JPQL query
    @Transactional
    @Modifying
    @Query("update Student s set s.status = ?2 where s.id=?1")
    void deactivate(Long studentId, StudentStatus studentStatus);

//    native query
//    @Transactional
//    @Modifying
//    @Query(value = "UPDATE student SET status = ?2 WHERE id = ?1", nativeQuery = true)
//    void deactivate(Integer studentId,  StudentStatus studentStatus);

//    @Transactional
//    @Modifying
//    @Query("update Student s set s.status = :status where s.id = :id")
//    void deactivate(@Param("id") Long studentId, @Param("status") StudentStatus studentStatus);


}
