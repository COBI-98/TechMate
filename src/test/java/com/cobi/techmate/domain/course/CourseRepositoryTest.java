package com.cobi.techmate.domain.course;

import static com.cobi.techmate.domain.course.CourseStatus.CREATE;
import static com.cobi.techmate.domain.course.CourseStatus.OPEN;
import static com.cobi.techmate.domain.course.CourseStatus.STOP;
import static com.cobi.techmate.domain.course.Difficulty.LOWER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class CourseRepositoryTest {

  @Autowired private CourseRepository courseRepository;

  @AfterEach
  void tearDown() {
    courseRepository.deleteAllInBatch();
  }

  @DisplayName("현재 개설된 강의리스트를 모두 조회할수있다.")
  @Test
  void readCreateCourseList() throws Exception {
    // given
    Course course1 = createProduct("001", "mvcCourse1", "content1", LOWER, CREATE);
    Course course2 = createProduct("002", "mvcCourse2", "content2", LOWER, CREATE);
    Course course3 = createProduct("003", "mvcCourse3", "content3", LOWER, CREATE);
    courseRepository.saveAll(List.of(course1, course2, course3));

    // when
    List<Course> openCourse = courseRepository.findAllByCourseStatusIn(List.of(CREATE));

    // then
    assertThat(openCourse)
        .hasSize(3)
        .extracting("courseNumber", "title", "content")
        .containsExactlyInAnyOrder(
            tuple("001", "mvcCourse1", "content1"),
            tuple("002", "mvcCourse2", "content2"),
            tuple("003", "mvcCourse3", "content3"));
  }

  @DisplayName("현재 운영중인 강의리스트를 모두 조회할수있다.")
  @Test
  void readOpenCourseList() throws Exception {
    // given
    Course course1 = createProduct("001", "mvcCourse1", "content1", LOWER, CREATE);
    Course course2 = createProduct("002", "mvcCourse2", "content2", LOWER, OPEN);
    Course course3 = createProduct("003", "mvcCourse3", "content3", LOWER, OPEN);
    Course course4 = createProduct("004", "mvcCourse4", "content4", LOWER, STOP);
    courseRepository.saveAll(List.of(course1, course2, course3, course4));

    // when
    List<Course> openCourse = courseRepository.findAllByCourseStatusIn(List.of(OPEN));

    // then
    assertThat(openCourse)
        .hasSize(2)
        .extracting("courseNumber", "title", "content")
        .containsExactlyInAnyOrder(
            tuple("002", "mvcCourse2", "content2"), tuple("003", "mvcCourse3", "content3"));
  }

  @DisplayName("강의를 생성하면 마지막으로 생성한 번호를 읽어온다.")
  @Test
  void createLatestCourseNumber() throws Exception {
    String targetCourseNumber = "002";
    // given
    Course course1 = createProduct("001", "mvcCourse1", "content1", LOWER, OPEN);
    Course course2 = createProduct("002", "mvcCourse2", "content2", LOWER, OPEN);
    courseRepository.saveAll(List.of(course1, course2));

    // when
    String latestCourseNumber = courseRepository.findLatestCourseNumber();

    // then
    assertThat(latestCourseNumber).isEqualTo(targetCourseNumber);
  }

  @DisplayName("강의를 생성할 때 이전 강의가 없다면 null 을 반환한다.")
  @Test
  void createCourseNumberLatestIsNull() throws Exception {
    // given
    String latestCourseNumber = courseRepository.findLatestCourseNumber();

    // when //then
    assertThat(latestCourseNumber).isNull();
  }

  private Course createProduct(
      String courseNumber,
      String title,
      String content,
      Difficulty difficulty,
      CourseStatus courseStatus) {

    return Course.builder()
        .courseNumber(courseNumber)
        .title(title)
        .content(content)
        .difficulty(difficulty)
        .courseStatus(courseStatus)
        .build();
  }
}
