# 숫자 야구 게임

## TO-DO

* 게임의 최소, 최대, 개수를 주입받을 수 있도록 수정 가능한가?

## DONE
* Random 값 추출 객체 만들기
    * camp.nextstep.edu.missionutils의 Randoms 사용하기
* 게임을 수행할 객체 생성
    * 정답 체크할 객체 생성 및 구현
        * 숫자 판정 모델 구현
        * 판정 모델 결과에서 낫싱, 스트라이크, 볼 모델 구현
    * 입력한 값의 Validation 구현
        * IllegalArgumentException 구조 구현
    * 게임 상황 판독할 Class 및 Static Method 추가
* 게임 수행할 Input view 생성
* 게임 수행할 Output view 생성