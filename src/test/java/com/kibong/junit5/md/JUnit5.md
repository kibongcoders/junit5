# Junit5

Jupiter: TestEngine API 구현체로 JUnit 5를 제공.
2.2+ 버전의 스프링 부트 프로젝트를 만든다면 기본으로 JUnit 5 의존성 추가 됨.

기본 에노테이션
@Test
@BeforeAll 모든 테스트 실행 하기전 한번만 실행 static
@AfterAll 모든 테스트 실행 후에 한번만 실행 static
@BeforeEach 각 테스트 실행 전에 실행
@AfterEach 각 테스트 실행 후에 실행
@Disabled 테스트 실행 X 잘 사용하지는 않는다.

테스트 이름 표기하기
@DisplayNameGeneration 
클래스, 메소드에 사용 가능
클래스에 사용시 클래스 안에 있는 모든 메소드에 적용
Method와 Class 레퍼런스를 사용해서 테스트 이름을 표기하는 방법 설정.
DisplayNameGenerator.ReplaceUnderscores.class 사용 언더 스코어 변경 가능

@DisplayName
어떤 테스트인지 테스트 이름을 보다 쉽게 표현할 수 있는 방법을 제공하는 애노테이션.
@DisplayNameGeneration 보다 우선 순위가 높다.
