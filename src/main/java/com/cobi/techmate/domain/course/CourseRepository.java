package com.cobi.techmate.domain.course;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

  List<Course> findByCourseNumber(String CourseNumber);

  List<Course> findAllByCourseStatusIn(List<CourseStatus> courseStatuses);

  @Query(
      value = "select c.course_number from course c order by id desc limit 1",
      nativeQuery = true)
  String findLatestCourseNumber();
}
