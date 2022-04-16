# 숫자 야구 게임

## 기능 요구 사항

* 서로 다른 세자리의 난수 생성
  + randomNumber() 함수 사용

* 사용자 숫자 입력
  + randomNumber() 함수 사용
  + 입력 받은 값을 List 형식으로 저장
 
* 입력 받은 숫자 validation 확인
  + 입력한 숫자가 3자리인지 비교
  + 입력한 숫자의 중복이 있는지 비교
  + 입력한 숫자의 범위가 1~9 값인지 비교
  + validation이 올바르지 않을 경우 IllegalAgrumentException 발생
  
* 입력 받은 숫자와 난수 값 비교 및 결과 생성
  + 입력한 값이 존재 하고, 같은 index 이면 Strike
  + 입력한 값이 존재 하지만 다른 index 이면 Ball
 
* 비교 결과 값에 대해 출력
  + Strike, Ball 값이 0 이라면 '낫띵' 출력
  + Strike, Ball 값에 따라 결과 출력 ex) 2볼  1스트라이크

* 게임 재시작 기능
  + 1. 재시작 / 2.종료 가 아닌 다른 값 입력 시 IllegalAgrumentExceptionException 발생 
