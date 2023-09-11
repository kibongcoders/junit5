## Assumptions

assumeTrue(조건)  
assumingThat(조건, 테스트)  

assumeTrue의 조건이 안맞을 경우 경우 밑에 있는 모든 것을 실행 못함 -> Exception 던짐  
assumingThat(조건, 테스트)의 경우 조건이 맞지 않으면 테스트를 실행하지 않음 하지만 그 밖에 있는 것은 실행 가능  

@Enabled___ 와 @Disabled___  
● OnOS  
● OnJre  
● IfSystemProperty  
● IfEnvironmentVariable   
● If  

## Tagging
@Tag  
테스트를 그룹화하고 필터링하기 위해 사용
특정 태그를 가진 테스트만 실행하거나 제외 가능

