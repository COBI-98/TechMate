package com.cobi.techmate.service.course;

import com.cobi.techmate.domain.course.Course;
import com.cobi.techmate.domain.course.CourseRepository;
import com.cobi.techmate.service.course.request.CourseCreateServiceRequest;
import com.cobi.techmate.service.course.response.CourseResponse;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@NoArgsConstructor
@Transactional(readOnly = true)
public class CourseService {

  private CourseRepository courseRepository;

  public CourseResponse createCourse(CourseCreateServiceRequest request) {
    String nextCourseNumber = createCourseNumber();

    Course course = request.toEntity(nextCourseNumber);
    Course saveCourse = courseRepository.save(course);

    return CourseResponse.of(saveCourse);
  }

  private String createCourseNumber() {
    String latestCourseNumber = courseRepository.findLatestCourseNumber();

    if (latestCourseNumber == null) {
      return "001";
    }

    int curCourseNumber = Integer.parseInt(latestCourseNumber);
    int nextCourseNumber = curCourseNumber + 1;

    return String.format("%3d", nextCourseNumber);
  }

  // 전체강의
  public List<CourseResponse> findCourses() {

    return null;
  }
}
