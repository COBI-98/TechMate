package com.cobi.techmate.service.course;

import com.cobi.techmate.domain.course.CourseRepository;
import com.cobi.techmate.service.course.response.CourseResponse;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
@Transactional(readOnly = true)
public class CourseService {

  private CourseRepository courseRepository;

  public CourseResponse createCourse() {
    //        courseRepository.findByLastestCourseNumber();

    return null;
  }
}
