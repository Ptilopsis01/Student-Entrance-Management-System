package com.example.demo.mapper;

import com.example.demo.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper extends JpaRepository<Student, Integer> {
    Student findStudentById(Integer id);
    List<Student> findStudentsByClassId(Integer id);
    List<Student> findStudentsByDeptId(Integer id);
    List<Student> findAll();
    List<Student> findStudentsByStatus(Integer status);
    @Query(value = """
        select *
        from student s
        where s.id in (select `stu_id`
            from (select distinct `stu_id`, count(`stu_id`) as all_count
            from enter_report
            group by `stu_id`
            order by count(`stu_id`) DESC) as `stu_id_list`)""", nativeQuery = true)
    List<Student> findStudentsWithMostEnterReport();
}
