# Mockito 
소프트웨어 개발 및 테스트 중에 모의 객체(Mock 객체)를 만들고 사용하는데 도움을 주는 프레임워크입니다.  
Mockito는 단위 테스터나 TDD에서 꼭 필요한 프레임워크 라고 볼 수 있습니다.  

## 단위 테스트
소프트웨어의 작은 부분 단위를 격리된 환경에서 테스트하는 것을 단위테스트라고 합니다.  
그럼 단위를 어느 수준으로 설정하는 것이 좋을까요?   
보통은 단위를 메소드나 클래스 수준으로 보지만 마틴 파울러의 말을 빌려보자면  
메소드나 클래스처럼 독립적인 단위 수준으로 하는 것이 아닌,
상호 작용 단위테스트가 객체 지향 소프트웨어 개발에서 클래스 간의 협력과 상호 작용을 테스트를 더 유용하게 테스트 할 수 있다라고 이야기 하고 있습니다.
여기서 상호작용은 클래스와 또은 모듈간에 상호작용입니다.  
저는 OOP를 실천하는데 있어 상호 작용 테스트가 더 유용하다고 생각합니다.  
클래스 하나로만 이루어져 있는 객체가 많이 없을것 이라고 생각합니다.

## Mockito 설치
SpringBoot에는 Mockito가 내장되어 있습니다.

